package com.teamaurora.horizons.core;

import com.teamaurora.borealib.api.datagen.v1.BorealibDataGenerator;
import com.teamaurora.horizons.core.data.client.HorizonsLanguageProvider;
import com.teamaurora.horizons.core.data.client.HorizonsModelProvider;
import com.teamaurora.horizons.core.data.server.HorizonsBlockTagsProvider;
import com.teamaurora.horizons.core.data.server.HorizonsItemTagsProvider;

public class HorizonsData {

    public static void init(BorealibDataGenerator generator) {
        generator.addProvider(generator.includeClient(), HorizonsModelProvider::new);
        generator.addProvider(generator.includeClient(), HorizonsLanguageProvider::new);
        HorizonsBlockTagsProvider blockTags = generator.addProvider(generator.includeServer(), HorizonsBlockTagsProvider::new);
        generator.addProvider(generator.includeServer(), (output, registries) -> new HorizonsItemTagsProvider(output, registries, blockTags));
    }
}
