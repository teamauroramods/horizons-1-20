package com.teamaurora.horizons.core.registry;

import com.teamaurora.horizons.common.levelgen.treedecorators.CypressBranchTreeDecorator;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.InclusiveRange;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.DualNoiseProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

/**
 * @author rose_
 * @author ebo2022
 */
public class HorizonsConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TROPICAL_GRASS = key("patch_tropical_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_FERN = key("giant_fern");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_LILY = key("blue_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_GRAY_LILY = key("light_gray_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYAN_LILY = key("cyan_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_BLUE_LILY = key("light_blue_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAGENTA_LILY = key("magenta_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_LILY = key("pink_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_LILY = key("purple_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_LILY = key("white_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_GROWN = key("cypress_grown");


    private static ResourceKey<ConfiguredFeature<?, ?>> key(String path) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Horizons.location(path));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
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
        FeatureUtils.register(
                context,
                GIANT_FERN,
                Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.GIANT_FERN.get().defaultBlockState())))
        );
        FeatureUtils.register(
                context,
                BLUE_LILY,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.BLUE_LILY.get().defaultBlockState())))
                )
        );
        FeatureUtils.register(
                context,
                LIGHT_GRAY_LILY,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.LIGHT_GRAY_LILY.get().defaultBlockState())))
                )
        );
        FeatureUtils.register(
                context,
                CYAN_LILY,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.CYAN_LILY.get().defaultBlockState())))
                )
        );
        FeatureUtils.register(
                context,
                LIGHT_BLUE_LILY,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.LIGHT_BLUE_LILY.get().defaultBlockState())))
                )
        );
        FeatureUtils.register(
                context,
                MAGENTA_LILY,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.MAGENTA_LILY.get().defaultBlockState())))
                )
        );
        FeatureUtils.register(
                context,
                PINK_LILY,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.PINK_LILY.get().defaultBlockState())))
                )
        );
        FeatureUtils.register(
                context,
                PURPLE_LILY,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.PURPLE_LILY.get().defaultBlockState())))
                )
        );
        FeatureUtils.register(
                context,
                WHITE_LILY,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HorizonsBlocks.WHITE_LILY.get().defaultBlockState())))
                )
        );
        FeatureUtils.register(
                context,
                CYPRESS_GROWN,
                HorizonsFeatures.CYPRESS_TREE.get(),
                createCypress(false).build()
        );
    }

    private static RandomPatchConfiguration createPlantPatch(int tries, BlockState state) {
        return new RandomPatchConfiguration(
                tries,
                6,
                2,
                PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                        new DualNoiseProvider(
                                new InclusiveRange<>(1, 3),
                                new NormalNoise.NoiseParameters(-10, 1d),
                                1f,
                                2345L,
                                new NormalNoise.NoiseParameters(-3, 1d), 1f,
                                List.of(state)
                        )
                ))
        );
    }

    private static TreeConfiguration.TreeConfigurationBuilder createCypress(boolean natural) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(HorizonsBlocks.CYPRESS_LOG.get().defaultBlockState()),
                new StraightTrunkPlacer(0, 0, 0),
                BlockStateProvider.simple(HorizonsBlocks.CYPRESS_LEAVES.get().defaultBlockState()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )
                .ignoreVines()
                .decorators(List.of(
                        new AttachedToLeavesDecorator(
                                0.14F,
                                1,
                                0,
                                BlockStateProvider.simple(HorizonsBlocks.HANGING_CYPRESS_LEAVES.get().defaultBlockState()),
                                2,
                                List.of(Direction.DOWN)
                        ),
                        CypressBranchTreeDecorator.INSTANCE
                ));
    }
}
