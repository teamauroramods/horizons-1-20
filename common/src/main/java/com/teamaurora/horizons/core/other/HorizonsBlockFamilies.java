package com.teamaurora.horizons.core.other;

import net.minecraft.data.BlockFamily;
import static com.teamaurora.horizons.core.registry.HorizonsBlocks.*;

public final class HorizonsBlockFamilies {
    public static final BlockFamily CYPRESS_PLANKS_FAMILY = new BlockFamily.Builder(CYPRESS_PLANKS.get()).button(CYPRESS_BUTTON.get()).fence(CYPRESS_FENCE.get()).fenceGate(CYPRESS_FENCE_GATE.get()).pressurePlate(CYPRESS_PRESSURE_PLATE.get()).sign(CYPRESS_SIGNS.getFirst().get(), CYPRESS_SIGNS.getSecond().get()).slab(CYPRESS_SLAB.get()).stairs(CYPRESS_STAIRS.get()).door(CYPRESS_DOOR.get()).trapdoor(CYPRESS_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    public static final BlockFamily REDWOOD_PLANKS_FAMILY = new BlockFamily.Builder(REDWOOD_PLANKS.get()).button(REDWOOD_BUTTON.get()).fence(REDWOOD_FENCE.get()).fenceGate(REDWOOD_FENCE_GATE.get()).pressurePlate(REDWOOD_PRESSURE_PLATE.get()).sign(REDWOOD_SIGNS.getFirst().get(), REDWOOD_SIGNS.getSecond().get()).slab(REDWOOD_SLAB.get()).stairs(REDWOOD_STAIRS.get()).door(REDWOOD_DOOR.get()).trapdoor(REDWOOD_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    public static final BlockFamily ALGAE_THATCH_FAMILY = new BlockFamily.Builder(ALGAE_THATCH.get()).stairs(ALGAE_THATCH_STAIRS.get()).slab(ALGAE_THATCH_SLAB.get()).getFamily();
}
