package com.teamaurora.horizons.common.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class FeatureHelper {

    public static boolean isAir(LevelSimulatedReader level, BlockPos pos) {
        if (!(level instanceof BlockGetter)) {
            return level.isStateAtPosition(pos, BlockState::isAir);
        } else {
            return level.isStateAtPosition(pos, BlockBehaviour.BlockStateBase::isAir);
        }
    }
}
