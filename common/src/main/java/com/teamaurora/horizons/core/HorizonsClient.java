package com.teamaurora.horizons.core;

import com.teamaurora.borealib.api.base.v1.util.ParallelDispatcher;
import com.teamaurora.borealib.api.content_registries.v1.client.ColorRegistry;
import com.teamaurora.borealib.api.content_registries.v1.client.render.RenderTypeRegistry;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;

/**
 * @author rose_
 * @author ebo2022
 */
public final class HorizonsClient {
    public static void init() {
        ColorRegistry.register((state, level, pos, tintIndex) -> level != null && pos != null ? BiomeColors.getAverageFoliageColor(level, pos) : FoliageColor.getDefaultColor(), HorizonsBlocks.CYPRESS_LEAVES, HorizonsBlocks.HANGING_CYPRESS_LEAVES);
        ColorRegistry.register((stack, tintIndex) -> FoliageColor.getDefaultColor(), HorizonsBlocks.CYPRESS_LEAVES, HorizonsBlocks.HANGING_CYPRESS_LEAVES);
        ColorRegistry.register((state, level, pos, tintIndex) -> level != null && pos != null ? BiomeColors.getAverageGrassColor(level, pos) : GrassColor.get(0.5D, 1.0D), HorizonsBlocks.GIANT_FERN, HorizonsBlocks.TROPICAL_GRASS, HorizonsBlocks.TROPICAL_FERN);
        ColorRegistry.register((stack, tintIndex) -> GrassColor.get(0.5D, 1.0D), HorizonsBlocks.GIANT_FERN, HorizonsBlocks.TROPICAL_GRASS, HorizonsBlocks.TROPICAL_FERN);
        ColorRegistry.register((state, level, pos, tintIndex) -> level != null && pos != null ? 2129968 : 7455580, HorizonsBlocks.BLUE_LILY, HorizonsBlocks.LIGHT_GRAY_LILY, HorizonsBlocks.CYAN_LILY, HorizonsBlocks.LIGHT_BLUE_LILY, HorizonsBlocks.MAGENTA_LILY, HorizonsBlocks.PINK_LILY, HorizonsBlocks.PURPLE_LILY, HorizonsBlocks.WHITE_LILY);
    }

    public static void postInit(ParallelDispatcher dispatcher) {
        RenderTypeRegistry.register(RenderType.cutoutMipped(), HorizonsBlocks.HANGING_CYPRESS_LEAVES.get());
        RenderTypeRegistry.register(RenderType.cutout(),
                HorizonsBlocks.CYPRESS_SAPLING.get(),
                HorizonsBlocks.POTTED_CYPRESS_SAPLING.get(),
                HorizonsBlocks.ALGAE.get(),
                HorizonsBlocks.ALGAE_THATCH.get(),
                HorizonsBlocks.ALGAE_THATCH_SLAB.get(),
                HorizonsBlocks.ALGAE_THATCH_STAIRS.get(),
                HorizonsBlocks.CYPRESS_KNEE.get(),
                HorizonsBlocks.LARGE_CYPRESS_KNEE.get(),
                HorizonsBlocks.STRIPPED_CYPRESS_KNEE.get(),
                HorizonsBlocks.STRIPPED_LARGE_CYPRESS_KNEE.get(),
                HorizonsBlocks.BLUE_LILY.get(),
                HorizonsBlocks.POTTED_BLUE_LILY.get(),
                HorizonsBlocks.LIGHT_GRAY_LILY.get(),
                HorizonsBlocks.POTTED_LIGHT_GRAY_LILY.get(),
                HorizonsBlocks.CYAN_LILY.get(),
                HorizonsBlocks.POTTED_CYAN_LILY.get(),
                HorizonsBlocks.LIGHT_BLUE_LILY.get(),
                HorizonsBlocks.POTTED_LIGHT_BLUE_LILY.get(),
                HorizonsBlocks.MAGENTA_LILY.get(),
                HorizonsBlocks.POTTED_MAGENTA_LILY.get(),
                HorizonsBlocks.PINK_LILY.get(),
                HorizonsBlocks.POTTED_PINK_LILY.get(),
                HorizonsBlocks.PURPLE_LILY.get(),
                HorizonsBlocks.POTTED_PURPLE_LILY.get(),
                HorizonsBlocks.WHITE_LILY.get(),
                HorizonsBlocks.POTTED_WHITE_LILY.get(),
                HorizonsBlocks.BEARD_MOSS.get(),
                HorizonsBlocks.GIANT_FERN.get(),
                HorizonsBlocks.TROPICAL_GRASS.get(),
                HorizonsBlocks.TROPICAL_FERN.get(),
                HorizonsBlocks.CYPRESS_BRANCH.get(),
                HorizonsBlocks.FIDDLENECK.get(),
                HorizonsBlocks.AMARANTHUS.get(),
                HorizonsBlocks.MYOSOTIS.get(),
                HorizonsBlocks.POTTED_FIDDLENECK.get(),
                HorizonsBlocks.POTTED_AMARANTHUS.get(),
                HorizonsBlocks.POTTED_MYOSOTIS.get(),
                HorizonsBlocks.HELICONIA.get(),
                HorizonsBlocks.REDWOOD_SAPLING.get(),
                HorizonsBlocks.POTTED_REDWOOD_SAPLING.get(),
                HorizonsBlocks.REDWOOD_DOOR.get(),
                HorizonsBlocks.REDWOOD_TRAPDOOR.get()
        );
    }
}
