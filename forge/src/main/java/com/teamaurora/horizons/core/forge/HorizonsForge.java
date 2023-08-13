package com.teamaurora.horizons.core.forge;

import com.teamaurora.borealib.api.base.v1.modloading.forge.ForgeModFactory;
import com.teamaurora.horizons.core.Horizons;
import net.minecraftforge.fml.common.Mod;

@Mod(Horizons.MOD_ID)
public class HorizonsForge {

    public HorizonsForge() {
        ForgeModFactory.loadMod(Horizons.MOD_ID);

    }
}
