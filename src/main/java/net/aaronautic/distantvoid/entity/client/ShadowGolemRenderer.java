package net.aaronautic.distantvoid.entity.client;

import net.aaronautic.distantvoid.DistantVoidMod;
import net.aaronautic.distantvoid.entity.custom.ShadowGolemEntity;
import net.aaronautic.distantvoid.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ShadowGolemRenderer extends MobRenderer<ShadowGolemEntity, ShadowGolemModel<ShadowGolemEntity>> {
    private static final ResourceLocation SHADOW_GOLEM_LOCATION = new ResourceLocation(DistantVoidMod.MOD_ID, "textures/entity/shadow_golem.png");

    public ShadowGolemRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ShadowGolemModel<>(pContext.bakeLayer(ModModelLayers.SHADOW_GOLEM_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(ShadowGolemEntity pEntity) {
        return SHADOW_GOLEM_LOCATION;
    }
}
