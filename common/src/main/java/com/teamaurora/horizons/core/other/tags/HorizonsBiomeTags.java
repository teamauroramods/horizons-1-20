package com.teamaurora.horizons.core.other.tags;

import com.teamaurora.horizons.core.Horizons;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public final class HorizonsBiomeTags {
    public static final TagKey<Biome> HAS_ALGAE = biomeTag("has_feature/algae");
    public static final TagKey<Biome> HAS_GIANT_FERN = biomeTag("has_feature/giant_fern");
    public static final TagKey<Biome> HAS_BLUE_LILY = biomeTag("has_feature/blue_lily");
    public static final TagKey<Biome> HAS_LIGHT_GRAY_LILY = biomeTag("has_feature/light_gray_lily");
    public static final TagKey<Biome> HAS_CYAN_LILY = biomeTag("has_feature/cyan_lily");
    public static final TagKey<Biome> HAS_LIGHT_BLUE_LILY = biomeTag("has_feature/light_blue_lily");
    public static final TagKey<Biome> HAS_MAGENTA_LILY = biomeTag("has_feature/magenta_lily");
    public static final TagKey<Biome> HAS_PINK_LILY = biomeTag("has_feature/pink_lily");
    public static final TagKey<Biome> HAS_PURPLE_LILY = biomeTag("has_feature/purple_lily");
    public static final TagKey<Biome> HAS_WHITE_LILY = biomeTag("has_feature/white_lily");
    public static final TagKey<Biome> HAS_HELICONIA = biomeTag("has_feature/heliconia");
    public static final TagKey<Biome> HAS_AMARANTHUS = biomeTag("has_feature/amaranthus");
    public static final TagKey<Biome> HAS_MYOSOTIS = biomeTag("has_feature/myosotis");
    public static final TagKey<Biome> HAS_FIDDLENECK = biomeTag("has_feature/fiddleneck");

    private static TagKey<Biome> biomeTag(String path) {
        return TagKey.create(Registries.BIOME, Horizons.location(path));
    }
}
