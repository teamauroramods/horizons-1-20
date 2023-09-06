package com.teamaurora.horizons.core.other;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.teamaurora.borealib.api.base.v1.platform.Platform;
import com.teamaurora.borealib.api.base.v1.util.Mods;
import com.teamaurora.borealib.api.event.creativetabs.v1.CreativeTabEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.List;

import static com.teamaurora.horizons.core.registry.HorizonsItems.*;
import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;

/**
 * @author ebo2022
 * @author rose_
 */
public final class HorizonsTabPlacement {
    public static void register(ResourceKey<CreativeModeTab> tabKey, CreativeModeTab tab, FeatureFlagSet flags, CreativeModeTab.ItemDisplayParameters parameters, CreativeTabEvents.Output output, boolean canUseGameMasterBlocks) {
        if (tabKey.equals(CreativeModeTabs.BUILDING_BLOCKS)) {
            acceptAllAfter(output, Items.CHERRY_BUTTON, List.of(
                    CYPRESS_LOG.get(),
                    CYPRESS_WOOD.get(),
                    STRIPPED_CYPRESS_LOG.get(),
                    STRIPPED_CYPRESS_WOOD.get(),
                    CYPRESS_PLANKS.get(),
                    CYPRESS_STAIRS.get(),
                    CYPRESS_SLAB.get(),
                    CYPRESS_FENCE.get(),
                    CYPRESS_FENCE_GATE.get(),
                    CYPRESS_DOOR.get(),
                    CYPRESS_TRAPDOOR.get(),
                    CYPRESS_PRESSURE_PLATE.get(),
                    CYPRESS_BUTTON.get(),
                    REDWOOD_LOG.get(),
                    REDWOOD.get(),
                    STRIPPED_REDWOOD_LOG.get(),
                    STRIPPED_REDWOOD.get(),
                    REDWOOD_PLANKS.get(),
                    REDWOOD_STAIRS.get(),
                    REDWOOD_SLAB.get(),
                    REDWOOD_FENCE.get(),
                    REDWOOD_FENCE_GATE.get(),
                    REDWOOD_DOOR.get(),
                    REDWOOD_TRAPDOOR.get(),
                    REDWOOD_PRESSURE_PLATE.get(),
                    REDWOOD_BUTTON.get(),
                    JACARANDA_LOG.get(),
                    JACARANDA_WOOD.get(),
                    STRIPPED_JACARANDA_LOG.get(),
                    STRIPPED_JACARANDA_WOOD.get(),
                    JACARANDA_PLANKS.get(),
                    JACARANDA_STAIRS.get(),
                    JACARANDA_SLAB.get(),
                    JACARANDA_FENCE.get(),
                    JACARANDA_FENCE_GATE.get(),
                    JACARANDA_DOOR.get(),
                    JACARANDA_TRAPDOOR.get(),
                    JACARANDA_PRESSURE_PLATE.get(),
                    JACARANDA_BUTTON.get()
            ));
            acceptAllAfter(output, Items.MUD_BRICK_WALL, List.of(
                    ALGAE_THATCH.get(),
                    ALGAE_THATCH_STAIRS.get(),
                    ALGAE_THATCH_SLAB.get()
            ));
        } else if (tabKey.equals(CreativeModeTabs.NATURAL_BLOCKS)) {
            acceptAllAfter(output, Items.FERN, List.of(
                    TROPICAL_GRASS.get(),
                    TROPICAL_FERN.get()
            ));
            acceptAllAfter(output, Items.HANGING_ROOTS, List.of(
                    HANGING_CYPRESS_LEAVES.get(),
                    BEARD_MOSS_BLOCK.get(),
                    BEARD_MOSS.get()
            ));
            acceptAllAfter(output, Items.WITHER_ROSE, List.of(
                    FIDDLENECK.get(),
                    AMARANTHUS.get(),
                    MYOSOTIS.get(),
                    BLUE_LILY.get(),
                    LIGHT_GRAY_LILY.get(),
                    CYAN_LILY.get(),
                    LIGHT_BLUE_LILY.get(),
                    MAGENTA_LILY.get(),
                    PINK_LILY.get(),
                    PURPLE_LILY.get(),
                    WHITE_LILY.get()
            ));
            output.acceptAfter(Items.PEONY, HELICONIA.get());
            acceptAllAfter(output, Items.CHERRY_LEAVES, List.of(
                    CYPRESS_LEAVES.get(),
                    REDWOOD_LEAVES.get(),
                    JACARANDA_LEAVES.get(),
                    FLOWERING_JACARANDA_LEAVES.get()
            ));
            acceptAllAfter(output, Items.CHERRY_SAPLING, List.of(
                    CYPRESS_SAPLING.get(),
                    REDWOOD_SAPLING.get(),
                    JACARANDA_SAPLING.get(),
                    FLOWERING_JACARANDA_SAPLING.get()
            ));
            output.acceptAfter(Items.LARGE_FERN, GIANT_FERN.get());
            acceptAllAfter(output, Items.CHERRY_LOG, List.of(
                    CYPRESS_LOG.get(),
                    REDWOOD_LOG.get(),
                    JACARANDA_LOG.get()
            ));
            output.acceptAfter(Items.FROGSPAWN, ALGAE.get());
            acceptAllAfter(output, Items.CACTUS, List.of(
                    CYPRESS_KNEE.get(),
                    LARGE_CYPRESS_KNEE.get(),
                    CYPRESS_BRANCH.get()
            ));
        } else if (tabKey.equals(CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
            acceptAllAfter(output, Items.CHERRY_HANGING_SIGN, List.of(
                    CYPRESS_SIGNS.getFirst().get(),
                    CYPRESS_HANGING_SIGNS.getFirst().get(),
                    REDWOOD_SIGNS.getFirst().get(),
                    REDWOOD_HANGING_SIGNS.getFirst().get(),
                    JACARANDA_SIGNS.getFirst().get(),
                    JACARANDA_HANGING_SIGNS.getFirst().get()
            ));
            if (Platform.anyModsLoaded(Mods.QUARK, Mods.WOODWORKS, Mods.CARPENTER)) {
                //output.acceptAfter(Items.BOOKSHELF, CYPRESS_BOOKSHELF.get());
                //output.acceptAfter(Items.CHEST, CYPRESS_CHESTS.getFirst().get());
            }
        } else if (tabKey.equals(CreativeModeTabs.REDSTONE_BLOCKS)) {
            if (Platform.anyModsLoaded(Mods.QUARK, Mods.WOODWORKS, Mods.CARPENTER)) {
                //output.acceptAfter(Items.CHEST, CYPRESS_CHESTS.getFirst().get());
                //output.acceptAfter(Items.TRAPPED_CHEST, CYPRESS_CHESTS.getSecond().get());
            }
        } else if (tabKey.equals(CreativeModeTabs.TOOLS_AND_UTILITIES)) {
            acceptAllAfter(output, Items.CHERRY_CHEST_BOAT, List.of(
                    CYPRESS_BOATS.getFirst().get(),
                    CYPRESS_BOATS.getSecond().get(),
                    REDWOOD_BOATS.getFirst().get(),
                    REDWOOD_BOATS.getSecond().get(),
                    JACARANDA_BOATS.getFirst().get(),
                    JACARANDA_BOATS.getSecond().get()
            ));
        } else if (tabKey.equals(CreativeModeTabs.FOOD_AND_DRINKS)) {
            acceptAllAfter(output, Items.GLOW_BERRIES, List.of(
                    GOOSEBERRIES.get(),
                    HONEY_GLAZED_GOOSEBERRIES.get()
            ));
            acceptAllAfter(output, Items.HONEY_BOTTLE, List.of(
                    GOOSEBERRY_JUICE.get(),
                    GOOSEBERRY_JAM.get(),
                    LAVENDER_TEA.get()
            ));
            output.acceptAfter(Items.RABBIT_STEW, LAVENDER_SALAD.get());
            output.acceptAfter(Items.COOKIE, GOOSEBERRY_JAM_COOKIE.get());
            output.acceptAfter(Items.PUMPKIN_PIE, GOOSEBERRY_PIE.get());
            output.acceptAfter(Items.SUGAR_CANE, LAVENDER.get());
        }
    }

    private static void acceptAllAfter(CreativeTabEvents.Output output, ItemLike after, List<ItemLike> items) {
        Preconditions.checkArgument(items.size() > 1, "At least 2 items needed to add in bulk");
        List<ItemLike> reversed = Lists.reverse(items); // Reversed for proper ordering
        output.acceptAllAfter(after, reversed.stream().map(ItemStack::new).toList());
    }
}
