package com.teamaurora.horizons.core;

import com.teamaurora.borealib.api.datagen.v1.BorealibDataGenerator;
import com.teamaurora.horizons.core.data.client.HorizonsLanguageProvider;
import com.teamaurora.horizons.core.data.server.HorizonsBlockTagsProvider;

public class HorizonsData {

    public static void init(BorealibDataGenerator generator) {
        generator.addProvider(generator.includeClient(), HorizonsLanguageProvider::new);
        generator.addProvider(generator.includeServer(), HorizonsBlockTagsProvider::new);
    }
}
