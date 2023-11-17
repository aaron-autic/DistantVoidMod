package net.aaronautic.distantvoid.event;

import net.aaronautic.distantvoid.DistantVoidMod;
import net.aaronautic.distantvoid.entity.ModEntities;
import net.aaronautic.distantvoid.entity.client.ShadowGolemModel;
import net.aaronautic.distantvoid.entity.custom.ShadowGolemEntity;
import net.aaronautic.distantvoid.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DistantVoidMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.SHADOW_GOLEM_LAYER, ShadowGolemModel::createBodyLayer);
    }

    @SubscribeEvent

    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SHADOW_GOLEM.get(), ShadowGolemEntity.createAttributes().build());

    }
}
