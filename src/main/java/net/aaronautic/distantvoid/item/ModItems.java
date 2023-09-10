package net.aaronautic.distantvoid.item;
import net.aaronautic.distantvoid.DistantVoidMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DistantVoidMod.MOD_ID);

    public static final RegistryObject<Item> OBSCURITE_INGOT = ITEMS.register("obscurite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OBSCURE_CHERRIES = ITEMS.register("obscure_cherries",
            () -> new Item(new Item.Properties().food(ModFoodProperties.OBSCURE_CHERRIES)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
