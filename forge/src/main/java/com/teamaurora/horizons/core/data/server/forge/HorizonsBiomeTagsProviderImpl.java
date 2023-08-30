package com.teamaurora.horizons.core.data.server.forge;

import com.teamaurora.horizons.core.data.server.HorizonsBiomeTagsProvider;
import com.teamaurora.horizons.core.other.tags.HorizonsBiomeTags;
import com.teamaurora.horizons.core.registry.HorizonsBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;

public class HorizonsBiomeTagsProviderImpl {
    public static void handlePlatformTags(HorizonsBiomeTagsProvider provider, HolderLookup.Provider registries) {
        provider.tag(HorizonsBiomeTags.HAS_GIANT_FERN).addTag(Tags.Biomes.IS_SWAMP).add(Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA).addOptional(HorizonsBiomes.REDWOOD_FOREST.location());
        provider.tag(HorizonsBiomeTags.HAS_BLUE_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_LIGHT_GRAY_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_CYAN_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_LIGHT_BLUE_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_MAGENTA_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_PINK_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_PURPLE_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_WHITE_LILY).addTag(Tags.Biomes.IS_SWAMP);

        provider.tag(HorizonsBiomeTags.HAS_AMARANTHUS).addTag(BiomeTags.IS_JUNGLE);
        provider.tag(HorizonsBiomeTags.HAS_MYOSOTIS).addTag(BiomeTags.IS_JUNGLE).add(Biomes.MEADOW);
        provider.tag(HorizonsBiomeTags.HAS_FIDDLENECK).addTag(BiomeTags.IS_JUNGLE);
        provider.tag(HorizonsBiomeTags.HAS_HELICONIA).addTag(BiomeTags.IS_JUNGLE);

        provider.tag(Tags.Biomes.IS_SWAMP).addOptional(HorizonsBiomes.BAYOU.location());
        provider.tag(Tags.Biomes.IS_DENSE_OVERWORLD).addOptional(HorizonsBiomes.BAYOU.location()).addOptional(HorizonsBiomes.REDWOOD_FOREST.location());
        provider.tag(Tags.Biomes.IS_CONIFEROUS).addOptional(HorizonsBiomes.REDWOOD_FOREST.location());
        provider.tag(HorizonsBiomeTags.HAS_PERCH).addOptional(HorizonsBiomes.BAYOU.location());
        provider.tag(HorizonsBiomeTags.HAS_CATTAILS).addOptional(HorizonsBiomes.BAYOU.location());
        provider.tag(HorizonsBiomeTags.HAS_RARE_CHESTNUT_TREES).addOptional(HorizonsBiomes.REDWOOD_FOREST.location());

        provider.tag(HorizonsBiomeTags.HAS_ALGAE).addOptional(HorizonsBiomes.BAYOU.location());

        provider.tag(BiomeTags.IS_FOREST).addOptional(HorizonsBiomes.BAYOU.location()).addOptional(HorizonsBiomes.REDWOOD_FOREST.location());
        provider.tag(BiomeTags.HAS_MINESHAFT).addOptional(HorizonsBiomes.BAYOU.location()).addOptional(HorizonsBiomes.REDWOOD_FOREST.location());
        provider.tag(BiomeTags.HAS_SWAMP_HUT).addOptional(HorizonsBiomes.BAYOU.location());
        provider.tag(BiomeTags.SPAWNS_WARM_VARIANT_FROGS).addOptional(HorizonsBiomes.BAYOU.location());
        provider.tag(BiomeTags.HAS_RUINED_PORTAL_SWAMP).addOptional(HorizonsBiomes.BAYOU.location());
        provider.tag(BiomeTags.STRONGHOLD_BIASED_TO).addOptional(HorizonsBiomes.REDWOOD_FOREST.location());
    }
}
