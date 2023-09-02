package com.teamaurora.horizons.common.levelgen.feature;

import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

/**
 * @author exoplanetary
 * @author ebo2022
 */
public class MegaCypressTreeFeature extends AbstractHorizonsTreeFeature {

    @Override
    public BlockState getSapling() {
        return HorizonsBlocks.CYPRESS_SAPLING.get().defaultBlockState();
    }

    @Override
    public boolean doPlace(FeaturePlaceContext<TreeConfiguration> context) {
        RandomSource random = context.random();
        BlockPos origin = context.origin();
        TreeConfiguration config = context.config();
        int height = random.nextInt(7) + 15;
        boolean isBald = random.nextInt(15) == 0;

        // Trunk
        for (int i = 0; i <= height; i++) {
            this.addLog(origin.above(i));
            this.addLog(origin.offset(1, i, 0));
            this.addLog(origin.offset(0, i, 1));
            this.addLog(origin.offset(1, i, 1));
        }

        // Branches
        int branches = random.nextInt(5) + 4;

        for (int i = 0; i < branches; i++) {
            int x = isBald ? random.nextInt(height - 5) + 4 : random.nextInt(height - 7) + 4;
            Direction dir = Direction.from2DDataValue(random.nextInt(4));
            if (dir == Direction.NORTH) {
                // min z, x varies
                this.addBranch(origin.offset(random.nextInt(2), x, 0), dir, config, random);
            } else if (dir == Direction.EAST) {
                // max z, x varies
                this.addBranch(origin.offset(1, x, random.nextInt(2)), dir, config, random);
            } else if (dir == Direction.SOUTH) {
                // max z, x varies
                this.addBranch(origin.offset(random.nextInt(2), x, 1), dir, config, random);
            } else if (dir == Direction.WEST) {
                // min z, x varies
                this.addBranch(origin.offset(0, x, random.nextInt(2)), dir, config, random);
            }
        }

        if (isBald) {
            // Decorate the top of the trunk if bald
            int variant = random.nextInt(4);
            switch (variant) {
                case 0 -> this.addLog(origin.above(height + 1));
                case 1 -> this.addLog(origin.offset(1, height + 1, 0));
                case 2 -> this.addLog(origin.offset(0, height + 1, 1));
                case 3 -> this.addLog(origin.offset(1, height + 1, 1));
            }
        } else {
            // Canopy
            this.canopyDisc1(origin.above(height - 2));
            this.canopyDisc3Bottom(origin.above(height - 1), random);
            this.canopyDisc3Top(origin.above(height));
            this.canopyDisc1(origin.above(height + 1));
        }
        return true;
    }

    private void addBranch(BlockPos pos, Direction dir, TreeConfiguration config, RandomSource random) {
        this.addAxisLog(pos.relative(dir), dir, config, random);
        this.addAxisLog(pos.relative(dir, 2), dir, config, random);
        this.disc2H(pos.relative(dir, 2), random);
        this.disc1(pos.relative(dir, 2).above());
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

    private void disc2H(BlockPos origin, RandomSource random) {
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                if (Math.abs(x) != 2 || Math.abs(z) != 2) {
                    this.addFoliage(origin.offset(x, 0, z));
                    if (random.nextInt(3) == 0) {
                        this.addFoliage(origin.offset(x, -1, z));
                        if (random.nextInt(3) == 0) {
                            this.addFoliage(origin.offset(x, -2, z));
                        }
                    }
                }
            }
        }
    }

    private void canopyDisc1(BlockPos origin) {
        for (int x = -1; x <= 2; x++) {
            for (int z = -1; z <= 2; z++) {
                if (!((x == -1 || x == 2) && (z == -1 || z == 2))) {
                    this.addFoliage(origin.offset(x, 0, z));
                }
            }
        }
    }

    private void canopyDisc3Top(BlockPos origin) {
        for (int x = -3; x <= 4; x++) {
            for (int z = -3; z <= 4; z++) {
                if (!((x <= -2 || x >= 3) && (z <= -2 || z >= 3)) || ((x == -2 || x == 3) && (z == -2 || z == 3))) {
                    this.addFoliage(origin.offset(x, 0, z));
                }
            }
        }
    }

    private void canopyDisc3Bottom(BlockPos origin, RandomSource random) {
        for (int x = -3; x <= 4; x++) {
            for (int z = -3; z <= 4; z++) {
                if (!((x == -3 || x == 4) && (z == -3 || z == 4))) {
                    this.addFoliage(origin.offset(x, 0, z));
                    if (random.nextBoolean()) {
                        this.addFoliage(origin.offset(x, -1, z));
                        if (random.nextInt(3) != 0) {
                            this.addFoliage(origin.offset(x, -2, z));
                            if (random.nextBoolean()) {
                                this.addFoliage(origin.offset(x, -3, z));
                            }
                        }
                    }
                }
            }
        }
    }
}
