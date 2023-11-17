package net.aaronautic.distantvoid.fluid;

import net.aaronautic.distantvoid.DistantVoidMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, DistantVoidMod.MOD_ID);


    public static final RegistryObject<FluidType> MOLTEN_OBSCURITE_FLUID_TYPE = registerFluidType("molten_obscurite_fluid",
            new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL, 330062,
                    new Vector3f(66f / 255f, 24f / 255f, 201f / 255f),
                    FluidType.Properties.create().lightLevel(14).viscosity(5).density(15).temperature(15)));



    private static RegistryObject<FluidType> registerFluidType(String name, FluidType fluidType) {
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus){
        FLUID_TYPES.register(eventBus);
    }
}
