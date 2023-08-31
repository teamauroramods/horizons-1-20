package com.teamaurora.horizons.core.registry.feature;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static com.teamaurora.horizons.core.registry.HorizonsPlacedFeatures.key;

/**
 * @author rose_
 * @author ebo2022
 */
public final class HorizonsVegetationPlacements {
    public static final ResourceKey<PlacedFeature> PATCH_TROPICAL_GRASS = key("patch_tropical_grass");
    public static final ResourceKey<PlacedFeature> ALGAE = key("algae");
    public static final ResourceKey<PlacedFeature> GIANT_FERN = key("giant_fern");
    public static final ResourceKey<PlacedFeature> BLUE_LILY = key("blue_lily");
    public static final ResourceKey<PlacedFeature> LIGHT_GRAY_LILY = key("light_gray_lily");
    public static final ResourceKey<PlacedFeature> CYAN_LILY = key("cyan_lily");
    public static final ResourceKey<PlacedFeature> LIGHT_BLUE_LILY = key("light_blue_lily");
    public static final ResourceKey<PlacedFeature> MAGENTA_LILY = key("magenta_lily");
    public static final ResourceKey<PlacedFeature> PINK_LILY = key("pink_lily");
    public static final ResourceKey<PlacedFeature> PURPLE_LILY = key("purple_lily");
    public static final ResourceKey<PlacedFeature> WHITE_LILY = key("white_lily");

    public static final ResourceKey<PlacedFeature> FIDDLENECK = key("fiddleneck");
    public static final ResourceKey<PlacedFeature> AMARANTHUS = key("amaranthus");
    public static final ResourceKey<PlacedFeature> MYOSOTIS = key("myosotis");
    public static final ResourceKey<PlacedFeature> HELICONIA = key("heliconia");

    public static final ResourceKey<PlacedFeature> TREES_CYPRESS = key("trees_cypress");
    public static final ResourceKey<PlacedFeature> TREES_WATER_CYPRESS = key("trees_water_cypress");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> patchTropicalGrass = configuredFeatures.getOrThrow(HorizonsVegetationFeatures.PATCH_TROPICAL_GRASS);
        Holder<ConfiguredFeature<?, ?>> algae = configuredFeatures.getOrThrow(HorizonsVegetationFeatures.ALGAE);
        Holder<ConfiguredFeature<?, ?>> giantFern = configuredFeatures.getOrThrow(HorizonsVegetationFeatures.GIANT_FERN);
        Holder<ConfiguredFeature<?, ?>> blueLily = configuredFeatures.getOrThrow(HorizonsVegetationFeatures.BLUE_LILY);
        Holder<ConfiguredFeature<?, ?>> lightGrayLily = configuredFeatures.getOrThrow(HorizonsVegetationFeatures.LIGHT_GRAY_LILY);
        Holder<ConfiguredFeature<?, ?>> cyanLily = configuredFeatures.getOrThrow(HorizonsVegetationFeatures.CYAN_LILY);
        Holder<ConfiguredFeature<?, ?>> lightBlueLily = configuredFeatures.getOrThrow(HorizonsVegetationFeatures.LIGHT_BLUE_LILY);
        Holder<ConfiguredFeature<?, ?>> magentaLily = configuredFeatures.getOrThrow(HorizonsVegetationFeatures.MAGENTA_LILY);
        Holder<ConfiguredFeature<?, ?>> pinkLily = configuredFeatures.getOrThrow(HorizonsVegetationFeatures.PINK_LILY);
        Holder<ConfiguredFeature<?, ?>> purpleLily = configuredFeatures.getOrThrow(HorizonsVegetationFeatures.PURPLE_LILY);
        Holder<ConfiguredFeature<?, ?>> whiteLily = configuredFeatures.getOrThrow(HorizonsVegetationFeatures.WHITE_LILY);

        Holder<ConfiguredFeature<?, ?>> fiddleneck = configuredFeatures.getOrThrow(HorizonsVegetationFeatures.FIDDLENECK);
        Holder<ConfiguredFeature<?, ?>> amaranthus = configuredFeatures.getOrThrow(HorizonsVegetationFeatures.AMARANTHUS);
        Holder<ConfiguredFeature<?, ?>> myosotis = configuredFeatures.getOrThrow(HorizonsVegetationFeatures.MYOSOTIS);
        Holder<ConfiguredFeature<?, ?>> heliconia = configuredFeatures.getOrThrow(HorizonsVegetationFeatures.HELICONIA);

        Holder<ConfiguredFeature<?, ?>> treesCypress = configuredFeatures.getOrThrow(HorizonsVegetationFeatures.TREES_CYPRESS);
        Holder<ConfiguredFeature<?, ?>> treesWaterCypress = configuredFeatures.getOrThrow(HorizonsVegetationFeatures.TREES_WATER_CYPRESS);

        PlacementUtils.register(context, PATCH_TROPICAL_GRASS, patchTropicalGrass, VegetationPlacements.worldSurfaceSquaredWithCount(25));
        PlacementUtils.register(context, ALGAE, algae, createPatch(3));
        PlacementUtils.register(context, GIANT_FERN, giantFern, createPatch(5));
        PlacementUtils.register(context, BLUE_LILY, blueLily, createPatch(12));
        PlacementUtils.register(context, LIGHT_GRAY_LILY, lightGrayLily, createPatch(12));
        PlacementUtils.register(context, CYAN_LILY, cyanLily, createPatch(12));
        PlacementUtils.register(context, LIGHT_BLUE_LILY, lightBlueLily, createPatch(12));
        PlacementUtils.register(context, MAGENTA_LILY, magentaLily, createPatch(12));
        PlacementUtils.register(context, PINK_LILY, pinkLily, createPatch(12));
        PlacementUtils.register(context, PURPLE_LILY, purpleLily, createPatch(12));
        PlacementUtils.register(context, WHITE_LILY, whiteLily, createPatch(12));

        PlacementUtils.register(context, FIDDLENECK, fiddleneck, createPatch(2));
        PlacementUtils.register(context, AMARANTHUS, amaranthus, createPatch(2));
        PlacementUtils.register(context, MYOSOTIS, myosotis, createPatch(12));
        PlacementUtils.register(context, HELICONIA, heliconia, createPatch(3));

        PlacementUtils.register(context, TREES_CYPRESS, treesCypress, VegetationPlacements.treePlacement(PlacementUtils.countExtra(20, 0.1F, 1)));
        PlacementUtils.register(context, TREES_WATER_CYPRESS, treesWaterCypress, PlacementUtils.countExtra(9, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(3), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());
    }

    private static List<PlacementModifier> createPatch(int onceEvery) {
        return List.of(
                RarityFilter.onAverageOnceEvery(onceEvery),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome()
        );
    }
}
