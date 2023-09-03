package com.teamaurora.horizons.core;

import com.teamaurora.borealib.api.base.v1.util.ParallelDispatcher;
import com.teamaurora.borealib.api.content_registries.v1.client.ColorRegistry;
import com.teamaurora.borealib.api.content_registries.v1.client.render.RenderTypeRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;

import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;

/**
 * @author rose_
 * @author ebo2022
 */
public final class HorizonsClient {
    public static void init() {
        ColorRegistry.register((state, level, pos, tintIndex) -> level != null && pos != null ? BiomeColors.getAverageFoliageColor(level, pos) : FoliageColor.getDefaultColor(), CYPRESS_LEAVES, HANGING_CYPRESS_LEAVES);
        ColorRegistry.register((stack, tintIndex) -> FoliageColor.getDefaultColor(), CYPRESS_LEAVES, HANGING_CYPRESS_LEAVES);
        ColorRegistry.register((state, level, pos, tintIndex) -> level != null && pos != null ? BiomeColors.getAverageGrassColor(level, pos) : GrassColor.get(0.5D, 1.0D), GIANT_FERN, TROPICAL_GRASS, TROPICAL_FERN);
        ColorRegistry.register((stack, tintIndex) -> GrassColor.get(0.5D, 1.0D), GIANT_FERN, TROPICAL_GRASS, TROPICAL_FERN);
        ColorRegistry.register((state, level, pos, tintIndex) -> level != null && pos != null ? 2129968 : 7455580, BLUE_LILY, LIGHT_GRAY_LILY, CYAN_LILY, LIGHT_BLUE_LILY, MAGENTA_LILY, PINK_LILY, PURPLE_LILY, WHITE_LILY);
    }

    public static void postInit(ParallelDispatcher dispatcher) {
        RenderTypeRegistry.register(RenderType.cutoutMipped(), HANGING_CYPRESS_LEAVES.get());
        RenderTypeRegistry.register(RenderType.cutout(),
                CYPRESS_SAPLING.get(),
                POTTED_CYPRESS_SAPLING.get(),
                ALGAE.get(),
                ALGAE_THATCH.get(),
                ALGAE_THATCH_SLAB.get(),
                ALGAE_THATCH_STAIRS.get(),
                CYPRESS_KNEE.get(),
                LARGE_CYPRESS_KNEE.get(),
                BLUE_LILY.get(),
                POTTED_BLUE_LILY.get(),
                LIGHT_GRAY_LILY.get(),
                POTTED_LIGHT_GRAY_LILY.get(),
                CYAN_LILY.get(),
                POTTED_CYAN_LILY.get(),
                LIGHT_BLUE_LILY.get(),
                POTTED_LIGHT_BLUE_LILY.get(),
                MAGENTA_LILY.get(),
                POTTED_MAGENTA_LILY.get(),
                PINK_LILY.get(),
                POTTED_PINK_LILY.get(),
                PURPLE_LILY.get(),
                POTTED_PURPLE_LILY.get(),
                WHITE_LILY.get(),
                POTTED_WHITE_LILY.get(),
                BEARD_MOSS.get(),
                GIANT_FERN.get(),
                TROPICAL_GRASS.get(),
                TROPICAL_FERN.get(),
                CYPRESS_BRANCH.get(),
                FIDDLENECK.get(),
                AMARANTHUS.get(),
                MYOSOTIS.get(),
                POTTED_FIDDLENECK.get(),
                POTTED_AMARANTHUS.get(),
                POTTED_MYOSOTIS.get(),
                HELICONIA.get(),
                REDWOOD_SAPLING.get(),
                POTTED_REDWOOD_SAPLING.get(),
                REDWOOD_DOOR.get(),
                REDWOOD_TRAPDOOR.get(),
                JACARANDA_DOOR.get(),
                JACARANDA_TRAPDOOR.get(),
                JACARANDA_SAPLING.get(),
                POTTED_JACARANDA_SAPLING.get(),
                FLOWERING_JACARANDA_SAPLING.get(),
                POTTED_FLOWERING_JACARANDA_SAPLING.get(),
                LAVENDER.get(),
                TALL_LAVENDER.get()
        );
    }
}
