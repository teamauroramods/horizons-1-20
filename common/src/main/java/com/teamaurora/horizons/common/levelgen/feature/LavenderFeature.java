package com.teamaurora.horizons.common.levelgen.feature;

import com.teamaurora.horizons.common.block.LavenderBlock;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

/**
 * @author rose_
 * @author JustinPlayzz
 */
public class LavenderFeature extends Feature<NoneFeatureConfiguration> {

    public LavenderFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
        BlockPos blockPos = featurePlaceContext.origin();
        RandomSource random = featurePlaceContext.random();
        WorldGenLevel level = featurePlaceContext.level();
        boolean generated = false;

        for (BlockPos pos : BlockPos.betweenClosed(blockPos.offset(-6, -6, -6), blockPos.offset(6, 6, 6)))
            if (blockPos.closerThan(pos, 6.0) && isAir(level, pos))
                if (blockPos.closerThan(pos, 3.0)) {
                    if (random.nextBoolean() && HorizonsBlocks.LAVENDER.get().defaultBlockState().canSurvive(level, pos)) {
                        level.setBlock(pos, HorizonsBlocks.LAVENDER.get().defaultBlockState().setValue(LavenderBlock.AGE, 2), 2);
                        generated = true;
                    }
                } else if (random.nextInt(3) == 0 && HorizonsBlocks.TALL_LAVENDER.get().defaultBlockState().canSurvive(level, pos) && isAir(level, pos.above())) {
                    if (random.nextInt(4) == 0)
                        level.setBlock(pos.below(), Blocks.COARSE_DIRT.defaultBlockState(), 2);

                    DoublePlantBlock.placeAt(level, HorizonsBlocks.TALL_LAVENDER.get().defaultBlockState(), pos, 2);
                    generated = true;
                }

        return generated;
    }


    private static boolean isAir(LevelSimulatedReader levelSimulatedReader, BlockPos blockPos) {
        return levelSimulatedReader.isStateAtPosition(blockPos, BlockBehaviour.BlockStateBase::isAir);
    }

}
