package com.teamaurora.horizons.core.data.server;

import com.teamaurora.borealib.api.datagen.v1.BorealibPackOutput;
import com.teamaurora.borealib.api.datagen.v1.providers.BorealibTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class HorizonsBlockTagsProvider extends BorealibTagsProvider.BlockTagProvider {

    public HorizonsBlockTagsProvider(BorealibPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
    }
}
