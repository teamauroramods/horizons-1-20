package com.teamaurora.horizons.core.data.server.forge;

import com.mojang.datafixers.util.Pair;
import com.teamaurora.borealib.api.base.v1.util.Mods;
import com.teamaurora.borealib.api.block.v1.compat.BorealibChestBlock;
import com.teamaurora.borealib.api.block.v1.compat.BorealibTrappedChestBlock;
import com.teamaurora.borealib.api.registry.v1.RegistryReference;
import com.teamaurora.borealib.api.resource_condition.v1.DefaultResourceConditions;
import com.teamaurora.borealib.api.resource_condition.v1.ResourceConditionProvider;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.data.server.HorizonsRecipeProvider;
import com.teamaurora.horizons.core.other.HorizonsBlockFamilies;
import com.teamaurora.horizons.core.other.tags.HorizonsItemTags;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static com.teamaurora.horizons.core.registry.HorizonsItems.*;
import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;

public class HorizonsRecipeProviderImpl {

    private static final ResourceConditionProvider CARPENTER_LOADED = DefaultResourceConditions.allModsLoaded(Mods.CARPENTER);
    private static final ResourceConditionProvider BOOKSHELVES = DefaultResourceConditions.or(CARPENTER_LOADED, DefaultResourceConditions.quarkFlag("variant_bookshelves"), DefaultResourceConditions.woodworksFlag("wooden_bookshelves"));
    private static final ResourceConditionProvider CHESTS = DefaultResourceConditions.or(CARPENTER_LOADED, DefaultResourceConditions.quarkFlag("variant_chests"), DefaultResourceConditions.woodworksFlag("wooden_chests"));
    private static final ResourceConditionProvider WOOD_TO_CHEST_RECIPES = DefaultResourceConditions.and(DefaultResourceConditions.quarkFlag("wood_to_chest_recipes"), DefaultResourceConditions.quarkFlag("variant_chests"));

    public static void handlePlatformRecipes(Consumer<FinishedRecipe> exporter, HorizonsRecipeProvider provider) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GOOSEBERRY_PIE.get()).requires(GOOSEBERRIES.get()).requires(Tags.Items.EGGS).requires(Items.SUGAR).unlockedBy(HorizonsRecipeProvider.getHasName(GOOSEBERRIES.get()), HorizonsRecipeProvider.has(GOOSEBERRIES.get())).save(exporter);
        Consumer<FinishedRecipe> shelvesExporter = provider.withConditions(exporter, BOOKSHELVES);
        Consumer<FinishedRecipe> chestsExporter = provider.withConditions(exporter, CHESTS);
        Consumer<FinishedRecipe> woodToChestRecipeExporter = provider.withConditions(exporter, WOOD_TO_CHEST_RECIPES);
        forgeWoodSet(HorizonsItemTags.CYPRESS_LOGS, HorizonsBlockFamilies.CYPRESS_PLANKS_FAMILY, CYPRESS_CHESTS, CYPRESS_BOOKSHELF, shelvesExporter, chestsExporter, woodToChestRecipeExporter);
    }

    private static void forgeWoodSet(TagKey<Item> logs, BlockFamily family, Pair<RegistryReference<BorealibChestBlock>, RegistryReference<BorealibTrappedChestBlock>> chests,
                                     RegistryReference<Block> bookshelf, Consumer<FinishedRecipe> shelves, Consumer<FinishedRecipe> chestExporter, Consumer<FinishedRecipe> wood2ChestRecipes) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bookshelf.get()).group("wooden_bookshelves").define('#', family.getBaseBlock()).define('B', Items.BOOK).pattern("###").pattern("BBB").pattern("###").unlockedBy(HorizonsRecipeProvider.getHasName(family.getBaseBlock()), HorizonsRecipeProvider.has(family.getBaseBlock())).save(shelves);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, chests.getFirst().get()).group("wooden_chests").define('#', family.getBaseBlock()).pattern("###").pattern("# #").pattern("###").unlockedBy(HorizonsRecipeProvider.getHasName(family.getBaseBlock()), HorizonsRecipeProvider.has(family.getBaseBlock())).save(chestExporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, chests.getSecond().get()).requires(chests.getFirst().get()).requires(Items.TRIPWIRE_HOOK).unlockedBy("has_lots_of_items", new InventoryChangeTrigger.TriggerInstance(ContextAwarePredicate.ANY, MinMaxBounds.Ints.atLeast(10), MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, new ItemPredicate[0])).save(chestExporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, chests.getFirst().get(), 4).group("wooden_chests").define('#', logs).pattern("###").pattern("# #").pattern("###").unlockedBy("has_lots_of_items", new InventoryChangeTrigger.TriggerInstance(ContextAwarePredicate.ANY, MinMaxBounds.Ints.atLeast(10), MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, new ItemPredicate[0])).save(wood2ChestRecipes, chests.getFirst().getId().withSuffix("_wood"));
    }
}
