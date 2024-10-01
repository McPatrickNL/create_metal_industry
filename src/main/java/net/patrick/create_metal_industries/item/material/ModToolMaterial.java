package net.patrick.create_metal_industries.item.material;

import net.minecraft.world.item.Tier;

import java.util.ArrayList;
import java.util.List;

public class ModToolMaterial
{
    // Move some of those to the child tool material classes. Just generic ones should stay here.
    public String codeName;
    public String inGameName;
    public String texture;
    //public String materialType;
    //public String fluidSourceMaterial; // "none" would be for example for diamond
    //public String recipeType;
    public int miningLevel;             // Right now as an int. Should be a "Teir" from a minecraft class.
    public int baseDurability;
    public int miningSpeed;
    public double durabilityModifier;
    public double miningSpeedModifier;
    public boolean veinMiner;
    public int veinMinerMaxDepth; // 1 would be every adjacent block of the block that is being mined.
    public Tier Level;
    
    public ModToolMaterial(String codeName, String inGameName, String texture,
                           int miningLevel, int baseDurability, int miningSpeed,
                           double durabilityModifier, double miningSpeedModifier)
    {
        this.codeName = codeName;
        this.inGameName = inGameName;
        this.texture = texture;
        this.miningLevel = miningLevel;
        this.baseDurability = baseDurability;
        this.miningSpeed = miningSpeed;
        this.durabilityModifier = durabilityModifier;
        this.miningSpeedModifier = miningSpeedModifier;
    }
    
    static String woodTexture = "minecraft:block/stripped_spruce_log";
    static String stoneTexture = "minecraft:block/smooth_stone";
    static String goldTexture = "minecraft:block/gold_block";
    static String zincTexture = "create:block/zinc_block";
    static String copperTexture = "minecraft:block/copper_block";
    static String ironTexture = "minecraft:block/iron_block";
    static String brassTexture = "create:block/brass_block";
    static String netheriteTexture = "minecraft:block/netherite_block";
    static String noTexture = "create_metal_industries:item/empty";
    static String netherQuartzTexture = "minecraft:item/quartz";
    static String emeraldTexture = "minecraft:item/emerald";
    static String diamondTexture = "minecraft:item/diamond";
    static String amethystTexture = "minecraft:item/amethyst_shard";
    
    // modifiers and such still have to be changed...
    static ModToolMaterialRod woodRod = new ModToolMaterialRod(
            "wood", "Wooden", woodTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialRod stoneRod = new ModToolMaterialRod(
            "stone", "Stone", stoneTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialRod goldRod = new ModToolMaterialRod(
            "gold", "Gold", goldTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialRod zincRod = new ModToolMaterialRod(
            "zinc", "Zinc", zincTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialRod copperRod = new ModToolMaterialRod(
            "copper", "Copper", copperTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialRod ironRod = new ModToolMaterialRod(
            "iron", "Iron", ironTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialRod brassRod = new ModToolMaterialRod(
            "brass", "Brass", brassTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialRod netheriteRod = new ModToolMaterialRod(
            "netherite", "Netherite", netheriteTexture,
            1, 100, 1, 0.8, 0.2);
    
    // modifiers and such still have to be changed...
    static ModToolMaterialHead woodHead = new ModToolMaterialHead(
            "wood", "Wooden", woodTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialHead stoneHead = new ModToolMaterialHead(
            "stone", "Stone", stoneTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialHead goldHead = new ModToolMaterialHead(
            "gold", "Gold", goldTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialHead zincHead = new ModToolMaterialHead(
            "zinc", "Zinc", zincTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialHead copperHead = new ModToolMaterialHead(
            "copper", "Copper", copperTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialHead ironHead = new ModToolMaterialHead(
            "iron", "Iron", ironTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialHead brassHead = new ModToolMaterialHead(
            "brass", "Brass", brassTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialHead netheriteHead = new ModToolMaterialHead(
            "netherite", "Netherite", netheriteTexture,
            1, 100, 1, 0.8, 0.2);
   
    // modifiers and such still have to be changed...
    static ModToolMaterialCoating noCoating = new ModToolMaterialCoating(
            "no", "no", noTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialCoating goldCoating = new ModToolMaterialCoating(
            "gold", "Gold", goldTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialCoating zincCoating = new ModToolMaterialCoating(
            "zinc", "Zinc", zincTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialCoating copperCoating = new ModToolMaterialCoating(
            "copper", "Copper", copperTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialCoating ironCoating = new ModToolMaterialCoating(
            "iron", "Iron", ironTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialCoating brassCoating = new ModToolMaterialCoating(
            "brass", "Brass", brassTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialCoating netheriteCoating = new ModToolMaterialCoating(
            "netherite", "Netherite", netheriteTexture,
            1, 100, 1, 0.8, 0.2);
    
    // modifiers and such still have to be changed...
    static ModToolMaterialDecoration noDecoration = new ModToolMaterialDecoration(
            "no", "no", noTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialDecoration netherQuartzDecoration = new ModToolMaterialDecoration(
            "nether_quartz", "Nether Quartz", netherQuartzTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialDecoration emeraldDecoration = new ModToolMaterialDecoration(
            "emerald", "Emerald", emeraldTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialDecoration diamondDecoration = new ModToolMaterialDecoration(
            "diamond", "Diamond", diamondTexture,
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialDecoration amethystDecoration = new ModToolMaterialDecoration(
            "amethyst", "Amethyst", amethystTexture,
            1, 100, 1, 0.8, 0.2);
    
    public static ArrayList<ModToolMaterial> toolRodMaterials = new ArrayList<ModToolMaterial>(List.of(
            woodRod, stoneRod, goldRod, zincRod, copperRod, ironRod, brassRod, netheriteRod));
    public static ArrayList<ModToolMaterial> toolHeadMaterials = new ArrayList<ModToolMaterial>(List.of(
            woodHead, stoneHead, goldHead, zincHead, copperHead, ironHead, brassHead, netheriteHead));
    public static ArrayList<ModToolMaterial> toolCoatingMaterials = new ArrayList<ModToolMaterial>(List.of(
            noCoating, goldCoating, zincCoating, copperCoating, ironCoating,   brassCoating, netheriteCoating));
    public static ArrayList<ModToolMaterial> toolDecorationMaterials = new ArrayList<ModToolMaterial>(List.of(
            noDecoration, netherQuartzDecoration, emeraldDecoration, diamondDecoration, amethystDecoration));
    
    // Getters
    public static ArrayList<ModToolMaterial> getToolRodMaterials()
    {
        return toolRodMaterials;
    }
    
    public static ArrayList<ModToolMaterial> getToolHeadMaterials()
    {
        return toolHeadMaterials;
    }
    
    public static ArrayList<ModToolMaterial> getToolCoatingMaterials()
    {
        return toolCoatingMaterials;
    }
    
    public static ArrayList<ModToolMaterial> getToolDecorationMaterials()
    {
        return toolDecorationMaterials;
    }
}
