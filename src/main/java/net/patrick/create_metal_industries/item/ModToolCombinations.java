package net.patrick.create_metal_industries.item;

import net.minecraft.resources.ResourceLocation;
import net.patrick.create_metal_industries.item.material.*;

import java.util.ArrayList;
import java.util.List;


public class ModToolCombinations
{
    
    public static ArrayList<ModTool> tools = new ArrayList<ModTool>(List.of());
    
    static ResourceLocation woodTexture = new ResourceLocation("minecraft","block/stripped_spruce_log");
    static ResourceLocation stoneTexture = new ResourceLocation("minecraft","block/smooth_stone");
    static ResourceLocation goldTexture = new ResourceLocation("minecraft","block/gold_block");
    //static ResourceLocation zincTexture = new ResourceLocation("create","block/zinc_block");
    static ResourceLocation zincTexture = new ResourceLocation("minecraft","block/iron_block");
    static ResourceLocation copperTexture = new ResourceLocation("minecraft","block/copper_block");
    static ResourceLocation ironTexture = new ResourceLocation("minecraft","block/iron_block");
    //static ResourceLocation brassTexture = new ResourceLocation("create","block/brass_block");
    static ResourceLocation brassTexture = new ResourceLocation("minecraft","block/gold_block");
    static ResourceLocation netheriteTexture = new ResourceLocation("minecraft","block/netherite_block");
    static ResourceLocation noTexture = new ResourceLocation("create_metal_industries","item/empty");
    static ResourceLocation netherQuartzTexture = new ResourceLocation("minecraft","item/quartz");
    static ResourceLocation emeraldTexture = new ResourceLocation("minecraft","item/emerald");
    static ResourceLocation diamondTexture = new ResourceLocation("minecraft","item/diamond");
    static ResourceLocation amethystTexture = new ResourceLocation("minecraft","item/amethyst_shard");
    
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
    
    public static void createToolCombinations()
    {
        System.out.println("Number of tools: " + toolRodMaterials.size()*toolHeadMaterials.size()*toolCoatingMaterials.size()*
                toolDecorationMaterials.size());
        
        toolRodMaterials.forEach( rod ->
                toolHeadMaterials.forEach( head ->
                        toolCoatingMaterials.forEach( coating ->
                                toolDecorationMaterials.forEach( decoration ->
                                        addToolCombination(rod, head, coating, decoration)
                                )
                        )
                )
        );
        
    }
    
    public static void addToolCombination(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating,
                                          ModToolMaterial decoration)
    {
        String codeName = CodeName(rod, head, coating, decoration);
        String inGameName = InGameName(rod, head, coating, decoration);
        ResourceLocation rodTexture = rod.texture;
        ResourceLocation headTexture = head.texture;
        ResourceLocation coatingTexture = coating.texture;
        ResourceLocation decorationTexture = decoration.texture;
        int miningLevel = MiningLevel(rod, head, coating, decoration);
        int durability = Durability(rod, head, coating, decoration);
        int miningSpeed = MiningSpeed(rod, head, coating, decoration);
        double durabilityModifier = DurabilityModifier(rod, head, coating, decoration);
        double miningSpeedModifier = MiningSpeedModifer(rod, head, coating, decoration);
        double attackSpeedModifier = AttackSpeedModifier(rod, head, coating, decoration);
        
        System.out.println(inGameName);
        tools.add(new ModTool(codeName, inGameName, rodTexture, headTexture, coatingTexture, decorationTexture, miningLevel, durability, miningSpeed, durabilityModifier,
                miningSpeedModifier, attackSpeedModifier));
    }
    
    public static String InGameName(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating,
                       ModToolMaterial decoration)
    {
        return "ToolTest: " + head.inGameName + " pickaxe with " + rod.inGameName + " rod, " + coating.inGameName +
                " coating and " + decoration.inGameName + " decoration.";
    }
    
    private static String CodeName(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating, ModToolMaterial decoration)
    {
        return "pickaxe_" + rod.codeName + "_" + head.codeName + "_" + coating.codeName + "_" + decoration.codeName;
    }
    
    private static int MiningLevel(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating, ModToolMaterial decoration)
    {
        return 1;
    }
    
    private static int Durability(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating, ModToolMaterial decoration)
    {
        return 1;
    }
    
    private static int MiningSpeed(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating, ModToolMaterial decoration)
    {
        return 1;
    }
    
    private static double DurabilityModifier(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating, ModToolMaterial decoration)
    {
        return 1;
    }
    
    private static double MiningSpeedModifer(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating, ModToolMaterial decoration)
    {
        return 1;
    }
    
    private static double AttackSpeedModifier(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating, ModToolMaterial decoration)
    {
        return 1;
    }
}
