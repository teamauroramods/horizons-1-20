package com.teamaurora.horizons.core;

import com.teamaurora.borealib.api.base.v1.util.ParallelDispatcher;
import com.teamaurora.borealib.api.config.v1.ConfigRegistry;
import com.teamaurora.borealib.api.config.v1.ModConfig;
import com.teamaurora.borealib.api.event.creativetabs.v1.CreativeTabEvents;
import com.teamaurora.horizons.core.other.HorizonsCompat;
import com.teamaurora.horizons.core.other.HorizonsTabPlacement;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.resources.ResourceLocation;

public class Horizons {

    public static final String MOD_ID = "horizons";
    public static final HorizonsCommonConfig CONFIG = ConfigRegistry.register(MOD_ID, ModConfig.Type.COMMON, HorizonsCommonConfig::new);

    public static void init() {
        HorizonsItems.PROVIDER.register();
        HorizonsBlocks.PROVIDER.register();
        HorizonsFeatures.PROVIDER.register();
    }

    public static void postInit(ParallelDispatcher dispatcher) {
        dispatcher.enqueueWork(HorizonsCompat::init);
        CreativeTabEvents.MODIFY_ENTRIES_ALL.register(HorizonsTabPlacement::register);
    }

    public static ResourceLocation location(String string) {
        if (string.contains(":")) return new ResourceLocation(string);
        return new ResourceLocation(MOD_ID, string);
    }

    public static String id(String string) {
        return MOD_ID + ":" + string;
    }
}
