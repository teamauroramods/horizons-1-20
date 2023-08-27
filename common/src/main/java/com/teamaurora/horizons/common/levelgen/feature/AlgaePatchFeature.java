package com.teamaurora.horizons.common.levelgen.feature;

import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

/**
 * @author rose_
 */
public class AlgaePatchFeature extends Feature<NoneFeatureConfiguration> {

    public AlgaePatchFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource rand = context.random();
        BlockState state = HorizonsBlocks.ALGAE.get().defaultBlockState();
        boolean generated = false;

        for (int x = -5; x <= 5; ++x)
            for (int z = -5; z <= 5; ++z)
                for (int y = -1; y <= 1; ++y)
                    if (x == 0 && z == 0 || (x + z == 0 || x - z == 0 ? rand.nextBoolean() : (Mth.abs(x + z) < 5 && Mth.abs(x - z) < 5) ? rand.nextInt(3) > 0 : rand.nextInt(8) == 0))
                        generated = place(state, level, origin.offset(x, y, z));

        return generated;
    }

    private static boolean place(BlockState state, WorldGenLevel level, BlockPos pos) {
        if (level.isEmptyBlock(pos) && pos.getY() < level.getMaxBuildHeight() && state.canSurvive(level, pos)) {
            level.setBlock(pos, state,2);
            return true;
        }

        return false;
    }

}