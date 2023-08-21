package com.teamaurora.horizons.core.fabric;

import com.teamaurora.borealib.api.base.v1.util.fabric.FabricHelper;
import com.teamaurora.horizons.core.HorizonsData;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class HorizonsFabricData implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();
        HorizonsData.init(FabricHelper.createGenerator(generator, pack));
    }
}
