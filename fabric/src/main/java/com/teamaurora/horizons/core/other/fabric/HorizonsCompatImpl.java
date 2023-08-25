package com.teamaurora.horizons.core.other.fabric;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public class HorizonsCompatImpl {
    public static void addCompostable(ItemLike itemLike, float chance) {
        CompostingChanceRegistry.INSTANCE.add(itemLike, chance);
    }
}
