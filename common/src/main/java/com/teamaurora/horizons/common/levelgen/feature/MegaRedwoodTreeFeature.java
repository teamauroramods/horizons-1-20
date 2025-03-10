package com.teamaurora.horizons.common.levelgen.feature;

import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class MegaRedwoodTreeFeature extends AbstractHorizonsTreeFeature {
    @Override
    public BlockState getSapling() {
        return HorizonsBlocks.REDWOOD_SAPLING.get().defaultBlockState();
    }

    @Override
    public boolean doPlace(FeaturePlaceContext<TreeConfiguration> context) {
        RandomSource random = context.random();
        BlockPos origin = context.origin();
        int height = random.nextInt(7) + 15;

        for (int i = 0; i <= height; i++) {
            this.addLog(origin.above(i));
            this.addLog(origin.offset(1, i, 0));
            this.addLog(origin.offset(0, i, 1));
            this.addLog(origin.offset(1, i, 1));
        }

        return true;
    }
}
