package net.aaronautic.distantvoid.block;

import net.aaronautic.distantvoid.DistantVoidMod;
import net.aaronautic.distantvoid.block.custom.ModFlammableRotatedPillarBlock;
import net.aaronautic.distantvoid.block.custom.OreRefiningStationBlock;
import net.aaronautic.distantvoid.fluid.ModFluids;
import net.aaronautic.distantvoid.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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

    public static final RegistryObject<Block> VOIDSTRUCK_FENCE = registerBlock("voidstruck_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_FENCE)));

    public static final RegistryObject<Block> VOIDSTRUCK_FENCE_GATE = registerBlock("voidstruck_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));



    public static final RegistryObject<Block> VOIDSTRUCK_LOG = registerBlock("voidstruck_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_STEM)));

    public static final RegistryObject<Block> VOIDSTRUCK_WOOD = registerBlock("voidstruck_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_HYPHAE)));

    public static final RegistryObject<Block> STRIPPED_VOIDSTRUCK_LOG = registerBlock("stripped_voidstruck_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_WARPED_STEM)));

    public static final RegistryObject<Block> STRIPPED_VOIDSTRUCK_WOOD = registerBlock("stripped_voidstruck_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_WARPED_HYPHAE)));




    public static final RegistryObject<Block> ORE_REFINING_STATION = registerBlock("ore_refining_station",
            () -> new OreRefiningStationBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));




    public static final RegistryObject<LiquidBlock> MOLTEN_OBSCURITE_BLOCK = BLOCKS.register("molten_obscurite_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_OBSCURITE, BlockBehaviour.Properties.copy(Blocks.LAVA).noLootTable()));







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
