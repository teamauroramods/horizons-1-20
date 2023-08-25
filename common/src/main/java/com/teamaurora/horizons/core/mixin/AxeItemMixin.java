package com.teamaurora.horizons.core.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.teamaurora.borealib.api.base.v1.platform.Platform;
import com.teamaurora.horizons.common.block.DoubleCypressKneeBlock;
import com.teamaurora.horizons.common.util.BlockUtil;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AxeItem.class)
public class AxeItemMixin {

    @Inject(method = "useOn", at = @At("TAIL"), cancellable = true)
    private void handleCypressKnee(UseOnContext useOnContext, CallbackInfoReturnable<InteractionResult> cir) {
        BlockPos pos = useOnContext.getClickedPos();
        Level level = useOnContext.getLevel();
        BlockState state = level.getBlockState(pos);
        Player player = useOnContext.getPlayer();
        if (state.getBlock() == HorizonsBlocks.LARGE_CYPRESS_KNEE.get()) {
            boolean lower = state.getValue(DoubleCypressKneeBlock.HALF) == DoubleBlockHalf.LOWER;
            level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (Platform.isFabric()) BlockUtil.prepForDoubleBlockPlacement(level, pos, lower);
            DoubleCypressKneeBlock.placeAt(HorizonsBlocks.STRIPPED_LARGE_CYPRESS_KNEE.get(), level, lower ? pos : pos.below(), 3);
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, pos, useOnContext.getItemInHand());
            }
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, level.getBlockState(pos)));
            level.gameEvent(GameEvent.BLOCK_CHANGE, lower ? pos.above() : pos.below(), GameEvent.Context.of(player, level.getBlockState(pos)));
            cir.setReturnValue(InteractionResult.sidedSuccess(level.isClientSide));
        }
    }
}
