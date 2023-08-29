package com.teamaurora.horizons.core.registry.feature;

import com.teamaurora.horizons.common.levelgen.treedecorators.*;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;

import static com.teamaurora.horizons.core.registry.HorizonsConfiguredFeatures.key;

public final class HorizonsTreeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_GROWN = key("cypress_grown");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_CYPRESS_GROWN = key("mega_cypress_grown");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS = key("cypress");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_CYPRESS = key("mega_cypress");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_CYPRESS = key("water_cypress");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_MEGA_CYPRESS = key("water_mega_cypress");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_BUSH = key("cypress_bush");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(
                context,
                CYPRESS_GROWN,
                HorizonsFeatures.CYPRESS_TREE.get(),
                createGrownCypress().build()
        );
        FeatureUtils.register(
                context,
                MEGA_CYPRESS_GROWN,
                HorizonsFeatures.MEGA_CYPRESS_TREE.get(),
                createGrownCypress().build()
        );
        FeatureUtils.register(
                context,
                CYPRESS,
                HorizonsFeatures.CYPRESS_TREE.get(),
                createNaturalCypress(true).build()
        );
        FeatureUtils.register(
                context,
                MEGA_CYPRESS,
                HorizonsFeatures.MEGA_CYPRESS_TREE.get(),
                createNaturalCypress(false).build()
        );
        FeatureUtils.register(
                context,
                WATER_CYPRESS,
                HorizonsFeatures.WATER_CYPRESS_TREE.get(),
                createNaturalCypress(true).build()
        );
        FeatureUtils.register(
                context,
                WATER_MEGA_CYPRESS,
                HorizonsFeatures.WATER_MEGA_CYPRESS_TREE.get(),
                createNaturalCypress(false).build()
        );
        FeatureUtils.register(
                context,
                CYPRESS_BUSH,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(HorizonsBlocks.CYPRESS_LOG.get().defaultBlockState()),
                        new StraightTrunkPlacer(1, 0, 0),
                        BlockStateProvider.simple(HorizonsBlocks.CYPRESS_LEAVES.get()),
                        new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
                        new TwoLayersFeatureSize(0, 0, 0)
                ).build()
        );
    }

    private static TreeConfiguration.TreeConfigurationBuilder createGrownCypress() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(HorizonsBlocks.CYPRESS_LOG.get().defaultBlockState()),
                new StraightTrunkPlacer(0, 0, 0),
                BlockStateProvider.simple(HorizonsBlocks.CYPRESS_LEAVES.get().defaultBlockState()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )
                .ignoreVines()
                .decorators(List.of(
                        HangingCypressLeavesTreeDecorator.INSTANCE,
                        CypressBranchTreeDecorator.INSTANCE
                ));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createNaturalCypress(boolean sparseKnees) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(HorizonsBlocks.CYPRESS_LOG.get().defaultBlockState()),
                new StraightTrunkPlacer(0, 0, 0),
                BlockStateProvider.simple(HorizonsBlocks.CYPRESS_LEAVES.get().defaultBlockState()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )
                .ignoreVines()
                .decorators(List.of(
                        HangingCypressLeavesTreeDecorator.INSTANCE,
                        CypressBranchTreeDecorator.INSTANCE,
                        new LeaveVineDecorator(0.0625F),
                        sparseKnees ? SparseCypressKneesTreeDecorator.INSTANCE : CypressKneesTreeDecorator.INSTANCE,
                        BeardMossTreeDecorator.INSTANCE
                ));
    }
}
