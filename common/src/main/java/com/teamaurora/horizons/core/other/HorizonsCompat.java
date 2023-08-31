package com.teamaurora.horizons.core.other;

import com.teamaurora.borealib.api.base.v1.platform.Platform;
import com.teamaurora.borealib.api.content_registries.v1.FlammabilityRegistry;
import com.teamaurora.borealib.api.content_registries.v1.FuelRegistry;
import com.teamaurora.borealib.api.content_registries.v1.StrippingRegistry;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.level.ItemLike;

import static com.teamaurora.horizons.core.registry.HorizonsItems.*;
import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;

public final class HorizonsCompat {
    public static void init() {
        registerCompostables();
        registerFlammables();
        registerStrippables();
        registerFuel();
    }

    public static void registerCompostables() {
        addCompostable(GOOSEBERRIES.get(), .3f);
        addCompostable(HONEY_GLAZED_GOOSEBERRIES.get(), .3f);
        addCompostable(GOOSEBERRY_JAM_COOKIE.get(), .85f);
        addCompostable(GOOSEBERRY_PIE.get(), 1f);
        addCompostable(SUNFLOWER_SEEDS.get(), .3f);
        addCompostable(CYPRESS_LEAVES.get(), .3f);
        addCompostable(CYPRESS_SAPLING.get(), .3f);
        addCompostable(BEARD_MOSS_BLOCK.get(), .3f);
        addCompostable(BEARD_MOSS.get(), .3f);
        addCompostable(BLUE_LILY.get(), .65f);
        addCompostable(LIGHT_GRAY_LILY.get(), .65f);
        addCompostable(CYAN_LILY.get(), .65f);
        addCompostable(LIGHT_BLUE_LILY.get(), .65f);
        addCompostable(MAGENTA_LILY.get(), .65f);
        addCompostable(PINK_LILY.get(), .65f);
        addCompostable(PURPLE_LILY.get(), .65f);
        addCompostable(WHITE_LILY.get(), .65f);
        addCompostable(FIDDLENECK.get(), .65f);
        addCompostable(AMARANTHUS.get(), .65f);
        addCompostable(MYOSOTIS.get(), .65f);
        addCompostable(HELICONIA.get(), .65f);
    }

    @ExpectPlatform
    private static void addCompostable(ItemLike itemLike, float chance) {
        Platform.expect();
    }

    public static void registerFlammables() {
        FlammabilityRegistry.register(5, 20, CYPRESS_PLANKS.get(), CYPRESS_SLAB.get(), CYPRESS_STAIRS.get(), CYPRESS_FENCE.get(), CYPRESS_FENCE_GATE.get(), REDWOOD_PLANKS.get(), REDWOOD_SLAB.get(), REDWOOD_STAIRS.get(), REDWOOD_FENCE.get(), REDWOOD_FENCE_GATE.get());
        FlammabilityRegistry.register(5, 5, STRIPPED_CYPRESS_WOOD.get(), STRIPPED_CYPRESS_LOG.get(), CYPRESS_LOG.get(), CYPRESS_WOOD.get(), CYPRESS_KNEE.get(), LARGE_CYPRESS_KNEE.get(), STRIPPED_REDWOOD.get(), STRIPPED_REDWOOD_LOG.get(), REDWOOD_LOG.get(), REDWOOD.get());
        FlammabilityRegistry.register(30, 20, CYPRESS_BOOKSHELF.get(), REDWOOD_BOOKSHELF.get());
        FlammabilityRegistry.register(30, 60, BEARD_MOSS_BLOCK.get(), BEARD_MOSS.get(), CYPRESS_LEAVES.get(), HANGING_CYPRESS_LEAVES.get(), REDWOOD_LEAVES.get());
        FlammabilityRegistry.register(60, 100, BLUE_LILY.get(), LIGHT_GRAY_LILY.get(), CYAN_LILY.get(), LIGHT_BLUE_LILY.get(), MAGENTA_LILY.get(), PINK_LILY.get(), PURPLE_LILY.get(), WHITE_LILY.get(), FIDDLENECK.get(), AMARANTHUS.get(), MYOSOTIS.get(), HELICONIA.get());
    }

    public static void registerStrippables() {
        StrippingRegistry.register(CYPRESS_LOG.get(), STRIPPED_CYPRESS_LOG.get());
        StrippingRegistry.register(CYPRESS_WOOD.get(), STRIPPED_CYPRESS_WOOD.get());
        StrippingRegistry.register(REDWOOD_LOG.get(), STRIPPED_REDWOOD_LOG.get());
        StrippingRegistry.register(REDWOOD.get(), STRIPPED_REDWOOD.get());
    }

    public static void registerFuel() {
        FuelRegistry.register(CYPRESS_BOOKSHELF.get(), 300);
        FuelRegistry.register(REDWOOD_BOOKSHELF.get(), 300);
        FuelRegistry.register(BEARD_MOSS_BLOCK.get(), 800);
        FuelRegistry.register(BEARD_MOSS.get(), 800);
    }
}
