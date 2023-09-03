package com.teamaurora.horizons.core.registry;

import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.HorizonsOverworldBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public final class HorizonsBiomes {
    public static final ResourceKey<Biome> ATACAMA_DESERT = biome("atacama_desert");
    public static final ResourceKey<Biome> BAYOU = biome("bayou");
    public static final ResourceKey<Biome> LAVENDER_FIELD = biome("lavender_field");
    public static final ResourceKey<Biome> LAVENDER_FOREST = biome("lavender_forest");
    public static final ResourceKey<Biome> REDWOOD_FOREST = biome("redwood_forest");

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> featureGetter = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> carverGetter = context.lookup(Registries.CONFIGURED_CARVER);

        context.register(BAYOU, HorizonsOverworldBiomes.bayou(featureGetter, carverGetter));
        context.register(REDWOOD_FOREST, HorizonsOverworldBiomes.redwoodForest(featureGetter, carverGetter));
        context.register(LAVENDER_FIELD, HorizonsOverworldBiomes.lavenderField(featureGetter, carverGetter));
    }

    private static ResourceKey<Biome> biome(String path) {
        return ResourceKey.create(Registries.BIOME, Horizons.location(path));
    }
}
