package net.aaronautic.distantvoid.datagen;

import net.aaronautic.distantvoid.DistantVoidMod;
import net.aaronautic.distantvoid.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.security.MessageDigest;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DistantVoidMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.OBSCURITE_BLOCK);
        blockWithItem(ModBlocks.VOIDSTRUCK_PLANKS);

        stairsBlock((StairBlock) ModBlocks.VOIDSTRUCK_STAIRS.get(), blockTexture(ModBlocks.VOIDSTRUCK_PLANKS.get()));
        slabBlock((SlabBlock) ModBlocks.VOIDSTRUCK_SLAB.get(), blockTexture(ModBlocks.VOIDSTRUCK_PLANKS.get()), blockTexture(ModBlocks.VOIDSTRUCK_PLANKS.get()));

        buttonBlock((ButtonBlock) ModBlocks.VOIDSTRUCK_BUTTON.get(), blockTexture(ModBlocks.VOIDSTRUCK_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.VOIDSTRUCK_PRESSURE_PLATE.get(), blockTexture(ModBlocks.VOIDSTRUCK_PLANKS.get()));

        fenceBlock((FenceBlock) ModBlocks.VOIDSTRUCK_FENCE.get(), blockTexture(ModBlocks.VOIDSTRUCK_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.VOIDSTRUCK_FENCE_GATE.get(), blockTexture(ModBlocks.VOIDSTRUCK_PLANKS.get()));

        blockItem(ModBlocks.VOIDSTRUCK_STAIRS);
        blockItem(ModBlocks.VOIDSTRUCK_SLAB);
        blockItem(ModBlocks.VOIDSTRUCK_PRESSURE_PLATE);
        blockItem(ModBlocks.VOIDSTRUCK_FENCE_GATE);

        horizontalBlock(ModBlocks.ORE_REFINING_STATION.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/ore_refining_station")));

        logBlock(((RotatedPillarBlock) ModBlocks.VOIDSTRUCK_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.VOIDSTRUCK_WOOD.get()), blockTexture(ModBlocks.VOIDSTRUCK_LOG.get()), blockTexture(ModBlocks.VOIDSTRUCK_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_VOIDSTRUCK_LOG.get(), new ResourceLocation(DistantVoidMod.MOD_ID, "block/stripped_voidstruck_log"),
                new ResourceLocation(DistantVoidMod.MOD_ID, "block/stripped_voidstruck_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_VOIDSTRUCK_WOOD.get(), new ResourceLocation(DistantVoidMod.MOD_ID, "block/stripped_voidstruck_log"),
                new ResourceLocation(DistantVoidMod.MOD_ID, "block/stripped_voidstruck_log"));

        blockItem(ModBlocks.VOIDSTRUCK_LOG);
        blockItem(ModBlocks.VOIDSTRUCK_WOOD);
        blockItem(ModBlocks.STRIPPED_VOIDSTRUCK_LOG);
        blockItem(ModBlocks.STRIPPED_VOIDSTRUCK_WOOD);


    }


    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("distantvoid:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
