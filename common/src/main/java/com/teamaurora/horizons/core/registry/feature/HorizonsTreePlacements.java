package com.teamaurora.horizons.core.registry.feature;

import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static com.teamaurora.horizons.core.registry.HorizonsPlacedFeatures.key;

public final class HorizonsTreePlacements {
    public static final ResourceKey<PlacedFeature> CYPRESS_CHECKED = key("cypress_checked");
    public static final ResourceKey<PlacedFeature> MEGA_CYPRESS_CHECKED = key("mega_cypress_checked");
    public static final ResourceKey<PlacedFeature> WATER_CYPRESS_CHECKED = key("water_cypress_checked");
    public static final ResourceKey<PlacedFeature> WATER_MEGA_CYPRESS_CHECKED = key("water_mega_cypress_checked");
    public static final ResourceKey<PlacedFeature> CYPRESS_BUSH = key("cypress_bush");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> cypress = configuredFeatures.getOrThrow(HorizonsTreeFeatures.CYPRESS);
        Holder<ConfiguredFeature<?, ?>> megaCypress = configuredFeatures.getOrThrow(HorizonsTreeFeatures.MEGA_CYPRESS);
        Holder<ConfiguredFeature<?, ?>> waterCypress = configuredFeatures.getOrThrow(HorizonsTreeFeatures.WATER_CYPRESS);
        Holder<ConfiguredFeature<?, ?>> waterMegaCypress = configuredFeatures.getOrThrow(HorizonsTreeFeatures.WATER_MEGA_CYPRESS);
        Holder<ConfiguredFeature<?, ?>> cypressBush = configuredFeatures.getOrThrow(HorizonsTreeFeatures.CYPRESS_BUSH);

        PlacementUtils.register(context, CYPRESS_CHECKED, cypress, PlacementUtils.filteredByBlockSurvival(HorizonsBlocks.CYPRESS_SAPLING.get()));
        PlacementUtils.register(context, MEGA_CYPRESS_CHECKED, megaCypress, PlacementUtils.filteredByBlockSurvival(HorizonsBlocks.CYPRESS_SAPLING.get()));
        PlacementUtils.register(context, WATER_CYPRESS_CHECKED, waterCypress, PlacementUtils.filteredByBlockSurvival(HorizonsBlocks.CYPRESS_SAPLING.get()));
        PlacementUtils.register(context, WATER_MEGA_CYPRESS_CHECKED, waterMegaCypress, PlacementUtils.filteredByBlockSurvival(HorizonsBlocks.CYPRESS_SAPLING.get()));
        PlacementUtils.register(context, CYPRESS_BUSH, cypressBush, PlacementUtils.filteredByBlockSurvival(HorizonsBlocks.CYPRESS_SAPLING.get()));
    }
}
