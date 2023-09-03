package com.teamaurora.horizons.core.registry;

import com.mojang.datafixers.util.Pair;
import com.teamaurora.borealib.api.block.v1.BorealibCeilingHangingSignBlock;
import com.teamaurora.borealib.api.block.v1.BorealibStandingSignBlock;
import com.teamaurora.borealib.api.block.v1.BorealibWallHangingSignBlock;
import com.teamaurora.borealib.api.block.v1.BorealibWallSignBlock;
import com.teamaurora.borealib.api.block.v1.compat.BorealibChestBlock;
import com.teamaurora.borealib.api.block.v1.compat.BorealibTrappedChestBlock;
import com.teamaurora.borealib.api.block.v1.compat.CabinetBlock;
import com.teamaurora.borealib.api.block.v1.thatch.ThatchBlock;
import com.teamaurora.borealib.api.block.v1.thatch.ThatchSlabBlock;
import com.teamaurora.borealib.api.block.v1.thatch.ThatchStairBlock;
import com.teamaurora.borealib.api.registry.v1.RegistryReference;
import com.teamaurora.borealib.api.registry.v1.RegistryWrapper;
import com.teamaurora.borealib.api.registry.v1.util.PropertiesHelper;
import com.teamaurora.horizons.common.block.*;
import com.teamaurora.horizons.common.block.grower.CypressTreeGrower;
import com.teamaurora.horizons.common.block.grower.JacarandaTreeGrower;
import com.teamaurora.horizons.common.item.AlgaeBlockItem;
import com.teamaurora.horizons.common.item.LilyItem;
import com.teamaurora.horizons.core.other.HorizonsBlockSetTypes;
import com.teamaurora.horizons.core.other.HorizonsProperties;
import com.teamaurora.horizons.core.other.HorizonsWoodTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public final class HorizonsBlocks {
    public static final RegistryWrapper.BlockProvider PROVIDER = RegistryWrapper.blockProvider(HorizonsItems.PROVIDER);

    // Cypress //
    public static final RegistryReference<Block> STRIPPED_CYPRESS_LOG = PROVIDER.registerWithItem("stripped_cypress_log", () -> new RotatedPillarBlock(HorizonsProperties.CYPRESS.strippedLogOrWood()), new Item.Properties());
    public static final RegistryReference<Block> STRIPPED_CYPRESS_WOOD = PROVIDER.registerWithItem("stripped_cypress_wood", () -> new RotatedPillarBlock(HorizonsProperties.CYPRESS.strippedLogOrWood()), new Item.Properties());
    public static final RegistryReference<Block> CYPRESS_LOG = PROVIDER.registerWithItem("cypress_log", () -> new RotatedPillarBlock(HorizonsProperties.CYPRESS.log()), new Item.Properties());
    public static final RegistryReference<Block> CYPRESS_WOOD = PROVIDER.registerWithItem("cypress_wood", () -> new RotatedPillarBlock(HorizonsProperties.CYPRESS.wood()), new Item.Properties());
    public static final RegistryReference<Block> CYPRESS_PLANKS = PROVIDER.registerWithItem("cypress_planks", () -> new Block(HorizonsProperties.CYPRESS.planks()), new Item.Properties());
    public static final RegistryReference<Block> CYPRESS_SLAB = PROVIDER.registerWithItem("cypress_slab", () -> new SlabBlock(HorizonsProperties.CYPRESS.planks()), new Item.Properties());
    public static final RegistryReference<Block> CYPRESS_STAIRS = PROVIDER.registerWithItem("cypress_stairs", () -> new StairBlock(CYPRESS_PLANKS.get().defaultBlockState(), HorizonsProperties.CYPRESS.planks()), new Item.Properties());
    public static final RegistryReference<Block> CYPRESS_FENCE = PROVIDER.registerWithItem("cypress_fence", () -> new FenceBlock(HorizonsProperties.CYPRESS.planks()), new Item.Properties());
    public static final RegistryReference<Block> CYPRESS_FENCE_GATE = PROVIDER.registerWithItem("cypress_fence_gate", () -> new FenceGateBlock(HorizonsProperties.CYPRESS.planks(), HorizonsWoodTypes.CYPRESS), new Item.Properties());
    public static final RegistryReference<Block> CYPRESS_PRESSURE_PLATE = PROVIDER.registerWithItem("cypress_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, HorizonsProperties.CYPRESS.pressurePlate(), HorizonsBlockSetTypes.CYPRESS), new Item.Properties());
    public static final RegistryReference<Block> CYPRESS_DOOR = PROVIDER.registerWithItem("cypress_door", () -> new DoorBlock(HorizonsProperties.CYPRESS.door(), HorizonsBlockSetTypes.CYPRESS), new Item.Properties());
    public static final RegistryReference<Block> CYPRESS_TRAPDOOR = PROVIDER.registerWithItem("cypress_trapdoor", () -> new TrapDoorBlock(HorizonsProperties.CYPRESS.trapdoor(), HorizonsBlockSetTypes.CYPRESS), new Item.Properties());
    public static final RegistryReference<Block> CYPRESS_BUTTON = PROVIDER.registerWithItem("cypress_button", () -> new ButtonBlock(HorizonsProperties.CYPRESS.button(), HorizonsBlockSetTypes.CYPRESS, 30, true), new Item.Properties());
    public static final Pair<RegistryReference<BorealibStandingSignBlock>, RegistryReference<BorealibWallSignBlock>> CYPRESS_SIGNS = PROVIDER.registerSign("cypress", HorizonsWoodTypes.CYPRESS, HorizonsProperties.CYPRESS_SIGN, new Item.Properties().stacksTo(16));
    public static final Pair<RegistryReference<BorealibCeilingHangingSignBlock>, RegistryReference<BorealibWallHangingSignBlock>> CYPRESS_HANGING_SIGNS = PROVIDER.registerHangingSign("cypress", HorizonsWoodTypes.CYPRESS, HorizonsProperties.CYPRESS_SIGN, new Item.Properties().stacksTo(16));
    public static final RegistryReference<Block> CYPRESS_SAPLING = PROVIDER.registerWithItem("cypress_sapling", () -> new SaplingBlock(new CypressTreeGrower(), HorizonsProperties.CYPRESS.sapling()), new Item.Properties());
    public static final RegistryReference<Block> POTTED_CYPRESS_SAPLING = PROVIDER.register("potted_cypress_sapling", () -> new FlowerPotBlock(CYPRESS_SAPLING.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> CYPRESS_LEAVES = PROVIDER.registerWithItem("cypress_leaves", () -> new LeavesBlock(HorizonsProperties.CYPRESS.leaves()), new Item.Properties());

    //public static final RegistryReference<Block> VERTICAL_CYPRESS_PLANKS = PROVIDER.createCompatBlock(HorizonsConstants.QUARK, "vertical_cypress_planks", () -> new Block(HorizonsProperties.CYPRESS.planks()), new Item.Properties());
    //public static final RegistryReference<Block> CYPRESS_BEEHIVE = PROVIDER.createCompatBlock(HorizonsConstants.WOODWORKS, "cypress_beehive", () -> new BlueprintBeehiveBlock(HorizonsProperties.CYPRESS.beehive()), CreativeModeTab.TAB_DECORATIONS);
    //public static final RegistryReference<Block> CYPRESS_LADDER = PROVIDER.createFuelBlock("cypress_ladder", () -> new BlueprintLadderBlock(HorizonsProperties.CYPRESS.ladder()), 300, ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_DECORATIONS : null);
    public static final RegistryReference<Block> CYPRESS_BOOKSHELF = PROVIDER.registerWithItem("cypress_bookshelf", () -> new Block(HorizonsProperties.CYPRESS.bookshelf()), new Item.Properties());
    //public static final RegistryReference<Block> CYPRESS_BOARDS = PROVIDER.createCompatBlock(HorizonsConstants.WOODWORKS, "cypress_boards", () -> new RotatedPillarBlock(HorizonsProperties.CYPRESS.planks()), new Item.Properties());
    //public static final RegistryReference<Block> CYPRESS_VERTICAL_SLAB = PROVIDER.createCompatFuelBlock(HorizonsConstants.QUARK, "cypress_vertical_slab", () -> new VerticalSlabBlock(HorizonsProperties.CYPRESS.planks()), 150, new Item.Properties());
    //public static final RegistryReference<Block> STRIPPED_CYPRESS_POST = PROVIDER.createCompatFuelBlock(HorizonsConstants.QUARK, "stripped_cypress_post", () -> new WoodPostBlock(HorizonsProperties.CYPRESS.post()), 300, CreativeModeTab.TAB_DECORATIONS);
    //public static final RegistryReference<Block> CYPRESS_POST = PROVIDER.createCompatFuelBlock(HorizonsConstants.QUARK, "cypress_post", () -> new WoodPostBlock(STRIPPED_CYPRESS_POST, HorizonsProperties.CYPRESS.post()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final Pair<RegistryReference<BorealibChestBlock>, RegistryReference<BorealibTrappedChestBlock>> CYPRESS_CHESTS = PROVIDER.registerChest("cypress", HorizonsProperties.CYPRESS.chest());
    public static final RegistryReference<Block> CYPRESS_CABINET = PROVIDER.registerWithItem("cypress_cabinet", () -> new CabinetBlock(HorizonsProperties.CYPRESS.cabinet()), new Item.Properties());
    //public static final RegistryReference<Block> CYPRESS_HEDGE = PROVIDER.createCompatFuelBlock(HorizonsConstants.QUARK, "cypress_hedge", () -> new HedgeBlock(HorizonsProperties.CYPRESS.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    //public static final RegistryReference<Block> CYPRESS_LEAF_CARPET = PROVIDER.createCompatBlock(HorizonsConstants.QUARK, "cypress_leaf_carpet", () -> new LeafCarpetBlock(HorizonsProperties.CYPRESS.leafCarpet()), CreativeModeTab.TAB_DECORATIONS);
    //public static final RegistryReference<Block> CYPRESS_LEAF_PILE = PROVIDER.createCompatBlock(HorizonsConstants.WOODWORKS, "cypress_leaf_pile", () -> new LeafPileBlock(HorizonsProperties.CYPRESS.leafPile()), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryReference<Block> HANGING_CYPRESS_LEAVES = PROVIDER.registerWithItem("hanging_cypress_leaves", () -> new HangingCypressLeavesBlock(HorizonsProperties.CYPRESS.leaves()), new Item.Properties());

    public static final RegistryReference<Block> CYPRESS_KNEE = PROVIDER.registerWithItem("cypress_knee", () -> new CypressKneeBlock(HorizonsProperties.CYPRESS_KNEE), new Item.Properties());
    public static final RegistryReference<Block> LARGE_CYPRESS_KNEE = PROVIDER.registerWithItem("large_cypress_knee", () -> new DoubleCypressKneeBlock(HorizonsProperties.CYPRESS_KNEE), new Item.Properties());

    // Beard Moss //
    public static final RegistryReference<Block> BEARD_MOSS_BLOCK = PROVIDER.registerWithItem("beard_moss_block", () -> new BeardMossBlockBlock(HorizonsProperties.BEARD_MOSS_BLOCK), new Item.Properties());
    public static final RegistryReference<Block> BEARD_MOSS = PROVIDER.registerWithItem("beard_moss", () -> new BeardMossBlock(HorizonsProperties.BEARD_MOSS), new Item.Properties());

    // Gooseberry //
    public static final RegistryReference<Block> CYPRESS_BRANCH = PROVIDER.registerWithItem("cypress_branch", () -> new CypressBranchBlock(HorizonsProperties.CYPRESS_BRANCH), new Item.Properties());
    //public static final RegistryReference<Block> GOOSEBERRY_SACK = PROVIDER.registerWithItem(HorizonsConstants.QUARK, "gooseberry_sack", () -> new Block(HorizonsProperties.GOOSEBERRY_SACK), 300, CreativeModeTab.TAB_DECORATIONS);

    // Algae //
    public static final RegistryReference<Block> ALGAE = PROVIDER.registerWithItem("algae", () -> new AlgaeBlock(HorizonsProperties.ALGAE), block -> new AlgaeBlockItem(block, new Item.Properties()));
    public static final RegistryReference<Block> ALGAE_THATCH = PROVIDER.registerWithItem("algae_thatch", () -> new ThatchBlock(HorizonsProperties.ALGAE_THATCH), new Item.Properties());
    public static final RegistryReference<Block> ALGAE_THATCH_SLAB = PROVIDER.registerWithItem("algae_thatch_slab", () -> new ThatchSlabBlock(HorizonsProperties.ALGAE_THATCH), new Item.Properties());
    public static final RegistryReference<Block> ALGAE_THATCH_STAIRS = PROVIDER.registerWithItem("algae_thatch_stairs", () -> new ThatchStairBlock(ALGAE_THATCH.get().defaultBlockState(), HorizonsProperties.ALGAE_THATCH), new Item.Properties());
    //public static final RegistryReference<Block> ALGAE_THATCH_VERTICAL_SLAB = PROVIDER.createCompatBlock(HorizonsConstants.QUARK, "algae_thatch_vertical_slab", () -> new ThatchVerticalSlabBlock(HorizonsProperties.ALGAE_THATCH), CreativeModeTab.TAB_BUILDING_BLOCKS);

    // Lily Flowers //
    public static final RegistryReference<Block> BLUE_LILY = PROVIDER.registerWithItem("blue_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY), b -> new LilyItem(b, new Item.Properties()));
    public static final RegistryReference<Block> LIGHT_GRAY_LILY = PROVIDER.registerWithItem("light_gray_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY), b -> new LilyItem(b, new Item.Properties()));
    public static final RegistryReference<Block> CYAN_LILY = PROVIDER.registerWithItem("cyan_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY), b -> new LilyItem(b, new Item.Properties()));
    public static final RegistryReference<Block> LIGHT_BLUE_LILY = PROVIDER.registerWithItem("light_blue_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY), b -> new LilyItem(b, new Item.Properties()));
    public static final RegistryReference<Block> MAGENTA_LILY = PROVIDER.registerWithItem("magenta_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY), b -> new LilyItem(b, new Item.Properties()));
    public static final RegistryReference<Block> PINK_LILY = PROVIDER.registerWithItem("pink_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY), b -> new LilyItem(b, new Item.Properties()));
    public static final RegistryReference<Block> PURPLE_LILY = PROVIDER.registerWithItem("purple_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY), b -> new LilyItem(b, new Item.Properties()));
    public static final RegistryReference<Block> WHITE_LILY = PROVIDER.registerWithItem("white_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY), b -> new LilyItem(b, new Item.Properties()));

    public static final RegistryReference<Block> POTTED_BLUE_LILY = PROVIDER.register("potted_blue_lily", () -> new FlowerPotBlock(BLUE_LILY.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> POTTED_LIGHT_GRAY_LILY = PROVIDER.register("potted_light_gray_lily", () -> new FlowerPotBlock(LIGHT_GRAY_LILY.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> POTTED_CYAN_LILY = PROVIDER.register("potted_cyan_lily", () -> new FlowerPotBlock(CYAN_LILY.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> POTTED_LIGHT_BLUE_LILY = PROVIDER.register("potted_light_blue_lily", () -> new FlowerPotBlock(LIGHT_BLUE_LILY.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> POTTED_MAGENTA_LILY = PROVIDER.register("potted_magenta_lily", () -> new FlowerPotBlock(MAGENTA_LILY.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> POTTED_PINK_LILY = PROVIDER.register("potted_pink_lily", () -> new FlowerPotBlock(PINK_LILY.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> POTTED_PURPLE_LILY = PROVIDER.register("potted_purple_lily", () -> new FlowerPotBlock(PURPLE_LILY.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> POTTED_WHITE_LILY = PROVIDER.register("potted_white_lily", () -> new FlowerPotBlock(WHITE_LILY.get(), PropertiesHelper.flowerPot()));

    // Misc Plants //
    public static final RegistryReference<Block> GIANT_FERN = PROVIDER.registerWithItem("giant_fern", () -> new DoublePlantBlock(BlockBehaviour.Properties.copy(Blocks.LARGE_FERN)), new Item.Properties());
    public static final RegistryReference<Block> TROPICAL_GRASS = PROVIDER.registerWithItem("tropical_grass", () -> new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).dropsLike(Blocks.GRASS)), new Item.Properties());
    public static final RegistryReference<Block> TROPICAL_FERN = PROVIDER.registerWithItem("tropical_fern", () -> new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.FERN).dropsLike(Blocks.FERN)), new Item.Properties());

    // Flowers //
    public static final RegistryReference<Block> FIDDLENECK = PROVIDER.registerWithItem("fiddleneck", () -> new FlowerBlock(MobEffects.INVISIBILITY, 12, PropertiesHelper.flower()), new Item.Properties());
    public static final RegistryReference<Block> AMARANTHUS = PROVIDER.registerWithItem("amaranthus", () -> new FlowerBlock(MobEffects.DAMAGE_BOOST, 12, PropertiesHelper.flower()), new Item.Properties());
    public static final RegistryReference<Block> MYOSOTIS = PROVIDER.registerWithItem("myosotis", () -> new FlowerBlock(MobEffects.JUMP, 12, PropertiesHelper.flower()), new Item.Properties());

    public static final RegistryReference<Block> POTTED_FIDDLENECK = PROVIDER.register("potted_fiddleneck", () -> new FlowerPotBlock(FIDDLENECK.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> POTTED_AMARANTHUS = PROVIDER.register("potted_amaranthus", () -> new FlowerPotBlock(AMARANTHUS.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> POTTED_MYOSOTIS = PROVIDER.register("potted_myosotis", () -> new FlowerPotBlock(MYOSOTIS.get(), PropertiesHelper.flowerPot()));

    // Tall Flowers //
    public static final RegistryReference<Block> HELICONIA = PROVIDER.registerWithItem("heliconia", () -> new TallFlowerBlock(PropertiesHelper.flower()), new Item.Properties());

    // Lavender //
    public static final Supplier<Block> LAVENDER = PROVIDER.registerWithItem("lavender", () -> new LavenderBlock(BlockBehaviour.Properties.copy(Blocks.ALLIUM).sound(SoundType.CROP)), new Item.Properties());
    public static final Supplier<Block> TALL_LAVENDER = PROVIDER.register("tall_lavender", () -> new TallLavenderBlock(BlockBehaviour.Properties.copy(Blocks.ALLIUM).sound(SoundType.CROP)));

    // Redwood //
    public static final RegistryReference<Block> STRIPPED_REDWOOD_LOG = PROVIDER.registerWithItem("stripped_redwood_log", () -> new RotatedPillarBlock(HorizonsProperties.REDWOOD.strippedLogOrWood()), new Item.Properties());
    public static final RegistryReference<Block> STRIPPED_REDWOOD = PROVIDER.registerWithItem("stripped_redwood", () -> new RotatedPillarBlock(HorizonsProperties.REDWOOD.strippedLogOrWood()), new Item.Properties());
    public static final RegistryReference<Block> REDWOOD_LOG = PROVIDER.registerWithItem("redwood_log", () -> new RotatedPillarBlock(HorizonsProperties.REDWOOD.log()), new Item.Properties());
    public static final RegistryReference<Block> REDWOOD = PROVIDER.registerWithItem("redwood", () -> new RotatedPillarBlock(HorizonsProperties.REDWOOD.wood()), new Item.Properties());
    public static final RegistryReference<Block> REDWOOD_PLANKS = PROVIDER.registerWithItem("redwood_planks", () -> new Block(HorizonsProperties.REDWOOD.planks()), new Item.Properties());
    public static final RegistryReference<Block> REDWOOD_SLAB = PROVIDER.registerWithItem("redwood_slab", () -> new SlabBlock(HorizonsProperties.REDWOOD.planks()), new Item.Properties());
    public static final RegistryReference<Block> REDWOOD_STAIRS = PROVIDER.registerWithItem("redwood_stairs", () -> new StairBlock(REDWOOD_PLANKS.get().defaultBlockState(), HorizonsProperties.REDWOOD.planks()), new Item.Properties());
    public static final RegistryReference<Block> REDWOOD_FENCE = PROVIDER.registerWithItem("redwood_fence", () -> new FenceBlock(HorizonsProperties.REDWOOD.planks()), new Item.Properties());
    public static final RegistryReference<Block> REDWOOD_FENCE_GATE = PROVIDER.registerWithItem("redwood_fence_gate", () -> new FenceGateBlock(HorizonsProperties.REDWOOD.planks(), HorizonsWoodTypes.REDWOOD), new Item.Properties());
    public static final RegistryReference<Block> REDWOOD_PRESSURE_PLATE = PROVIDER.registerWithItem("redwood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, HorizonsProperties.REDWOOD.pressurePlate(), HorizonsBlockSetTypes.REDWOOD), new Item.Properties());
    public static final RegistryReference<Block> REDWOOD_DOOR = PROVIDER.registerWithItem("redwood_door", () -> new DoorBlock(HorizonsProperties.REDWOOD.door(), HorizonsBlockSetTypes.REDWOOD), new Item.Properties());
    public static final RegistryReference<Block> REDWOOD_TRAPDOOR = PROVIDER.registerWithItem("redwood_trapdoor", () -> new TrapDoorBlock(HorizonsProperties.REDWOOD.trapdoor(), HorizonsBlockSetTypes.REDWOOD), new Item.Properties());
    public static final RegistryReference<Block> REDWOOD_BUTTON = PROVIDER.registerWithItem("redwood_button", () -> new ButtonBlock(HorizonsProperties.REDWOOD.button(), HorizonsBlockSetTypes.REDWOOD, 30, true), new Item.Properties());
    public static final Pair<RegistryReference<BorealibStandingSignBlock>, RegistryReference<BorealibWallSignBlock>> REDWOOD_SIGNS = PROVIDER.registerSign("redwood", HorizonsWoodTypes.REDWOOD, HorizonsProperties.REDWOOD_SIGN, new Item.Properties().stacksTo(16));
    public static final Pair<RegistryReference<BorealibCeilingHangingSignBlock>, RegistryReference<BorealibWallHangingSignBlock>> REDWOOD_HANGING_SIGNS = PROVIDER.registerHangingSign("redwood", HorizonsWoodTypes.REDWOOD, HorizonsProperties.REDWOOD_SIGN, new Item.Properties().stacksTo(16));
    public static final RegistryReference<Block> REDWOOD_SAPLING = PROVIDER.registerWithItem("redwood_sapling", () -> new SaplingBlock(new CypressTreeGrower(), HorizonsProperties.REDWOOD.sapling()), new Item.Properties());
    public static final RegistryReference<Block> POTTED_REDWOOD_SAPLING = PROVIDER.register("potted_redwood_sapling", () -> new FlowerPotBlock(REDWOOD_SAPLING.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> REDWOOD_LEAVES = PROVIDER.registerWithItem("redwood_leaves", () -> new LeavesBlock(HorizonsProperties.REDWOOD.leaves()), new Item.Properties());

    //public static final RegistryReference<Block> VERTICAL_REDWOOD_PLANKS = PROVIDER.createCompatBlock(HorizonsConstants.QUARK, "vertical_redwood_planks", () -> new Block(HorizonsProperties.REDWOOD.planks()), new Item.Properties());
    //public static final RegistryReference<Block> REDWOOD_BEEHIVE = PROVIDER.createCompatBlock(HorizonsConstants.WOODWORKS, "redwood_beehive", () -> new BlueprintBeehiveBlock(HorizonsProperties.REDWOOD.beehive()), CreativeModeTab.TAB_DECORATIONS);
    //public static final RegistryReference<Block> REDWOOD_LADDER = PROVIDER.createFuelBlock("redwood_ladder", () -> new BlueprintLadderBlock(HorizonsProperties.REDWOOD.ladder()), 300, ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_DECORATIONS : null);
    public static final RegistryReference<Block> REDWOOD_BOOKSHELF = PROVIDER.registerWithItem("redwood_bookshelf", () -> new Block(HorizonsProperties.REDWOOD.bookshelf()), new Item.Properties());
    //public static final RegistryReference<Block> REDWOOD_BOARDS = PROVIDER.createCompatBlock(HorizonsConstants.WOODWORKS, "redwood_boards", () -> new RotatedPillarBlock(HorizonsProperties.REDWOOD.planks()), new Item.Properties());
    //public static final RegistryReference<Block> REDWOOD_VERTICAL_SLAB = PROVIDER.createCompatFuelBlock(HorizonsConstants.QUARK, "redwood_vertical_slab", () -> new VerticalSlabBlock(HorizonsProperties.REDWOOD.planks()), 150, new Item.Properties());
    //public static final RegistryReference<Block> STRIPPED_REDWOOD_POST = PROVIDER.createCompatFuelBlock(HorizonsConstants.QUARK, "stripped_redwood_post", () -> new WoodPostBlock(HorizonsProperties.REDWOOD.post()), 300, CreativeModeTab.TAB_DECORATIONS);
    //public static final RegistryReference<Block> REDWOOD_POST = PROVIDER.createCompatFuelBlock(HorizonsConstants.QUARK, "redwood_post", () -> new WoodPostBlock(STRIPPED_REDWOOD_POST, HorizonsProperties.REDWOOD.post()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final Pair<RegistryReference<BorealibChestBlock>, RegistryReference<BorealibTrappedChestBlock>> REDWOOD_CHESTS = PROVIDER.registerChest("redwood", HorizonsProperties.REDWOOD.chest());
    public static final RegistryReference<Block> REDWOOD_CABINET = PROVIDER.registerWithItem("redwood_cabinet", () -> new CabinetBlock(HorizonsProperties.REDWOOD.cabinet()), new Item.Properties());
    //public static final RegistryReference<Block> REDWOOD_HEDGE = PROVIDER.createCompatFuelBlock(HorizonsConstants.QUARK, "redwood_hedge", () -> new HedgeBlock(HorizonsProperties.REDWOOD.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    //public static final RegistryReference<Block> REDWOOD_LEAF_CARPET = PROVIDER.createCompatBlock(HorizonsConstants.QUARK, "redwood_leaf_carpet", () -> new LeafCarpetBlock(HorizonsProperties.REDWOOD.leafCarpet()), CreativeModeTab.TAB_DECORATIONS);
    //public static final RegistryReference<Block> REDWOOD_LEAF_PILE = PROVIDER.createCompatBlock(HorizonsConstants.WOODWORKS, "redwood_leaf_pile", () -> new LeafPileBlock(HorizonsProperties.REDWOOD.leafPile()), CreativeModeTab.TAB_DECORATIONS);

    // Jacaranda //
    public static final RegistryReference<Block> STRIPPED_JACARANDA_LOG = PROVIDER.registerWithItem("stripped_jacaranda_log", () -> new RotatedPillarBlock(HorizonsProperties.JACARANDA.strippedLogOrWood()), new Item.Properties());
    public static final RegistryReference<Block> STRIPPED_JACARANDA_WOOD = PROVIDER.registerWithItem("stripped_jacaranda_wood", () -> new RotatedPillarBlock(HorizonsProperties.JACARANDA.strippedLogOrWood()), new Item.Properties());
    public static final RegistryReference<Block> JACARANDA_LOG = PROVIDER.registerWithItem("jacaranda_log", () -> new RotatedPillarBlock(HorizonsProperties.JACARANDA.log()), new Item.Properties());
    public static final RegistryReference<Block> JACARANDA_WOOD = PROVIDER.registerWithItem("jacaranda_wood", () -> new RotatedPillarBlock(HorizonsProperties.JACARANDA.wood()), new Item.Properties());
    public static final RegistryReference<Block> JACARANDA_PLANKS = PROVIDER.registerWithItem("jacaranda_planks", () -> new Block(HorizonsProperties.JACARANDA.planks()), new Item.Properties());
    public static final RegistryReference<Block> JACARANDA_SLAB = PROVIDER.registerWithItem("jacaranda_slab", () -> new SlabBlock(HorizonsProperties.JACARANDA.planks()), new Item.Properties());
    public static final RegistryReference<Block> JACARANDA_STAIRS = PROVIDER.registerWithItem("jacaranda_stairs", () -> new StairBlock(JACARANDA_PLANKS.get().defaultBlockState(), HorizonsProperties.JACARANDA.planks()), new Item.Properties());
    public static final RegistryReference<Block> JACARANDA_FENCE = PROVIDER.registerWithItem("jacaranda_fence", () -> new FenceBlock(HorizonsProperties.JACARANDA.planks()), new Item.Properties());
    public static final RegistryReference<Block> JACARANDA_FENCE_GATE = PROVIDER.registerWithItem("jacaranda_fence_gate", () -> new FenceGateBlock(HorizonsProperties.JACARANDA.planks(), HorizonsWoodTypes.JACARANDA), new Item.Properties());
    public static final RegistryReference<Block> JACARANDA_PRESSURE_PLATE = PROVIDER.registerWithItem("jacaranda_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, HorizonsProperties.JACARANDA.pressurePlate(), HorizonsBlockSetTypes.JACARANDA), new Item.Properties());
    public static final RegistryReference<Block> JACARANDA_DOOR = PROVIDER.registerWithItem("jacaranda_door", () -> new DoorBlock(HorizonsProperties.JACARANDA.door(), HorizonsBlockSetTypes.JACARANDA), new Item.Properties());
    public static final RegistryReference<Block> JACARANDA_TRAPDOOR = PROVIDER.registerWithItem("jacaranda_trapdoor", () -> new TrapDoorBlock(HorizonsProperties.JACARANDA.trapdoor(), HorizonsBlockSetTypes.JACARANDA), new Item.Properties());
    public static final RegistryReference<Block> JACARANDA_BUTTON = PROVIDER.registerWithItem("jacaranda_button", () -> new ButtonBlock(HorizonsProperties.JACARANDA.button(), HorizonsBlockSetTypes.JACARANDA, 30, true), new Item.Properties());
    public static final Pair<RegistryReference<BorealibStandingSignBlock>, RegistryReference<BorealibWallSignBlock>> JACARANDA_SIGNS = PROVIDER.registerSign("jacaranda", HorizonsWoodTypes.JACARANDA, HorizonsProperties.JACARANDA_SIGN, new Item.Properties().stacksTo(16));
    public static final Pair<RegistryReference<BorealibCeilingHangingSignBlock>, RegistryReference<BorealibWallHangingSignBlock>> JACARANDA_HANGING_SIGNS = PROVIDER.registerHangingSign("jacaranda", HorizonsWoodTypes.JACARANDA, HorizonsProperties.JACARANDA_SIGN, new Item.Properties().stacksTo(16));
    public static final RegistryReference<Block> JACARANDA_SAPLING = PROVIDER.registerWithItem("jacaranda_sapling", () -> new SaplingBlock(new JacarandaTreeGrower(), HorizonsProperties.JACARANDA.sapling()), new Item.Properties());
    public static final RegistryReference<Block> FLOWERING_JACARANDA_SAPLING = PROVIDER.registerWithItem("flowering_jacaranda_sapling", () -> new SaplingBlock(new JacarandaTreeGrower(), HorizonsProperties.JACARANDA.sapling()), new Item.Properties());
    public static final RegistryReference<Block> POTTED_JACARANDA_SAPLING = PROVIDER.register("potted_jacaranda_sapling", () -> new FlowerPotBlock(JACARANDA_SAPLING.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> POTTED_FLOWERING_JACARANDA_SAPLING = PROVIDER.register("potted_flowering_jacaranda_sapling", () -> new FlowerPotBlock(FLOWERING_JACARANDA_SAPLING.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> JACARANDA_LEAVES = PROVIDER.registerWithItem("jacaranda_leaves", () -> new LeavesBlock(HorizonsProperties.JACARANDA.leaves()), new Item.Properties());
    public static final RegistryReference<Block> FLOWERING_JACARANDA_LEAVES = PROVIDER.registerWithItem("flowering_jacaranda_leaves", () -> new LeavesBlock(HorizonsProperties.JACARANDA.leaves()), new Item.Properties());

    //public static final RegistryReference<Block> VERTICAL_JACARANDA_PLANKS = PROVIDER.createCompatBlock(HorizonsConstants.QUARK, "vertical_jacaranda_planks", () -> new Block(HorizonsProperties.JACARANDA.planks()), new Item.Properties());
    //public static final RegistryReference<Block> JACARANDA_BEEHIVE = PROVIDER.createCompatBlock(HorizonsConstants.WOODWORKS, "jacaranda_beehive", () -> new BlueprintBeehiveBlock(HorizonsProperties.JACARANDA.beehive()), CreativeModeTab.TAB_DECORATIONS);
    //public static final RegistryReference<Block> JACARANDA_LADDER = PROVIDER.createFuelBlock("jacaranda_ladder", () -> new BlueprintLadderBlock(HorizonsProperties.JACARANDA.ladder()), 300, ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_DECORATIONS : null);
    public static final RegistryReference<Block> JACARANDA_BOOKSHELF = PROVIDER.registerWithItem("jacaranda_bookshelf", () -> new Block(HorizonsProperties.JACARANDA.bookshelf()), new Item.Properties());
    //public static final RegistryReference<Block> JACARANDA_BOARDS = PROVIDER.createCompatBlock(HorizonsConstants.WOODWORKS, "jacaranda_boards", () -> new RotatedPillarBlock(HorizonsProperties.JACARANDA.planks()), new Item.Properties());
    //public static final RegistryReference<Block> JACARANDA_VERTICAL_SLAB = PROVIDER.createCompatFuelBlock(HorizonsConstants.QUARK, "jacaranda_vertical_slab", () -> new VerticalSlabBlock(HorizonsProperties.JACARANDA.planks()), 150, new Item.Properties());
    //public static final RegistryReference<Block> STRIPPED_JACARANDA_POST = PROVIDER.createCompatFuelBlock(HorizonsConstants.QUARK, "stripped_jacaranda_post", () -> new WoodPostBlock(HorizonsProperties.JACARANDA.post()), 300, CreativeModeTab.TAB_DECORATIONS);
    //public static final RegistryReference<Block> JACARANDA_POST = PROVIDER.createCompatFuelBlock(HorizonsConstants.QUARK, "jacaranda_post", () -> new WoodPostBlock(STRIPPED_JACARANDA_POST, HorizonsProperties.JACARANDA.post()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final Pair<RegistryReference<BorealibChestBlock>, RegistryReference<BorealibTrappedChestBlock>> JACARANDA_CHESTS = PROVIDER.registerChest("jacaranda", HorizonsProperties.JACARANDA.chest());
    public static final RegistryReference<Block> JACARANDA_CABINET = PROVIDER.registerWithItem("jacaranda_cabinet", () -> new CabinetBlock(HorizonsProperties.JACARANDA.cabinet()), new Item.Properties());
    //public static final RegistryReference<Block> JACARANDA_HEDGE = PROVIDER.createCompatFuelBlock(HorizonsConstants.QUARK, "jacaranda_hedge", () -> new HedgeBlock(HorizonsProperties.JACARANDA.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    //public static final RegistryReference<Block> JACARANDA_LEAF_CARPET = PROVIDER.createCompatBlock(HorizonsConstants.QUARK, "jacaranda_leaf_carpet", () -> new LeafCarpetBlock(HorizonsProperties.JACARANDA.leafCarpet()), CreativeModeTab.TAB_DECORATIONS);
    //public static final RegistryReference<Block> JACARANDA_LEAF_PILE = PROVIDER.createCompatBlock(HorizonsConstants.WOODWORKS, "jacaranda_leaf_pile", () -> new LeafPileBlock(HorizonsProperties.JACARANDA.leafPile()), CreativeModeTab.TAB_DECORATIONS);
}
