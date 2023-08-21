package com.teamaurora.horizons.core.other;

import com.teamaurora.horizons.common.util.FoodPropertiesHelper;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

/**
 * @author ebo2022
 * @author rose_
 */
public final class HorizonsFoods {
    public static final FoodProperties GOOSEBERRIES = new FoodProperties.Builder().nutrition(2).saturationMod(0.2F).build();
    public static final FoodProperties GOOSEBERRY_JUICE = new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).build();
    public static final FoodProperties GOOSEBERRY_PIE = new FoodProperties.Builder().nutrition(6).saturationMod(0.5F).build();
    public static final FoodProperties HONEY_GLAZED_GOOSEBERRIES = new FoodProperties.Builder().nutrition(7).saturationMod(0.3F).build();
    public static final FoodProperties GOOSEBERRY_JAM = new FoodProperties.Builder().nutrition(2).saturationMod(0.25F).build();
    public static final FoodProperties GOOSEBERRY_JAM_COOKIE = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build();
    public static final FoodProperties GOOSEBERRY_JAM_COOKIE_FAST = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).fast().build();
    public static final FoodProperties LAVENDER_SALAD = new FoodProperties.Builder().nutrition(6).saturationMod(0.5F).build();
    public static final FoodProperties SUNFLOWER_SEEDS = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties LAVENDER_TEA = FoodPropertiesHelper.effect(new FoodProperties.Builder().nutrition(0).saturationMod(0.0F), () -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 200, 0, false, true, true), 1).build();
}