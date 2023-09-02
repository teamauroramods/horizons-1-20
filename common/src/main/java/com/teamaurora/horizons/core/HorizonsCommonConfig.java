package com.teamaurora.horizons.core;

import com.teamaurora.borealib.api.config.v1.ConfigBuilder;
import com.teamaurora.borealib.api.config.v1.ConfigValue;

public class HorizonsCommonConfig {
    public final ConfigValue<Integer> regionWeight;
    public final ConfigValue<Float> cypressBranchOdds;
    public final ConfigValue<Boolean> atacamaDesert;
    public final ConfigValue<Boolean> bayou;
    public final ConfigValue<Boolean> lavenderField;
    public final ConfigValue<Boolean> lavenderForest;
    public final ConfigValue<Boolean> redwoodForest;

    HorizonsCommonConfig(ConfigBuilder builder) {
        builder.push("General");
        this.regionWeight = builder.comment("The relative weight to use for the Horizons TerraBlender region.", "This determines how often Horizons' biomes will appear compared to those added by other mods.").define("Region Weight", 10);
        this.cypressBranchOdds = builder.comment("The odds out of 1 for a cypress branch to generate if the randomly selected adjacent block is available.").defineInRange("Cypress Branch Odds", 0.1F, 0F, 1F, Float.class);
        builder.pop();

        builder.push("Biomes");
        this.atacamaDesert = builder.comment("Whether the Atacama Desert should generate naturally.").define("Enable Atacama Desert", true);
        this.bayou = builder.comment("Whether the Bayou should generate naturally.").define("Enable Bayou", true);
        this.lavenderField = builder.comment("Whether the Lavender Field should generate naturally.").define("Enable Lavender Field", true);
        this.lavenderForest = builder.comment("Whether the Lavender Forest should generate naturally.").define("Enable Lavender Forest", true);
        this.redwoodForest = builder.comment("Whether the Redwood Forest should generate naturally.").define("Enable Redwood Forest", true);
        builder.pop();
    }

}
