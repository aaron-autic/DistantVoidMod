package net.aaronautic.distantvoid.item;
import net.aaronautic.distantvoid.DistantVoidMod;
import net.aaronautic.distantvoid.entity.ModEntities;
import net.aaronautic.distantvoid.fluid.ModFluids;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
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

    public static final RegistryObject<Item> OBSCURITE_GEM = ITEMS.register("obscurite_gem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MOLTEN_OBSCURITE_BUCKET = ITEMS.register("molten_obscurite_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_OBSCURITE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> OBSCURITE_HELMET = ITEMS.register("obscurite_helmet",
            () -> new ArmorItem(ModArmorMaterials.OBSCURITE, ArmorItem.Type.HELMET,  new Item.Properties()));

    public static final RegistryObject<Item> OBSCURITE_CHESTPLATE = ITEMS.register("obscurite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.OBSCURITE, ArmorItem.Type.CHESTPLATE,  new Item.Properties()));

    public static final RegistryObject<Item> OBSCURITE_LEGGINGS = ITEMS.register("obscurite_leggings",
            () -> new ArmorItem(ModArmorMaterials.OBSCURITE, ArmorItem.Type.LEGGINGS,  new Item.Properties()));

    public static final RegistryObject<Item> OBSCURITE_BOOTS = ITEMS.register("obscurite_boots",
            () -> new ArmorItem(ModArmorMaterials.OBSCURITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> OBSCURITE_SWORD = ITEMS.register("obscurite_sword",
            () -> new SwordItem(ModToolTiers.OBSCURITE, 3, 3, new Item.Properties().fireResistant().durability(300)));

    public static final RegistryObject<Item> OBSCURITE_PICKAXE = ITEMS.register("obscurite_pickaxe",
            () -> new SwordItem(ModToolTiers.OBSCURITE, 2, 2, new Item.Properties().fireResistant().durability(300)));

    public static final RegistryObject<Item> OBSCURITE_SHOVEL= ITEMS.register("obscurite_shovel",
            () -> new ShovelItem(ModToolTiers.OBSCURITE, 2, 2, new Item.Properties().fireResistant().durability(300)));

    public static final RegistryObject<Item> OBSCURITE_AXE = ITEMS.register("obscurite_axe",
            () -> new AxeItem(ModToolTiers.OBSCURITE, 4, 2, new Item.Properties().fireResistant().durability(300)));

    public static final RegistryObject<Item> OBSCURITE_HOE = ITEMS.register("obscurite_hoe",
            () -> new HoeItem(ModToolTiers.OBSCURITE, 2, 3, new Item.Properties().fireResistant().durability(300)));

    public static final RegistryObject<Item> SHADOW_GOLEM_SPAWN_EGG = ITEMS.register("shadow_golem_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SHADOW_GOLEM, 000000, 000000, new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
