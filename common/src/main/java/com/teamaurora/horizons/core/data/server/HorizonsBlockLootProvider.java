package com.teamaurora.horizons.core.data.server;

import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Pair;
import com.teamaurora.borealib.api.block.v1.BorealibCeilingHangingSignBlock;
import com.teamaurora.borealib.api.block.v1.BorealibStandingSignBlock;
import com.teamaurora.borealib.api.block.v1.BorealibWallHangingSignBlock;
import com.teamaurora.borealib.api.block.v1.BorealibWallSignBlock;
import com.teamaurora.borealib.api.block.v1.compat.BorealibChestBlock;
import com.teamaurora.borealib.api.block.v1.compat.BorealibTrappedChestBlock;
import com.teamaurora.borealib.api.datagen.v1.BorealibPackOutput;
import com.teamaurora.borealib.api.datagen.v1.providers.loot.BorealibBlockLootProvider;
import com.teamaurora.borealib.api.registry.v1.RegistryReference;
import com.teamaurora.borealib.api.resource_condition.v1.ResourceConditionProvider;
import com.teamaurora.horizons.common.block.lavender.LavenderBlock;
import com.teamaurora.horizons.common.block.lavender.TallLavenderBlock;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;

/**
 * @author rose_
 * @author ebo2022
 */
public class HorizonsBlockLootProvider extends BorealibBlockLootProvider {
    public HorizonsBlockLootProvider(BorealibPackOutput output) {
        super(output);
    }

