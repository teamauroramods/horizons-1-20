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

/**
 * @author rose_
 * @author ebo2022
 */
public final class HorizonsTreePlacements {
    public static final ResourceKey<PlacedFeature> CYPRESS_CHECKED = key("cypress_checked");
    public static final ResourceKey<PlacedFeature> MEGA_CYPRESS_CHECKED = key("mega_cypress_checked");
    public static final ResourceKey<PlacedFeature> WATER_CYPRESS_CHECKED = key("water_cypress_checked");
    public static final ResourceKey<PlacedFeature> WATER_MEGA_CYPRESS_CHECKED = key("water_mega_cypress_checked");
    public static final ResourceKey<PlacedFeature> CYPRESS_BUSH = key("cypress_bush");

    public static final ResourceKey<PlacedFeature> JACARANDA_TREE_CHECKED = key("jacaranda_tree_checked");
    public static final ResourceKey<PlacedFeature> FLOWERING_JACARANDA_TREE_CHECKED = key("flowering_jacaranda_tree_checked");

    public static final ResourceKey<PlacedFeature> REDWOOD_TREE_CHECKED = key("redwood_tree_checked");
    public static final ResourceKey<PlacedFeature> MEGA_REDWOOD_TREE_CHECKED = key("mega_redwood_tree_checked");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> cypress = configuredFeatures.getOrThrow(HorizonsTreeFeatures.CYPRESS);
        Holder<ConfiguredFeature<?, ?>> megaCypress = configuredFeatures.getOrThrow(HorizonsTreeFeatures.MEGA_CYPRESS);
        Holder<ConfiguredFeature<?, ?>> waterCypress = configuredFeatures.getOrThrow(HorizonsTreeFeatures.WATER_CYPRESS);
        Holder<ConfiguredFeature<?, ?>> waterMegaCypress = configuredFeatures.getOrThrow(HorizonsTreeFeatures.WATER_MEGA_CYPRESS);
        Holder<ConfiguredFeature<?, ?>> cypressBush = configuredFeatures.getOrThrow(HorizonsTreeFeatures.CYPRESS_BUSH);

        Holder<ConfiguredFeature<?, ?>> jacaranda = configuredFeatures.getOrThrow(HorizonsTreeFeatures.JACARANDA_TREE);
        Holder<ConfiguredFeature<?, ?>> floweringJacaranda = configuredFeatures.getOrThrow(HorizonsTreeFeatures.FLOWERING_JACARANDA_TREE);

        Holder<ConfiguredFeature<?, ?>> redwood = configuredFeatures.getOrThrow(HorizonsTreeFeatures.REDWOOD_TREE);
        Holder<ConfiguredFeature<?, ?>> megaRedwood = configuredFeatures.getOrThrow(HorizonsTreeFeatures.MEGA_REDWOOD_TREE);

        PlacementUtils.register(context, CYPRESS_CHECKED, cypress, PlacementUtils.filteredByBlockSurvival(HorizonsBlocks.CYPRESS_SAPLING.get()));
        PlacementUtils.register(context, MEGA_CYPRESS_CHECKED, megaCypress, PlacementUtils.filteredByBlockSurvival(HorizonsBlocks.CYPRESS_SAPLING.get()));
        PlacementUtils.register(context, WATER_CYPRESS_CHECKED, waterCypress, PlacementUtils.filteredByBlockSurvival(HorizonsBlocks.CYPRESS_SAPLING.get()));
        PlacementUtils.register(context, WATER_MEGA_CYPRESS_CHECKED, waterMegaCypress, PlacementUtils.filteredByBlockSurvival(HorizonsBlocks.CYPRESS_SAPLING.get()));
        PlacementUtils.register(context, CYPRESS_BUSH, cypressBush, PlacementUtils.filteredByBlockSurvival(HorizonsBlocks.CYPRESS_SAPLING.get()));

        PlacementUtils.register(context, JACARANDA_TREE_CHECKED, jacaranda, PlacementUtils.filteredByBlockSurvival(HorizonsBlocks.JACARANDA_SAPLING.get()));
        PlacementUtils.register(context, FLOWERING_JACARANDA_TREE_CHECKED, floweringJacaranda, PlacementUtils.filteredByBlockSurvival(HorizonsBlocks.FLOWERING_JACARANDA_SAPLING.get()));

        PlacementUtils.register(context, REDWOOD_TREE_CHECKED, redwood, PlacementUtils.filteredByBlockSurvival(HorizonsBlocks.REDWOOD_SAPLING.get()));
        PlacementUtils.register(context, MEGA_REDWOOD_TREE_CHECKED, megaRedwood, PlacementUtils.filteredByBlockSurvival(HorizonsBlocks.REDWOOD_SAPLING.get()));
    }
}
