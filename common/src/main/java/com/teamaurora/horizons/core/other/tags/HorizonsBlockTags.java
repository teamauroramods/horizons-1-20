package com.teamaurora.horizons.core.other.tags;

import com.teamaurora.horizons.core.Horizons;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class HorizonsBlockTags {
    public static final TagKey<Block> CYPRESS_LOGS = blockTag("cypress_logs");
    public static final TagKey<Block> REDWOOD_LOGS = blockTag("redwood_logs");
    public static final TagKey<Block> JACARANDA_LOGS = blockTag("jacaranda_logs");

    private static TagKey<Block> blockTag(String path) {
        return TagKey.create(Registries.BLOCK, Horizons.location(path));
    }
}
