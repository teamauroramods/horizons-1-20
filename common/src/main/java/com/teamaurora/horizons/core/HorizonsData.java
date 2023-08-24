package com.teamaurora.horizons.core;

import com.teamaurora.borealib.api.datagen.v1.BorealibDataGenerator;
import com.teamaurora.borealib.api.datagen.v1.RegistrySetWrapper;
import com.teamaurora.borealib.core.registry.BorealibRegistries;
import com.teamaurora.horizons.core.data.client.HorizonsLanguageProvider;
import com.teamaurora.horizons.core.data.client.HorizonsModelProvider;
import com.teamaurora.horizons.core.data.server.*;
import com.teamaurora.horizons.core.registry.HorizonsBiomeModifiers;
import com.teamaurora.horizons.core.registry.HorizonsConfiguredFeatures;
import com.teamaurora.horizons.core.registry.HorizonsPlacedFeatures;
import net.minecraft.core.registries.Registries;

public class HorizonsData {

    public static void init(BorealibDataGenerator generator) {
        generator.addProvider(generator.includeClient(), HorizonsModelProvider::new);
        generator.addProvider(generator.includeClient(), HorizonsLanguageProvider::new);
        HorizonsBlockTagsProvider blockTags = generator.addProvider(generator.includeServer(), HorizonsBlockTagsProvider::new);
        generator.addProvider(generator.includeServer(), (output, registries) -> new HorizonsItemTagsProvider(output, registries, blockTags));
        generator.addProvider(generator.includeServer(), HorizonsPlacedFeatureTagsProvider::new);
        generator.addProvider(generator.includeServer(), HorizonsBiomeTagsProvider::new);
        generator.addProvider(generator.includeServer(), HorizonsBlockLootProvider::new);
    }

    public static void initRegistries(RegistrySetWrapper builder) {
        builder.add(Registries.CONFIGURED_FEATURE, HorizonsConfiguredFeatures::bootstrap)
                .add(Registries.PLACED_FEATURE, HorizonsPlacedFeatures::bootstrap)
                .add(BorealibRegistries.BIOME_MODIFIERS, HorizonsBiomeModifiers::bootstrap);
    }
}
