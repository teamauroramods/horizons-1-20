package com.teamaurora.horizons.core.mixin;

import com.teamaurora.borealib.api.base.v1.platform.Platform;
import com.teamaurora.borealib.api.base.v1.util.Mods;
import com.teamaurora.horizons.common.block.LilyFlowerBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(WaterlilyBlock.class)
public class WaterlilyBlockMixin implements BonemealableBlock {

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos pos, BlockState state, boolean isClientSide) {
        return state.is(Blocks.LILY_PAD) && !Platform.isModLoaded(Mods.ENVIRONMENTAL);
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        level.setBlock(pos, LilyFlowerBlock.getRandomLily(random).defaultBlockState(), 2);
    }
}