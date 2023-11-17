package net.aaronautic.distantvoid.fluid;

import net.aaronautic.distantvoid.DistantVoidMod;
import net.aaronautic.distantvoid.block.ModBlocks;
import net.aaronautic.distantvoid.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, DistantVoidMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_MOLTEN_OBSCURITE = FLUIDS.register("molten_obscurite_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_OBSCURITE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_OBSCURITE = FLUIDS.register("flowing_molten_obscurite_fluid",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_OBSCURITE_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties MOLTEN_OBSCURITE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_OBSCURITE_FLUID_TYPE, SOURCE_MOLTEN_OBSCURITE, FLOWING_MOLTEN_OBSCURITE)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModBlocks.MOLTEN_OBSCURITE_BLOCK)
            .bucket(ModItems.MOLTEN_OBSCURITE_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
