package com.teamaurora.horizons.core.registry;

import com.teamaurora.borealib.api.registry.v1.RegistryReference;
import com.teamaurora.borealib.api.registry.v1.RegistryWrapper;
import com.teamaurora.horizons.common.levelgen.feature.*;
import com.teamaurora.horizons.common.levelgen.treedecorators.*;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public final class HorizonsFeatures {
    public static final RegistryWrapper.FeatureProvider PROVIDER = RegistryWrapper.featureProvider(Horizons.MOD_ID);

    // Cypress //
    public static final RegistryReference<CypressTreeFeature> CYPRESS_TREE = PROVIDER.register("cypress_tree", CypressTreeFeature::new);
    public static final RegistryReference<MegaCypressTreeFeature> MEGA_CYPRESS_TREE = PROVIDER.register("mega_cypress_tree", MegaCypressTreeFeature::new);
    public static final RegistryReference<WaterCypressTreeFeature> WATER_CYPRESS_TREE = PROVIDER.register("water_cypress_tree", WaterCypressTreeFeature::new);
    public static final RegistryReference<WaterMegaCypressTreeFeature> WATER_MEGA_CYPRESS_TREE = PROVIDER.register("water_mega_cypress_tree", WaterMegaCypressTreeFeature::new);
    public static final RegistryReference<AlgaePatchFeature> ALGAE_PATCH = PROVIDER.register("algae_patch", AlgaePatchFeature::new);
    public static final RegistryReference<TreeDecoratorType<CypressBranchTreeDecorator>> CYPRESS_BRANCH = PROVIDER.registerTreeDecoratorType("cypress_branch", CypressBranchTreeDecorator.CODEC);
    public static final RegistryReference<TreeDecoratorType<HangingCypressLeavesTreeDecorator>> HANGING_CYPRESS_LEAVES = PROVIDER.registerTreeDecoratorType("hanging_cypress_leaves", HangingCypressLeavesTreeDecorator.CODEC);
    public static final RegistryReference<TreeDecoratorType<BeardMossTreeDecorator>> BEARD_MOSS = PROVIDER.registerTreeDecoratorType("beard_moss", BeardMossTreeDecorator.CODEC);
    public static final RegistryReference<TreeDecoratorType<CypressKneesTreeDecorator>> CYPRESS_KNEES = PROVIDER.registerTreeDecoratorType("cypress_knees", CypressKneesTreeDecorator.CODEC);
    public static final RegistryReference<TreeDecoratorType<SparseCypressKneesTreeDecorator>> CYPRESS_KNEES_SPARSE = PROVIDER.registerTreeDecoratorType("cypress_knees_sparse", SparseCypressKneesTreeDecorator.CODEC);

    // Jacaranda & Lavender //
    public static final RegistryReference<JacarandaTreeFeature> JACARANDA_TREE = PROVIDER.register("jacaranda_tree", JacarandaTreeFeature::new);
    public static final RegistryReference<LavenderFeature> LAVENDER = PROVIDER.register("lavender", LavenderFeature::new);


    // Redwood //
    public static final RegistryReference<RedwoodTreeFeature> REDWOOD_TREE = PROVIDER.register("redwood_tree", RedwoodTreeFeature::new);
    public static final RegistryReference<MegaRedwoodTreeFeature> MEGA_REDWOOD_TREE = PROVIDER.register("mega_redwood_tree", MegaRedwoodTreeFeature::new);
    public static final RegistryReference<GiantRedwoodTree> GIANT_REDWOOD_TREE = PROVIDER.register("giant_redwood_tree", GiantRedwoodTree::new);

    // Misc //
    public static final RegistryReference<TreeDecoratorType<BranchTreeDecorator>> BRANCH = PROVIDER.registerTreeDecoratorType("branch", BranchTreeDecorator.CODEC);

}