package com.teamaurora.horizons.common.levelgen.treedecorators;

import com.mojang.serialization.Codec;
import com.teamaurora.horizons.common.block.CypressBranchBlock;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class CypressBranchTreeDecorator extends TreeDecorator {
    public static final Codec<CypressBranchTreeDecorator> CODEC;
    public static final CypressBranchTreeDecorator INSTANCE = new CypressBranchTreeDecorator();

    @Override
    protected TreeDecoratorType<CypressBranchTreeDecorator> type() {
        return HorizonsFeatures.CYPRESS_BRANCH.get();
    }

    static {
        CODEC = Codec.unit(() -> INSTANCE);
    }

    @Override
    public void place(Context context) {
        RandomSource random = context.random();
        for (BlockPos pos : context.logs()) {
            if (random.nextInt(12) == 0) {
                Direction dir = Direction.from2DDataValue(random.nextInt(4));
                BlockPos posToUse = pos.relative(dir);
                if (context.isAir(posToUse)) {
                    context.setBlock(posToUse, HorizonsBlocks.CYPRESS_BRANCH.get().defaultBlockState().setValue(CypressBranchBlock.FACING, dir).setValue(CypressBranchBlock.AGE, 2));
                }
            }
        }
    }
}