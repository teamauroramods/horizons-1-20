package com.teamaurora.horizons.common.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public final class BlockHelper {

    public static void prepForDoubleBlockPlacement(Level level, BlockPos pos, boolean below) { //wtf is this
        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        level.setBlock(below ? pos.above() : pos.below(), Blocks.AIR.defaultBlockState(), 3);
    }
}
