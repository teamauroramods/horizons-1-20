package com.teamaurora.horizons.core.other.tags;

import com.teamaurora.horizons.core.Horizons;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * @author rose_
 * @author ebo2022
 */
public class HorizonsItemTags {

    public static final TagKey<Item> CYPRESS_LOGS = itemTag("cypress_logs");
    public static final TagKey<Item> BERRIES = itemTag("forge:berries");
    public static final TagKey<Item> STRIPPED_LOGS = itemTag("forge:stripped_logs");
    public static final TagKey<Item> STRIPPED_WOOD = itemTag("forge:stripped_wood");
    public static final TagKey<Item> DUCK_FOOD = itemTag("environmental:duck_food");

    private static TagKey<Item> itemTag(String path) {
        return TagKey.create(Registries.ITEM, Horizons.location(path));
    }
}
