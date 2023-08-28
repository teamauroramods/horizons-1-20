package com.teamaurora.horizons.common.levelgen.feature;

import com.teamaurora.horizons.common.util.FeatureHelper;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class WaterMegaCypressTreeFeature extends AbstractHorizonsTreeFeature {

    @Override
    public BlockState getSapling() {
        return HorizonsBlocks.CYPRESS_SAPLING.get().defaultBlockState();
    }

    @Override
    public boolean doPlace(FeaturePlaceContext<TreeConfiguration> context) {
        RandomSource random = context.random();
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        TreeConfiguration config = context.config();
        int height = random.nextInt(7) + 18;
        boolean isBald = random.nextInt(15) == 0;

        int surfaceY = level.getHeightmapPos(Heightmap.Types.OCEAN_FLOOR, origin).getY();
        int waterY = level.getHeightmapPos(Heightmap.Types.WORLD_SURFACE, origin).getY();
        if (waterY <= surfaceY) return false;

        BlockPos position = new BlockPos(origin.getX(), waterY, origin.getZ());
        BlockPos bottom = new BlockPos(origin.getX(), surfaceY, origin.getZ());
        for (BlockPos pos2 : BlockPos.betweenClosed(bottom, bottom.offset(1, 0, 1))) {
            if (!FeatureHelper.isAirOrWaterOrLeaves(level.getBlockState(pos2)))
                return false;
        }

        // Underwater part of trunk
        for (int i = 0; i <= waterY - surfaceY; i++) {
            for (int x = -1; x <= 2; x++) {
                for (int z = -1; z <= 2; z++) {
                    if (i == 0 && level.isWaterAt(bottom.offset(x, -1, z))) {
                        return false;
                    }
                    this.addLog(bottom.offset(x, i, z));
                }
            }
        }

        // Above-water part of trunk
        for (int i = 1; i <= height; i++) {
            if (i <= 2) {
                for (int x = -1; x <= 2; x++) {
                    for (int z = -1; z <= 2; z++) {
                        if (!((x == -1 || x == 2) && (z == -1 || z == 2))) {
                            this.addLog(position.offset(x, i, z));
                        }
                    }
                }
            } else {
                this.addLog(position.above(i));
                this.addLog(position.offset(1, i, 0));
                this.addLog(position.offset(0, i, 1));
                this.addLog(position.offset(1, i, 1));
            }
        }

        // Branches
        int branches = random.nextInt(5) + 4;

        for (int i = 0; i < branches; i++) {
            int x = isBald ? random.nextInt(height - 5) + 7 : random.nextInt(height - 7) + 7;
            Direction dir = Direction.from2DDataValue(random.nextInt(4));
            if (dir == Direction.NORTH) {
                // min z, x varies
                this.addBranch(position.offset(random.nextInt(2), x, 0), dir, config, random);
            } else if (dir == Direction.EAST) {
                // max z, x varies
                this.addBranch(position.offset(1, x, random.nextInt(2)), dir, config, random);
            } else if (dir == Direction.SOUTH) {
                // max z, x varies
                this.addBranch(position.offset(random.nextInt(2), x, 1), dir, config, random);
            } else if (dir == Direction.WEST) {
                // min z, x varies
                this.addBranch(position.offset(0, x, random.nextInt(2)), dir, config, random);
            }
        }

        if (isBald) {
            // Decorate the top of the trunk if bald
            int variant = random.nextInt(4);
            switch (variant) {
                case 0 -> this.addLog(position.above(height + 1));
                case 1 -> this.addLog(position.offset(1, height + 1, 0));
                case 2 -> this.addLog(position.offset(0, height + 1, 1));
                case 3 -> this.addLog(position.offset(1, height + 1, 1));
            }
        } else {
            // Canopy
            this.canopyDisc1(position.above(height - 2));
            this.canopyDisc3Bottom(position.above(height - 1), random);
            this.canopyDisc3Top(position.above(height));
            this.canopyDisc1(position.above(height + 1));
        }
        return true;
    }

    private void addBranch(BlockPos pos, Direction dir, TreeConfiguration config, RandomSource random) {
        this.addAxisLog(pos.relative(dir), dir, config, random);
        this.addAxisLog(pos.relative(dir,2), dir, config, random);
        this.disc2H(pos.relative(dir,2), random);
        this.disc1(pos.relative(dir,2).above());
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
