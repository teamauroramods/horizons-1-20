package com.teamaurora.horizons.core;

import com.teamaurora.borealib.api.base.v1.util.ParallelDispatcher;
import com.teamaurora.borealib.api.datagen.v1.BorealibDataGenerator;
import com.teamaurora.borealib.api.event.creativetabs.v1.CreativeTabEvents;
import com.teamaurora.borealib.api.event.lifecycle.v1.ServerLifecycleEvents;
import com.teamaurora.horizons.core.data.server.HorizonsBlockTagsProvider;
import com.teamaurora.horizons.core.other.HorizonsCompat;
import com.teamaurora.horizons.core.other.HorizonsTabPlacement;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import com.teamaurora.horizons.core.registry.HorizonsPlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;

public class Horizons {

    public static final String MOD_ID = "horizons";

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
