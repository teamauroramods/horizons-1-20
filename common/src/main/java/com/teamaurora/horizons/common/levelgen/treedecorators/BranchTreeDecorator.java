package com.teamaurora.horizons.common.levelgen.treedecorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author rose_
 */
public class BranchTreeDecorator extends TreeDecorator {
    public static final Codec<BranchTreeDecorator> CODEC = RecordCodecBuilder.create(i -> i
            .group(SimpleStateProvider.CODEC.fieldOf("state").forGetter(bd -> bd.state), Codec.intRange(0, 32).fieldOf("minHeight").forGetter(bd -> bd.minHeight))
            .apply(i, BranchTreeDecorator::new));
    private final SimpleStateProvider state;
    private final int minHeight;

    public BranchTreeDecorator(SimpleStateProvider state, int minHeight) {
        this.state = state;
        this.minHeight = minHeight;
    }

    @Override
    public void place(Context context) {
        RandomSource rand = context.random();

        if (rand.nextFloat() <= .25f)
            return;

        int i = context.logs().get(0).getY();
        final List<Direction> logs = new LinkedList<>();

        for (BlockPos pos : context.logs())
            if (pos.getY() - i >= this.minHeight && rand.nextFloat() <= .25f) {
                final List<Direction> directions = new LinkedList<>(List.of(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST));
                logs.forEach(directions::remove);
                Collections.shuffle(directions, new Random(rand.nextInt()));
                for (Direction direction : directions) {
                    BlockPos blockpos = pos.offset(direction.getOpposite().getStepX(), 0, direction.getOpposite().getStepZ());

                    if (context.isAir(blockpos) && context.isAir(blockpos.below()) && context.isAir(blockpos.above())) {
                        BlockState blockState = this.state.getState(rand, blockpos);

                        if (blockState.hasProperty(RotatedPillarBlock.AXIS))
                            blockState = blockState.setValue(RotatedPillarBlock.AXIS, direction.getAxis());

                        context.setBlock(blockpos, blockState);
                        logs.add(direction);

                        if (rand.nextBoolean()) break;
                        else return;
                    }
                }
            }
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return HorizonsFeatures.BRANCH.get();
    }

}
