package com.teamaurora.horizons.core;

import com.teamaurora.borealib.api.datagen.v1.BorealibDataGenerator;
import com.teamaurora.horizons.core.data.server.HorizonsBlockTagsProvider;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.resources.ResourceLocation;

public class Horizons {

    public static final String MOD_ID = "horizons";

    public static void init() {
        HorizonsItems.PROVIDER.register();
        HorizonsBlocks.PROVIDER.register();
    }

    public static ResourceLocation location(String string) {
        if (string.contains(":")) return new ResourceLocation(string);
        return new ResourceLocation(MOD_ID, string);
    }

    public static String id(String string) {
        return MOD_ID + ":" + string;
    }
}
