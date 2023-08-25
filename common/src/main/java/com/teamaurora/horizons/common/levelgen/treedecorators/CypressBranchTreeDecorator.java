package com.teamaurora.horizons.common.levelgen.treedecorators;

import com.mojang.serialization.Codec;
import com.teamaurora.horizons.common.block.CypressBranchBlock;
import com.teamaurora.horizons.common.util.FeatureHelper;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.function.BiConsumer;

public class CypressBranchTreeDecorator extends TreeDecorator {
    public static final Codec<CypressBranchTreeDecorator> CODEC;
    public static final CypressBranchTreeDecorator INSTANCE = new CypressBranchTreeDecorator();

    @Override
    protected TreeDecoratorType<CypressBranchTreeDecorator> type() {
        return HorizonsFeatures.CYPRESS_BRANCH_DECORATOR.get();
    }

    static {
        CODEC = Codec.unit(() -> INSTANCE);
    }

    @Override
    public void place(Context context) {
        RandomSource random = context.random();
        LevelSimulatedReader level = context.level();
        for (BlockPos pos : context.logs()) {
            if (true) {
                Direction dir = Direction.from2DDataValue(random.nextInt(4));
                if (level.isStateAtPosition(pos.relative(dir), BlockState::isAir)) {
                    context.setBlock(pos.relative(dir), HorizonsBlocks.CYPRESS_BRANCH.get().defaultBlockState().setValue(CypressBranchBlock.FACING, dir.getOpposite()).setValue(CypressBranchBlock.AGE, 2));
                }
            }
        }
    }
}