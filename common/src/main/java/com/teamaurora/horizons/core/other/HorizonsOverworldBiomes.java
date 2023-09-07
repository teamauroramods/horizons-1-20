package com.teamaurora.horizons.core.other;

import com.teamaurora.horizons.core.registry.feature.HorizonsVegetationPlacements;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

/**
 * @author rose_
 */
public final class HorizonsOverworldBiomes {

    // Builders //

    public static Biome bayou(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        MobSpawnSettings.Builder spawns = baseBayouSpawns();
        BiomeGenerationSettings.Builder gen = new BiomeGenerationSettings.Builder(featureGetter, carverGetter);

        BiomeDefaultFeatures.addFossilDecoration(gen);
        globalOverworldGeneration(gen);
        BiomeDefaultFeatures.addFerns(gen);
        BiomeDefaultFeatures.addPlainGrass(gen);
        BiomeDefaultFeatures.addDefaultOres(gen);
        BiomeDefaultFeatures.addSwampClayDisk(gen);

        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_SWAMP);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_PLAIN);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_WATERLILY);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_SWAMP);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.RED_MUSHROOM_SWAMP);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsVegetationPlacements.CYPRESS_TREES);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsVegetationPlacements.WATER_CYPRESS_TREES);

        BiomeDefaultFeatures.addDefaultMushrooms(gen);
        BiomeDefaultFeatures.addSwampExtraVegetation(gen);

        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);

        return biome(true, 0.75F, 1.0F, 0x87C0C6, 0x3D5156, 0xA0E2E5, spawns, gen, null);
    }

    public static Biome redwoodForest(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        MobSpawnSettings.Builder spawns = baseRedwoodForestSpawns();
        BiomeGenerationSettings.Builder gen = new BiomeGenerationSettings.Builder(featureGetter, carverGetter);

        globalOverworldGeneration(gen);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsVegetationPlacements.REDWOOD_TREES);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsVegetationPlacements.SPRUCE_PINE_TREES);
        BiomeDefaultFeatures.addFerns(gen);
        BiomeDefaultFeatures.addDefaultOres(gen);
        BiomeDefaultFeatures.addDefaultSoftDisks(gen);
        BiomeDefaultFeatures.addDefaultFlowers(gen);
        BiomeDefaultFeatures.addGiantTaigaVegetation(gen);
        BiomeDefaultFeatures.addDefaultMushrooms(gen);
        BiomeDefaultFeatures.addDefaultExtraVegetation(gen);
        BiomeDefaultFeatures.addMossyStoneBlock(gen);
        BiomeDefaultFeatures.addRareBerryBushes(gen);

        return biome(true, 0.75F, 0.9F, 4159204, 329011, 12638463, spawns, gen, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA));
    }

    public static Biome lavender(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter, boolean sparse) {
        MobSpawnSettings.Builder spawns = baseLavenderFieldSpawns();
        BiomeGenerationSettings.Builder gen = new BiomeGenerationSettings.Builder(featureGetter, carverGetter);

        globalOverworldGeneration(gen);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsVegetationPlacements.LAVENDER);
        if (sparse)
            gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsVegetationPlacements.SPARSE_JACARANDA_TREES);
        else {
            gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsVegetationPlacements.JACARANDA_TREES);
            gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsVegetationPlacements.TALL_BIRCH_TREES);
        }
        BiomeDefaultFeatures.addDefaultOres(gen);
        BiomeDefaultFeatures.addDefaultSoftDisks(gen);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_PLAIN);
        BiomeDefaultFeatures.addDefaultMushrooms(gen);

        return biome(true, 0.8F, 0.6F, 4159204, 329011, 12638463, spawns, gen, null);
    }

    // Base Spawns //

    private static MobSpawnSettings.Builder baseBayouSpawns() {
        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawns);
        BiomeDefaultFeatures.farmAnimals(spawns);
        spawns.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 3, 1, 1));
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FROG, 5, 2, 4));
        spawns.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 2, 3, 5));

        return spawns;
    }

    private static MobSpawnSettings.Builder baseRedwoodForestSpawns() {
        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawns);
        BiomeDefaultFeatures.farmAnimals(spawns);
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));

        return spawns;
    }

    private static MobSpawnSettings.Builder baseLavenderFieldSpawns() {
        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawns);
        BiomeDefaultFeatures.farmAnimals(spawns);
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 8, 2, 4));

        return spawns;
    }

    // Util //

    private static Biome biome(boolean hasPrecipitation, float temperature, float downfall, int waterColor, int waterFogColor, int fogColor, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, Music music) {
        return new Biome.BiomeBuilder()
                .hasPrecipitation(hasPrecipitation)
                .temperature(temperature)
                .downfall(downfall)
                .specialEffects(new BiomeSpecialEffects.Builder().waterColor(waterColor)
                        .waterFogColor(waterFogColor).fogColor(fogColor)
                        .skyColor(calculateSkyColor(temperature))
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    private static int calculateSkyColor(float temperature) {
        float clampedTemp = Mth.clamp(temperature / 3.0F, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - clampedTemp * 0.05F, 0.5F + clampedTemp * 0.1F, 1.0F);
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }
}