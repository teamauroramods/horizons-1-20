package com.teamaurora.horizons.core.data.server.forge;

import com.teamaurora.horizons.core.data.server.HorizonsBlockTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraftforge.common.Tags;

import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;

public class HorizonsBlockTagsProviderImpl {

    public static void handlePlatformTags(HorizonsBlockTagsProvider provider, HolderLookup.Provider lookup) {
        //forge
        provider.tag(Tags.Blocks.CHESTS_WOODEN).add(CYPRESS_CHESTS.getFirst().get(), CYPRESS_CHESTS.getSecond().get());
        provider.tag(Tags.Blocks.CHESTS_TRAPPED).add(CYPRESS_CHESTS.getSecond().get());
        provider.tag(Tags.Blocks.FENCE_GATES_WOODEN).add(CYPRESS_FENCE_GATE.get());
        provider.tag(Tags.Blocks.FENCES_WOODEN).add(CYPRESS_FENCE.get());
        provider.tag(Tags.Blocks.BOOKSHELVES).add(CYPRESS_BOOKSHELF.get());
    }
}
