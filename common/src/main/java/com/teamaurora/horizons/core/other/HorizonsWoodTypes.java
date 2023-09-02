package com.teamaurora.horizons.core.other;

import com.teamaurora.horizons.core.Horizons;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.WoodType;

public final class HorizonsWoodTypes {
    public static final WoodType CYPRESS = WoodType.register(new WoodType(Horizons.id("cypress"), HorizonsBlockSetTypes.CYPRESS));
    public static final WoodType REDWOOD = WoodType.register(new WoodType(Horizons.id("redwood"), HorizonsBlockSetTypes.REDWOOD));
    public static final WoodType JACARANDA = WoodType.register(new WoodType(Horizons.id("jacaranda"), HorizonsBlockSetTypes.JACARANDA, SoundType.CHERRY_WOOD, SoundType.CHERRY_WOOD_HANGING_SIGN, SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE, SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN));

}
