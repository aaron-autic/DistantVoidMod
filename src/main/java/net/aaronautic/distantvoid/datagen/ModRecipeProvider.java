package net.aaronautic.distantvoid.datagen;

import net.aaronautic.distantvoid.block.ModBlocks;
import net.aaronautic.distantvoid.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OBSCURITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.OBSCURITE_INGOT.get())
                .unlockedBy("has_obscurite_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.OBSCURITE_INGOT.get()).build()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OBSCURITE_INGOT.get(), 9)
                .requires(ModBlocks.OBSCURITE_BLOCK.get())
                .unlockedBy("has_obscurite_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.OBSCURITE_BLOCK.get()).build()))
                .save(pWriter);




    }
}
