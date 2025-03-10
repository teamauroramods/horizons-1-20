package com.teamaurora.horizons.core.data.server;

import com.teamaurora.borealib.api.base.v1.platform.Platform;
import com.teamaurora.borealib.api.base.v1.util.CompatBlockTags;
import com.teamaurora.borealib.api.datagen.v1.BorealibPackOutput;
import com.teamaurora.borealib.api.datagen.v1.providers.BorealibTagsProvider;
import com.teamaurora.horizons.core.other.tags.HorizonsBlockTags;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

import static com.teamaurora.horizons.core.other.tags.HorizonsBlockTags.*;
import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;

public class HorizonsBlockTagsProvider extends BorealibTagsProvider.BlockTagProvider {
    public HorizonsBlockTagsProvider(BorealibPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        handlePlatformTags(this, registries);

        //horizons
        this.tag(HorizonsBlockTags.CYPRESS_LOGS).add(CYPRESS_LOG.get(), CYPRESS_WOOD.get(), STRIPPED_CYPRESS_LOG.get(), STRIPPED_CYPRESS_WOOD.get());
        this.tag(HorizonsBlockTags.REDWOOD_LOGS).add(REDWOOD_LOG.get(), REDWOOD.get(), STRIPPED_REDWOOD_LOG.get(), STRIPPED_REDWOOD.get());
        this.tag(HorizonsBlockTags.JACARANDA_LOGS).add(JACARANDA_LOG.get(), JACARANDA_WOOD.get(), STRIPPED_JACARANDA_LOG.get(), STRIPPED_JACARANDA_WOOD.get());

        //quark
        //this.tag(BlueprintBlockTags.VERTICAL_SLABS).add(ALGAE_THATCH_VERTICAL_SLAB.get(), LIGHT_BOULDER_VERTICAL_SLAB.get(), DARK_BOULDER_VERTICAL_SLAB.get(), MOSSY_LIGHT_BOULDER_VERTICAL_SLAB.get(), MOSSY_DARK_BOULDER_VERTICAL_SLAB.get(), BOULDER_BRICK_VERTICAL_SLAB.get());
        //this.tag(BlueprintBlockTags.WOODEN_VERTICAL_SLABS).add(CYPRESS_VERTICAL_SLAB.get(), REDWOOD_VERTICAL_SLAB.get(), REDBUD_VERTICAL_SLAB.get(), JACARANDA_VERTICAL_SLAB.get());
        //this.tag(BlueprintBlockTags.HEDGES).add(CYPRESS_HEDGE.get(), REDWOOD_HEDGE.get(), REDBUD_HEDGE.get(), BUDDING_REDBUD_HEDGE.get(), FLOWERING_REDBUD_HEDGE.get(), JACARANDA_HEDGE.get(), BUDDING_JACARANDA_HEDGE.get(), FLOWERING_JACARANDA_HEDGE.get(), AZURE_JACARANDA_HEDGE.get(), BUDDING_AZURE_JACARANDA_HEDGE.get(), FLOWERING_AZURE_JACARANDA_HEDGE.get());
        //this.tag(BlueprintBlockTags.LADDERS).add(CYPRESS_LADDER.get(), REDWOOD_LADDER.get(), REDBUD_LADDER.get(), JACARANDA_LADDER.get());

        //woodworks
        //this.tag(BlueprintBlockTags.LEAF_PILES).add(CYPRESS_LEAF_PILE.get(), REDWOOD_LEAF_PILE.get(), REDBUD_LEAF_PILE.get(), BUDDING_REDBUD_LEAF_PILE.get(), FLOWERING_REDBUD_LEAF_PILE.get(), JACARANDA_LEAF_PILE.get(), BUDDING_JACARANDA_LEAF_PILE.get(), FLOWERING_JACARANDA_LEAF_PILE.get(), AZURE_JACARANDA_LEAF_PILE.get(), BUDDING_AZURE_JACARANDA_LEAF_PILE.get(), FLOWERING_AZURE_JACARANDA_LEAF_PILE.get(), REDBUD_BLOSSOMS_LEAF_PILE.get());

        //carpenter
        this.tag(CompatBlockTags.CARPENTER_CHESTS).add(CYPRESS_CHESTS.getFirst().get(), REDWOOD_CHESTS.getFirst().get(), JACARANDA_CHESTS.getFirst().get());
        this.tag(CompatBlockTags.CARPENTER_TRAPPED_CHESTS).add(CYPRESS_CHESTS.getSecond().get(), REDWOOD_CHESTS.getSecond().get(), JACARANDA_CHESTS.getSecond().get());
        this.tag(CompatBlockTags.CARPENTER_BOOKSHELVES).add(CYPRESS_BOOKSHELF.get(), REDWOOD_BOOKSHELF.get(), JACARANDA_BOOKSHELF.get());

        //minecraft
        this.tag(BlockTags.SLABS).add(ALGAE_THATCH_SLAB.get());
        this.tag(BlockTags.STAIRS).add(ALGAE_THATCH_STAIRS.get());
        //this.tag(BlockTags.WALLS).add(LIGHT_BOULDER_WALL.get(), DARK_BOULDER_WALL.get(), MOSSY_LIGHT_BOULDER_WALL.get(), MOSSY_DARK_BOULDER_WALL.get(), BOULDER_BRICK_WALL.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(CYPRESS_BUTTON.get(), REDWOOD_BUTTON.get(), JACARANDA_BUTTON.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(CYPRESS_PRESSURE_PLATE.get(), REDWOOD_PRESSURE_PLATE.get(), JACARANDA_PRESSURE_PLATE.get());
        this.tag(BlockTags.PLANKS).add(CYPRESS_PLANKS.get(), REDWOOD_PLANKS.get(), JACARANDA_PLANKS.get());
        this.tag(BlockTags.WOODEN_DOORS).add(CYPRESS_DOOR.get(), REDWOOD_DOOR.get(), JACARANDA_DOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(CYPRESS_TRAPDOOR.get(), REDWOOD_TRAPDOOR.get(), JACARANDA_TRAPDOOR.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(CYPRESS_STAIRS.get(), REDWOOD_STAIRS.get(), JACARANDA_STAIRS.get());
        this.tag(BlockTags.WOODEN_SLABS).add(CYPRESS_SLAB.get(), REDWOOD_SLAB.get(), JACARANDA_SLAB.get());
        this.tag(BlockTags.STANDING_SIGNS).add(CYPRESS_SIGNS.getFirst().get(), REDWOOD_SIGNS.getFirst().get(), JACARANDA_SIGNS.getFirst().get());
        this.tag(BlockTags.WALL_SIGNS).add(CYPRESS_SIGNS.getSecond().get(), REDWOOD_SIGNS.getSecond().get(), JACARANDA_SIGNS.getSecond().get());
        this.tag(BlockTags.CEILING_HANGING_SIGNS).add(CYPRESS_HANGING_SIGNS.getFirst().get(), REDWOOD_HANGING_SIGNS.getFirst().get(), JACARANDA_HANGING_SIGNS.getFirst().get());
        this.tag(BlockTags.WALL_HANGING_SIGNS).add(CYPRESS_HANGING_SIGNS.getSecond().get(), REDWOOD_HANGING_SIGNS.getSecond().get(), JACARANDA_HANGING_SIGNS.getSecond().get());
        this.tag(BlockTags.WOODEN_FENCES).add(CYPRESS_FENCE.get(), REDWOOD_FENCE.get(), JACARANDA_FENCE.get());
        this.tag(BlockTags.LOGS_THAT_BURN).addTag(CYPRESS_LOGS).addTag(REDWOOD_LOGS).addTag(JACARANDA_LOGS);
        this.tag(BlockTags.LEAVES).add(CYPRESS_LEAVES.get(), REDWOOD_LEAVES.get(), JACARANDA_LEAVES.get(), FLOWERING_JACARANDA_LEAVES.get());
        this.tag(BlockTags.CLIMBABLE).add(BEARD_MOSS.get(), CYPRESS_LADDER.get(), REDWOOD_LADDER.get(), JACARANDA_LADDER.get());
        this.tag(BlockTags.FENCE_GATES).add(CYPRESS_FENCE_GATE.get(), REDWOOD_FENCE_GATE.get(), JACARANDA_FENCE_GATE.get());
        this.tag(BlockTags.SAPLINGS).add(CYPRESS_SAPLING.get(), REDWOOD_SAPLING.get(), JACARANDA_SAPLING.get(), FLOWERING_JACARANDA_SAPLING.get());
        this.tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(CYPRESS_LOG.get(), REDWOOD_LOG.get(), JACARANDA_LOG.get());
        this.tag(BlockTags.GUARDED_BY_PIGLINS).add(CYPRESS_CHESTS.getFirst().get(), CYPRESS_CHESTS.getSecond().get(), REDWOOD_CHESTS.getFirst().get(), REDWOOD_CHESTS.getSecond().get(), JACARANDA_CHESTS.getFirst().get(), JACARANDA_CHESTS.getSecond().get());
        this.tag(BlockTags.TALL_FLOWERS).add(HELICONIA.get());
        this.tag(BlockTags.FLOWER_POTS).add(POTTED_CYPRESS_SAPLING.get(), POTTED_BLUE_LILY.get(), POTTED_LIGHT_GRAY_LILY.get(), POTTED_CYAN_LILY.get(), POTTED_LIGHT_BLUE_LILY.get(), POTTED_MAGENTA_LILY.get(), POTTED_PINK_LILY.get(), POTTED_PURPLE_LILY.get(), POTTED_WHITE_LILY.get(), POTTED_FIDDLENECK.get(),
                POTTED_AMARANTHUS.get(), POTTED_MYOSOTIS.get(), POTTED_REDWOOD_SAPLING.get(), POTTED_JACARANDA_SAPLING.get(), POTTED_FLOWERING_JACARANDA_SAPLING.get(), POTTED_LAVENDER.get());
        this.tag(BlockTags.SMALL_FLOWERS).add(BLUE_LILY.get(), LIGHT_GRAY_LILY.get(), CYAN_LILY.get(), LIGHT_BLUE_LILY.get(), MAGENTA_LILY.get(), PINK_LILY.get(), PURPLE_LILY.get(), WHITE_LILY.get(), FIDDLENECK.get(), AMARANTHUS.get(), MYOSOTIS.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(ALGAE.get(), ALGAE_THATCH.get(), ALGAE_THATCH_SLAB.get(), ALGAE_THATCH_STAIRS.get(), CYPRESS_LEAVES.get(), HANGING_CYPRESS_LEAVES.get(), BEARD_MOSS_BLOCK.get(), BEARD_MOSS.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(CYPRESS_BOOKSHELF.get(), CYPRESS_CHESTS.getFirst().get(), CYPRESS_CHESTS.getSecond().get(), CYPRESS_KNEE.get(), LARGE_CYPRESS_KNEE.get(), CYPRESS_BRANCH.get(), CYPRESS_CABINET.get(), CYPRESS_LADDER.get(),
                REDWOOD_BOOKSHELF.get(), REDWOOD_CHESTS.getFirst().get(), REDWOOD_CHESTS.getSecond().get(), REDWOOD_CABINET.get(), REDWOOD_LADDER.get(),
                JACARANDA_BOOKSHELF.get(), JACARANDA_CHESTS.getFirst().get(), JACARANDA_CHESTS.getSecond().get(), JACARANDA_CABINET.get(), JACARANDA_LADDER.get());
    }

    @ExpectPlatform
    public static void handlePlatformTags(HorizonsBlockTagsProvider provider, HolderLookup.Provider lookup) {
        Platform.expect();
    }
}
