package com.teamaurora.horizons.core.fabric;

import com.teamaurora.borealib.api.base.v1.util.fabric.FabricHelper;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.HorizonsData;
import com.teamaurora.horizons.core.data.server.HorizonsBlockTagsProvider;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import terrablender.api.TerraBlenderApi;

public class HorizonsFabric implements ModInitializer, TerraBlenderApi {

    @Override
    public void onInitialize() {
        Horizons.init();
        Horizons.postInit(FabricHelper.getDispatcher());
    }

    @Override
    public void onTerraBlenderInitialized() {
        Horizons.initTerrablender();
    }
}
