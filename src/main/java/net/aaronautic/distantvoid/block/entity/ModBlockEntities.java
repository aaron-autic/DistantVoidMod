package net.aaronautic.distantvoid.block.entity;

import net.aaronautic.distantvoid.DistantVoidMod;
import net.aaronautic.distantvoid.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DistantVoidMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<OreRefiningStationBlockEntity>> ORE_REFINING_STATION_BE =
            BLOCK_ENTITIES.register("ore_refining_station_block_entity", () ->
                    BlockEntityType.Builder.of(OreRefiningStationBlockEntity::new,
                            ModBlocks.ORE_REFINING_STATION.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
