package com.teamaurora.horizons.core.fabric;

import com.teamaurora.borealib.api.base.v1.util.fabric.FabricHelper;
import com.teamaurora.horizons.core.HorizonsClient;
import net.fabricmc.api.ClientModInitializer;

public class HorizonsFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HorizonsClient.init();
        HorizonsClient.postInit(FabricHelper.getDispatcher());
    }
}
