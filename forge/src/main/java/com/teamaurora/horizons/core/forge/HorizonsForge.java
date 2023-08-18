package com.teamaurora.horizons.core.forge;

import com.teamaurora.borealib.api.base.v1.util.forge.ForgeHelper;
import com.teamaurora.borealib.api.datagen.v1.providers.BorealibTagsProvider;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.data.tags.TagsProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;

@Mod(Horizons.MOD_ID)
public class HorizonsForge {

    public HorizonsForge() {
        IEventBus bus = ForgeHelper.getEventBus(Horizons.MOD_ID);
        bus.<GatherDataEvent>addListener(e -> {
            Horizons.dataInit(ForgeHelper.createGenerator(e));
        });
    }
}
