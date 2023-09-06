package com.teamaurora.horizons.core.registry;

import com.teamaurora.borealib.api.biome.v1.modifier.BiomeModifier;
import com.teamaurora.borealib.api.biome.v1.modifier.BiomeModifierAction;
import com.teamaurora.borealib.api.biome.v1.modifier.BiomeSelector;
import com.teamaurora.borealib.core.registry.BorealibRegistries;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.tags.HorizonsBiomeTags;
import com.teamaurora.horizons.core.other.tags.HorizonsPlacedFeatureTags;
import com.teamaurora.horizons.core.registry.feature.HorizonsVegetationPlacements;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public final class HorizonsBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TROPICAL_GRASS = key("add_tropical_grass");
    public static final ResourceKey<BiomeModifier> ADD_GIANT_FERNS = key("add_giant_ferns");
    public static final ResourceKey<BiomeModifier> ADD_ALGAE = key("add_algae");
    public static final ResourceKey<BiomeModifier> ADD_BLUE_LILY = key("add_blue_lily");
    public static final ResourceKey<BiomeModifier> ADD_LIGHT_GRAY_LILY = key("add_light_gray_lily");
    public static final ResourceKey<BiomeModifier> ADD_CYAN_LILY = key("add_cyan_lily");
    public static final ResourceKey<BiomeModifier> ADD_LIGHT_BLUE_LILY = key("add_light_blue_lily");
    public static final ResourceKey<BiomeModifier> ADD_MAGENTA_LILY = key("add_magenta_lily");
    public static final ResourceKey<BiomeModifier> ADD_PINK_LILY = key("add_pink_lily");
    public static final ResourceKey<BiomeModifier> ADD_PURPLE_LILY = key("add_purple_lily");
    public static final ResourceKey<BiomeModifier> ADD_WHITE_LILY = key("add_white_lily");

    public static final ResourceKey<BiomeModifier> ADD_FIDDLENECK = key("add_fiddleneck");
    public static final ResourceKey<BiomeModifier> ADD_AMARANTHUS = key("add_amaranthus");
    public static final ResourceKey<BiomeModifier> ADD_MYOSOTIS = key("add_myosotis");
    public static final ResourceKey<BiomeModifier> ADD_HELICONIA = key("add_heliconia");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        BiomeSelector tropicalGrassSelector = BiomeSelector.existingFeatures(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(HorizonsPlacedFeatureTags.TROPICAL_GRASS_REPLACEABLE));
        BiomeModifier addTropicalGrass = BiomeModifier.Builder.selects(tropicalGrassSelector)
                .withAction(BiomeModifierAction.replaceFeaturesNonlinear(
                        GenerationStep.Decoration.VEGETAL_DECORATION,
                        placedFeatures.getOrThrow(HorizonsPlacedFeatureTags.TROPICAL_GRASS_REPLACEABLE),
                        HolderSet.direct(placedFeatures.getOrThrow(HorizonsVegetationPlacements.PATCH_TROPICAL_GRASS))))
                .build();

        context.register(ADD_TROPICAL_GRASS, addTropicalGrass);
        tagBasedFeatureAdder(context, ADD_GIANT_FERNS, biomes.getOrThrow(HorizonsBiomeTags.HAS_GIANT_FERN), placedFeatures.getOrThrow(HorizonsVegetationPlacements.GIANT_FERN), GenerationStep.Decoration.VEGETAL_DECORATION);
        tagBasedFeatureAdder(context, ADD_ALGAE, biomes.getOrThrow(HorizonsBiomeTags.HAS_ALGAE), placedFeatures.getOrThrow(HorizonsVegetationPlacements.ALGAE), GenerationStep.Decoration.VEGETAL_DECORATION);

        tagBasedFeatureAdder(context, ADD_BLUE_LILY, biomes.getOrThrow(HorizonsBiomeTags.HAS_BLUE_LILY), placedFeatures.getOrThrow(HorizonsVegetationPlacements.BLUE_LILY), GenerationStep.Decoration.VEGETAL_DECORATION);
        tagBasedFeatureAdder(context, ADD_LIGHT_GRAY_LILY, biomes.getOrThrow(HorizonsBiomeTags.HAS_LIGHT_GRAY_LILY), placedFeatures.getOrThrow(HorizonsVegetationPlacements.LIGHT_GRAY_LILY), GenerationStep.Decoration.VEGETAL_DECORATION);
        tagBasedFeatureAdder(context, ADD_CYAN_LILY, biomes.getOrThrow(HorizonsBiomeTags.HAS_CYAN_LILY), placedFeatures.getOrThrow(HorizonsVegetationPlacements.CYAN_LILY), GenerationStep.Decoration.VEGETAL_DECORATION);
        tagBasedFeatureAdder(context, ADD_LIGHT_BLUE_LILY, biomes.getOrThrow(HorizonsBiomeTags.HAS_LIGHT_BLUE_LILY), placedFeatures.getOrThrow(HorizonsVegetationPlacements.LIGHT_BLUE_LILY), GenerationStep.Decoration.VEGETAL_DECORATION);
        tagBasedFeatureAdder(context, ADD_MAGENTA_LILY, biomes.getOrThrow(HorizonsBiomeTags.HAS_MAGENTA_LILY), placedFeatures.getOrThrow(HorizonsVegetationPlacements.MAGENTA_LILY), GenerationStep.Decoration.VEGETAL_DECORATION);
        tagBasedFeatureAdder(context, ADD_PINK_LILY, biomes.getOrThrow(HorizonsBiomeTags.HAS_PINK_LILY), placedFeatures.getOrThrow(HorizonsVegetationPlacements.PINK_LILY), GenerationStep.Decoration.VEGETAL_DECORATION);
        tagBasedFeatureAdder(context, ADD_PURPLE_LILY, biomes.getOrThrow(HorizonsBiomeTags.HAS_PURPLE_LILY), placedFeatures.getOrThrow(HorizonsVegetationPlacements.PURPLE_LILY), GenerationStep.Decoration.VEGETAL_DECORATION);
        tagBasedFeatureAdder(context, ADD_WHITE_LILY, biomes.getOrThrow(HorizonsBiomeTags.HAS_WHITE_LILY), placedFeatures.getOrThrow(HorizonsVegetationPlacements.WHITE_LILY), GenerationStep.Decoration.VEGETAL_DECORATION);

        tagBasedFeatureAdder(context, ADD_FIDDLENECK, biomes.getOrThrow(HorizonsBiomeTags.HAS_FIDDLENECK), placedFeatures.getOrThrow(HorizonsVegetationPlacements.FIDDLENECK), GenerationStep.Decoration.VEGETAL_DECORATION);
        tagBasedFeatureAdder(context, ADD_AMARANTHUS, biomes.getOrThrow(HorizonsBiomeTags.HAS_AMARANTHUS), placedFeatures.getOrThrow(HorizonsVegetationPlacements.AMARANTHUS), GenerationStep.Decoration.VEGETAL_DECORATION);
        tagBasedFeatureAdder(context, ADD_MYOSOTIS, biomes.getOrThrow(HorizonsBiomeTags.HAS_MYOSOTIS), placedFeatures.getOrThrow(HorizonsVegetationPlacements.MYOSOTIS), GenerationStep.Decoration.VEGETAL_DECORATION);
        tagBasedFeatureAdder(context, ADD_HELICONIA, biomes.getOrThrow(HorizonsBiomeTags.HAS_HELICONIA), placedFeatures.getOrThrow(HorizonsVegetationPlacements.HELICONIA), GenerationStep.Decoration.VEGETAL_DECORATION);
    }

    private static void tagBasedFeatureAdder(BootstapContext<BiomeModifier> context, ResourceKey<BiomeModifier> key, HolderSet<Biome> biomes, Holder<PlacedFeature> feature, GenerationStep.Decoration step) {
        context.register(
                key,
                BiomeModifier.Builder.selects(BiomeSelector.isBiome(biomes)).withAction(BiomeModifierAction.addFeatures(step, HolderSet.direct(feature))).build()
        );
    }

    private static ResourceKey<BiomeModifier> key(String path) {
        return ResourceKey.create(BorealibRegistries.BIOME_MODIFIERS, Horizons.location(path));
    }
}
