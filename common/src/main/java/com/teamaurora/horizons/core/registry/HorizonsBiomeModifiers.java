package com.teamaurora.horizons.core.registry;

import com.teamaurora.borealib.api.biome.v1.modifier.BiomeModifier;
import com.teamaurora.borealib.api.biome.v1.modifier.BiomeModifierAction;
import com.teamaurora.borealib.api.biome.v1.modifier.BiomeSelector;
import com.teamaurora.borealib.core.registry.BorealibRegistries;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.tags.HorizonsPlacedFeatureTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static com.teamaurora.horizons.core.other.tags.HorizonsPlacedFeatureTags.*;

public class HorizonsBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_TROPICAL_GRASS = key("add_tropical_grass");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        BiomeSelector tropicalGrassSelector = BiomeSelector.existingFeatures(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(TROPICAL_GRASS_REPLACEABLE));
        BiomeModifier addTropicalGrass = BiomeModifier.Builder.selects(tropicalGrassSelector)
                .withAction(BiomeModifierAction.replaceFeaturesNonlinear(
                        GenerationStep.Decoration.VEGETAL_DECORATION,
                        placedFeatures.getOrThrow(TROPICAL_GRASS_REPLACEABLE),
                        HolderSet.direct(placedFeatures.getOrThrow(HorizonsPlacedFeatures.PATCH_TROPICAL_GRASS))))
                .build();
        context.register(ADD_TROPICAL_GRASS, addTropicalGrass);
    }

    private static ResourceKey<BiomeModifier> key(String path) {
        return ResourceKey.create(BorealibRegistries.BIOME_MODIFIERS, Horizons.location(path));
    }
}
