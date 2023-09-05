package com.teamaurora.horizons.common.block.grower;

import com.teamaurora.horizons.core.registry.feature.HorizonsTreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class FloweringJacarandaTreeGrower extends AbstractTreeGrower {

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean bl) {
        return HorizonsTreeFeatures.FLOWERING_JACARANDA_TREE;
    }
}

