package net.aaronautic.distantvoid.item;

import net.aaronautic.distantvoid.DistantVoidMod;
import net.aaronautic.distantvoid.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier OBSCURITE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2500, 9f, 3, 15,
                    ModTags.Blocks.NEEDS_OBSCURITE_TOOL, () -> Ingredient.of(ModItems.OBSCURITE_INGOT.get())),
            new ResourceLocation(DistantVoidMod.MOD_ID, "obscurite"), List.of(Tiers.NETHERITE), List.of());



}
