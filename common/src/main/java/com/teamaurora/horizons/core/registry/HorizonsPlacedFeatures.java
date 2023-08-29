package com.teamaurora.horizons.core.registry;

import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.feature.HorizonsTreePlacements;
import com.teamaurora.horizons.core.registry.feature.HorizonsVegetationPlacements;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public final class HorizonsPlacedFeatures {
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HorizonsTreePlacements.bootstrap(context);
        HorizonsVegetationPlacements.bootstrap(context);
    }

    public static ResourceKey<PlacedFeature> key(String path) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Horizons.location(path));
    }
}
