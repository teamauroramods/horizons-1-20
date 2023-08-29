package com.teamaurora.horizons.core.other.region;

import com.mojang.datafixers.util.Pair;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class HorizonsOverworldRegion extends Region {
    public HorizonsOverworldRegion() {
        super(Horizons.location("overworld"), RegionType.OVERWORLD, Horizons.CONFIG.regionWeight.get());
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        (new HorizonsOverworldBiomeBuilder()).addBiomes(mapper);
    }
}
