package com.teamaurora.horizons.core.registry;

import com.teamaurora.borealib.api.biome.v1.modifier.BiomeModifier;
import com.teamaurora.borealib.api.biome.v1.modifier.BiomeModifierAction;
import com.teamaurora.borealib.api.biome.v1.modifier.BiomeSelector;
import com.teamaurora.borealib.core.registry.BorealibRegistries;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.tags.HorizonsBiomeTags;
import com.teamaurora.horizons.core.other.tags.HorizonsPlacedFeatureTags;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static com.teamaurora.horizons.core.other.tags.HorizonsPlacedFeatureTags.*;

public class HorizonsBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_TROPICAL_GRASS = key("add_tropical_grass");
    public static final ResourceKey<BiomeModifier> ADD_GIANT_FERNS = key("add_giant_ferns");
    public static final ResourceKey<BiomeModifier> ADD_BLUE_LILY = key("add_blue_lily");
    public static final ResourceKey<BiomeModifier> ADD_LIGHT_GRAY_LILY = key("add_light_gray_lily");
    public static final ResourceKey<BiomeModifier> ADD_CYAN_LILY = key("add_cyan_lily");
    public static final ResourceKey<BiomeModifier> ADD_LIGHT_BLUE_LILY = key("add_light_blue_lily");
    public static final ResourceKey<BiomeModifier> ADD_MAGENTA_LILY = key("add_magenta_lily");
    public static final ResourceKey<BiomeModifier> ADD_PINK_LILY = key("add_pink_lily");
    public static final ResourceKey<BiomeModifier> ADD_PURPLE_LILY = key("add_purple_lily");
    public static final ResourceKey<BiomeModifier> ADD_WHITE_LILY = key("add_white_lily");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        BiomeSelector tropicalGrassSelector = BiomeSelector.existingFeatures(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(TROPICAL_GRASS_REPLACEABLE));
        BiomeModifier addTropicalGrass = BiomeModifier.Builder.selects(tropicalGrassSelector)
                .withAction(BiomeModifierAction.replaceFeaturesNonlinear(
                        GenerationStep.Decoration.VEGETAL_DECORATION,
                        placedFeatures.getOrThrow(TROPICAL_GRASS_REPLACEABLE),
                        HolderSet.direct(placedFeatures.getOrThrow(HorizonsPlacedFeatures.PATCH_TROPICAL_GRASS))))
                .build();
        context.register(ADD_TROPICAL_GRASS, addTropicalGrass);
        tagBasedFeatureAdder(
                context,
                ADD_GIANT_FERNS,
                biomes.getOrThrow(HorizonsBiomeTags.HAS_GIANT_FERN),
                placedFeatures.getOrThrow(HorizonsPlacedFeatures.GIANT_FERN),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );
        tagBasedFeatureAdder(
                context,
                ADD_BLUE_LILY,
                biomes.getOrThrow(HorizonsBiomeTags.HAS_BLUE_LILY),
                placedFeatures.getOrThrow(HorizonsPlacedFeatures.BLUE_LILY),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );
        tagBasedFeatureAdder(
                context,
                ADD_LIGHT_GRAY_LILY,
                biomes.getOrThrow(HorizonsBiomeTags.HAS_LIGHT_GRAY_LILY),
                placedFeatures.getOrThrow(HorizonsPlacedFeatures.LIGHT_GRAY_LILY),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );
        tagBasedFeatureAdder(
                context,
                ADD_CYAN_LILY,
                biomes.getOrThrow(HorizonsBiomeTags.HAS_CYAN_LILY),
                placedFeatures.getOrThrow(HorizonsPlacedFeatures.CYAN_LILY),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );
        tagBasedFeatureAdder(
                context,
                ADD_LIGHT_BLUE_LILY,
                biomes.getOrThrow(HorizonsBiomeTags.HAS_LIGHT_BLUE_LILY),
                placedFeatures.getOrThrow(HorizonsPlacedFeatures.LIGHT_BLUE_LILY),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );
        tagBasedFeatureAdder(
                context,
                ADD_MAGENTA_LILY,
                biomes.getOrThrow(HorizonsBiomeTags.HAS_MAGENTA_LILY),
                placedFeatures.getOrThrow(HorizonsPlacedFeatures.MAGENTA_LILY),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );
        tagBasedFeatureAdder(
                context,
                ADD_PINK_LILY,
                biomes.getOrThrow(HorizonsBiomeTags.HAS_PINK_LILY),
                placedFeatures.getOrThrow(HorizonsPlacedFeatures.PINK_LILY),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );
        tagBasedFeatureAdder(
                context,
                ADD_PURPLE_LILY,
                biomes.getOrThrow(HorizonsBiomeTags.HAS_PURPLE_LILY),
                placedFeatures.getOrThrow(HorizonsPlacedFeatures.PURPLE_LILY),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );
        tagBasedFeatureAdder(
                context,
                ADD_WHITE_LILY,
                biomes.getOrThrow(HorizonsBiomeTags.HAS_WHITE_LILY),
                placedFeatures.getOrThrow(HorizonsPlacedFeatures.WHITE_LILY),
                GenerationStep.Decoration.VEGETAL_DECORATION
        );
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
