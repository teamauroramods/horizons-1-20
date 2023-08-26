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

public class WaterCypressTreeFeature extends AbstractHorizonsTreeFeature {

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
        int height = random.nextInt(5) + 12;
        boolean isBald = random.nextInt(15) == 0;

        int surfaceY = level.getHeightmapPos(Heightmap.Types.OCEAN_FLOOR, origin).getY();
        int waterY = level.getHeightmapPos(Heightmap.Types.WORLD_SURFACE, origin).getY();
        if (waterY <= surfaceY) return false;

        BlockPos position = new BlockPos(origin.getX(), waterY, origin.getZ());
        BlockPos bottom = new BlockPos(origin.getX(), surfaceY, origin.getZ());
        if (!FeatureHelper.isAirOrWaterOrLeaves(level.getBlockState(bottom))) return false;

        // Underwater part of trunk
        for (int i = 0; i <= waterY - surfaceY; i++) {
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
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
                for (int x = -1; x <= 1; x++) {
                    for (int z = -1; z <= 1; z++) {
                        if (x == 0 || z == 0) {
                            this.addLog(position.offset(x, i, z));
                        }
                    }
                }
            } else {
                this.addLog(position.above(i));
            }
        }

        // Branches
        int branches = random.nextInt(4) + 1;
        if (branches == 4) branches = 2;

        for (int i = 0; i < branches; i++) {
            Direction dir = Direction.from2DDataValue(random.nextInt(4));
            int x = isBald ? random.nextInt(height - 3) + 6 : random.nextInt(height - 5) + 6;
            this.addAxisLog(position.above(x).relative(dir), dir, config, random);
            this.addAxisLog(position.above(x).relative(dir, 2), dir, config, random);
            this.disc2H(position.above(x).relative(dir, 2), random);
            this.disc1(position.above(x + 1).relative(dir, 2));
        }

        // Canopy
        if (isBald) {
            this.disc1(position.above(height - 1));
            this.disc3H(position.above(height), random);
            this.disc2(position.above(height + 1));
        }
        return true;
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

    private void disc3H(BlockPos origin, RandomSource random) {
        for (int x = -3; x <= 3; x++) {
            for (int z = -3; z <= 3; z++) {
                if (Math.abs(x) != 3 || Math.abs(z) != 3) {
                    this.addFoliage(origin.offset(x, 0, z));
                    if (random.nextInt(3) == 0) {
                        this.addFoliage(origin.offset(x, -1, z));
                        if (random.nextBoolean()) {
                            this.addFoliage(origin.offset(x, -2, z));
                        }
                    }
                }
            }
        }
    }
}
