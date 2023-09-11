package net.aaronautic.distantvoid.datagen.loot;

import net.aaronautic.distantvoid.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.OBSCURITE_BLOCK.get());


        this.dropSelf(ModBlocks.VOIDSTRUCK_PLANKS.get());
        this.dropSelf(ModBlocks.VOIDSTRUCK_STAIRS.get());
        this.add(ModBlocks.VOIDSTRUCK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.VOIDSTRUCK_SLAB.get()));
        this.dropSelf(ModBlocks.VOIDSTRUCK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.VOIDSTRUCK_BUTTON.get());
        this.dropSelf(ModBlocks.VOIDSTRUCK_FENCE.get());
        this.dropSelf(ModBlocks.VOIDSTRUCK_FENCE_GATE.get());

        this.dropSelf(ModBlocks.ORE_REFINING_STATION.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;

    }
}
