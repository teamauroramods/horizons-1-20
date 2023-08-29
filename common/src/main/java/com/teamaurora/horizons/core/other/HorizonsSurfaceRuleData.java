package com.teamaurora.horizons.core.other;

import com.teamaurora.horizons.core.registry.HorizonsBiomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public final class HorizonsSurfaceRuleData {
    private static final SurfaceRules.RuleSource PODZOL = SurfaceRules.state(Blocks.PODZOL.defaultBlockState());
    private static final SurfaceRules.RuleSource WATER = SurfaceRules.state(Blocks.WATER.defaultBlockState());
    private static final SurfaceRules.RuleSource MUD = SurfaceRules.state(Blocks.MUD.defaultBlockState());

    public static SurfaceRules.RuleSource overworld() {
        SurfaceRules.ConditionSource y62 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
        SurfaceRules.ConditionSource y63 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);

        return SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(HorizonsBiomes.REDWOOD_FOREST), SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(Noises.SURFACE, 0.5, 0.9),
                                        PODZOL
                                ),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(Noises.SURFACE, -0.9, -0.5),
                                        PODZOL
                                )
                        )
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(HorizonsBiomes.BAYOU), SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        y62, SurfaceRules.ifTrue(
                                                SurfaceRules.not(y63), SurfaceRules.ifTrue(
                                                        SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D),
                                                        WATER
                                                )
                                        )
                                ),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(Noises.SURFACE, -0.065, 0.065),
                                        MUD
                                ),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(Noises.SURFACE, 0.6, 0.9),
                                        PODZOL
                                ),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(Noises.SURFACE, -0.9, -0.6),
                                        PODZOL
                                )
                        )
                ))
        );
    }
}
