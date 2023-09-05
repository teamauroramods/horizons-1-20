package com.teamaurora.horizons.common.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

/**
 * @author JustinPlayzz
 * @author Steven
 */

@Deprecated
public class DirectionalBlockPos { //wtf is this
    public BlockPos pos;
    public Direction direction;

    public DirectionalBlockPos(BlockPos p, Direction a) {
        pos = p;
        direction = a;
    }
}
