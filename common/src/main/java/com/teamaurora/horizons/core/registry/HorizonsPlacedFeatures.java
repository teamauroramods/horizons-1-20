package com.teamaurora.horizons.core.registry;

import com.teamaurora.horizons.core.Horizons;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class HorizonsPlacedFeatures {

    public static final ResourceKey<PlacedFeature> PATCH_TROPICAL_GRASS = key("patch_tropical_grass");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        PlacementUtils.register(context, PATCH_TROPICAL_GRASS, configuredFeatures.getOrThrow(HorizonsConfiguredFeatures.PATCH_TROPICAL_GRASS), VegetationPlacements.worldSurfaceSquaredWithCount(25));
    }

    private static ResourceKey<PlacedFeature> key(String path) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Horizons.location(path));
    }
}
