package com.teamaurora.horizons.core.data.server;

import com.teamaurora.borealib.api.base.v1.platform.Platform;
import com.teamaurora.borealib.api.datagen.v1.BorealibPackOutput;
import com.teamaurora.borealib.api.datagen.v1.providers.BorealibTagsProvider;
import com.teamaurora.horizons.core.other.tags.HorizonsBiomeTags;
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
        this.tag(HorizonsBiomeTags.HAS_BLUE_DAISY).add(Biomes.MEADOW);
        //this.tag(HorizonsBiomeTags.HAS_ALGAE).add(HorizonsBiomes.BAYOU.getKey());

        //this.tag(BiomeTags.IS_FOREST).add(HorizonsBiomes.BAYOU.getKey(), HorizonsBiomes.REDBUD_GROVE.getKey(), HorizonsBiomes.REDWOOD_FOREST.getKey());
        //this.tag(BiomeTags.HAS_MINESHAFT).add(HorizonsBiomes.BAYOU.getKey(), HorizonsBiomes.REDBUD_GROVE.getKey(), HorizonsBiomes.REDWOOD_FOREST.getKey());
        //this.tag(BiomeTags.HAS_SWAMP_HUT).add(HorizonsBiomes.BAYOU.getKey());
        //this.tag(BiomeTags.SPAWNS_WARM_VARIANT_FROGS).add(HorizonsBiomes.BAYOU.getKey());
        //this.tag(BiomeTags.HAS_RUINED_PORTAL_SWAMP).add(HorizonsBiomes.BAYOU.getKey());
        //this.tag(BiomeTags.IS_TAIGA).add(HorizonsBiomes.REDWOOD_FOREST.getKey());
        //this.tag(BiomeTags.STRONGHOLD_BIASED_TO).add(HorizonsBiomes.REDWOOD_FOREST.getKey());
    }

    @ExpectPlatform
    public static void handlePlatformTags(HorizonsBiomeTagsProvider provider, HolderLookup.Provider registries) {
        Platform.expect();
    }
}
