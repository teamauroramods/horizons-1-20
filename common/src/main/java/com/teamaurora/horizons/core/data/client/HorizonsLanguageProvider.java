package com.teamaurora.horizons.core.data.client;

import com.google.common.collect.ImmutableSet;
import com.teamaurora.borealib.api.datagen.v1.BorealibPackOutput;
import com.teamaurora.borealib.api.datagen.v1.providers.BorealibLanguageProvider;
import com.teamaurora.borealib.api.registry.v1.RegistryReference;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Set;
import java.util.function.Predicate;

public class HorizonsLanguageProvider extends BorealibLanguageProvider {

    private static final Set<RegistryReference<?>> DONT_AUTO_TRANSLATE = ImmutableSet.of(
      // Put stuff you want to manually translate here
    );

    public HorizonsLanguageProvider(BorealibPackOutput output) {
        super(output, output.getModContainer());
    }

    @Override
    public void generateLanguage(TranslationRegistry registry) {
        HorizonsBlocks.PROVIDER.stream().filter(Predicate.not(DONT_AUTO_TRANSLATE::contains)).forEach(ref -> generateTranslation(registry, ref));
        HorizonsItems.PROVIDER.stream().filter(Predicate.not(DONT_AUTO_TRANSLATE::contains)).forEach(ref -> generateTranslation(registry, ref));
    }

    private static void generateTranslation(TranslationRegistry registry, RegistryReference<?> ref) {
        String translationKey;
        if (ref.get() instanceof Block block)
            translationKey = block.getDescriptionId();
        else if (ref.get() instanceof Item item)
            translationKey = item.getDescriptionId();
        else
            throw new IllegalStateException("Couldn't get translation key for " + ref.getId());
        registry.add(translationKey, autoTranslate(ref.getId().getPath()));
    }
}
