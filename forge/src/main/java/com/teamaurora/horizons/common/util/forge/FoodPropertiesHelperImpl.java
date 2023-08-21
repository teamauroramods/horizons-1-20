package com.teamaurora.horizons.common.util.forge;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

import java.util.function.Supplier;

public class FoodPropertiesHelperImpl {
    public static FoodProperties.Builder effect(FoodProperties.Builder properties, Supplier<MobEffectInstance> instance, float chance) {
        return properties.effect(instance, chance);
    }
}