    @Override
    public void generate() {

        // Cypress //
        this.woodDrops(STRIPPED_CYPRESS_LOG, STRIPPED_CYPRESS_WOOD, CYPRESS_LOG, CYPRESS_WOOD,
                CYPRESS_PLANKS, CYPRESS_SLAB, CYPRESS_STAIRS, CYPRESS_FENCE, CYPRESS_FENCE_GATE,
                CYPRESS_PRESSURE_PLATE, CYPRESS_DOOR, CYPRESS_TRAPDOOR, CYPRESS_BUTTON, CYPRESS_SIGNS,
                CYPRESS_HANGING_SIGNS, CYPRESS_CABINET, CYPRESS_BOOKSHELF, CYPRESS_LADDER, CYPRESS_CHESTS);
        this.dropSelf(CYPRESS_SAPLING.get());
        this.dropPottedContents(POTTED_CYPRESS_SAPLING.get());
        this.normalLeaves(CYPRESS_LEAVES.get(), CYPRESS_SAPLING.get());
        this.add(HANGING_CYPRESS_LEAVES.get(), HorizonsBlockLootProvider::createShearsOnlyDrop);
        this.cypressKnee(CYPRESS_KNEE.get(), CYPRESS_LOG.get());
        this.largeCypressKnee(LARGE_CYPRESS_KNEE.get(), CYPRESS_LOG.get());

        // Plants n stuff //
        this.add(BEARD_MOSS_BLOCK.get(), HorizonsBlockLootProvider::createShearsOnlyDrop);
        this.add(BEARD_MOSS.get(), HorizonsBlockLootProvider::createShearsOnlyDrop);
        this.add(CYPRESS_BRANCH.get(), HorizonsBlockLootProvider::createShearsOnlyDrop);

        this.add(ALGAE.get(), HorizonsBlockLootProvider::createShearsOnlyDrop);
        this.dropSelf(ALGAE_THATCH.get());
        this.add(ALGAE_THATCH_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(ALGAE_THATCH_STAIRS.get());

        this.dropSelfAndOther(BLUE_LILY.get(), Items.LILY_PAD);
        this.dropSelfAndOther(LIGHT_GRAY_LILY.get(), Items.LILY_PAD);
        this.dropSelfAndOther(CYAN_LILY.get(), Items.LILY_PAD);
        this.dropSelfAndOther(LIGHT_BLUE_LILY.get(), Items.LILY_PAD);
        this.dropSelfAndOther(MAGENTA_LILY.get(), Items.LILY_PAD);
        this.dropSelfAndOther(PINK_LILY.get(), Items.LILY_PAD);
        this.dropSelfAndOther(PURPLE_LILY.get(), Items.LILY_PAD);
        this.dropSelfAndOther(WHITE_LILY.get(), Items.LILY_PAD);
        this.dropPottedContents(POTTED_BLUE_LILY.get());
        this.dropPottedContents(POTTED_LIGHT_GRAY_LILY.get());
        this.dropPottedContents(POTTED_CYAN_LILY.get());
        this.dropPottedContents(POTTED_LIGHT_BLUE_LILY.get());
        this.dropPottedContents(POTTED_MAGENTA_LILY.get());
        this.dropPottedContents(POTTED_PINK_LILY.get());
        this.dropPottedContents(POTTED_PURPLE_LILY.get());
        this.dropPottedContents(POTTED_WHITE_LILY.get());

        this.dropSelf(FIDDLENECK.get());
        this.dropSelf(AMARANTHUS.get());
        this.dropSelf(MYOSOTIS.get());
        this.dropPottedContents(POTTED_FIDDLENECK.get());
        this.dropPottedContents(POTTED_AMARANTHUS.get());
        this.dropPottedContents(POTTED_MYOSOTIS.get());

        this.tallFlower(HELICONIA.get());

        this.lavender(LAVENDER.get());
        this.tallLavender(TALL_LAVENDER.get(), LAVENDER.get());
        this.dropPottedContents(POTTED_LAVENDER.get());

        this.add(GIANT_FERN.get(), this.createTriplePlantWithSeedDrops(GIANT_FERN.get(), Items.FERN));
        
        // Redwood //
        this.woodDrops(STRIPPED_REDWOOD_LOG, STRIPPED_REDWOOD, REDWOOD_LOG, REDWOOD,
                REDWOOD_PLANKS, REDWOOD_SLAB, REDWOOD_STAIRS, REDWOOD_FENCE, REDWOOD_FENCE_GATE,
                REDWOOD_PRESSURE_PLATE, REDWOOD_DOOR, REDWOOD_TRAPDOOR, REDWOOD_BUTTON, REDWOOD_SIGNS,
                REDWOOD_HANGING_SIGNS, REDWOOD_CABINET, REDWOOD_BOOKSHELF, REDWOOD_LADDER, REDWOOD_CHESTS);
        this.dropSelf(REDWOOD_SAPLING.get());
        this.dropPottedContents(POTTED_REDWOOD_SAPLING.get());
        this.normalLeaves(REDWOOD_LEAVES.get(), REDWOOD_SAPLING.get());

        // Jacaranda //
        this.woodDrops(STRIPPED_JACARANDA_LOG, STRIPPED_JACARANDA_WOOD, JACARANDA_LOG, JACARANDA_WOOD,
                JACARANDA_PLANKS, JACARANDA_SLAB, JACARANDA_STAIRS, JACARANDA_FENCE, JACARANDA_FENCE_GATE,
                JACARANDA_PRESSURE_PLATE, JACARANDA_DOOR, JACARANDA_TRAPDOOR, JACARANDA_BUTTON, JACARANDA_SIGNS,
                JACARANDA_HANGING_SIGNS, JACARANDA_CABINET, JACARANDA_BOOKSHELF, JACARANDA_LADDER, JACARANDA_CHESTS);
        this.dropSelf(JACARANDA_SAPLING.get());
        this.dropSelf(FLOWERING_JACARANDA_SAPLING.get());
        this.dropPottedContents(POTTED_JACARANDA_SAPLING.get());
        this.dropPottedContents(POTTED_FLOWERING_JACARANDA_SAPLING.get());
        this.normalLeaves(JACARANDA_LEAVES.get(), JACARANDA_SAPLING.get());
        this.normalLeaves(FLOWERING_JACARANDA_LEAVES.get(), FLOWERING_JACARANDA_SAPLING.get());
    }

    private void woodDrops(RegistryReference<Block> strippedLog, RegistryReference<Block> strippedWood,
                           RegistryReference<Block> log, RegistryReference<Block> wood,
                           RegistryReference<Block> planks, RegistryReference<Block> slab,
                           RegistryReference<Block> stairs, RegistryReference<Block> fence,
                           RegistryReference<Block> fenceGate, RegistryReference<Block> pressurePlate,
                           RegistryReference<Block> door, RegistryReference<Block> trapdoor,
                           RegistryReference<Block> button, Pair<RegistryReference<BorealibStandingSignBlock>, RegistryReference<BorealibWallSignBlock>> signs,
                           Pair<RegistryReference<BorealibCeilingHangingSignBlock>, RegistryReference<BorealibWallHangingSignBlock>> hangingSigns,
                           RegistryReference<Block> cabinet, RegistryReference<Block> bookshelf, RegistryReference<Block> ladder,
                           Pair<RegistryReference<BorealibChestBlock>, RegistryReference<BorealibTrappedChestBlock>> chests) {
        this.dropSelf(strippedLog.get());
        this.dropSelf(strippedWood.get());
        this.dropSelf(log.get());
        this.dropSelf(wood.get());
        this.dropSelf(planks.get());
        this.add(slab.get(), this::createSlabItemTable);
        this.dropSelf(stairs.get());
        this.dropSelf(fence.get());
        this.dropSelf(fenceGate.get());
        this.dropSelf(pressurePlate.get());
        this.add(door.get(), this::createDoorTable);
        this.dropSelf(trapdoor.get());
        this.dropSelf(button.get());
        this.dropSelf(signs.getFirst().get());
        this.dropSelf(hangingSigns.getFirst().get());
        this.add(cabinet.get(), this::createNameableBlockEntityTable);
        this.add(bookshelf.get(), block -> this.createSingleItemTableWithSilkTouch(block, Items.BOOK, ConstantValue.exactly(3.0F)));
        this.dropSelf(ladder.get());
        this.add(chests.getFirst().get(), this::createNameableBlockEntityTable);
        this.add(chests.getSecond().get(), this::createNameableBlockEntityTable);
    }

    private void tallFlower(Block flower) {
        this.add(flower, b -> createSinglePropConditionTable(b, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
    }

    private void normalLeaves(Block leaves, Block sapling) {
        this.add(leaves, b -> createLeavesDrops(b, sapling, 0.05F, 0.0625F, 0.083333336F, 0.1F));
    }

    private void cypressKnee(Block knee, Block log) {
        this.add(knee, b -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f)).add(createCypressKneeLootItemBuilder(knee, log, UniformGenerator.between(1, 2)))));
    }

