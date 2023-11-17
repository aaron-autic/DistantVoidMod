package net.aaronautic.distantvoid.datagen;

import net.aaronautic.distantvoid.DistantVoidMod;
import net.aaronautic.distantvoid.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future,
                               CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, completableFuture, DistantVoidMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.OBSCURITE_HELMET.get(),
                       ModItems.OBSCURITE_CHESTPLATE.get(),
                       ModItems.OBSCURITE_LEGGINGS.get(),
                       ModItems.OBSCURITE_BOOTS.get());


    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
