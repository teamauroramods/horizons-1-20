package com.teamaurora.horizons.common.levelgen.treedecorators;

import com.mojang.serialization.Codec;
import com.teamaurora.horizons.common.block.beard_moss.BeardMossBlock;
import com.teamaurora.horizons.common.block.beard_moss.BeardMossBlockBlock;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

/**
 * @author ebo2022
 */
public class BeardMossTreeDecorator extends TreeDecorator {
    public static final BeardMossTreeDecorator INSTANCE = new BeardMossTreeDecorator();
    public static final Codec<BeardMossTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);

    @Override
    public void place(Context context) {
        RandomSource random = context.random();
        LevelSimulatedReader level = context.level();
        for (BlockPos pos : context.logs()) {
            if (level.isStateAtPosition(pos.below(), BeardMossTreeDecorator::isAirOrLeaves)) {
                boolean flag = true;
                int rand1 = random.nextInt(3) + 1;
                for (int i = 0; i < rand1; i++) {
                    if (!level.isStateAtPosition(pos.below(i + 1), BeardMossTreeDecorator::isAirOrLeaves)) {
                        flag = false;
                        break;
                    }
                }
                if (!context.isAir(pos.below(rand1 + 1))) flag = false;
                if (flag) {
                    for (int i = 0; i < rand1; i++) {
                        context.setBlock(pos.below(i + 1), HorizonsBlocks.BEARD_MOSS_BLOCK.get().defaultBlockState().setValue(BeardMossBlockBlock.PERSISTENT, false));
                    }
                    int rand2 = random.nextInt(6) + 1;
                    for (int i = 0; i < rand2; i++) {
                        if (!context.isAir(pos.below(rand1 + i + 1))) {
                            if (i > 0) {
                                context.setBlock(pos.below(rand1 + i), HorizonsBlocks.BEARD_MOSS.get().defaultBlockState());
                            }
                            break;
                        }
                        BlockPos below = pos.below(rand1 + i + 1);
                        if (i == rand2 - 1) {
                            context.setBlock(below, HorizonsBlocks.BEARD_MOSS.get().defaultBlockState());
                        } else {
                            context.setBlock(below, HorizonsBlocks.BEARD_MOSS.get().defaultBlockState().setValue(BeardMossBlock.HALF, DoubleBlockHalf.UPPER));
                        }
                    }
                }
            }
        }
        for (BlockPos pos : context.leaves()) {
            if (random.nextInt(6) == 0) {
                if (level.isStateAtPosition(pos.below(), BeardMossTreeDecorator::isAirOrLeaves)) {
                    boolean flag = true;
                    int rand1 = random.nextInt(2) + 1;
                    for (int i = 0; i < rand1; i++) {
                        if (!level.isStateAtPosition(pos.below(i + 1), BeardMossTreeDecorator::isAirOrLeaves)) {
                            flag = false;
                            break;
                        }
                    }
                    if (!context.isAir(pos.below(rand1 + 1))) flag = false;
                    if (flag) {
                        for (int i = 0; i < rand1; i++) {
                            context.setBlock(pos.below(i + 1), HorizonsBlocks.BEARD_MOSS_BLOCK.get().defaultBlockState().setValue(BeardMossBlockBlock.PERSISTENT, false));
                        }
                        int rand2 = random.nextInt(4) + 1;
                        for (int i = 0; i < rand2; i++) {
                            if (!context.isAir(pos.below(rand1 + i + 1))) {
                                if (i > 0) {
                                    context.setBlock(pos.below(rand1 + i), HorizonsBlocks.BEARD_MOSS.get().defaultBlockState());
                                }
                                break;
                            }
                            BlockPos below = pos.below(rand1 + i + 1);
                            if (i == rand2 - 1) {
                                context.setBlock(below, HorizonsBlocks.BEARD_MOSS.get().defaultBlockState());
                            } else {
                                context.setBlock(below, HorizonsBlocks.BEARD_MOSS.get().defaultBlockState().setValue(BeardMossBlock.HALF, DoubleBlockHalf.UPPER));
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    protected TreeDecoratorType<BeardMossTreeDecorator> type() {
        return HorizonsFeatures.BEARD_MOSS.get();
    }

    private static boolean isAirOrLeaves(BlockState state) {
        return state.isAir() || state.is(BlockTags.LEAVES);
    }

}
