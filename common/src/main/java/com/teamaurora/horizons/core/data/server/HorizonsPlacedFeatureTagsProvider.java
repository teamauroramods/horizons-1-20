package com.teamaurora.horizons.core.data.server;

import com.teamaurora.borealib.api.datagen.v1.BorealibPackOutput;
import com.teamaurora.borealib.api.datagen.v1.providers.BorealibTagsProvider;
import com.teamaurora.horizons.core.other.tags.HorizonsPlacedFeatureTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.concurrent.CompletableFuture;

public class HorizonsPlacedFeatureTagsProvider extends BorealibTagsProvider<PlacedFeature> {

    public HorizonsPlacedFeatureTagsProvider(BorealibPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.PLACED_FEATURE, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        this.tag(HorizonsPlacedFeatureTags.TROPICAL_GRASS_REPLACEABLE).add(VegetationPlacements.PATCH_GRASS_JUNGLE);
    }
}
