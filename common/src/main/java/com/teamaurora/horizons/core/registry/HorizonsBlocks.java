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
import com.teamaurora.horizons.core.other.HorizonsBlockSetTypes;
import com.teamaurora.horizons.core.other.HorizonsProperties;
import com.teamaurora.horizons.core.other.HorizonsWoodTypes;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.OakTreeGrower;

public class HorizonsBlocks {

    public static final RegistryWrapper.BlockProvider PROVIDER = RegistryWrapper.blockProvider(HorizonsItems.PROVIDER);

    // BAYOU CONTENT //
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
    public static final RegistryReference<Block> CYPRESS_SAPLING = PROVIDER.registerWithItem("cypress_sapling", () -> new SaplingBlock(new OakTreeGrower(), PropertiesHelper.sapling()), new Item.Properties());
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
    public static final RegistryReference<Block> STRIPPED_CYPRESS_KNEE = PROVIDER.registerWithItem("stripped_cypress_knee", () -> new CypressKneeBlock(HorizonsProperties.CYPRESS_KNEE), new Item.Properties());
    public static final RegistryReference<Block> STRIPPED_LARGE_CYPRESS_KNEE = PROVIDER.registerWithItem("stripped_large_cypress_knee", () -> new DoubleCypressKneeBlock(HorizonsProperties.CYPRESS_KNEE), new Item.Properties());

    // Beard Moss //

    public static final RegistryReference<Block> BEARD_MOSS_BLOCK = PROVIDER.registerWithItem("beard_moss_block", () -> new BeardMossBlockBlock(HorizonsProperties.BEARD_MOSS_BLOCK), new Item.Properties());
    public static final RegistryReference<Block> BEARD_MOSS = PROVIDER.registerWithItem("beard_moss", () -> new BeardMossBlock(HorizonsProperties.BEARD_MOSS), new Item.Properties());

    // Gooseberry //

    public static final RegistryReference<Block> CYPRESS_BRANCH = PROVIDER.registerWithItem("cypress_branch", () -> new CypressBranchBlock(HorizonsProperties.CYPRESS_BRANCH), new Item.Properties());
    //public static final RegistryReference<Block> GOOSEBERRY_SACK = PROVIDER.registerWithItem(HorizonsConstants.QUARK, "gooseberry_sack", () -> new Block(HorizonsProperties.GOOSEBERRY_SACK), 300, CreativeModeTab.TAB_DECORATIONS);

    // Algae //

    public static final RegistryReference<Block> ALGAE = PROVIDER.register("algae", () -> new AlgaeBlock(HorizonsProperties.ALGAE));
    public static final RegistryReference<Block> ALGAE_THATCH = PROVIDER.registerWithItem("algae_thatch", () -> new ThatchBlock(HorizonsProperties.ALGAE_THATCH), new Item.Properties());
    public static final RegistryReference<Block> ALGAE_THATCH_SLAB = PROVIDER.registerWithItem("algae_thatch_slab", () -> new ThatchSlabBlock(HorizonsProperties.ALGAE_THATCH), new Item.Properties());
    public static final RegistryReference<Block> ALGAE_THATCH_STAIRS = PROVIDER.registerWithItem("algae_thatch_stairs" ,() -> new ThatchStairBlock(ALGAE_THATCH.get().defaultBlockState(), HorizonsProperties.ALGAE_THATCH), new Item.Properties());
    //public static final RegistryReference<Block> ALGAE_THATCH_VERTICAL_SLAB = PROVIDER.createCompatBlock(HorizonsConstants.QUARK, "algae_thatch_vertical_slab", () -> new ThatchVerticalSlabBlock(HorizonsProperties.ALGAE_THATCH), CreativeModeTab.TAB_BUILDING_BLOCKS);

    // Lily Flowers //

    public static final RegistryReference<Block> BLUE_LILY = PROVIDER.register("blue_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY));
    public static final RegistryReference<Block> LIGHT_GRAY_LILY = PROVIDER.register("light_gray_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY));
    public static final RegistryReference<Block> CYAN_LILY = PROVIDER.register("cyan_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY));
    public static final RegistryReference<Block> LIGHT_BLUE_LILY = PROVIDER.register("light_blue_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY));
    public static final RegistryReference<Block> MAGENTA_LILY = PROVIDER.register("magenta_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY));
    public static final RegistryReference<Block> PINK_LILY = PROVIDER.register("pink_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY));
    public static final RegistryReference<Block> PURPLE_LILY = PROVIDER.register("purple_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY));
    public static final RegistryReference<Block> WHITE_LILY = PROVIDER.register("white_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY));

    public static final RegistryReference<Block> POTTED_BLUE_LILY = PROVIDER.register("potted_blue_lily", () -> new FlowerPotBlock(BLUE_LILY.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> POTTED_LIGHT_GRAY_LILY= PROVIDER.register("potted_light_gray_lily", () -> new FlowerPotBlock(LIGHT_GRAY_LILY.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> POTTED_CYAN_LILY = PROVIDER.register("potted_cyan_lily", () -> new FlowerPotBlock(CYAN_LILY.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> POTTED_LIGHT_BLUE_LILY = PROVIDER.register("potted_light_blue_lily", () -> new FlowerPotBlock(LIGHT_BLUE_LILY.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> POTTED_MAGENTA_LILY = PROVIDER.register("potted_magenta_lily", () -> new FlowerPotBlock(MAGENTA_LILY.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> POTTED_PINK_LILY = PROVIDER.register("potted_pink_lily", () -> new FlowerPotBlock(PINK_LILY.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> POTTED_PURPLE_LILY = PROVIDER.register("potted_purple_lily", () -> new FlowerPotBlock(PURPLE_LILY.get(), PropertiesHelper.flowerPot()));
    public static final RegistryReference<Block> POTTED_WHITE_LILY = PROVIDER.register("potted_white_lily", () -> new FlowerPotBlock(WHITE_LILY.get(), PropertiesHelper.flowerPot()));
}
