package net.patrick.create_metal_industries.item.material;

import net.minecraft.world.item.Tier;

import java.util.ArrayList;
import java.util.List;

public class ModToolMaterial
{
    // Move some of those to the child tool material classes. Just generic ones should stay here.
    public String codeName;
    public String inGameName;
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
    
    public ModToolMaterial(String codeName, String inGameName, int miningLevel, int baseDurability, int miningSpeed,
                           double durabilityModifier, double miningSpeedModifier)
    {
        this.codeName = codeName;
        this.inGameName = inGameName;
        this.miningLevel = miningLevel;
        this.baseDurability = baseDurability;
        this.miningSpeed = miningSpeed;
        this.durabilityModifier = durabilityModifier;
        this.miningSpeedModifier = miningSpeedModifier;
    }
    
    
    // modifiers and such still have to be changed...
    static ModToolMaterialRod woodRod = new ModToolMaterialRod("wood", "Wooden",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialRod stoneRod = new ModToolMaterialRod("stone", "Stone",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialRod goldRod = new ModToolMaterialRod("gold", "Gold",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialRod zincRod = new ModToolMaterialRod("zinc", "Zinc",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialRod copperRod = new ModToolMaterialRod("copper", "Copper",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialRod ironRod = new ModToolMaterialRod("iron", "Iron",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialRod brassRod = new ModToolMaterialRod("brass", "Brass",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialRod netheriteRod = new ModToolMaterialRod("netherite", "Netherite",
            1, 100, 1, 0.8, 0.2);
    
    // modifiers and such still have to be changed...
    static ModToolMaterialHead woodHead = new ModToolMaterialHead("wood", "Wooden",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialHead stoneHead = new ModToolMaterialHead("stone", "Stone",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialHead goldHead = new ModToolMaterialHead("gold", "Gold",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialHead zincHead = new ModToolMaterialHead("zinc", "Zinc",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialHead copperHead = new ModToolMaterialHead("copper", "Copper",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialHead ironHead = new ModToolMaterialHead("iron", "Iron",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialHead brassHead = new ModToolMaterialHead("brass", "Brass",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialHead netheriteHead = new ModToolMaterialHead("netherite", "Netherite",
            1, 100, 1, 0.8, 0.2);
   
    // modifiers and such still have to be changed...
    static ModToolMaterialCoating noCoating = new ModToolMaterialCoating("no", "no",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialCoating goldCoating = new ModToolMaterialCoating("gold", "Gold",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialCoating zincCoating = new ModToolMaterialCoating("zinc", "Zinc",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialCoating copperCoating = new ModToolMaterialCoating("copper", "Copper",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialCoating ironCoating = new ModToolMaterialCoating("iron", "Iron",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialCoating brassCoating = new ModToolMaterialCoating("brass", "Brass",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialCoating netheriteCoating = new ModToolMaterialCoating("netherite", "Netherite",
            1, 100, 1, 0.8, 0.2);
    
    // modifiers and such still have to be changed...
    static ModToolMaterialDecoration noDecoration = new ModToolMaterialDecoration("no", "no",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialDecoration netherQuartzDecoration = new ModToolMaterialDecoration("nether_quartz", "Nether Quartz",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialDecoration emeraldDecoration = new ModToolMaterialDecoration("emerald", "Emerald",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialDecoration diamondDecoration = new ModToolMaterialDecoration("diamond", "Diamond",
            1, 100, 1, 0.8, 0.2);
    static ModToolMaterialDecoration amethystDecoration = new ModToolMaterialDecoration("amethyst", "Amethyst",
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
