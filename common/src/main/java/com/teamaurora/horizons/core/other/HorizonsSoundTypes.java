package com.teamaurora.horizons.core.other;

import com.teamaurora.horizons.common.util.DeferredSoundType;
import net.minecraft.sounds.SoundEvents;

/**
 * @author ebo2022
 * @author rose_
 */
public final class HorizonsSoundTypes {
    public static final DeferredSoundType ALGAE = new DeferredSoundType(1F, 2.0F, () -> SoundEvents.BIG_DRIPLEAF_BREAK, () -> SoundEvents.MOSS_CARPET_STEP, () -> SoundEvents.LILY_PAD_PLACE, () -> SoundEvents.MOSS_CARPET_HIT, () -> SoundEvents.MOSS_CARPET_FALL);
    public static final DeferredSoundType ALGAE_THATCH = new DeferredSoundType(1.0F, 0.7F, () -> SoundEvents.ROOTS_BREAK, () -> SoundEvents.ROOTS_STEP, () -> SoundEvents.ROOTS_PLACE, () -> SoundEvents.GRASS_HIT, () -> SoundEvents.ROOTS_FALL);
    public static final DeferredSoundType THIN_WOOD = new DeferredSoundType(1.0F, 1.5F, () -> SoundEvents.WOOD_BREAK, () -> SoundEvents.WOOD_STEP, () -> SoundEvents.WOOD_PLACE, () -> SoundEvents.WOOD_HIT, () -> SoundEvents.WOOD_FALL);
}