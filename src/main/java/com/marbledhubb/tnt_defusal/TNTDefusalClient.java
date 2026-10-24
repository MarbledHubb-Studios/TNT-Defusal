package com.marbledhubb.tnt_defusal;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;

@Mod(value = TNTDefusal.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = TNTDefusal.MOD_ID, value = Dist.CLIENT)
public class TNTDefusalClient {
    public TNTDefusalClient(ModContainer container) {

    }
}
