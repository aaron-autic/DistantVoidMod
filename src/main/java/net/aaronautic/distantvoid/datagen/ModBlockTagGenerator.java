package net.aaronautic.distantvoid.datagen;

import net.aaronautic.distantvoid.DistantVoidMod;
import net.aaronautic.distantvoid.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DistantVoidMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.OBSCURITE_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.VOIDSTRUCK_BUTTON.get(),
                        ModBlocks.VOIDSTRUCK_PRESSURE_PLATE.get(),
                        ModBlocks.VOIDSTRUCK_FENCE_GATE.get(),
                        ModBlocks.VOIDSTRUCK_FENCE.get(),
                        ModBlocks.VOIDSTRUCK_SLAB.get(),
                        ModBlocks.VOIDSTRUCK_STAIRS.get(),
                        ModBlocks.VOIDSTRUCK_PLANKS.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.VOIDSTRUCK_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.VOIDSTRUCK_FENCE_GATE.get());



    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
