package com.teamaurora.horizons.core;

import com.teamaurora.borealib.api.datagen.v1.BorealibDataGenerator;
import com.teamaurora.horizons.core.data.server.HorizonsBlockTagsProvider;
import net.minecraft.resources.ResourceLocation;

public class Horizons {

    public static final String MOD_ID = "horizons";

    public static void dataInit(BorealibDataGenerator generator) {
        generator.addProvider(generator.includeServer(), HorizonsBlockTagsProvider::new);
    }

    public static ResourceLocation location(String string) {
        if (string.contains(":")) return new ResourceLocation(string);
        return new ResourceLocation(MOD_ID, string);
    }
}
