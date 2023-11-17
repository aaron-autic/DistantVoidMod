package net.aaronautic.distantvoid;

import com.mojang.logging.LogUtils;
import net.aaronautic.distantvoid.block.ModBlocks;
import net.aaronautic.distantvoid.block.entity.ModBlockEntities;
import net.aaronautic.distantvoid.entity.ModEntities;
import net.aaronautic.distantvoid.entity.client.ShadowGolemRenderer;
import net.aaronautic.distantvoid.fluid.ModFluidTypes;
import net.aaronautic.distantvoid.fluid.ModFluids;
import net.aaronautic.distantvoid.item.ModCreativeModeTabs;
import net.aaronautic.distantvoid.item.ModItems;
import net.aaronautic.distantvoid.recipe.ModRecipes;
import net.aaronautic.distantvoid.screen.ModMenuTypes;
import net.aaronautic.distantvoid.screen.OreRefiningStationScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DistantVoidMod.MOD_ID)
public class DistantVoidMod {

    public static final String MOD_ID = "distantvoid";

    private static final Logger LOGGER = LogUtils.getLogger();

    public static ModConfig CONFIG;

    public DistantVoidMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModMenuTypes.register(modEventBus);


        ModRecipes.register(modEventBus);
        ModEntities.register(modEventBus);

        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);



        ModBlockEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);


    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

        // You can use SubscribeEvent and let the Event Bus discover methods to call
        @SubscribeEvent
        public void onServerStarting(ServerStartingEvent event){

        }

        // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
        @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
        public static class ClientModEvents {
            @SubscribeEvent
            public static void onClientSetup(FMLClientSetupEvent event) {
                MenuScreens.register(ModMenuTypes.ORE_REFINING_MENU.get(), OreRefiningStationScreen::new);

                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_MOLTEN_OBSCURITE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_MOLTEN_OBSCURITE.get(), RenderType.translucent());

                EntityRenderers.register(ModEntities.SHADOW_GOLEM.get(), ShadowGolemRenderer::new);

            }
        }
    }



