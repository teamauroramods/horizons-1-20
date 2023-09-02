package com.teamaurora.horizons.common.levelgen.treedecorators;

import com.mojang.serialization.Codec;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

/**
 * @author rose_
 */
public class SparseCypressKneesTreeDecorator extends TreeDecorator {
    public static final SparseCypressKneesTreeDecorator INSTANCE = new SparseCypressKneesTreeDecorator();
    public static final Codec<SparseCypressKneesTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);

    @Override
    public void place(Context context) {
        CypressKneesTreeDecorator.placeFeature(context, random -> random.nextInt(6) == 0);
    }

    @Override
    protected TreeDecoratorType<SparseCypressKneesTreeDecorator> type() {
        return HorizonsFeatures.CYPRESS_KNEES_SPARSE.get();
    }
}
