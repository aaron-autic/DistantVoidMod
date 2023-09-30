package net.aaronautic.distantvoid.recipe;

import net.aaronautic.distantvoid.DistantVoidMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, DistantVoidMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<OreRefiningRecipe>> ORE_REFINING_SERIALIZER =
            SERIALIZERS.register("ore_refining", () -> OreRefiningRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }


}
