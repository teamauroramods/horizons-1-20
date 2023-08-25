package com.teamaurora.horizons.core.registry;

import com.teamaurora.borealib.api.registry.v1.RegistryReference;
import com.teamaurora.borealib.api.registry.v1.RegistryWrapper;
import com.teamaurora.horizons.common.levelgen.feature.CypressTreeFeature;
import com.teamaurora.horizons.common.levelgen.treedecorators.CypressBranchTreeDecorator;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class HorizonsFeatures {

    public static final RegistryWrapper.FeatureProvider PROVIDER = RegistryWrapper.featureProvider(Horizons.MOD_ID);

    public static final RegistryReference<TreeDecoratorType<CypressBranchTreeDecorator>> CYPRESS_BRANCH_DECORATOR = PROVIDER.registerTreeDecoratorType("cypress_branches", CypressBranchTreeDecorator.CODEC);
    public static final RegistryReference<CypressTreeFeature> CYPRESS_TREE = PROVIDER.register("cypress_tree", CypressTreeFeature::new);
}
