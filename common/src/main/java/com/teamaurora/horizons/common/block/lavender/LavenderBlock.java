package com.teamaurora.horizons.common.block.lavender;

import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LavenderBlock extends BushBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    protected static final VoxelShape SHAPE_SMALL = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 6.0D, 14.0D);
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);

    public LavenderBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().getOwner().defaultBlockState().setValue(AGE, 0));
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(HorizonsBlocks.LAVENDER.get());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return state.getValue(AGE) == 0 ? SHAPE_SMALL : SHAPE;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
        int j = state.getValue(AGE);
        if ((j < 2 || (worldIn.getBlockState(pos.below()).getBlock() == Blocks.COARSE_DIRT)) && j < 3 && worldIn.getRawBrightness(pos.above(), 0) >= 9)
            if (j == 2) {
                if (worldIn.isEmptyBlock(pos.above()))
                    DoublePlantBlock.placeAt(worldIn, HorizonsBlocks.TALL_LAVENDER.get().defaultBlockState(), pos, 2);
            } else {
                int i = Math.min(2, state.getValue(AGE) + 1);
                worldIn.setBlock(pos, state.setValue(AGE, i), 2);
            }

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean bl) {
        return blockState.getValue(AGE) < 3;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        if (blockState.getValue(AGE) == 2) {
            if (serverLevel.isEmptyBlock(blockPos.above())) {
                DoublePlantBlock.placeAt(serverLevel, HorizonsBlocks.TALL_LAVENDER.get().defaultBlockState(), blockPos, 2);
            }
        } else {
            int i = Math.min(2, blockState.getValue(AGE) + 1);
            serverLevel.setBlock(blockPos, blockState.setValue(AGE, i), 2);
        }
    }

}
