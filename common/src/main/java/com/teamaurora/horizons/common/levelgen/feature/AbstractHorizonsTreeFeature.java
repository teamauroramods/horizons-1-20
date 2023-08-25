package com.teamaurora.horizons.common.levelgen.feature;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BitSetDiscreteVoxelShape;
import net.minecraft.world.phys.shapes.DiscreteVoxelShape;

import java.util.*;
import java.util.function.BiConsumer;

public abstract class AbstractHorizonsTreeFeature extends Feature<TreeConfiguration> {

    protected Set<BlockPos> logPositions;
    protected Set<BlockPos> foliagePositions;
    protected Map<BlockPos, BlockState> specialLogPositions;
    protected Map<BlockPos, BlockState> specialFoliagePositions;

    protected boolean placeDirt;

    protected AbstractHorizonsTreeFeature(boolean placeDirt, Codec<TreeConfiguration> config) {
        super(config);
        this.placeDirt = placeDirt;
    }

    @Override
    public boolean place(FeaturePlaceContext<TreeConfiguration> context) {
        TreeConfiguration config = context.config();
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos origin = context.origin();

        this.logPositions = new HashSet<>();
        this.foliagePositions = new HashSet<>();
        this.specialLogPositions = new HashMap<>();
        this.specialFoliagePositions = new HashMap<>();

        if (this.canSurvive(level, origin)) {
            this.doPlace(context);

            for (BlockPos logPos : this.logPositions) {
                if (!TreeFeature.validTreePos(level, logPos) || logPos.getY() > level.getMaxBuildHeight())
                    return false;
            }

            for (BlockPos foliagePos : this.foliagePositions) {
                if (!TreeFeature.validTreePos(level, foliagePos) || foliagePos.getY() > level.getMaxBuildHeight())
                    return false;
            }

            this.doMidPlace(context);

            this.logPositions.forEach(logPos -> {
                level.setBlock(logPos, this.specialLogPositions.getOrDefault(logPos, config.trunkProvider.getState(random, logPos)), 19);
                if (logPos.getY() == origin.getY() && this.placeDirt) {
                    setDirtAt(level, random, logPos.below(), config);
                }
            });
            this.foliagePositions.forEach(foliagePos -> {
                if (TreeFeature.validTreePos(level, foliagePos)) {
                    BlockState state = this.specialFoliagePositions.getOrDefault(foliagePos, config.foliageProvider.getState(random, foliagePos));

                    if (state.hasProperty(BlockStateProperties.WATERLOGGED)) {
                        state = state.setValue(BlockStateProperties.WATERLOGGED, level.isFluidAtPosition(foliagePos, (fluidState) -> fluidState.isSourceOfType(Fluids.WATER)));
                    }

                    if (!state.isAir()) {
                        level.setBlock(foliagePos, state, 19);
                    }
                }
            });

            Set<BlockPos> decorationPositions = new HashSet<>();
            BiConsumer<BlockPos, BlockState> decorationSetter = (decorationPos, state) -> {
                decorationPositions.add(decorationPos.immutable());
                level.setBlock(decorationPos, state, 19);
            };

            if (!config.decorators.isEmpty()) {
                TreeDecorator.Context decoratorContext = new TreeDecorator.Context(level, decorationSetter, random, this.logPositions, this.foliagePositions, new HashSet<>());
                config.decorators.forEach((decorator) -> decorator.place(decoratorContext));
            }

            this.doPostPlace(context);

            return BoundingBox.encapsulatingPositions(Iterables.concat(this.logPositions, this.foliagePositions, decorationPositions)).map((boundingBox) -> {
                DiscreteVoxelShape shape = updateLeaves(level, boundingBox, this.logPositions, decorationPositions, Set.of());
                StructureTemplate.updateShapeAtEdge(level, 3, shape, boundingBox.minX(), boundingBox.minY(), boundingBox.minZ());
                return true;
            }).orElse(false);
        } else {
            return false;
        }
    }

