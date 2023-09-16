package com.teamaurora.horizons.core.registry.feature;

import com.teamaurora.horizons.common.levelgen.treedecorators.*;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;

import static com.teamaurora.horizons.core.registry.HorizonsConfiguredFeatures.key;
import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;

public final class HorizonsTreeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_GROWN = key("cypress_grown");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_CYPRESS_GROWN = key("mega_cypress_grown");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS = key("cypress");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_CYPRESS = key("mega_cypress");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_CYPRESS = key("water_cypress");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_MEGA_CYPRESS = key("water_mega_cypress");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_BUSH = key("cypress_bush");

    public static final ResourceKey<ConfiguredFeature<?, ?>> JACARANDA_TREE = key("jacaranda_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_JACARANDA_TREE = key("flowering_jacaranda_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD_TREE = key("redwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_REDWOOD_TREE = key("mega_redwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_REDWOOD_TREE = key("giant_redwood_tree");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        // Cypress //
        FeatureUtils.register(context, CYPRESS_GROWN, HorizonsFeatures.CYPRESS_TREE.get(), createGrownCypress().build());
        FeatureUtils.register(context, MEGA_CYPRESS_GROWN, HorizonsFeatures.MEGA_CYPRESS_TREE.get(), createGrownCypress().build());
        FeatureUtils.register(context, CYPRESS, HorizonsFeatures.CYPRESS_TREE.get(), createNaturalCypress(true).build());
        FeatureUtils.register(context, MEGA_CYPRESS, HorizonsFeatures.MEGA_CYPRESS_TREE.get(), createNaturalCypress(false).build());
        FeatureUtils.register(context, WATER_CYPRESS, HorizonsFeatures.WATER_CYPRESS_TREE.get(), createNaturalCypress(true).build());
        FeatureUtils.register(context, WATER_MEGA_CYPRESS, HorizonsFeatures.WATER_MEGA_CYPRESS_TREE.get(), createNaturalCypress(false).build());
        FeatureUtils.register(context, CYPRESS_BUSH, Feature.TREE, createCypressBush().build());

        // Jacaranda //
        FeatureUtils.register(context, JACARANDA_TREE, HorizonsFeatures.JACARANDA_TREE.get(), createJacarandaTree(JACARANDA_LEAVES.get()).build());
        FeatureUtils.register(context, FLOWERING_JACARANDA_TREE, HorizonsFeatures.JACARANDA_TREE.get(), createJacarandaTree(FLOWERING_JACARANDA_LEAVES.get()).build());

        // Redwood //
        FeatureUtils.register(context, REDWOOD_TREE, HorizonsFeatures.REDWOOD_TREE.get(), createRedwoodTree().build());
        FeatureUtils.register(context, MEGA_REDWOOD_TREE, HorizonsFeatures.MEGA_REDWOOD_TREE.get(), createRedwoodTree().build());
        FeatureUtils.register(context, GIANT_REDWOOD_TREE, HorizonsFeatures.GIANT_REDWOOD_TREE.get(), createRedwoodTree().build());
    }

    private static TreeConfiguration.TreeConfigurationBuilder createGrownCypress() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(CYPRESS_LOG.get().defaultBlockState()),
                new StraightTrunkPlacer(0, 0, 0),
                BlockStateProvider.simple(CYPRESS_LEAVES.get().defaultBlockState()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        ).ignoreVines().decorators(List.of(
                HangingCypressLeavesTreeDecorator.INSTANCE,
                CypressBranchTreeDecorator.INSTANCE
        ));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createNaturalCypress(boolean sparseKnees) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(CYPRESS_LOG.get().defaultBlockState()),
                new StraightTrunkPlacer(0, 0, 0),
                BlockStateProvider.simple(CYPRESS_LEAVES.get().defaultBlockState()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        ).ignoreVines().decorators(List.of(
                HangingCypressLeavesTreeDecorator.INSTANCE,
                CypressBranchTreeDecorator.INSTANCE,
                new LeaveVineDecorator(0.0625F),
                sparseKnees ? SparseCypressKneesTreeDecorator.INSTANCE : CypressKneesTreeDecorator.INSTANCE,
                BeardMossTreeDecorator.INSTANCE,
                new BeehiveDecorator(.005f)
        ));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createCypressBush() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(CYPRESS_LOG.get().defaultBlockState()),
                new StraightTrunkPlacer(1, 0, 0),
                BlockStateProvider.simple(CYPRESS_LEAVES.get()),
                new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
                new TwoLayersFeatureSize(0, 0, 0));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createJacarandaTree(Block leaves) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(JACARANDA_LOG.get().defaultBlockState()),
                new StraightTrunkPlacer(0, 0, 0),
                BlockStateProvider.simple(leaves.defaultBlockState()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        ).ignoreVines().decorators(List.of(
                new BranchTreeDecorator(BlockStateProvider.simple(JACARANDA_LOG.get()), 1),
                new BeehiveDecorator(.0075f)
        ));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createRedwoodTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(REDWOOD_LOG.get().defaultBlockState()),
                new StraightTrunkPlacer(0, 0, 0),
                BlockStateProvider.simple(REDWOOD_LEAVES.get().defaultBlockState()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        ).ignoreVines().decorators(List.of(
                new BranchTreeDecorator(BlockStateProvider.simple(REDWOOD_LOG.get()), 3),
                new BeehiveDecorator(.005f)
        ));
    }

}
