package com.teamaurora.horizons.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

/**
 * @author JustinPlayzz
 * @author Steven
 * @author ebo2022
 * @author rose_
 */
public class LilyItem extends BlockItem {
    public LilyItem(Block block, Properties builder) {
        super(block, builder);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (state.getBlock() == Blocks.LILY_PAD && player != null) {
            level.setBlockAndUpdate(pos, this.getBlock().defaultBlockState());
            stack.shrink(1);
            level.playSound(player, pos, this.getPlaceSound(state), SoundSource.BLOCKS, (SoundType.LILY_PAD.getVolume() + 1.0F) / 2.0F, SoundType.LILY_PAD.getPitch() * 0.8F);
            player.swing(context.getHand());

            return InteractionResult.CONSUME;
        } else
            return InteractionResult.PASS;
    }
}