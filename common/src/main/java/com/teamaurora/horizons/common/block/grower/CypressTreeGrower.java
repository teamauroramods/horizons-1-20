package com.teamaurora.horizons.common.block.grower;

import com.teamaurora.horizons.core.registry.HorizonsConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class CypressTreeGrower extends AbstractMegaTreeGrower {

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean bl) {
        return HorizonsConfiguredFeatures.CYPRESS_GROWN;
    }

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource randomSource) {
        return HorizonsConfiguredFeatures.MEGA_CYPRESS_GROWN;
    }
}
