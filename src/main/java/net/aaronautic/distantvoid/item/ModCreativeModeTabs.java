package net.aaronautic.distantvoid.item;

import net.aaronautic.distantvoid.block.ModBlocks;
import net.aaronautic.distantvoid.DistantVoidMod;
import net.aaronautic.distantvoid.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DistantVoidMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DISTANT_VOID_TAB = CREATIVE_MODE_TABS.register("distant_void_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.OBSCURITE_INGOT.get()))
                    .title(Component.translatable("creativetab.distant_void_tab"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.OBSCURITE_INGOT.get());
                        output.accept(ModItems.OBSCURITE_GEM.get());
                        output.accept(ModBlocks.OBSCURITE_BLOCK.get());
                        output.accept(ModItems.OBSCURE_CHERRIES.get());
                        output.accept(ModBlocks.VOIDSTRUCK_PLANKS.get());
                        output.accept(ModBlocks.VOIDSTRUCK_STAIRS.get());
                        output.accept(ModBlocks.VOIDSTRUCK_SLAB.get());
                        output.accept(ModBlocks.VOIDSTRUCK_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.VOIDSTRUCK_BUTTON.get());
                        output.accept(ModBlocks.VOIDSTRUCK_FENCE.get());
                        output.accept(ModBlocks.VOIDSTRUCK_FENCE_GATE.get());
                        output.accept(ModBlocks.ORE_REFINING_STATION.get());
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
