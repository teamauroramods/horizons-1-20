package com.teamaurora.horizons.common.levelgen.feature;

import com.mojang.serialization.Codec;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class CypressTreeFeature extends AbstractHorizonsTreeFeature {

    public CypressTreeFeature() {
        super(true, TreeConfiguration.CODEC);
    }

    @Override
    public BlockState getSapling() {
        return HorizonsBlocks.CYPRESS_SAPLING.get().defaultBlockState();
    }

    @Override
    public void doPlace(FeaturePlaceContext<TreeConfiguration> context) {
        RandomSource random = context.random();
        BlockPos origin = context.origin();
        TreeConfiguration config = context.config();
        int height = random.nextInt(5) + 9;
        boolean isBald = random.nextInt(15) == 0;

        // Trunk
        for (int i = 0; i <= height; i++) {
            this.addLog(origin.above(i));
        }

        int branches = random.nextInt(4) + 1;
        if (branches == 4) branches = 2;

        // Place branches
        for (int i = 0; i < branches; i++) {
            Direction dir = Direction.from2DDataValue(random.nextInt(4));
            int x = isBald ? random.nextInt(height - 3) + 3 : random.nextInt(height - 5) + 3;
            this.addAxisLog(origin.above(x).relative(dir), dir, config, random);
            this.addAxisLog(origin.above(x).relative(dir, 2), dir, config, random);
            this.disc2H(origin.above(x).relative(dir, 2), random);
            this.disc1(origin.above(x + 1).relative(dir, 2));
        }

        // Canopy
        if (!isBald) {
            this.disc1(origin.above(height - 1));
            this.disc3H(origin.above(height), random);
            this.disc2(origin.above(height + 1));
        }
    }

    private void disc1(BlockPos origin) {
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                if (Math.abs(x) != 1 || Math.abs(z) != 1) {
                    this.addFoliage(origin.offset(x, 0, z));
                }
            }
        }
    }

    private void disc2(BlockPos origin) {
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                if (Math.abs(x) != 2 || Math.abs(z) != 2) {
                    this.addFoliage(origin.offset(x, 0, z));
                }
            }
        }
    }

    private void disc2H(BlockPos origin, RandomSource rand) {
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                if (Math.abs(x) != 2 || Math.abs(z) != 2) {
                    this.addFoliage(origin.offset(x, 0, z));
                    if (rand.nextInt(3) == 0) {
                        this.addFoliage(origin.offset(x, -1, z));
                        if (rand.nextInt(3) == 0) {
                            this.addFoliage(origin.offset(x, -2, z));
                        }
                    }
                }
            }
        }
    }

    private void disc3H(BlockPos origin, RandomSource rand) {
        for (int x = -3; x <= 3; x++) {
            for (int z = -3; z <= 3; z++) {
                if (Math.abs(x) != 3 || Math.abs(z) != 3) {
                    this.addFoliage(origin.offset(x, 0, z));
                    if (rand.nextInt(3) == 0) {
                        this.addFoliage(origin.offset(x, -1, z));
                        if (rand.nextBoolean()) {
                            this.addFoliage(origin.offset(x, -2, z));
                        }
                    }
                }
            }
        }
    }
}
