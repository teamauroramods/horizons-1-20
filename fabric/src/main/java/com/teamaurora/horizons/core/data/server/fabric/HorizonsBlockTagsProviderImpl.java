package com.teamaurora.horizons.core.data.server.fabric;

import com.teamaurora.horizons.core.data.server.HorizonsBlockTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;

import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;

public class HorizonsBlockTagsProviderImpl {
    public static void handlePlatformTags(HorizonsBlockTagsProvider provider, HolderLookup.Provider lookup) {
        provider.tag(ConventionalBlockTags.BOOKSHELVES).add(CYPRESS_BOOKSHELF.get());
        provider.tag(ConventionalBlockTags.CHESTS).add(CYPRESS_CHESTS.getFirst().get(), CYPRESS_CHESTS.getSecond().get());
    }
}
