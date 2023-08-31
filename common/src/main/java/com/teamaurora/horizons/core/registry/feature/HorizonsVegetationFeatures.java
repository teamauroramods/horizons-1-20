package com.teamaurora.horizons.core.registry.feature;

import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

import static com.teamaurora.horizons.core.registry.HorizonsConfiguredFeatures.key;

/**
 * @author rose_
 * @author ebo2022
 */
public final class HorizonsVegetationFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TROPICAL_GRASS = key("patch_tropical_grass");
    public static final ResourceKey<ConfiguredFeature<? ,?>> ALGAE = key("algae");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_FERN = key("giant_fern");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_LILY = key("blue_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_GRAY_LILY = key("light_gray_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYAN_LILY = key("cyan_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_BLUE_LILY = key("light_blue_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAGENTA_LILY = key("magenta_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_LILY = key("pink_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_LILY = key("purple_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_LILY = key("white_lily");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FIDDLENECK = key("fiddleneck");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMARANTHUS = key("amaranthus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MYOSOTIS = key("myosotis");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HELICONIA = key("heliconia");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_CYPRESS = key("trees_cypress");
    public static final ResourceKey<ConfiguredFeature<? ,?>> TREES_WATER_CYPRESS = key("trees_water_cypress");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        Holder<PlacedFeature> cypress = placedFeatures.getOrThrow(HorizonsTreePlacements.CYPRESS_CHECKED);
        Holder<PlacedFeature> megaCypress = placedFeatures.getOrThrow(HorizonsTreePlacements.MEGA_CYPRESS_CHECKED);
        Holder<PlacedFeature> waterCypress = placedFeatures.getOrThrow(HorizonsTreePlacements.WATER_CYPRESS_CHECKED);
        Holder<PlacedFeature> waterMegaCypress = placedFeatures.getOrThrow(HorizonsTreePlacements.WATER_MEGA_CYPRESS_CHECKED);
        Holder<PlacedFeature> cypressBush = placedFeatures.getOrThrow(HorizonsTreePlacements.CYPRESS_BUSH);

        FeatureUtils.register(
                context,
                PATCH_TROPICAL_GRASS,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        32,
                        7,
                        3,
                        PlacementUtils.filtered(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        new WeightedStateProvider(
                                                SimpleWeightedRandomList.<BlockState>builder().add(HorizonsBlocks.TROPICAL_GRASS.get().defaultBlockState(), 3).add(HorizonsBlocks.TROPICAL_FERN.get().defaultBlockState(), 1)
                                        )
                                ),
                                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.not(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.PODZOL)))
                        )
                )
        );

        FeatureUtils.register(context, ALGAE, HorizonsFeatures.ALGAE_PATCH.get(), NoneFeatureConfiguration.INSTANCE);
        FeatureUtils.register(context, GIANT_FERN, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.GIANT_FERN.get().defaultBlockState()))));
        FeatureUtils.register(context, BLUE_LILY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.BLUE_LILY.get().defaultBlockState())))));

        FeatureUtils.register(context, LIGHT_GRAY_LILY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.LIGHT_GRAY_LILY.get().defaultBlockState())))));
        FeatureUtils.register(context, CYAN_LILY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.CYAN_LILY.get().defaultBlockState())))));
        FeatureUtils.register(context, LIGHT_BLUE_LILY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.LIGHT_BLUE_LILY.get().defaultBlockState())))));
        FeatureUtils.register(context, MAGENTA_LILY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.MAGENTA_LILY.get().defaultBlockState())))));
        FeatureUtils.register(context, PINK_LILY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.PINK_LILY.get().defaultBlockState())))));
        FeatureUtils.register(context, PURPLE_LILY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.PURPLE_LILY.get().defaultBlockState())))));
        FeatureUtils.register(context, WHITE_LILY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.WHITE_LILY.get().defaultBlockState())))));

        FeatureUtils.register(context, FIDDLENECK, Feature.RANDOM_PATCH, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.FIDDLENECK.get().defaultBlockState())))));
        FeatureUtils.register(context, AMARANTHUS, Feature.RANDOM_PATCH, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.AMARANTHUS.get().defaultBlockState())))));
        FeatureUtils.register(context, MYOSOTIS, Feature.RANDOM_PATCH, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.MYOSOTIS.get().defaultBlockState())))));
        FeatureUtils.register(context, HELICONIA, Feature.RANDOM_PATCH, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.HELICONIA.get().defaultBlockState())))));

        FeatureUtils.register(context, TREES_CYPRESS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(cypressBush, 0.35f), new WeightedPlacedFeature(megaCypress, 0.333333334F)), cypress));
        FeatureUtils.register(context, TREES_WATER_CYPRESS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(waterMegaCypress, 0.333333334F)), waterCypress));
    }
}
