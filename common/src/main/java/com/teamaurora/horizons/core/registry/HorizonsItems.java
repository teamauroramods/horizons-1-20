package com.teamaurora.horizons.core.registry;

import com.mojang.datafixers.util.Pair;
import com.teamaurora.borealib.api.base.v1.platform.Platform;
import com.teamaurora.borealib.api.base.v1.util.Mods;
import com.teamaurora.borealib.api.registry.v1.RegistryReference;
import com.teamaurora.borealib.api.registry.v1.RegistryWrapper;
import com.teamaurora.borealib.api.registry.v1.util.PropertiesHelper;
import com.teamaurora.horizons.common.item.DrinkableBottleItem;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.HorizonsFoods;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public final class HorizonsItems {
    public static final RegistryWrapper.ItemProvider PROVIDER = RegistryWrapper.itemProvider(Horizons.MOD_ID);

    // Foods //

    public static final RegistryReference<Item> GOOSEBERRIES = PROVIDER.register("gooseberries", () -> new Item(PropertiesHelper.food(HorizonsFoods.GOOSEBERRIES)));
    public static final RegistryReference<Item> GOOSEBERRY_JUICE = PROVIDER.register("gooseberry_juice", () -> new DrinkableBottleItem(HorizonsFoods.GOOSEBERRY_JUICE));
    public static final RegistryReference<Item> GOOSEBERRY_PIE = PROVIDER.register("gooseberry_pie", () -> new Item(PropertiesHelper.food(HorizonsFoods.GOOSEBERRY_PIE)));
    public static final RegistryReference<Item> HONEY_GLAZED_GOOSEBERRIES = PROVIDER.register("honey_glazed_gooseberries", () -> new Item(PropertiesHelper.food(HorizonsFoods.HONEY_GLAZED_GOOSEBERRIES)));
    public static final RegistryReference<Item> GOOSEBERRY_JAM = PROVIDER.register("gooseberry_jam", () -> new DrinkableBottleItem(() -> SoundEvents.HONEY_DRINK, HorizonsFoods.GOOSEBERRY_JAM));
    public static final RegistryReference<Item> GOOSEBERRY_JAM_COOKIE = PROVIDER.register("gooseberry_jam_cookie", () -> new Item(PropertiesHelper.food(Platform.isModLoaded(Mods.FARMERS_DELIGHT) ? HorizonsFoods.GOOSEBERRY_JAM_COOKIE_FAST : HorizonsFoods.GOOSEBERRY_JAM_COOKIE)));

    public static final RegistryReference<Item> LAVENDER_SALAD = PROVIDER.register("lavender_salad", () -> new BowlFoodItem(PropertiesHelper.food(HorizonsFoods.LAVENDER_SALAD).stacksTo(1).craftRemainder(Items.BOWL)));
    public static final RegistryReference<Item> LAVENDER_TEA = PROVIDER.register("lavender_tea", () -> new DrinkableBottleItem(HorizonsFoods.LAVENDER_TEA));


    // Boats //

    public static final Pair<RegistryReference<Item>, RegistryReference<Item>> CYPRESS_BOATS = PROVIDER.registerBoats("cypress", HorizonsBlocks.CYPRESS_PLANKS);
    public static final Pair<RegistryReference<Item>, RegistryReference<Item>> REDWOOD_BOATS = PROVIDER.registerBoats("redwood", HorizonsBlocks.REDWOOD_PLANKS);

}
