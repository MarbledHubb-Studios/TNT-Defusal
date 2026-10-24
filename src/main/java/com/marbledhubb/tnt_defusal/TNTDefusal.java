package com.marbledhubb.tnt_defusal;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(TNTDefusal.MOD_ID)
public class TNTDefusal {
    public static final String MOD_ID = "tnt_defusal";

    public TNTDefusal(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);
    }
}
