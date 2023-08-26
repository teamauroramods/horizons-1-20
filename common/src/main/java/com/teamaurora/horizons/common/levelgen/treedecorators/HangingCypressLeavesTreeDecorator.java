package com.teamaurora.horizons.common.levelgen.treedecorators;

import com.mojang.serialization.Codec;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class HangingCypressLeavesTreeDecorator extends TreeDecorator{

    public static final Codec<HangingCypressLeavesTreeDecorator> CODEC;
    public static final HangingCypressLeavesTreeDecorator INSTANCE = new HangingCypressLeavesTreeDecorator();

    @Override
    protected TreeDecoratorType<HangingCypressLeavesTreeDecorator> type() {
        return HorizonsFeatures.HANGING_CYPRESS_LEAVES.get();
    }

    static {
        CODEC = Codec.unit(() -> INSTANCE);
    }

    @Override
    public void place(TreeDecorator.Context context) {
        RandomSource random = context.random();
        for (BlockPos pos : context.leaves()) {
           BlockPos below = pos.below();
           if (context.isAir(below)) {
               if (random.nextInt(3) == 0) {
                   context.setBlock(below, HorizonsBlocks.HANGING_CYPRESS_LEAVES.get().defaultBlockState());
               }
           }
        }
    }
}
