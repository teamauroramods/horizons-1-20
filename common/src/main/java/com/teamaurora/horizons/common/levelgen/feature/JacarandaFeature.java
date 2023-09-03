package com.teamaurora.horizons.common.levelgen.feature;

import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class JacarandaFeature extends AbstractHorizonsTreeFeature {

    @Override
    public BlockState getSapling() {
        return HorizonsBlocks.JACARANDA_SAPLING.get().defaultBlockState();
    }

    @Override
    public boolean doPlace(FeaturePlaceContext<TreeConfiguration> context) {
        RandomSource random = context.random();
        BlockPos origin = context.origin();
        TreeConfiguration config = context.config();
        int height = random.nextInt(4) + 4;

        // Trunk
        for (int i = 0; i <= height; i++) {
            this.addLog(origin.above(i));
        }

        // Branches
        for (int i = 2; i <= height - 2; i++) {
            Direction dir = Direction.from2DDataValue(random.nextInt(4));
            addBranch(origin.above(i), dir, config, random);
        }
        addCanopy(origin.above(height), random);

        return true;
    }

    private void addBranch(BlockPos pos, Direction dir, TreeConfiguration config, RandomSource rand) {
        this.addLog(pos.relative(dir));
        int i = rand.nextInt(3) - 1;
        BlockPos b2pos = pos.relative(dir, 2).relative(dir.getClockWise(), i);
        this.addLog(b2pos);
        addCanopy(b2pos, rand);
    }

    private void addCanopy(BlockPos pos, RandomSource rand) {
        cir1(pos.below(), rand);
        cir2(pos, rand);
        cir2(pos.above(), rand);
        cir1(pos.above(2), rand);
    }

    private void cir1(BlockPos pos, RandomSource rand) {
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                if (Math.abs(x) != 1 || Math.abs(z) != 1) {
                    this.addFoliage(pos.offset(x, 0, z));
                }
            }
        }
    }

    private void cir2(BlockPos pos, RandomSource rand) {
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                if (Math.abs(x) != 2 || Math.abs(z) != 2) {
                    this.addFoliage(pos.offset(x, 0, z));
                }
            }
        }
    }
}

