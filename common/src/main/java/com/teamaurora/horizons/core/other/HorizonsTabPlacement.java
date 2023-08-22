package com.teamaurora.horizons.core.other;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.teamaurora.borealib.api.base.v1.platform.Platform;
import com.teamaurora.borealib.api.base.v1.util.Mods;
import com.teamaurora.borealib.api.event.creativetabs.v1.CreativeTabEvents;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.List;

public class HorizonsTabPlacement {

    public static void register(ResourceKey<CreativeModeTab> tabKey, CreativeModeTab tab, FeatureFlagSet flags, CreativeModeTab.ItemDisplayParameters parameters, CreativeTabEvents.Output output, boolean canUseGameMasterBlocks) {
        if (tabKey.equals(CreativeModeTabs.BUILDING_BLOCKS)) {
            acceptAllAfter(output, Items.CHERRY_BUTTON, List.of(
                    HorizonsBlocks.CYPRESS_LOG.get(),
                    HorizonsBlocks.CYPRESS_WOOD.get(),
                    HorizonsBlocks.STRIPPED_CYPRESS_LOG.get(),
                    HorizonsBlocks.STRIPPED_CYPRESS_WOOD.get(),
                    HorizonsBlocks.CYPRESS_PLANKS.get(),
                    HorizonsBlocks.CYPRESS_STAIRS.get(),
                    HorizonsBlocks.CYPRESS_SLAB.get(),
                    HorizonsBlocks.CYPRESS_FENCE.get(),
                    HorizonsBlocks.CYPRESS_FENCE_GATE.get(),
                    HorizonsBlocks.CYPRESS_DOOR.get(),
                    HorizonsBlocks.CYPRESS_TRAPDOOR.get(),
                    HorizonsBlocks.CYPRESS_PRESSURE_PLATE.get(),
                    HorizonsBlocks.CYPRESS_BUTTON.get()
            ));
            acceptAllAfter(output, Items.MUD_BRICK_WALL, List.of(
                    HorizonsBlocks.ALGAE_THATCH.get(),
                    HorizonsBlocks.ALGAE_THATCH_STAIRS.get(),
                    HorizonsBlocks.ALGAE_THATCH_SLAB.get()
            ));
        } else if (tabKey.equals(CreativeModeTabs.NATURAL_BLOCKS)) {
            acceptAllAfter(output, Items.HANGING_ROOTS, List.of(
                    HorizonsBlocks.HANGING_CYPRESS_LEAVES.get(),
                    HorizonsBlocks.BEARD_MOSS_BLOCK.get(),
                    HorizonsBlocks.BEARD_MOSS.get()
            ));
            acceptAllAfter(output, Items.WITHER_ROSE, List.of(
                    HorizonsBlocks.BLUE_LILY.get(),
                    HorizonsBlocks.LIGHT_GRAY_LILY.get(),
                    HorizonsBlocks.CYAN_LILY.get(),
                    HorizonsBlocks.LIGHT_BLUE_LILY.get(),
                    HorizonsBlocks.MAGENTA_LILY.get(),
                    HorizonsBlocks.PINK_LILY.get(),
                    HorizonsBlocks.PURPLE_LILY.get(),
                    HorizonsBlocks.WHITE_LILY.get()
            ));
            output.acceptAfter(Items.CHERRY_LEAVES, HorizonsBlocks.CYPRESS_LEAVES.get());
            output.acceptAfter(Items.CHERRY_SAPLING, HorizonsBlocks.CYPRESS_SAPLING.get());
            output.acceptAfter(Items.LARGE_FERN, HorizonsBlocks.GIANT_FERN.get());
            output.acceptAfter(Items.CHERRY_LOG, HorizonsBlocks.CYPRESS_LOG.get());
        } else if (tabKey.equals(CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
            acceptAllAfter(output, Items.CHERRY_HANGING_SIGN, List.of(
                    HorizonsBlocks.CYPRESS_SIGNS.getFirst().get(),
                    HorizonsBlocks.CYPRESS_HANGING_SIGNS.getFirst().get()
            ));
            if (Platform.anyModsLoaded(Mods.QUARK, Mods.WOODWORKS, Mods.CARPENTER)) {
                output.acceptAfter(Items.BOOKSHELF, HorizonsBlocks.CYPRESS_BOOKSHELF.get());
                output.acceptAfter(Items.CHEST, HorizonsBlocks.CYPRESS_CHESTS.getFirst().get());
            }
        } else if (tabKey.equals(CreativeModeTabs.REDSTONE_BLOCKS)) {
            output.acceptAfter(Items.CHEST, HorizonsBlocks.CYPRESS_CHESTS.getFirst().get());
            output.acceptAfter(Items.TRAPPED_CHEST, HorizonsBlocks.CYPRESS_CHESTS.getSecond().get());
        } else if (tabKey.equals(CreativeModeTabs.TOOLS_AND_UTILITIES)) {
            acceptAllAfter(output, Items.CHERRY_CHEST_BOAT, List.of(
                    HorizonsItems.CYPRESS_BOATS.getFirst().get(),
                    HorizonsItems.CYPRESS_BOATS.getSecond().get()
            ));
        }
    }

    private static void acceptAllAfter(CreativeTabEvents.Output output, ItemLike after, List<ItemLike> items) {
        Preconditions.checkArgument(items.size() > 1, "At least 2 items needed to add in bulk");

        // Reversed for proper ordering
        List<ItemLike> reversed = Lists.reverse(items);
        output.acceptAllAfter(after, reversed.stream().map(ItemStack::new).toList());
    }
}
