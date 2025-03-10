package com.teamaurora.horizons.core.data.client;

import com.google.common.collect.ImmutableSet;
import com.teamaurora.borealib.api.datagen.v1.BorealibPackOutput;
import com.teamaurora.borealib.api.datagen.v1.providers.BorealibLanguageProvider;
import com.teamaurora.borealib.api.registry.v1.RegistryReference;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.world.item.BlockItem;

import java.util.Set;
import java.util.function.Predicate;

public class HorizonsLanguageProvider extends BorealibLanguageProvider {
    private static final Set<RegistryReference<?>> DONT_AUTO_TRANSLATE = ImmutableSet.of(
            HorizonsItems.CYPRESS_BOATS.getSecond(),
            HorizonsItems.REDWOOD_BOATS.getSecond(),
            HorizonsItems.JACARANDA_BOATS.getSecond(),
            HorizonsBlocks.BEARD_MOSS_BLOCK,
            HorizonsBlocks.BEARD_MOSS,

            // Put wall (hanging) signs here, they use the standing sign translations
            HorizonsBlocks.CYPRESS_SIGNS.getSecond(),
            HorizonsBlocks.CYPRESS_HANGING_SIGNS.getSecond(),
            HorizonsBlocks.REDWOOD_SIGNS.getSecond(),
            HorizonsBlocks.REDWOOD_HANGING_SIGNS.getSecond(),
            HorizonsBlocks.JACARANDA_SIGNS.getSecond(),
            HorizonsBlocks.JACARANDA_HANGING_SIGNS.getSecond()
    );

    public HorizonsLanguageProvider(BorealibPackOutput output) {
        super(output);
    }

    @Override
    public void generateLanguage(TranslationRegistry registry) {
        // Blocks
        HorizonsBlocks.PROVIDER.stream().filter(Predicate.not(DONT_AUTO_TRANSLATE::contains)).forEach(block -> registry.add(block.get(), autoTranslate(block.getId().getPath())));

        // Non-block items
        HorizonsItems.PROVIDER.stream().filter(Predicate.not(item -> DONT_AUTO_TRANSLATE.contains(item) || item.get() instanceof BlockItem)).forEach(item -> registry.add(item.get(), autoTranslate(item.getId().getPath())));

        // Manual translations
        registry.add("biome.horizons.bayou", "Bayou");
        registry.add("biome.horizons.lavender_field", "Lavender Field");
        registry.add("biome.horizons.lavender_forest", "Lavender Forest");
        registry.add("biome.horizons.redwood_forest", "Redwood Forest");

        registry.add(HorizonsBlocks.BEARD_MOSS_BLOCK.get(), "Beard Moss");
        registry.add(HorizonsBlocks.BEARD_MOSS.get(), "Hanging Beard Moss");

        registry.add(HorizonsItems.CYPRESS_BOATS.getSecond().get(), "Cypress Boat with Chest");
        registry.add(HorizonsItems.REDWOOD_BOATS.getSecond().get(), "Redwood Boat with Chest");
        registry.add(HorizonsItems.JACARANDA_BOATS.getSecond().get(), "Jacaranda Boat with Chest");
    }
}
