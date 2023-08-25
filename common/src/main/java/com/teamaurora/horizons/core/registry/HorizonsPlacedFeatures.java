package com.teamaurora.horizons.core.registry;

import com.teamaurora.horizons.core.Horizons;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class HorizonsPlacedFeatures {

    public static final ResourceKey<PlacedFeature> PATCH_TROPICAL_GRASS = key("patch_tropical_grass");
    public static final ResourceKey<PlacedFeature> GIANT_FERN = key("giant_fern");
    public static final ResourceKey<PlacedFeature> BLUE_LILY = key("blue_lily");
    public static final ResourceKey<PlacedFeature> LIGHT_GRAY_LILY = key("light_gray_lily");
    public static final ResourceKey<PlacedFeature> CYAN_LILY = key("cyan_lily");
    public static final ResourceKey<PlacedFeature> LIGHT_BLUE_LILY = key("light_blue_lily");
    public static final ResourceKey<PlacedFeature> MAGENTA_LILY = key("magenta_lily");
    public static final ResourceKey<PlacedFeature> PINK_LILY = key("pink_lily");
    public static final ResourceKey<PlacedFeature> PURPLE_LILY = key("purple_lily");
    public static final ResourceKey<PlacedFeature> WHITE_LILY = key("white_lily");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        PlacementUtils.register(
                context,
                PATCH_TROPICAL_GRASS,
                configuredFeatures.getOrThrow(HorizonsConfiguredFeatures.PATCH_TROPICAL_GRASS),
                VegetationPlacements.worldSurfaceSquaredWithCount(25)
        );
        PlacementUtils.register(
                context,
                GIANT_FERN,
                configuredFeatures.getOrThrow(HorizonsConfiguredFeatures.GIANT_FERN),
                createPatch(5)
        );
        PlacementUtils.register(
                context,
                BLUE_LILY,
                configuredFeatures.getOrThrow(HorizonsConfiguredFeatures.BLUE_LILY),
                createPatch(12)
        );
        PlacementUtils.register(
                context,
                LIGHT_GRAY_LILY,
                configuredFeatures.getOrThrow(HorizonsConfiguredFeatures.LIGHT_GRAY_LILY),
                createPatch(12)
        );
        PlacementUtils.register(
                context,
                CYAN_LILY,
                configuredFeatures.getOrThrow(HorizonsConfiguredFeatures.CYAN_LILY),
                createPatch(12)
        );
        PlacementUtils.register(
                context,
                LIGHT_BLUE_LILY,
                configuredFeatures.getOrThrow(HorizonsConfiguredFeatures.LIGHT_BLUE_LILY),
                createPatch(12)
        );
        PlacementUtils.register(
                context,
                MAGENTA_LILY,
                configuredFeatures.getOrThrow(HorizonsConfiguredFeatures.MAGENTA_LILY),
                createPatch(12)
        );
        PlacementUtils.register(
                context,
                PINK_LILY,
                configuredFeatures.getOrThrow(HorizonsConfiguredFeatures.PINK_LILY),
                createPatch(12)
        );
        PlacementUtils.register(
                context,
                PURPLE_LILY,
                configuredFeatures.getOrThrow(HorizonsConfiguredFeatures.PURPLE_LILY),
                createPatch(12)
        );
        PlacementUtils.register(
                context,
                WHITE_LILY,
                configuredFeatures.getOrThrow(HorizonsConfiguredFeatures.WHITE_LILY),
                createPatch(12)
        );
    }

    private static List<PlacementModifier> createPatch(int onceEvery) {
        return List.of(
                RarityFilter.onAverageOnceEvery(onceEvery),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome()
        );
    }

    private static ResourceKey<PlacedFeature> key(String path) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Horizons.location(path));
    }
}
