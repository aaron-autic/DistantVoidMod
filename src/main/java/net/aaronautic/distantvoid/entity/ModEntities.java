package net.aaronautic.distantvoid.entity;

import net.aaronautic.distantvoid.DistantVoidMod;
import net.aaronautic.distantvoid.entity.custom.ShadowGolemEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.security.PublicKey;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DistantVoidMod.MOD_ID);

    public static final RegistryObject<EntityType<ShadowGolemEntity>> SHADOW_GOLEM =
            ENTITY_TYPES.register("shadow_golem", () -> EntityType.Builder.of(ShadowGolemEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 2.5f).build("shadow_golem"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
