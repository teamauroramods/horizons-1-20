package com.teamaurora.horizons.core.data.server.fabric;

import com.teamaurora.horizons.core.data.server.HorizonsBiomeTagsProvider;
import com.teamaurora.horizons.core.other.tags.HorizonsBiomeTags;
import com.teamaurora.horizons.core.registry.HorizonsBiomes;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.core.HolderLookup;

public class HorizonsBiomeTagsProviderImpl {
    public static void handlePlatformTags(HorizonsBiomeTagsProvider provider, HolderLookup.Provider registries) {
        provider.tag(HorizonsBiomeTags.HAS_GIANT_FERN).addOptionalTag(ConventionalBiomeTags.SWAMP.location());
        provider.tag(HorizonsBiomeTags.HAS_BLUE_LILY).addOptionalTag(ConventionalBiomeTags.SWAMP.location());
        provider.tag(HorizonsBiomeTags.HAS_LIGHT_GRAY_LILY).addOptionalTag(ConventionalBiomeTags.SWAMP.location());
        provider.tag(HorizonsBiomeTags.HAS_CYAN_LILY).addOptionalTag(ConventionalBiomeTags.SWAMP.location());
        provider.tag(HorizonsBiomeTags.HAS_LIGHT_BLUE_LILY).addOptionalTag(ConventionalBiomeTags.SWAMP.location());
        provider.tag(HorizonsBiomeTags.HAS_MAGENTA_LILY).addOptionalTag(ConventionalBiomeTags.SWAMP.location());
        provider.tag(HorizonsBiomeTags.HAS_PINK_LILY).addOptionalTag(ConventionalBiomeTags.SWAMP.location());
        provider.tag(HorizonsBiomeTags.HAS_PURPLE_LILY).addOptionalTag(ConventionalBiomeTags.SWAMP.location());
        provider.tag(HorizonsBiomeTags.HAS_WHITE_LILY).addOptionalTag(ConventionalBiomeTags.SWAMP.location());

        provider.tag(ConventionalBiomeTags.SWAMP).add(HorizonsBiomes.BAYOU);
        provider.tag(ConventionalBiomeTags.VEGETATION_DENSE).add(HorizonsBiomes.BAYOU, HorizonsBiomes.REDWOOD_FOREST);
        provider.tag(ConventionalBiomeTags.TREE_CONIFEROUS).add(HorizonsBiomes.REDWOOD_FOREST);
    }
}
