package com.teamaurora.horizons.core.data.server.forge;

import com.teamaurora.horizons.core.data.server.HorizonsBiomeTagsProvider;
import com.teamaurora.horizons.core.other.tags.HorizonsBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;

public class HorizonsBiomeTagsProviderImpl {
    public static void handlePlatformTags(HorizonsBiomeTagsProvider provider, HolderLookup.Provider registries) {
        // TODO add redwood to giant fern tag
        provider.tag(HorizonsBiomeTags.HAS_GIANT_FERN).addTag(Tags.Biomes.IS_SWAMP).add(Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA);
        provider.tag(HorizonsBiomeTags.HAS_BLUE_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_LIGHT_GRAY_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_CYAN_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_LIGHT_BLUE_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_MAGENTA_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_PINK_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_PURPLE_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_WHITE_LILY).addTag(Tags.Biomes.IS_SWAMP);

        provider.tag(HorizonsBiomeTags.HAS_YELLOW_DAISY).add(Biomes.FLOWER_FOREST, Biomes.SUNFLOWER_PLAINS);
        provider.tag(HorizonsBiomeTags.HAS_ORANGE_DAISY).add(Biomes.FLOWER_FOREST, Biomes.SUNFLOWER_PLAINS);
        provider.tag(HorizonsBiomeTags.HAS_RED_DAISY).add(Biomes.FLOWER_FOREST, Biomes.SUNFLOWER_PLAINS);

        // TODO add lavender biomes to pink, purple, magenta
        provider.tag(HorizonsBiomeTags.HAS_PINK_DAISY).add(Biomes.FLOWER_FOREST);
        provider.tag(HorizonsBiomeTags.HAS_PURPLE_DAISY).add(Biomes.FLOWER_FOREST);
        provider.tag(HorizonsBiomeTags.HAS_MAGENTA_DAISY).add(Biomes.FLOWER_FOREST);

        provider.tag(HorizonsBiomeTags.HAS_AMARANTHUS).addTag(BiomeTags.IS_JUNGLE);
        provider.tag(HorizonsBiomeTags.HAS_MYOSOTIS).addTag(BiomeTags.IS_JUNGLE).add(Biomes.MEADOW);
        provider.tag(HorizonsBiomeTags.HAS_FIDDLENECK).addTag(BiomeTags.IS_JUNGLE);
        provider.tag(HorizonsBiomeTags.HAS_HELICONIA).addTag(BiomeTags.IS_JUNGLE);

        //provider.tag(ConventionalBiomeTags.SWAMP).add(HorizonsBiomes.BAYOU.getKey());
        //provider.tag(Tags.Biomes.IS_DENSE).add(HorizonsBiomes.BAYOU.getKey(), HorizonsBiomes.REDWOOD_FOREST.getKey());
        //provider.tag(Tags.Biomes.IS_DENSE_OVERWORLD).add(HorizonsBiomes.BAYOU.getKey(), HorizonsBiomes.REDWOOD_FOREST.getKey());
        //provider.tag(Tags.Biomes.IS_CONIFEROUS).add(HorizonsBiomes.REDWOOD_FOREST.getKey());
        //provider.tag(HorizonsBiomeTags.HAS_PERCH).add(HorizonsBiomes.BAYOU.getKey());
        //provider.tag(HorizonsBiomeTags.HAS_CATTAILS).add(HorizonsBiomes.BAYOU.getKey());
        //provider.tag(HorizonsBiomeTags.HAS_SPOTTED_RED_MAPLE_TREES).add(HorizonsBiomes.REDWOOD_FOREST.getKey());
        //provider.tag(HorizonsBiomeTags.HAS_HOLLY_TREES).add(HorizonsBiomes.REDWOOD_FOREST.getKey());
        //provider.tag(HorizonsBiomeTags.HAS_RARE_CHESTNUT_TREES).add(HorizonsBiomes.REDWOOD_FOREST.getKey(), HorizonsBiomes.REDBUD_GROVE.getKey());
    }
}
