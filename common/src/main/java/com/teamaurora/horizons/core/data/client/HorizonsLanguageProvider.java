package com.teamaurora.horizons.core.data.client;

import com.google.common.collect.ImmutableSet;
import com.teamaurora.borealib.api.datagen.v1.BorealibPackOutput;
import com.teamaurora.borealib.api.datagen.v1.providers.BorealibLanguageProvider;
import com.teamaurora.borealib.api.registry.v1.RegistryReference;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class HorizonsLanguageProvider extends BorealibLanguageProvider {

    private static final Set<RegistryReference<?>> DONT_AUTO_TRANSLATE = ImmutableSet.of(
            HorizonsItems.CYPRESS_BOATS.getSecond(),

            // Put wall (hanging) signs here, they use the standing sign translations
            HorizonsBlocks.CYPRESS_SIGNS.getSecond(),
            HorizonsBlocks.CYPRESS_HANGING_SIGNS.getSecond()
    );

    public HorizonsLanguageProvider(BorealibPackOutput output) {
        super(output, output.getModContainer());
    }

    @Override
    public void generateLanguage(TranslationRegistry registry) {
        // Blocks
        HorizonsBlocks.PROVIDER.stream().filter(Predicate.not(DONT_AUTO_TRANSLATE::contains)).forEach(block -> registry.add(block.get(), autoTranslate(block.getId().getPath())));

        // Non-block items
        HorizonsItems.PROVIDER.stream().filter(Predicate.not(item -> DONT_AUTO_TRANSLATE.contains(item) || item.get() instanceof BlockItem)).forEach(item -> registry.add(item.get(), autoTranslate(item.getId().getPath())));

        // Manual translations
        registry.add(HorizonsItems.CYPRESS_BOATS.getSecond().get(), "Cypress Boat with Chest");
    }
}
