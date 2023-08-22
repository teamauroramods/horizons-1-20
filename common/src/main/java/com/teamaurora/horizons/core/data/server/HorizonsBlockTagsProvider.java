package com.teamaurora.horizons.core.data.server;

import com.teamaurora.borealib.api.datagen.v1.BorealibPackOutput;
import com.teamaurora.borealib.api.datagen.v1.providers.BorealibTagsProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;

public class HorizonsBlockTagsProvider extends BorealibTagsProvider.BlockTagProvider {

    public HorizonsBlockTagsProvider(BorealibPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
    }
}
