package com.teamaurora.horizons.core.data.server;

import com.teamaurora.borealib.api.base.v1.platform.Platform;
import com.teamaurora.borealib.api.base.v1.util.CompatBlockTags;
import com.teamaurora.borealib.api.base.v1.util.CompatItemTags;
import com.teamaurora.borealib.api.datagen.v1.BorealibPackOutput;
import com.teamaurora.borealib.api.datagen.v1.providers.BorealibTagsProvider;
import com.teamaurora.horizons.core.other.tags.HorizonsBlockTags;
import com.teamaurora.horizons.core.other.tags.HorizonsItemTags;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;
import static com.teamaurora.horizons.core.registry.HorizonsItems.*;

public class HorizonsItemTagsProvider extends BorealibTagsProvider.ItemTagProvider {
    public HorizonsItemTagsProvider(BorealibPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable BlockTagProvider blockTagProvider) {
        super(output, completableFuture, blockTagProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        handlePlatformTags(this, registries);

        //horizons
        this.copy(HorizonsBlockTags.CYPRESS_LOGS, HorizonsItemTags.CYPRESS_LOGS);

        //farmerdelight
        this.tag(CompatItemTags.CABINETS_WOODEN).add(CYPRESS_CABINET.get().asItem());

        //minecraft
        //this.tag(ItemTags.NON_FLAMMABLE_WOOD).add(CYPRESS_BOARDS.get().asItem(), REDWOOD_BOARDS.get().asItem(), REDBUD_BOARDS.get().asItem(), JACARANDA_BOARDS.get().asItem());
        this.tag(ItemTags.BOATS).add(CYPRESS_BOATS.getFirst().get());
        this.tag(ItemTags.CHEST_BOATS).add(CYPRESS_BOATS.getSecond().get());
        this.tag(ItemTags.SIGNS).add(CYPRESS_SIGNS.getFirst().get().asItem());
        this.tag(ItemTags.HANGING_SIGNS).add(CYPRESS_SIGNS.getFirst().get().asItem());
        //this.copy(BlockTags.BUTTONS, ItemTags.BUTTONS);
        this.copy(BlockTags.LEAVES, ItemTags.LEAVES);
        this.copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);
        this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        //this.copy(BlockTags.SLABS, ItemTags.SLABS);
        //this.copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);
        //this.copy(BlockTags.STAIRS, ItemTags.STAIRS);
        //this.copy(BlockTags.WALLS, ItemTags.WALLS);
        this.copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        this.copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        this.copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        this.copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        this.copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        this.copy(CompatBlockTags.CARPENTER_BOOKSHELVES, CompatItemTags.CARPENTER_BOOKSHELVES);
        this.copy(CompatBlockTags.CARPENTER_CHESTS, CompatItemTags.CARPENTER_CHESTS);
        this.copy(CompatBlockTags.CARPENTER_TRAPPED_CHESTS, CompatItemTags.CARPENTER_TRAPPED_CHESTS);
    }

    @ExpectPlatform
    public static void handlePlatformTags(HorizonsItemTagsProvider provider, HolderLookup.Provider lookup) {
        Platform.expect();
    }
}
