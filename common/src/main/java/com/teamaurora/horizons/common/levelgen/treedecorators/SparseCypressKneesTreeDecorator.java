package com.teamaurora.horizons.common.levelgen.treedecorators;

import com.mojang.serialization.Codec;
import com.teamaurora.horizons.common.block.CypressKneeBlock;
import com.teamaurora.horizons.common.util.FeatureHelper;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.material.Fluids;

public class SparseCypressKneesTreeDecorator extends TreeDecorator{

    public static final Codec<SparseCypressKneesTreeDecorator> CODEC;
    public static final SparseCypressKneesTreeDecorator INSTANCE = new SparseCypressKneesTreeDecorator();

    @Override
    protected TreeDecoratorType<SparseCypressKneesTreeDecorator> type() {
        return HorizonsFeatures.CYPRESS_KNEES_SPARSE.get();
    }

    static {
        CODEC = Codec.unit(() -> INSTANCE);
    }

    @Override
    public void place(Context context) {
        RandomSource random = context.random();
        LevelSimulatedReader level = context.level();
        // placeholder, has no difference in effect
        int minY = Integer.MAX_VALUE;
        int maxWaterY = 0;
        for (BlockPos pos : context.logs()) {
            if (pos.getY() < minY) minY = pos.getY();
            if (pos.getY() > maxWaterY) {
                for (int i = 0; i < 4; i++) {
                    Direction dir = Direction.from2DDataValue(i);
                    if (level.isFluidAtPosition(pos.relative(dir), s -> s.is(Fluids.WATER))) {
                        maxWaterY = pos.getY();
                    }
                }
            }
        }
        if (maxWaterY > minY) minY = maxWaterY;
        for (BlockPos pos : context.logs()) {
            if (pos.getY() == minY && random.nextInt(6) == 0) {
                for (int x = -2; x <= 2; x++) {
                    for (int y = -2; y <= 2; y++) {
                        for (int z = -2; z <= 2; z++) {
                            BlockPos newPos = pos.offset(x, y, z);
                            if (pos.closerThan(newPos, 3.0D)) {
                                if (level.isStateAtPosition(newPos.below(), s -> s.is(BlockTags.DIRT)) && context.isAir(newPos)) {
                                    if (random.nextInt(9) == 0) {
                                        if (random.nextInt(3) == 0 && context.isAir(newPos.above())) {
                                            FeatureHelper.placeDoubleKnee(newPos, context);
                                        } else {
                                            context.setBlock(newPos, HorizonsBlocks.CYPRESS_KNEE.get().defaultBlockState().setValue(CypressKneeBlock.WATERLOGGED, false));
                                        }
                                    }
                                } else if (level.isStateAtPosition(newPos, s -> s.is(Blocks.WATER)) && level.isStateAtPosition(newPos.below(), BlockState::canOcclude)) {
                                    if (random.nextInt(8) == 0) {
                                        if (random.nextInt(4) != 0 && context.isAir(newPos.above())) {
                                            FeatureHelper.placeDoubleKnee(newPos, context);
                                        } else {
                                            context.setBlock(newPos, HorizonsBlocks.CYPRESS_KNEE.get().defaultBlockState().setValue(CypressKneeBlock.WATERLOGGED, true));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
