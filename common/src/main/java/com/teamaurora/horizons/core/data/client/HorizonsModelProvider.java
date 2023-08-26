package com.teamaurora.horizons.core.data.client;

import com.mojang.datafixers.util.Pair;
import com.teamaurora.borealib.api.block.v1.BorealibCeilingHangingSignBlock;
import com.teamaurora.borealib.api.block.v1.BorealibWallHangingSignBlock;
import com.teamaurora.borealib.api.block.v1.compat.BorealibChestBlock;
import com.teamaurora.borealib.api.block.v1.compat.BorealibTrappedChestBlock;
import com.teamaurora.borealib.api.datagen.v1.BorealibPackOutput;
import com.teamaurora.borealib.api.datagen.v1.providers.BorealibModelProvider;
import com.teamaurora.borealib.api.datagen.v1.util.BorealibModelTemplates;
import com.teamaurora.borealib.api.datagen.v1.util.ModelGeneratorHelper;
import com.teamaurora.borealib.api.registry.v1.RegistryReference;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.HorizonsBlockFamilies;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.*;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.StairsShape;
import org.lwjgl.openal.AL;

import java.util.Objects;

import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;
import static com.teamaurora.horizons.core.registry.HorizonsItems.*;
import static com.teamaurora.horizons.core.other.HorizonsBlockFamilies.*;

/**
 * @author ebo2022
 * @author rose_
 */
public class HorizonsModelProvider extends BorealibModelProvider {

    private static final ModelTemplate TRIPLE_PLANT_TOP = ModelGeneratorHelper.template(Horizons.location("block/template_triple_plant_top"), TextureSlot.CROSS, TextureSlot.TOP);
    private static final TextureSlot FLOWER_SLOT = ModelGeneratorHelper.slot("flower");
    private static final ModelTemplate TEMPLATE_LILY = ModelGeneratorHelper.template(Horizons.location("block/template_lily"), FLOWER_SLOT);

    private static final TextureSlot THATCH_SLOT = ModelGeneratorHelper.slot("thatch");
    private static final TextureSlot EXTRUDES_SLOT = ModelGeneratorHelper.slot("extrudes");
    private static final ModelTemplate THATCH = ModelGeneratorHelper.template(Horizons.location("borealib:block/thatch/thatch"), THATCH_SLOT, EXTRUDES_SLOT);
    private static final ModelTemplate THATCH_SLAB = ModelGeneratorHelper.template(Horizons.location("borealib:block/thatch/thatch_slab"), THATCH_SLOT, EXTRUDES_SLOT);
    private static final ModelTemplate THATCH_SLAB_TOP = ModelGeneratorHelper.template(Horizons.location("borealib:block/thatch/thatch_slab_top"), THATCH_SLOT, EXTRUDES_SLOT);
    private static final ModelTemplate THATCH_STAIRS = ModelGeneratorHelper.template(Horizons.location("borealib:block/thatch/thatch_stairs"), THATCH_SLOT, EXTRUDES_SLOT);
    private static final ModelTemplate THATCH_STAIRS_TOP = ModelGeneratorHelper.template(Horizons.location("borealib:block/thatch/thatch_stairs_top"), THATCH_SLOT, EXTRUDES_SLOT);
    private static final ModelTemplate THATCH_STAIRS_INNER = ModelGeneratorHelper.template(Horizons.location("borealib:block/thatch/thatch_stairs_inner"), THATCH_SLOT, EXTRUDES_SLOT);
    private static final ModelTemplate THATCH_STAIRS_INNER_TOP = ModelGeneratorHelper.template(Horizons.location("borealib:block/thatch/thatch_stairs_inner_top"), THATCH_SLOT, EXTRUDES_SLOT);
    private static final ModelTemplate THATCH_STAIRS_OUTER = ModelGeneratorHelper.template(Horizons.location("borealib:block/thatch/thatch_stairs_outer"), THATCH_SLOT, EXTRUDES_SLOT);
    private static final ModelTemplate THATCH_STAIRS_OUTER_TOP = ModelGeneratorHelper.template(Horizons.location("borealib:block/thatch/thatch_stairs_outer_top"), THATCH_SLOT, EXTRUDES_SLOT);
    private static final ModelTemplate WATER_COVER = ModelGeneratorHelper.template(Horizons.location("block/water_cover"), TextureSlot.TEXTURE);
    private static final TextureSlot BRANCH_SLOT = ModelGeneratorHelper.slot("branch");
    private static final ModelTemplate TEMPLATE_BRANCH = ModelGeneratorHelper.template(Horizons.location("block/template_branch"), BRANCH_SLOT);