    private void dropSelfAndOther(Block block, ItemLike other) {
        this.add(block, b -> LootTable.lootTable()
                .withPool(applyExplosionCondition(other, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(other))))
                .withPool(applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(block)))));
    }

    private void largeCypressKnee(Block knee, Block log) {
        LootPoolEntryContainer.Builder<?> builder = createCypressKneeLootItemBuilder(knee, log, UniformGenerator.between(2, 4));

        this.add(knee, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(knee)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(knee)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).build()).build()), new BlockPos(0, 1, 0))))
                .withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(knee)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(knee)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).build()).build()), new BlockPos(0, -1, 0)))));
    }

    private void lavender(Block block) {
        this.add(block, LootTable.lootTable()
                .withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(block).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LavenderBlock.AGE, 2))))))
                .withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LavenderBlock.AGE, 1))))))
                .withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LavenderBlock.AGE, 0)))))));
    }

    private void tallLavender(Block block, Block drop) {
        this.add(block, LootTable.lootTable().apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F))).withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                .add(LootItem.lootTableItem(drop).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TallLavenderBlock.HALF, DoubleBlockHalf.UPPER)))))));
    }

    private LootTable.Builder createTriplePlantWithSeedDrops(Block block, ItemLike drop) {
        LootPoolEntryContainer.Builder<?> builder = LootItem.lootTableItem(drop).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F)))
                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS))).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(Items.WHEAT_SEEDS)).when(LootItemRandomChanceCondition.randomChance(0.125F)));

        return LootTable.lootTable()
                .withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(block)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).build()).build()), new BlockPos(0, 1, 0))))
                .withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(block)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).build()).build()), new BlockPos(0, -1, 0))));
    }

    private LootPoolEntryContainer.Builder<?> createCypressKneeLootItemBuilder(Block knee, ItemLike log, NumberProvider logCount) {
        return LootItem.lootTableItem(knee).when(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))))
                .otherwise(applyExplosionDecay(log, LootItem.lootTableItem(log).apply(SetItemCountFunction.setCount(logCount))));
    }

    @Override
    public void addConditions(ResourceLocation id, ResourceConditionProvider... providers) {
        // Not needed, will add to main library if that becomes the case in-future
    }

    @Override
    public void injectConditions(ResourceLocation id, JsonObject json) {
    }

    @Override
    public String getName() {
        return "Block Loot";
    }
}
