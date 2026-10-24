package com.marbledhubb.tnt_defusal.event;

import com.marbledhubb.tnt_defusal.TNTDefusal;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = TNTDefusal.MOD_ID)
public class TNTDefusalEvent {
    @SubscribeEvent
    public static void tntDefuse(PlayerInteractEvent.EntityInteractSpecific event) {
        Player player = event.getEntity();
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        InteractionHand hand = event.getHand();
        ItemStack stack = player.getItemInHand(hand);
        Entity actualEntity = event.getTarget();

        if (actualEntity instanceof PrimedTnt) {
            if (stack.is(Items.SHEARS)) {
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
                if (!player.isCreative()) {
                    stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
                }
                actualEntity.discard();
                level.setBlock(pos, Blocks.TNT.defaultBlockState(), 1);
                level.playSound(player, pos, SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 1.1f, 1.2F / (level.getRandom().nextFloat() + 0.1F));
            }
        }
    }
}
