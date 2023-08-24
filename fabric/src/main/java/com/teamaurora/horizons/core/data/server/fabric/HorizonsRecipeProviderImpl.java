package com.teamaurora.horizons.core.data.server.fabric;

import com.mojang.datafixers.util.Pair;
import com.teamaurora.borealib.api.base.v1.util.Mods;
import com.teamaurora.borealib.api.block.v1.compat.BorealibChestBlock;
import com.teamaurora.borealib.api.block.v1.compat.BorealibTrappedChestBlock;
import com.teamaurora.borealib.api.registry.v1.RegistryReference;
import com.teamaurora.borealib.api.resource_condition.v1.DefaultResourceConditions;
import com.teamaurora.borealib.api.resource_condition.v1.ResourceConditionProvider;
import com.teamaurora.horizons.core.data.server.HorizonsRecipeProvider;
import com.teamaurora.horizons.core.other.HorizonsBlockFamilies;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

import static com.teamaurora.horizons.core.registry.HorizonsItems.*;
import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;

public class HorizonsRecipeProviderImpl {

    private static final ResourceConditionProvider CARPENTER_LOADED = DefaultResourceConditions.allModsLoaded(Mods.CARPENTER);

    public static void handlePlatformRecipes(Consumer<FinishedRecipe> exporter, HorizonsRecipeProvider provider) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GOOSEBERRY_PIE.get()).requires(GOOSEBERRIES.get()).requires(Items.EGG).requires(Items.SUGAR).unlockedBy(HorizonsRecipeProvider.getHasName(GOOSEBERRIES.get()), HorizonsRecipeProvider.has(GOOSEBERRIES.get())).save(exporter);
        Consumer<FinishedRecipe> carpenterExporter = provider.withConditions(exporter, CARPENTER_LOADED);
        fabricWoodSet(HorizonsBlockFamilies.CYPRESS_PLANKS_FAMILY, CYPRESS_CHESTS, CYPRESS_BOOKSHELF, carpenterExporter);
    }

    private static void fabricWoodSet(BlockFamily family, Pair<RegistryReference<BorealibChestBlock>, RegistryReference<BorealibTrappedChestBlock>> chests,
                                      RegistryReference<Block> bookshelf, Consumer<FinishedRecipe> conditionalConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bookshelf.get()).group("bookshelves").define('#', family.getBaseBlock()).define('B', Items.BOOK).pattern("###").pattern("BBB").pattern("###").unlockedBy(HorizonsRecipeProvider.getHasName(family.getBaseBlock()), HorizonsRecipeProvider.has(family.getBaseBlock())).save(conditionalConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, chests.getFirst().get()).group("chests").define('#', family.getBaseBlock()).pattern("###").pattern("# #").pattern("###").unlockedBy(HorizonsRecipeProvider.getHasName(family.getBaseBlock()), HorizonsRecipeProvider.has(family.getBaseBlock())).save(conditionalConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, chests.getSecond().get()).requires(chests.getFirst().get()).requires(Items.TRIPWIRE_HOOK).unlockedBy("has_lots_of_items", new InventoryChangeTrigger.TriggerInstance(ContextAwarePredicate.ANY, MinMaxBounds.Ints.atLeast(10), MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, new ItemPredicate[0])).save(conditionalConsumer);
    }
}
