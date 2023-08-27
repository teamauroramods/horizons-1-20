package com.teamaurora.horizons.core.forge;

import com.teamaurora.borealib.api.base.v1.util.forge.ForgeHelper;
import com.teamaurora.borealib.api.datagen.v1.providers.BorealibTagsProvider;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.HorizonsClient;
import com.teamaurora.horizons.core.HorizonsData;
import net.minecraft.data.tags.TagsProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.lang.reflect.Field;

@Mod(Horizons.MOD_ID)
public class HorizonsForge {

    public HorizonsForge() {
        IEventBus bus = ForgeHelper.getEventBus(Horizons.MOD_ID);
        Horizons.init();
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> HorizonsClient::init);
        bus.<FMLClientSetupEvent>addListener(e -> HorizonsClient.postInit(ForgeHelper.createDispatcher(e)));
        bus.<FMLCommonSetupEvent>addListener(e -> {
            Horizons.postInit(ForgeHelper.createDispatcher(e));
            e.enqueueWork(Horizons::initTerrablender);
        });
        bus.<GatherDataEvent>addListener(e -> {
            HorizonsData.init(ForgeHelper.createGenerator(e));
            ForgeHelper.buildRegistries(e, HorizonsData::initRegistries);
        });
    }
}
