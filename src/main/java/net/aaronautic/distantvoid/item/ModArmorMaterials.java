package net.aaronautic.distantvoid.item;

import net.aaronautic.distantvoid.DistantVoidMod;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    OBSCURITE("obscurite", 40, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266655_) -> {
        p_266655_.put(ArmorItem.Type.BOOTS, 4);
        p_266655_.put(ArmorItem.Type.LEGGINGS, 7);
        p_266655_.put(ArmorItem.Type.CHESTPLATE, 9);
        p_266655_.put(ArmorItem.Type.HELMET, 5);
    }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.5F, 0.2F, () -> Ingredient.of(ModItems.OBSCURITE_INGOT.get()));

    public static final StringRepresentable.EnumCodec<ArmorMaterials> CODEC = StringRepresentable.fromEnum(ArmorMaterials::values);
    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266653_) -> {
        p_266653_.put(ArmorItem.Type.BOOTS, 13);
        p_266653_.put(ArmorItem.Type.LEGGINGS, 15);
        p_266653_.put(ArmorItem.Type.CHESTPLATE, 16);
        p_266653_.put(ArmorItem.Type.HELMET, 11);
    });
    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    ModArmorMaterials(String Name, int DurabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionTypeMap,
                      int EnchantmentValue, SoundEvent Sound, float Toughness, float knockbackRes, Supplier<Ingredient> repairMaterial) {
        this.name = Name;
        this.durabilityMultiplier = DurabilityMultiplier;
        this.protectionFunctionForType = protectionTypeMap;
        this.enchantmentValue = EnchantmentValue;
        this.sound = Sound;
        this.toughness = Toughness;
        this.knockbackResistance = knockbackRes;
        this.repairIngredient = repairMaterial;
    }

    public int getDurabilityForType(ArmorItem.Type pType) {
        return HEALTH_FUNCTION_FOR_TYPE.get(pType) * this.durabilityMultiplier;
    }

    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionFunctionForType.get(pType);
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return DistantVoidMod.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    /**
     * Gets the percentage of knockback resistance provided by armor of the material.
     */
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    public String getSerializedName() {
        return DistantVoidMod.MOD_ID + ":" + this.name;
    }
}