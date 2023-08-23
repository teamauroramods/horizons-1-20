package com.teamaurora.horizons.core.other.tags;

import com.teamaurora.horizons.core.Horizons;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class HorizonsPlacedFeatureTags {

    public static final TagKey<PlacedFeature> TROPICAL_GRASS_REPLACEABLE = TagKey.create(Registries.PLACED_FEATURE, Horizons.location("tropical_grass_replaceable"));
}
