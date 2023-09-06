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
        provider.tag(HorizonsBiomeTags.HAS_GIANT_FERN).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_BLUE_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_LIGHT_GRAY_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_CYAN_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_LIGHT_BLUE_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_MAGENTA_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_PINK_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_PURPLE_LILY).addTag(Tags.Biomes.IS_SWAMP);
        provider.tag(HorizonsBiomeTags.HAS_WHITE_LILY).addTag(Tags.Biomes.IS_SWAMP);

        provider.tag(Tags.Biomes.IS_SWAMP).addOptional(HorizonsBiomes.BAYOU.location());
        provider.tag(Tags.Biomes.IS_DENSE_OVERWORLD).addOptional(HorizonsBiomes.BAYOU.location()).addOptional(HorizonsBiomes.REDWOOD_FOREST.location());
        provider.tag(Tags.Biomes.IS_CONIFEROUS).addOptional(HorizonsBiomes.REDWOOD_FOREST.location());
    }
}
