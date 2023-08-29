package com.teamaurora.horizons.common.util;

import com.teamaurora.horizons.common.block.DoubleCypressKneeBlock;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.material.Fluids;

public class FeatureHelper {
    public static boolean isAirOrLeaves(BlockState state) {
        return state.isAir() || state.is(BlockTags.LEAVES);
    }

    public static void placeDoubleKnee(BlockPos origin, TreeDecorator.Context context) {
        Block knee = HorizonsBlocks.LARGE_CYPRESS_KNEE.get();
        context.setBlock(origin, knee.defaultBlockState().setValue(DoubleCypressKneeBlock.HALF, DoubleBlockHalf.LOWER).setValue(DoubleCypressKneeBlock.WATERLOGGED, context.level().isFluidAtPosition(origin, s -> s.is(Fluids.WATER))));
        BlockPos above = origin.above();
        context.setBlock(above, knee.defaultBlockState().setValue(DoubleCypressKneeBlock.HALF, DoubleBlockHalf.UPPER).setValue(DoubleCypressKneeBlock.WATERLOGGED, context.level().isFluidAtPosition(above, s -> s.is(Fluids.WATER))));
    }

    public static boolean isAirOrWater(BlockState state) {
        return state.isAir() || state.getFluidState().is(FluidTags.WATER);
    }

    public static boolean isAirOrWaterOrLeaves(BlockState state) {
        return isAirOrWater(state) || state.is(BlockTags.LEAVES);
    }
}
