package com.teamaurora.horizons.core.mixin;

import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.spongepowered.asm.mixin.Mixin;

/**
 * @author rose_
 */
@Mixin(DoublePlantBlock.class)
public class DoublePlantBlockMixin implements BonemealableBlock {

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
        return state.is(Blocks.LARGE_FERN);
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource rand, BlockPos pos, BlockState state) {
        boolean below = state.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.LOWER;
        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
        level.setBlock(below ? pos.above() : pos.below(), Blocks.AIR.defaultBlockState(), 2);
        DoublePlantBlock.placeAt(level, HorizonsBlocks.GIANT_FERN.get().defaultBlockState(), below ? pos : pos.below(), 2);
    }
}