package com.teamaurora.horizons.core.other;

import com.teamaurora.horizons.core.Horizons;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class HorizonsWoodTypes {

    public static final WoodType CYPRESS = WoodType.register(new WoodType(Horizons.id("cypress"), HorizonsBlockSetTypes.CYPRESS, SoundType.CHERRY_WOOD, SoundType.CHERRY_WOOD_HANGING_SIGN, SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE, SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN));
}
