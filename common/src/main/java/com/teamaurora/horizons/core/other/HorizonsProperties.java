package com.teamaurora.horizons.core.other;

import com.teamaurora.borealib.api.registry.v1.util.PropertiesHelper;
import com.teamaurora.borealib.api.registry.v1.util.WoodProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

/**
 * @author ebo2022
 * @author rose_
 */
public class HorizonsProperties {

    // Wood Sets //
    public static final WoodProperties CYPRESS = WoodProperties.builder(MapColor.COLOR_GREEN, MapColor.COLOR_BROWN).build();
    public static final WoodProperties JACARANDA = WoodProperties.builder(MapColor.COLOR_PURPLE, MapColor.COLOR_BROWN).leavesColor(MapColor.COLOR_PURPLE).build();
    public static final WoodProperties REDBUD = WoodProperties.builder(MapColor.COLOR_RED, MapColor.COLOR_BROWN).build();
    public static final WoodProperties REDWOOD = WoodProperties.builder(MapColor.COLOR_ORANGE, MapColor.COLOR_BROWN).build();
    public static final BlockBehaviour.Properties CYPRESS_SIGN = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).forceSolidOn().instrument(NoteBlockInstrument.BASS).ignitedByLava().noCollission().strength(1.0F).sound(SoundType.CHERRY_WOOD);

    // Blocks //
    public static final BlockBehaviour.Properties GOOSEBERRY_SACK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(0.5F).sound(SoundType.WOOL);
    public static final BlockBehaviour.Properties ALGAE = BlockBehaviour.Properties.of().replaceable().instabreak().sound(HorizonsSoundTypes.ALGAE).noOcclusion().noCollission();
    public static final BlockBehaviour.Properties ALGAE_THATCH = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(0.5F).sound(HorizonsSoundTypes.ALGAE_THATCH).noOcclusion();
    public static final BlockBehaviour.Properties CYPRESS_KNEE = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(2.0F).sound(HorizonsSoundTypes.THIN_WOOD).noOcclusion().dynamicShape().pushReaction(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties CYPRESS_BRANCH = BlockBehaviour.Properties.of().randomTicks().noCollission().sound(HorizonsSoundTypes.THIN_WOOD);
    public static final BlockBehaviour.Properties BEARD_MOSS_BLOCK = BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.MOSS).noOcclusion().isValidSpawn(PropertiesHelper::ocelotOrParrot).isSuffocating(PropertiesHelper::never).isViewBlocking(PropertiesHelper::never);
    public static final BlockBehaviour.Properties BEARD_MOSS = BlockBehaviour.Properties.of().instabreak().sound(SoundType.MOSS).noOcclusion().noCollission().randomTicks();
    public static final BlockBehaviour.Properties LILY = BlockBehaviour.Properties.of().instabreak().sound(SoundType.LILY_PAD).noOcclusion();
    public static final BlockBehaviour.Properties GIANT_FERN = BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ);
    public static final BlockBehaviour.Properties BOULDER = BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F);
    public static final BlockBehaviour.Properties BOULDER_BRICKS = BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.NETHER_BRICKS).requiresCorrectToolForDrops().strength(1.5F, 6.0F);
    public static final BlockBehaviour.Properties REDBUD_BLOSSOMS = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).noCollission().strength(0.2F).sound(SoundType.FLOWERING_AZALEA);
    public static final BlockBehaviour.Properties SUNFLOWER_SEED_SACK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.5F).sound(SoundType.WOOL);
    public static final BlockBehaviour.Properties LAVENDER_BASKET = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.5F).sound(SoundType.WOOD);
    public static final BlockBehaviour.Properties LAVENDER = BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.AZALEA).offsetType(Block.OffsetType.XZ);
}
