package com.teamaurora.horizons.core.data.server;

import com.teamaurora.borealib.api.base.v1.platform.Platform;
import com.teamaurora.borealib.api.datagen.v1.BorealibPackOutput;
import com.teamaurora.borealib.api.datagen.v1.providers.BorealibTagsProvider;
import com.teamaurora.horizons.core.other.tags.HorizonsBiomeTags;
import com.teamaurora.horizons.core.registry.HorizonsBiomes;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import java.util.concurrent.CompletableFuture;

/**
 * @author rose_
 * @author ebo2022
 */
public class HorizonsBiomeTagsProvider extends BorealibTagsProvider<Biome> {
    public HorizonsBiomeTagsProvider(BorealibPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.BIOME, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        handlePlatformTags(this, registries);

        //horizons
        this.tag(HorizonsBiomeTags.HAS_GIANT_FERN).add(Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA, HorizonsBiomes.REDWOOD_FOREST);
        this.tag(HorizonsBiomeTags.HAS_ALGAE).add(HorizonsBiomes.BAYOU);

        this.tag(HorizonsBiomeTags.HAS_AMARANTHUS).add(Biomes.CHERRY_GROVE, HorizonsBiomes.LAVENDER_FIELD, HorizonsBiomes.LAVENDER_FIELD);
        this.tag(HorizonsBiomeTags.HAS_MYOSOTIS).addTag(BiomeTags.IS_TAIGA);
        this.tag(HorizonsBiomeTags.HAS_FIDDLENECK).add(HorizonsBiomes.REDWOOD_FOREST, Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA);
        this.tag(HorizonsBiomeTags.HAS_HELICONIA).add(HorizonsBiomes.REDWOOD_FOREST);

        //minecraft
        this.tag(BiomeTags.IS_FOREST).add(HorizonsBiomes.BAYOU, HorizonsBiomes.REDWOOD_FOREST, HorizonsBiomes.LAVENDER_FOREST);
        this.tag(BiomeTags.IS_TAIGA).add(HorizonsBiomes.REDWOOD_FOREST);
        this.tag(BiomeTags.HAS_MINESHAFT).add(HorizonsBiomes.BAYOU, HorizonsBiomes.REDWOOD_FOREST, HorizonsBiomes.LAVENDER_FIELD, HorizonsBiomes.LAVENDER_FOREST);
        this.tag(BiomeTags.HAS_SWAMP_HUT).add(HorizonsBiomes.BAYOU);
        this.tag(BiomeTags.SPAWNS_WARM_VARIANT_FROGS).add(HorizonsBiomes.BAYOU);
        this.tag(BiomeTags.HAS_RUINED_PORTAL_SWAMP).add(HorizonsBiomes.BAYOU);
        this.tag(BiomeTags.STRONGHOLD_BIASED_TO).add(HorizonsBiomes.REDWOOD_FOREST, HorizonsBiomes.LAVENDER_FOREST);
    }

    @ExpectPlatform
    public static void handlePlatformTags(HorizonsBiomeTagsProvider provider, HolderLookup.Provider registries) {
        Platform.expect();
    }
}
