package com.teamaurora.horizons.core.registry;

import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.feature.HorizonsTreeFeatures;
import com.teamaurora.horizons.core.registry.feature.HorizonsVegetationFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class HorizonsConfiguredFeatures {

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HorizonsTreeFeatures.bootstrap(context);
        HorizonsVegetationFeatures.bootstrap(context);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> key(String path) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Horizons.location(path));
    }
}
