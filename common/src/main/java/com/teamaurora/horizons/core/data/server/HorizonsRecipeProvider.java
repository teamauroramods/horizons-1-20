package com.teamaurora.horizons.core.data.server;

import com.mojang.datafixers.util.Pair;
import com.teamaurora.borealib.api.base.v1.platform.Platform;
import com.teamaurora.borealib.api.base.v1.util.Mods;
import com.teamaurora.borealib.api.block.v1.BorealibCeilingHangingSignBlock;
import com.teamaurora.borealib.api.block.v1.BorealibWallHangingSignBlock;
import com.teamaurora.borealib.api.datagen.v1.BorealibPackOutput;
import com.teamaurora.borealib.api.datagen.v1.providers.BorealibRecipeProvider;
import com.teamaurora.borealib.api.registry.v1.RegistryReference;
import com.teamaurora.borealib.api.resource_condition.v1.DefaultResourceConditions;
import com.teamaurora.borealib.api.resource_condition.v1.ResourceConditionProvider;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.HorizonsBlockFamilies;
import com.teamaurora.horizons.core.other.tags.HorizonsItemTags;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;
import static com.teamaurora.horizons.core.registry.HorizonsItems.*;

public class HorizonsRecipeProvider extends BorealibRecipeProvider {
    private static final ResourceConditionProvider FARMERS_DELIGHT_LOADED = DefaultResourceConditions.allModsLoaded(Mods.FARMERS_DELIGHT);

    public HorizonsRecipeProvider(BorealibPackOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        handlePlatformRecipes(exporter, this);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GOOSEBERRY_JUICE.get()).requires(Items.GLASS_BOTTLE).requires(GOOSEBERRIES.get(), 3).unlockedBy(getHasName(GOOSEBERRIES.get()), has(GOOSEBERRIES.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.SUGAR, 3).requires(GOOSEBERRY_JUICE.get()).unlockedBy(getHasName(GOOSEBERRY_JUICE.get()), has(GOOSEBERRY_JUICE.get())).save(exporter, Horizons.location("gooseberry_juice_to_sugar"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, HONEY_GLAZED_GOOSEBERRIES.get()).requires(GOOSEBERRIES.get()).requires(Items.HONEY_BOTTLE).unlockedBy(getHasName(GOOSEBERRIES.get()), has(GOOSEBERRIES.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GOOSEBERRY_JAM_COOKIE.get(), 8).requires(GOOSEBERRY_JAM.get()).requires(Items.WHEAT, 2).unlockedBy(getHasName(GOOSEBERRY_JAM.get()), has(GOOSEBERRY_JAM.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GOOSEBERRY_JAM.get(), 3).requires(HONEY_GLAZED_GOOSEBERRIES.get()).requires(Items.GLASS_BOTTLE, 3).unlockedBy(getHasName(HONEY_GLAZED_GOOSEBERRIES.get()), has(HONEY_GLAZED_GOOSEBERRIES.get())).save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.SUGAR, 3).requires(GOOSEBERRY_JAM.get()).unlockedBy(getHasName(GOOSEBERRY_JAM.get()), has(GOOSEBERRY_JAM.get())).save(exporter, Horizons.location("gooseberry_jam_to_sugar"));
        this.woodSet(HorizonsItemTags.CYPRESS_LOGS, HorizonsBlockFamilies.CYPRESS_PLANKS_FAMILY, CYPRESS_LOG, STRIPPED_CYPRESS_LOG, CYPRESS_WOOD, STRIPPED_CYPRESS_WOOD, CYPRESS_CABINET, CYPRESS_BOOKSHELF, CYPRESS_HANGING_SIGNS, CYPRESS_BOATS, exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ALGAE_THATCH.get(), 4).define('#', ALGAE.get()).pattern("##").pattern("##").unlockedBy(getHasName(ALGAE.get()), has(ALGAE.get())).save(exporter);
        generateRecipes(exporter, HorizonsBlockFamilies.ALGAE_THATCH_FAMILY);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, SUNFLOWER_SEEDS.get(), 2).requires(Items.SUNFLOWER).unlockedBy(getHasName(Items.SUNFLOWER), has(Items.SUNFLOWER)).save(exporter);
        oneToOneConversionRecipe(exporter, Items.BLUE_DYE, BLUE_LILY.get(), "blue_dye");
        oneToOneConversionRecipe(exporter, Items.LIGHT_GRAY_DYE, LIGHT_GRAY_LILY.get(), "light_gray_dye");
        oneToOneConversionRecipe(exporter, Items.CYAN_DYE, CYAN_LILY.get(), "cyan_dye");
        oneToOneConversionRecipe(exporter, Items.LIGHT_BLUE_DYE, LIGHT_BLUE_LILY.get(), "light_blue_dye");
        oneToOneConversionRecipe(exporter, Items.MAGENTA_DYE, MAGENTA_LILY.get(), "magenta_dye");
        oneToOneConversionRecipe(exporter, Items.PINK_DYE, PINK_LILY.get(), "pink_dye");
        oneToOneConversionRecipe(exporter, Items.PURPLE_DYE, PURPLE_LILY.get(), "purple_dye");
        oneToOneConversionRecipe(exporter, Items.WHITE_DYE, WHITE_LILY.get(), "white_dye");
        oneToOneConversionRecipe(exporter, Items.YELLOW_DYE, FIDDLENECK.get(), "yellow_dye");
        oneToOneConversionRecipe(exporter, Items.CYAN_DYE, MYOSOTIS.get(), "cyan_dye");
        oneToOneConversionRecipe(exporter, Items.RED_DYE, AMARANTHUS.get(), "red_dye");
        oneToOneConversionRecipe(exporter, Items.RED_DYE, HELICONIA.get(), "red_dye", 2);

    }

    private void woodSet(TagKey<Item> logs, BlockFamily family, RegistryReference<Block> log, RegistryReference<Block> strippedLog,
                                RegistryReference<Block> wood, RegistryReference<Block> strippedWood,
                                RegistryReference<Block> cabinet, RegistryReference<Block> bookshelf,
                                Pair<RegistryReference<BorealibCeilingHangingSignBlock>, RegistryReference<BorealibWallHangingSignBlock>> hangingSigns,
                                Pair<RegistryReference<Item>, RegistryReference<Item>> boats, Consumer<FinishedRecipe> consumer) {
        generateRecipes(consumer, family);
        hangingSign(consumer, hangingSigns.getFirst().get(), strippedLog.get());
        woodenBoat(consumer, boats.getFirst().get(), family.getBaseBlock());
        chestBoat(consumer, boats.getSecond().get(), boats.getFirst().get());
        planksFromLogs(consumer, family.getBaseBlock(), logs, 4);
        woodFromLogs(consumer, wood.get(), log.get());
        woodFromLogs(consumer, strippedWood.get(), strippedLog.get());
        Block trapdoor = family.get(BlockFamily.Variant.TRAPDOOR);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, cabinet.get()).define('#', family.get(BlockFamily.Variant.SLAB)).define('T', trapdoor).pattern("###").pattern("T T").pattern("###").unlockedBy(getHasName(trapdoor), has(trapdoor)).save(this.withConditions(consumer, FARMERS_DELIGHT_LOADED));
    }


    @ExpectPlatform
    public static void handlePlatformRecipes(Consumer<FinishedRecipe> exporter, HorizonsRecipeProvider provider) {
        Platform.expect();
    }
}
