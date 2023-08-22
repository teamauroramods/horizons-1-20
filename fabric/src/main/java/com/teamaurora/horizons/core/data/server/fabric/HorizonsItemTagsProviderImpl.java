package com.teamaurora.horizons.core.data.server.fabric;

import com.teamaurora.horizons.core.data.server.HorizonsItemTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.core.HolderLookup;

public class HorizonsItemTagsProviderImpl {
    public static void handlePlatformTags(HorizonsItemTagsProvider provider, HolderLookup.Provider lookup) {
        provider.copy(ConventionalBlockTags.BOOKSHELVES, ConventionalItemTags.BOOKSHELVES);
        provider.copy(ConventionalBlockTags.CHESTS, ConventionalItemTags.CHESTS);
    }
}