    public HorizonsModelProvider(BorealibPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockModels(BlockModelGenerators generator) {

        // Wood Sets //
        createWoodFamily(generator, CYPRESS_PLANKS_FAMILY, CYPRESS_LOG, CYPRESS_WOOD, STRIPPED_CYPRESS_LOG, STRIPPED_CYPRESS_WOOD, CYPRESS_CHESTS, CYPRESS_BOOKSHELF, CYPRESS_CABINET, CYPRESS_HANGING_SIGNS);
        generator.createTrivialBlock(CYPRESS_LEAVES.get(), TexturedModel.LEAVES);
        generator.createCrossBlockWithDefaultItem(HANGING_CYPRESS_LEAVES.get(), BlockModelGenerators.TintState.TINTED);
        generator.createPlant(CYPRESS_SAPLING.get(), POTTED_CYPRESS_SAPLING.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createCrossBlockWithDefaultItem(CYPRESS_KNEE.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createCrossBlockWithDefaultItem(STRIPPED_CYPRESS_KNEE.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createDoublePlant(LARGE_CYPRESS_KNEE.get(), BlockModelGenerators.TintState.NOT_TINTED);
        generator.createDoublePlant(STRIPPED_LARGE_CYPRESS_KNEE.get(), BlockModelGenerators.TintState.NOT_TINTED);
        createCypressBranch(generator);

        // Algae + Thatch //
        createWaterCover(generator, ALGAE);
        createThatchFamily(generator, ALGAE_THATCH_FAMILY);

        // Beard Moss //
        generator.createTrivialCube(BEARD_MOSS_BLOCK.get());
        createBeardMoss(generator);

        // Giant Fern & Tropical Grass //
        createGiantFern(generator);
        generator.createCrossBlockWithDefaultItem(TROPICAL_GRASS.get(), BlockModelGenerators.TintState.TINTED);
        generator.createCrossBlockWithDefaultItem(TROPICAL_FERN.get(), BlockModelGenerators.TintState.TINTED);

        // Flowers //
        createLily(generator, BLUE_LILY, POTTED_BLUE_LILY);
        createLily(generator, LIGHT_GRAY_LILY, POTTED_LIGHT_GRAY_LILY);
        createLily(generator, CYAN_LILY, POTTED_CYAN_LILY);
        createLily(generator, LIGHT_BLUE_LILY, POTTED_LIGHT_BLUE_LILY);
        createLily(generator, MAGENTA_LILY, POTTED_MAGENTA_LILY);
        createLily(generator, PINK_LILY, POTTED_PINK_LILY);
        createLily(generator, PURPLE_LILY, POTTED_PURPLE_LILY);
        createLily(generator, WHITE_LILY, POTTED_WHITE_LILY);
    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {
        createWoodItems(generator, CYPRESS_BOATS);
        generator.generateFlatItem(GOOSEBERRY_JAM.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(SUNFLOWER_SEEDS.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(GOOSEBERRY_PIE.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(HONEY_GLAZED_GOOSEBERRIES.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(LAVENDER_SALAD.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(GOOSEBERRY_JAM_COOKIE.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(LAVENDER_TEA.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(GOOSEBERRY_JUICE.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(REDBUD_BLOSSOMS.get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(GOOSEBERRIES.get(), ModelTemplates.FLAT_ITEM);
    }

    private static void createWoodFamily(BlockModelGenerators generator, BlockFamily planksFamily,
                                         RegistryReference<Block> log, RegistryReference<Block> wood,
                                         RegistryReference<Block> strippedLog, RegistryReference<Block> strippedWood,
                                         Pair<RegistryReference<BorealibChestBlock>, RegistryReference<BorealibTrappedChestBlock>> chests,
                                         RegistryReference<Block> bookshelf, RegistryReference<Block> cabinet,
                                         Pair<RegistryReference<BorealibCeilingHangingSignBlock>, RegistryReference<BorealibWallHangingSignBlock>> hangingSigns) {
        generator.family(planksFamily.getBaseBlock()).generateFor(planksFamily);
        generator.woodProvider(log.get()).logWithHorizontal(log.get()).wood(wood.get());
        generator.woodProvider(strippedLog.get()).logWithHorizontal(strippedLog.get()).wood(strippedWood.get());
        generator.blockEntityModels(chests.getFirst().get(), planksFamily.getBaseBlock()).createWithCustomBlockItemModel(BorealibModelTemplates.CHEST_ITEM, chests.getFirst().get(), chests.getSecond().get());
        createBookshelf(generator, bookshelf.get(), planksFamily.getBaseBlock());
        createCabinet(generator, cabinet.get());
        generator.createHangingSign(planksFamily.getBaseBlock(), hangingSigns.getFirst().get(), hangingSigns.getSecond().get());
    }

    private static void createBookshelf(BlockModelGenerators generator, Block shelf, Block planks) {
        TextureMapping textureMapping = TextureMapping.column(TextureMapping.getBlockTexture(shelf), TextureMapping.getBlockTexture(planks));
        ResourceLocation modelLocation = ModelTemplates.CUBE_COLUMN.create(shelf, textureMapping, generator.modelOutput);
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(shelf, modelLocation));
    }

    private static void createCabinet(BlockModelGenerators generator, Block cabinet) {
        ResourceLocation resourceLocation = TexturedModel.ORIENTABLE_ONLY_TOP.create(cabinet, generator.modelOutput);
        ResourceLocation openTexture = TextureMapping.getBlockTexture(cabinet, "_front_open");
        ResourceLocation resourceLocation3 = TexturedModel.ORIENTABLE_ONLY_TOP.get(cabinet).updateTextures((textureMapping) -> {
            textureMapping.put(TextureSlot.FRONT, openTexture);
        }).createWithSuffix(cabinet, "_open", generator.modelOutput);
        generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(cabinet).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.OPEN, resourceLocation3, resourceLocation)).with(BlockModelGenerators.createHorizontalFacingDispatch()));
    }

    private static void createWoodItems(ItemModelGenerators generator, Pair<RegistryReference<Item>, RegistryReference<Item>> boats) {
        generator.generateFlatItem(boats.getFirst().get(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(boats.getSecond().get(), ModelTemplates.FLAT_ITEM);
    }

    private static void createGiantFern(BlockModelGenerators generator) {
        RegistryReference<Block> block = GIANT_FERN;
        generator.createSimpleFlatItemModel(block.get(), "_top");
        ResourceLocation top = generator.createSuffixedVariant(block.get(), "_top", TRIPLE_PLANT_TOP, rl -> new TextureMapping().put(TextureSlot.CROSS, TextureMapping.getBlockTexture(block.get(), "_middle")).put(TextureSlot.TOP, rl));
        ResourceLocation bottom = generator.createSuffixedVariant(block.get(), "_bottom", ModelTemplates.TINTED_CROSS, TextureMapping::cross);
        generator.createDoubleBlock(block.get(), top, bottom);
    }

    private static void createLily(BlockModelGenerators generator, RegistryReference<Block> block, RegistryReference<Block> potted) {
        generator.createSimpleFlatItemModel(block.get());
        ResourceLocation model = TEMPLATE_LILY.create(block.get(), new TextureMapping().put(FLOWER_SLOT, TextureMapping.getBlockTexture(block.get())), generator.modelOutput);
        ResourceLocation pottedModel = BlockModelGenerators.TintState.NOT_TINTED.getCrossPot().create(potted.get(), TextureMapping.plant(block.get()), generator.modelOutput);
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block.get(), model));
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(potted.get(), pottedModel));
    }

    private static void createThatchFamily(BlockModelGenerators generator, BlockFamily family) {
        TextureMapping mapping = new TextureMapping().put(THATCH_SLOT, TextureMapping.getBlockTexture(family.getBaseBlock())).put(EXTRUDES_SLOT, TextureMapping.getBlockTexture(family.getBaseBlock(), "_extrudes"));
        ResourceLocation fullBlock = THATCH.create(family.getBaseBlock(), mapping, generator.modelOutput);

        Block slabBlock = Objects.requireNonNull(family.get(BlockFamily.Variant.SLAB), "Family doesn't have a slab block");
        ResourceLocation slab = THATCH_SLAB.create(slabBlock, mapping, generator.modelOutput);
        ResourceLocation slabTop = THATCH_SLAB_TOP.create(ModelLocationUtils.getModelLocation(slabBlock, "_top"), mapping, generator.modelOutput);

        Block stairBlock = Objects.requireNonNull(family.get(BlockFamily.Variant.STAIRS), "Family doesn't have a stair block");
        ResourceLocation straight = THATCH_STAIRS.create(stairBlock, mapping, generator.modelOutput);
        ResourceLocation straightTop = THATCH_STAIRS_TOP.create(ModelLocationUtils.getModelLocation(stairBlock, "_top"), mapping, generator.modelOutput);
        ResourceLocation inner = THATCH_STAIRS_INNER.create(ModelLocationUtils.getModelLocation(stairBlock, "_inner"), mapping, generator.modelOutput);
        ResourceLocation innerTop = THATCH_STAIRS_INNER_TOP.create(ModelLocationUtils.getModelLocation(stairBlock, "_inner_top"), mapping, generator.modelOutput);
        ResourceLocation outer = THATCH_STAIRS_OUTER.create(ModelLocationUtils.getModelLocation(stairBlock, "_outer"), mapping, generator.modelOutput);
        ResourceLocation outerTop = THATCH_STAIRS_OUTER_TOP.create(ModelLocationUtils.getModelLocation(stairBlock, "_outer_top"), mapping, generator.modelOutput);
        generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(stairBlock).with(PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.HALF, BlockStateProperties.STAIRS_SHAPE)
                .select(Direction.EAST, Half.BOTTOM, StairsShape.STRAIGHT, Variant.variant().with(VariantProperties.MODEL, straight))
                .select(Direction.WEST, Half.BOTTOM, StairsShape.STRAIGHT, Variant.variant().with(VariantProperties.MODEL, straight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true))
                .select(Direction.SOUTH, Half.BOTTOM, StairsShape.STRAIGHT, Variant.variant().with(VariantProperties.MODEL, straight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true))
                .select(Direction.NORTH, Half.BOTTOM, StairsShape.STRAIGHT, Variant.variant().with(VariantProperties.MODEL, straight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true))
                .select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_RIGHT, Variant.variant().with(VariantProperties.MODEL, outer))
                .select(Direction.WEST, Half.BOTTOM, StairsShape.OUTER_RIGHT, Variant.variant().with(VariantProperties.MODEL, outer).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true))
                .select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_RIGHT, Variant.variant().with(VariantProperties.MODEL, outer).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true))
                .select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_RIGHT, Variant.variant().with(VariantProperties.MODEL, outer).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true))
                .select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_LEFT, Variant.variant().with(VariantProperties.MODEL, outer).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true))
                .select(Direction.WEST, Half.BOTTOM, StairsShape.OUTER_LEFT, Variant.variant().with(VariantProperties.MODEL, outer).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true))
                .select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_LEFT, Variant.variant().with(VariantProperties.MODEL, outer))
                .select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_LEFT, Variant.variant().with(VariantProperties.MODEL, outer).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true))
                .select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, inner))
                .select(Direction.WEST, Half.BOTTOM, StairsShape.INNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, inner).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true))
                .select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, inner).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true))
                .select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, inner).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true))
                .select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_LEFT, Variant.variant().with(VariantProperties.MODEL, inner).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true))
                .select(Direction.WEST, Half.BOTTOM, StairsShape.INNER_LEFT, Variant.variant().with(VariantProperties.MODEL, inner).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true))
                .select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_LEFT, Variant.variant().with(VariantProperties.MODEL, inner))
                .select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_LEFT, Variant.variant().with(VariantProperties.MODEL, inner).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true))
                .select(Direction.EAST, Half.TOP, StairsShape.STRAIGHT, Variant.variant().with(VariantProperties.MODEL, straightTop).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true))
                .select(Direction.WEST, Half.TOP, StairsShape.STRAIGHT, Variant.variant().with(VariantProperties.MODEL, straightTop).with(VariantProperties.UV_LOCK, true))
                .select(Direction.SOUTH, Half.TOP, StairsShape.STRAIGHT, Variant.variant().with(VariantProperties.MODEL, straightTop).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true))
                .select(Direction.NORTH, Half.TOP, StairsShape.STRAIGHT, Variant.variant().with(VariantProperties.MODEL, straightTop).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true))
                .select(Direction.EAST, Half.TOP, StairsShape.OUTER_RIGHT, Variant.variant().with(VariantProperties.MODEL, outerTop).with(VariantProperties.UV_LOCK, true))
                .select(Direction.WEST, Half.TOP, StairsShape.OUTER_RIGHT, Variant.variant().with(VariantProperties.MODEL, outerTop).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true))
                .select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_RIGHT, Variant.variant().with(VariantProperties.MODEL, outerTop).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true))
                .select(Direction.NORTH, Half.TOP, StairsShape.OUTER_RIGHT, Variant.variant().with(VariantProperties.MODEL, outerTop).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true))
                .select(Direction.EAST, Half.TOP, StairsShape.OUTER_LEFT, Variant.variant().with(VariantProperties.MODEL, outerTop).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true))
                .select(Direction.WEST, Half.TOP, StairsShape.OUTER_LEFT, Variant.variant().with(VariantProperties.MODEL, outerTop).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true))
                .select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_LEFT, Variant.variant().with(VariantProperties.MODEL, outerTop).with(VariantProperties.UV_LOCK, true))
                .select(Direction.NORTH, Half.TOP, StairsShape.OUTER_LEFT, Variant.variant().with(VariantProperties.MODEL, outerTop).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true))
                .select(Direction.EAST, Half.TOP, StairsShape.INNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, innerTop).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true))
                .select(Direction.WEST, Half.TOP, StairsShape.INNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, innerTop).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true))
                .select(Direction.SOUTH, Half.TOP, StairsShape.INNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, innerTop).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true))
                .select(Direction.NORTH, Half.TOP, StairsShape.INNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, innerTop).with(VariantProperties.UV_LOCK, true))
                .select(Direction.EAST, Half.TOP, StairsShape.INNER_LEFT, Variant.variant().with(VariantProperties.MODEL, innerTop).with(VariantProperties.UV_LOCK, true))
                .select(Direction.WEST, Half.TOP, StairsShape.INNER_LEFT, Variant.variant().with(VariantProperties.MODEL, innerTop).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true))
                .select(Direction.SOUTH, Half.TOP, StairsShape.INNER_LEFT, Variant.variant().with(VariantProperties.MODEL, innerTop).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true))
                .select(Direction.NORTH, Half.TOP, StairsShape.INNER_LEFT, Variant.variant().with(VariantProperties.MODEL, innerTop).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true))
        ));
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(family.getBaseBlock(), fullBlock));
        generator.blockStateOutput.accept(BlockModelGenerators.createSlab(slabBlock, slab, slabTop, fullBlock));
    }

    private static void createWaterCover(BlockModelGenerators generator, RegistryReference<Block> block) {
        generator.createSimpleFlatItemModel(block.get());
        ResourceLocation model = WATER_COVER.create(block.get(), TextureMapping.defaultTexture(block.get()), generator.modelOutput);
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block.get(), model));
    }

    private static void createCypressBranch(BlockModelGenerators generator) {
        Block branch = CYPRESS_BRANCH.get();
        generator.createSimpleFlatItemModel(branch.asItem());
        ResourceLocation age0 = generator.createSuffixedVariant(branch, "_0", TEMPLATE_BRANCH, HorizonsModelProvider::branchMapping);
        ResourceLocation age1 = generator.createSuffixedVariant(branch, "_1", TEMPLATE_BRANCH, HorizonsModelProvider::branchMapping);
        ResourceLocation age2 = generator.createSuffixedVariant(branch, "_2", TEMPLATE_BRANCH, HorizonsModelProvider::branchMapping);
        generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(branch).with(PropertyDispatch.properties(BlockStateProperties.AGE_2, BlockStateProperties.HORIZONTAL_FACING)
                .select(0, Direction.EAST, Variant.variant().with(VariantProperties.MODEL, age0).with(VariantProperties.UV_LOCK, true).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(0, Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, age0).with(VariantProperties.UV_LOCK, true))
                .select(0, Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, age0).with(VariantProperties.UV_LOCK, true).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(0, Direction.WEST, Variant.variant().with(VariantProperties.MODEL, age0).with(VariantProperties.UV_LOCK, true).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(1, Direction.EAST, Variant.variant().with(VariantProperties.MODEL, age1).with(VariantProperties.UV_LOCK, true).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(1, Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, age1).with(VariantProperties.UV_LOCK, true))
                .select(1, Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, age1).with(VariantProperties.UV_LOCK, true).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(1, Direction.WEST, Variant.variant().with(VariantProperties.MODEL, age1).with(VariantProperties.UV_LOCK, true).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(2, Direction.EAST, Variant.variant().with(VariantProperties.MODEL, age2).with(VariantProperties.UV_LOCK, true).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(2, Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, age2).with(VariantProperties.UV_LOCK, true))
                .select(2, Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, age2).with(VariantProperties.UV_LOCK, true).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(2, Direction.WEST, Variant.variant().with(VariantProperties.MODEL, age2).with(VariantProperties.UV_LOCK, true).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
        ));
    }

    private static TextureMapping branchMapping(ResourceLocation texture) {
        return new TextureMapping().put(BRANCH_SLOT, texture);
    }

    private static void createBeardMoss(BlockModelGenerators generator) {
        Block beardMoss = BEARD_MOSS.get();
        generator.createSimpleFlatItemModel(beardMoss, "_bottom");
        ResourceLocation bottom = generator.createSuffixedVariant(beardMoss, "_bottom", ModelTemplates.CROSS, TextureMapping::cross);
        ResourceLocation top = generator.createSuffixedVariant(beardMoss, "_top", ModelTemplates.CROSS, TextureMapping::cross);
        generator.createDoubleBlock(beardMoss, top, bottom);
    }
}
