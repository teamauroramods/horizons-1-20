package com.teamaurora.horizons.core.other.forge;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;

public class HorizonsCompatImpl {
    public static void addCompostable(ItemLike itemLike, float chance) {
        ComposterBlock.COMPOSTABLES.put(itemLike, chance);
    }
}
