package com.teamaurora.horizons.common.block;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JustinPlayzz
 * @author Steven
 * @author ebo2022
 * @author rose_
 */
public class LilyFlowerBlock extends FlowerBlock {
    private static final VoxelShape LILY_PAD_AABB = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 1.5D, 15.0D);
    private static final VoxelShape LILY_FLOWER_AABB = Block.box(3.0D, 1.5D, 3.0D, 13.0D, 13.D, 13.0D);
    private static final VoxelShape SHAPE = Shapes.or(LILY_PAD_AABB, LILY_FLOWER_AABB);
    private static final List<LilyFlowerBlock> LILY_FLOWERS = new ArrayList<>();

    public LilyFlowerBlock(Properties builder) {
        super(MobEffects.POISON, 12, builder);
        LILY_FLOWERS.add(this);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return LILY_PAD_AABB;
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return !stateIn.canSurvive(level, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, level, currentPos, facingPos);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);

        if (level instanceof ServerLevel && entity instanceof Boat)
            level.removeBlock(new BlockPos(pos), true);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        FluidState fluid = level.getFluidState(pos);
        FluidState above = level.getFluidState(pos.above());

        return (fluid.getType() == Fluids.WATER || state.getBlock() instanceof IceBlock) && above.getType() == Fluids.EMPTY;
    }

    public static Block getRandomLily(RandomSource rand) {
        return Util.getRandom(LILY_FLOWERS, rand);
    }
}