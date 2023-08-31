package com.teamaurora.horizons.core.data.server.forge;

import com.teamaurora.borealib.api.base.v1.util.CompatItemTags;
import com.teamaurora.horizons.core.data.server.HorizonsItemTagsProvider;
import com.teamaurora.horizons.core.other.tags.HorizonsItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraftforge.common.Tags;

import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;
import static com.teamaurora.horizons.core.registry.HorizonsItems.GOOSEBERRIES;

public class HorizonsItemTagsProviderImpl {
    public static void handlePlatformTags(HorizonsItemTagsProvider provider, HolderLookup.Provider lookup) {

        //quark
        provider.tag(CompatItemTags.BOATABLE_CHESTS).add(CYPRESS_CHESTS.getFirst().get().asItem());
        provider.tag(CompatItemTags.REVERTABLE_CHESTS).add(CYPRESS_CHESTS.getFirst().get().asItem());

        //forge
        provider.tag(HorizonsItemTags.BERRIES).add(GOOSEBERRIES.get());
        provider.tag(HorizonsItemTags.STRIPPED_LOGS).add(STRIPPED_CYPRESS_LOG.get().asItem());
        provider.tag(HorizonsItemTags.STRIPPED_WOOD).add(STRIPPED_CYPRESS_WOOD.get().asItem());

        provider.copy(Tags.Blocks.CHESTS_WOODEN, Tags.Items.CHESTS_WOODEN);
        provider.copy(Tags.Blocks.CHESTS_TRAPPED, Tags.Items.CHESTS_TRAPPED);
        provider.copy(Tags.Blocks.FENCE_GATES_WOODEN, Tags.Items.FENCE_GATES_WOODEN);
        provider.copy(Tags.Blocks.FENCES_WOODEN, Tags.Items.FENCES_WOODEN);
        provider.copy(Tags.Blocks.BOOKSHELVES, Tags.Items.BOOKSHELVES);
    }
}
