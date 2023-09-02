package com.teamaurora.horizons.common.levelgen.treedecorators;

import com.mojang.datafixers.types.Func;
import com.mojang.serialization.Codec;
import com.teamaurora.horizons.common.block.CypressKneeBlock;
import com.teamaurora.horizons.common.block.DoubleCypressKneeBlock;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.material.Fluids;

import java.util.function.Function;

/**
 * @author rose_
 * @author ebo2022
 */
public class CypressKneesTreeDecorator extends TreeDecorator {
    public static final CypressKneesTreeDecorator INSTANCE = new CypressKneesTreeDecorator();
    public static final Codec<CypressKneesTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);

    @Override
    public void place(Context context) {
        placeFeature(context, random -> true);
    }

    @Override
    protected TreeDecoratorType<CypressKneesTreeDecorator> type() {
        return HorizonsFeatures.CYPRESS_KNEES.get();
    }

    public static void placeFeature(Context context, Function<RandomSource, Boolean> chance) {
        RandomSource random = context.random();
        LevelSimulatedReader level = context.level();
        int minY = Integer.MAX_VALUE; // placeholder, has no difference in effect
        int maxWaterY = 0;

        for (BlockPos pos : context.logs()) {
            if (pos.getY() < minY)
                minY = pos.getY();

            if (pos.getY() > maxWaterY)
                for (int i = 0; i < 4; i++) {
                    Direction dir = Direction.from2DDataValue(i);
                    if (level.isFluidAtPosition(pos.relative(dir), s -> s.is(Fluids.WATER)))
                        maxWaterY = pos.getY();
                }
        }

        if (maxWaterY > minY)
            minY = maxWaterY;

        for (BlockPos pos : context.logs())
            if (pos.getY() == minY && chance.apply(random))
                for (int x = -2; x <= 2; x++)
                    for (int y = -2; y <= 2; y++)
                        for (int z = -2; z <= 2; z++) {
                            BlockPos newPos = pos.offset(x, y, z);

                            if (pos.closerThan(newPos, 3.0D) && level.isStateAtPosition(newPos.below(), s -> s.is(BlockTags.DIRT)) && context.isAir(newPos) && random.nextInt(9) == 0) {
                                if (random.nextInt(3) == 0 && context.isAir(newPos.above()))
                                    placeLargeKnee(newPos, context);
                                else
                                    context.setBlock(newPos, HorizonsBlocks.CYPRESS_KNEE.get().defaultBlockState().setValue(CypressKneeBlock.WATERLOGGED, false));

                            } else if (level.isStateAtPosition(newPos, s -> s.is(Blocks.WATER)) && level.isStateAtPosition(newPos.below(), BlockState::canOcclude) && random.nextInt(8) == 0) {
                                if (random.nextInt(4) != 0 && context.isAir(newPos.above()))
                                    placeLargeKnee(newPos, context);
                                else
                                    context.setBlock(newPos, HorizonsBlocks.CYPRESS_KNEE.get().defaultBlockState().setValue(CypressKneeBlock.WATERLOGGED, true));
                            }
                        }
    }

    private static void placeLargeKnee(BlockPos origin, TreeDecorator.Context context) {
        Block knee = HorizonsBlocks.LARGE_CYPRESS_KNEE.get();
        context.setBlock(origin, knee.defaultBlockState().setValue(DoubleCypressKneeBlock.HALF, DoubleBlockHalf.LOWER).setValue(DoubleCypressKneeBlock.WATERLOGGED, context.level().isFluidAtPosition(origin, s -> s.is(Fluids.WATER))));
        BlockPos above = origin.above();
        context.setBlock(above, knee.defaultBlockState().setValue(DoubleCypressKneeBlock.HALF, DoubleBlockHalf.UPPER).setValue(DoubleCypressKneeBlock.WATERLOGGED, context.level().isFluidAtPosition(above, s -> s.is(Fluids.WATER))));
    }

}

