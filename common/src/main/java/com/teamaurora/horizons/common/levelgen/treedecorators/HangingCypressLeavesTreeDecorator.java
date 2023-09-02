package com.teamaurora.horizons.common.levelgen.treedecorators;

import com.mojang.serialization.Codec;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

/**
 * @author rose_
 * @author ebo2022
 */
public class HangingCypressLeavesTreeDecorator extends TreeDecorator {
    public static final HangingCypressLeavesTreeDecorator INSTANCE = new HangingCypressLeavesTreeDecorator();
    public static final Codec<HangingCypressLeavesTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);

    @Override
    public void place(TreeDecorator.Context context) {
        RandomSource random = context.random();
        for (BlockPos pos : context.leaves())
            if (context.isAir(pos.below()) && random.nextInt(3) == 0)
                context.setBlock(pos.below(), HorizonsBlocks.HANGING_CYPRESS_LEAVES.get().defaultBlockState());
    }

    @Override
    protected TreeDecoratorType<HangingCypressLeavesTreeDecorator> type() {
        return HorizonsFeatures.HANGING_CYPRESS_LEAVES.get();
    }
}
