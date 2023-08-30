package com.teamaurora.horizons.core.fabric;

import com.teamaurora.borealib.api.base.v1.util.fabric.FabricHelper;
import com.teamaurora.horizons.core.Horizons;
import net.fabricmc.api.ModInitializer;
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
