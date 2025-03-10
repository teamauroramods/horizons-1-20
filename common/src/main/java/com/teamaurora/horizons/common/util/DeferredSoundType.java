package com.teamaurora.horizons.common.util;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;

import java.util.function.Supplier;

@Deprecated
public class DeferredSoundType extends SoundType { // moved to borealib
    private final Supplier<SoundEvent> breakSound;
    private final Supplier<SoundEvent> stepSound;
    private final Supplier<SoundEvent> placeSound;
    private final Supplier<SoundEvent> hitSound;
    private final Supplier<SoundEvent> fallSound;

    public DeferredSoundType(float volumeIn, float pitchIn, Supplier<SoundEvent> breakSoundIn, Supplier<SoundEvent> stepSoundIn, Supplier<SoundEvent> placeSoundIn, Supplier<SoundEvent> hitSoundIn, Supplier<SoundEvent> fallSoundIn) {
        super(volumeIn, pitchIn, (SoundEvent) null, (SoundEvent) null, (SoundEvent) null, (SoundEvent) null, (SoundEvent) null);
        this.breakSound = breakSoundIn;
        this.stepSound = stepSoundIn;
        this.placeSound = placeSoundIn;
        this.hitSound = hitSoundIn;
        this.fallSound = fallSoundIn;
    }

    @Override
    public SoundEvent getBreakSound()
    {
        return breakSound.get();
    }

    @Override
    public SoundEvent getStepSound()
    {
        return stepSound.get();
    }

    @Override
    public SoundEvent getPlaceSound()
    {
        return placeSound.get();
    }

    @Override
    public SoundEvent getHitSound()
    {
        return hitSound.get();
    }

    @Override
    public SoundEvent getFallSound()
    {
        return fallSound.get();
    }
}