    private static DiscreteVoxelShape updateLeaves(LevelAccessor levelAccessor, BoundingBox boundingBox, Set<BlockPos> set, Set<BlockPos> set2, Set<BlockPos> set3) {
        DiscreteVoxelShape discreteVoxelShape = new BitSetDiscreteVoxelShape(boundingBox.getXSpan(), boundingBox.getYSpan(), boundingBox.getZSpan());
        int i = 7;
        List<Set<BlockPos>> list = Lists.newArrayList();

        for(int j = 0; j < 7; ++j) {
            list.add(Sets.newHashSet());
        }

        for(BlockPos blockPos : Lists.newArrayList(Sets.union(set2, set3))) {
            if (boundingBox.isInside(blockPos)) {
                discreteVoxelShape.fill(blockPos.getX() - boundingBox.minX(), blockPos.getY() - boundingBox.minY(), blockPos.getZ() - boundingBox.minZ());
            }
        }

        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        int k = 0;
        list.get(0).addAll(set);

        while(true) {
            while(k >= 7 || !((Set)list.get(k)).isEmpty()) {
                if (k >= 7) {
                    return discreteVoxelShape;
                }
                Iterator<BlockPos> iterator = ((Set)list.get(k)).iterator();
                BlockPos blockPos2 = iterator.next();
                iterator.remove();
                if (boundingBox.isInside(blockPos2)) {
                    if (k != 0) {
                        BlockState blockState = levelAccessor.getBlockState(blockPos2);
                        setBlockKnownShape(levelAccessor, blockPos2, blockState.setValue(BlockStateProperties.DISTANCE, Integer.valueOf(k)));
                    }

                    discreteVoxelShape.fill(blockPos2.getX() - boundingBox.minX(), blockPos2.getY() - boundingBox.minY(), blockPos2.getZ() - boundingBox.minZ());

                    for(Direction direction : Direction.values()) {
                        mutableBlockPos.setWithOffset(blockPos2, direction);
                        if (boundingBox.isInside(mutableBlockPos)) {
                            int l = mutableBlockPos.getX() - boundingBox.minX();
                            int m = mutableBlockPos.getY() - boundingBox.minY();
                            int n = mutableBlockPos.getZ() - boundingBox.minZ();
                            if (!discreteVoxelShape.isFull(l, m, n)) {
                                BlockState blockState2 = levelAccessor.getBlockState(mutableBlockPos);
                                OptionalInt optionalInt = LeavesBlock.getOptionalDistanceAt(blockState2);
                                if (!optionalInt.isEmpty()) {
                                    int o = Math.min(optionalInt.getAsInt(), k + 1);
                                    if (o < 7) {
                                        list.get(o).add(mutableBlockPos.immutable());
                                        k = Math.min(k, o);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            ++k;
        }
    }

    private static void setBlockKnownShape(LevelWriter levelWriter, BlockPos blockPos, BlockState blockState) {
        levelWriter.setBlock(blockPos, blockState, 19);
    }

    public abstract BlockState getSapling();

    public boolean canSurvive(WorldGenLevel level, BlockPos pos) {
        return this.getSapling().canSurvive(level, pos);
    }

    public abstract void doPlace(FeaturePlaceContext<TreeConfiguration> context);

    public void doMidPlace(FeaturePlaceContext<TreeConfiguration> context) {
    }

    public void doPostPlace(FeaturePlaceContext<TreeConfiguration> context) {
    }

    public void addLog(BlockPos pos) {
        this.logPositions.add(pos.immutable());
    }

    public void addAxisLog(BlockPos pos, Direction.Axis axis, TreeConfiguration config, RandomSource random) {
        BlockState state = config.trunkProvider.getState(random, pos);
        if (state.hasProperty(BlockStateProperties.AXIS)) {
            this.addSpecialLog(pos, state.setValue(BlockStateProperties.AXIS, axis));
        } else {
            this.addLog(pos);
        }
    }

    public void addAxisLog(BlockPos pos, Direction direction, TreeConfiguration config, RandomSource random) {
        this.addAxisLog(pos, direction.getAxis(), config, random);
    }

    public void addSpecialLog(BlockPos pos, BlockState state) {
        this.addLog(pos);
        this.specialLogPositions.put(pos.immutable(), state);
    }

    public void addFoliage(BlockPos pos) {
        this.foliagePositions.add(pos.immutable());
    }

    public void addSpecialFoliage(BlockPos pos, BlockState state) {
        this.addFoliage(pos);
        this.specialFoliagePositions.put(pos.immutable(), state);
    }

    public static void setDirtAt(WorldGenLevel level, RandomSource random, BlockPos pos, TreeConfiguration config) {
        if (config.forceDirt || level.isStateAtPosition(pos, state -> state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.MYCELIUM))) {
            level.setBlock(pos, config.dirtProvider.getState(random, pos), 19);
        }
    }
}
