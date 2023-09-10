package net.aaronautic.distantvoid.block;

import net.aaronautic.distantvoid.DistantVoidMod;
import net.aaronautic.distantvoid.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.security.PrivateKey;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DistantVoidMod.MOD_ID);

    public static final RegistryObject<Block> OBSCURITE_BLOCK = registerBlock("obscurite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));



    public static final RegistryObject<Block> VOIDSTRUCK_PLANKS = registerBlock("voidstruck_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));

    public static final RegistryObject<Block> VOIDSTRUCK_STAIRS = registerBlock("voidstruck_stairs",
            () -> new StairBlock(() -> ModBlocks.VOIDSTRUCK_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.WARPED_STAIRS)));
    public static final RegistryObject<Block> VOIDSTRUCK_SLAB = registerBlock("voidstruck_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_SLAB)));

    public static final RegistryObject<Block> VOIDSTRUCK_PRESSURE_PLATE = registerBlock("voidstruck_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.WARPED_PRESSURE_PLATE), BlockSetType.WARPED));
    public static final RegistryObject<Block> VOIDSTRUCK_BUTTON = registerBlock("voidstruck_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_BUTTON), BlockSetType.WARPED, 2, true));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;

    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
