package com.teamaurora.horizons.core;

import com.teamaurora.borealib.api.base.v1.modloading.ModLoaderService;
import net.minecraft.resources.ResourceLocation;

public class Horizons implements ModLoaderService {

    public static final String MOD_ID = "horizons";

    @Override
    public String id() {
        return MOD_ID;
    }

    public static ResourceLocation location(String string) {
        if (string.contains(":")) return new ResourceLocation(string);
        return new ResourceLocation(MOD_ID, string);
    }
}
