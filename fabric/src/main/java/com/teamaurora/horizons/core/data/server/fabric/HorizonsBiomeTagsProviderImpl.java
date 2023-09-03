package com.teamaurora.horizons.core.data.server.fabric;

import com.teamaurora.horizons.core.data.server.HorizonsBiomeTagsProvider;
import com.teamaurora.horizons.core.other.tags.HorizonsBiomeTags;
import com.teamaurora.horizons.core.registry.HorizonsBiomes;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;

public class HorizonsBiomeTagsProviderImpl {
    public static void handlePlatformTags(HorizonsBiomeTagsProvider provider, HolderLookup.Provider registries) {
        provider.tag(HorizonsBiomeTags.HAS_GIANT_FERN).addOptionalTag(ConventionalBiomeTags.SWAMP.location()).add(Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA, HorizonsBiomes.REDWOOD_FOREST);
        provider.tag(HorizonsBiomeTags.HAS_BLUE_LILY).addOptionalTag(ConventionalBiomeTags.SWAMP.location());
        provider.tag(HorizonsBiomeTags.HAS_LIGHT_GRAY_LILY).addOptionalTag(ConventionalBiomeTags.SWAMP.location());
        provider.tag(HorizonsBiomeTags.HAS_CYAN_LILY).addOptionalTag(ConventionalBiomeTags.SWAMP.location());
        provider.tag(HorizonsBiomeTags.HAS_LIGHT_BLUE_LILY).addOptionalTag(ConventionalBiomeTags.SWAMP.location());
        provider.tag(HorizonsBiomeTags.HAS_MAGENTA_LILY).addOptionalTag(ConventionalBiomeTags.SWAMP.location());
        provider.tag(HorizonsBiomeTags.HAS_PINK_LILY).addOptionalTag(ConventionalBiomeTags.SWAMP.location());
        provider.tag(HorizonsBiomeTags.HAS_PURPLE_LILY).addOptionalTag(ConventionalBiomeTags.SWAMP.location());
        provider.tag(HorizonsBiomeTags.HAS_WHITE_LILY).addOptionalTag(ConventionalBiomeTags.SWAMP.location());

        provider.tag(HorizonsBiomeTags.HAS_AMARANTHUS).add(Biomes.CHERRY_GROVE);
        provider.tag(HorizonsBiomeTags.HAS_MYOSOTIS).addOptionalTag(ConventionalBiomeTags.TAIGA.location());
        provider.tag(HorizonsBiomeTags.HAS_FIDDLENECK).add(HorizonsBiomes.REDWOOD_FOREST, Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA);
        provider.tag(HorizonsBiomeTags.HAS_HELICONIA).add(HorizonsBiomes.REDWOOD_FOREST);

        provider.tag(ConventionalBiomeTags.SWAMP).add(HorizonsBiomes.BAYOU);
        provider.tag(ConventionalBiomeTags.VEGETATION_DENSE).add(HorizonsBiomes.BAYOU, HorizonsBiomes.REDWOOD_FOREST);
        provider.tag(ConventionalBiomeTags.TREE_CONIFEROUS).add(HorizonsBiomes.REDWOOD_FOREST);

        provider.tag(HorizonsBiomeTags.HAS_ALGAE).add(HorizonsBiomes.BAYOU);

        provider.tag(BiomeTags.IS_FOREST).add(HorizonsBiomes.BAYOU).add(HorizonsBiomes.REDWOOD_FOREST);
        provider.tag(BiomeTags.IS_TAIGA).add(HorizonsBiomes.REDWOOD_FOREST);
        provider.tag(BiomeTags.HAS_MINESHAFT).add(HorizonsBiomes.BAYOU).add(HorizonsBiomes.REDWOOD_FOREST);
        provider.tag(BiomeTags.HAS_SWAMP_HUT).add(HorizonsBiomes.BAYOU);
        provider.tag(BiomeTags.SPAWNS_WARM_VARIANT_FROGS).add(HorizonsBiomes.BAYOU);
        provider.tag(BiomeTags.HAS_RUINED_PORTAL_SWAMP).add(HorizonsBiomes.BAYOU);
        provider.tag(BiomeTags.STRONGHOLD_BIASED_TO).add(HorizonsBiomes.REDWOOD_FOREST);
    }
}
