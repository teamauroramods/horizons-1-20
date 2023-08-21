package com.teamaurora.horizons.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * @author JustinPlayzz
 * @author Steven
 * @author ebo2022
 * @author rose_
 */
public class AlgaeBlock extends BushBlock implements BonemealableBlock {
    protected static final VoxelShape ALGAE_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);

    public AlgaeBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return ALGAE_AABB;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        FluidState fluid = level.getFluidState(pos);
        FluidState below = level.getFluidState(pos.below());

        return (below.getType() == Fluids.WATER || state.getBlock() instanceof IceBlock) && fluid.getType() == Fluids.EMPTY;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState statetate, boolean isClient) {
        for (BlockPos p : BlockPos.betweenClosed(pos.offset(-2, -2, -2), pos.offset(2, 2, 2)))
            if (pos.closerThan(p, 2.0F) && level.getBlockState(p).isAir() && level.getFluidState(p.below()).getType() == Fluids.WATER)
                return true;

        return false;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource rand, BlockPos pos, BlockState state) {
        for (BlockPos pos2 : BlockPos.betweenClosed(pos.offset(-3, -3, -3), pos.offset(3, 3, 3)))
            if (pos.closerThan(pos2, 3.0F) && rand.nextFloat() <= 1.0F - pos2.distSqr(pos) / 18.0F && level.getBlockState(pos2).isAir() && level.getFluidState(pos2.below()).getType() == Fluids.WATER)
                level.setBlockAndUpdate(pos2, this.defaultBlockState());
    }
}