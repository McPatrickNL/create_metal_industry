package net.patrick.create_metal_industries.item.tool.material;

import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tiers;
import net.patrick.create_metal_industries.item.tool.Abilities;
import net.patrick.create_metal_industries.item.tool.ToolTiers;

import java.util.ArrayList;
import java.util.List;

public class Materials implements Abilities
{
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
    //mithril...
    static ResourceLocation noTexture = new ResourceLocation("create_metal_industries","item/empty");
    static ResourceLocation netherQuartzTexture = new ResourceLocation("minecraft","item/quartz");
    static ResourceLocation emeraldTexture = new ResourceLocation("minecraft","item/emerald");
    static ResourceLocation diamondTexture = new ResourceLocation("minecraft","item/diamond");
    static ResourceLocation amethystTexture = new ResourceLocation("minecraft","item/amethyst_shard");
    static ResourceLocation enderPearlTexture = new ResourceLocation("minecraft","item/ender_pearl");
    static ResourceLocation netherStarTexture = new ResourceLocation("minecraft","item/nether_star");
    
    // EMPTY MATERIAL
    static Material none = new Material(
            "no", "no ", "", noTexture,
            1, 100, 1, 0.8, 1, 1,
            1, Tiers.WOOD, 0x000000,
            List.of(), ChatFormatting.GRAY);
    
    // BASIC MATERIALS
    static Material wood = new Material(
            "wood", "Wooden ", "Holded ", woodTexture,
            1, 100, 1, 0.8, 1.1, 1.1,
            1,  Tiers.WOOD, 0x675631,
            List.of(new MaterialAbility(treeFellerCodeName, treeFellerID, 1)), ChatFormatting.DARK_RED);
    
    static Material stone = new Material(
            "stone", "Stone ", "Petrified ", stoneTexture,
            1, 100, 1, 0.8, 1.2, 1.2,
            1,  Tiers.STONE, 0x636363,
            List.of(), ChatFormatting.DARK_GRAY);
    
    static Material gold = new Material(
            "gold", "Gold ", "Gilded ", goldTexture,
            1, 100, 1, 0.8, 3, 3,
            1,  Tiers.GOLD, 0xFFC81E,
            List.of(), ChatFormatting.YELLOW);
    
    static Material zinc = new Material(
            "zinc", "Zinc ", "Galvanized ", zincTexture,
            2, 100, 1, 0.8, 1.4, 1.4,
            1,  Tiers.GOLD, 0x256E5F,
            List.of(), ChatFormatting.LIGHT_PURPLE);
    
    static Material copper = new Material(
            "copper", "Copper ", "Cupred ", copperTexture,
            3, 100, 1, 0.8, 1.6, 1.6,
            1,  Tiers.IRON, 0xFF6C40,
            List.of(), ChatFormatting.GOLD);
    
    static Material iron = new Material(
            "iron", "Iron ", "Ferred ", ironTexture,
            3, 100, 1, 0.8, 1.7, 1.7,
            1,  Tiers.IRON, 0xFF4140,
            List.of(), ChatFormatting.RED);
    
    static Material brass = new Material(
            "brass", "Brass ", "Brazed ", brassTexture,
            4, 100, 1, 0.8, 1.9, 1.9,
            1,  ToolTiers.BRASS, 0xFF9B2F,
            List.of(), ChatFormatting.GOLD);
    
    static Material netherite = new Material(
            "netherite", "Netherite ", "Tainted ", netheriteTexture,
            5, 100, 1, 0.8, 2.5, 2.5,
            1,  Tiers.NETHERITE, 0x473F40,
            List.of(), ChatFormatting.DARK_GRAY);
    
    // todo add Mithril properly
    // todo set Mithril texture
    static Material mithril = new Material(
            "mithril", "Mithril ", "Enriched ", netheriteTexture,
            5, 100, 1, 0.8, 2.5, 2.5,
            1,  Tiers.NETHERITE, 0xbefbe8,
            List.of(new MaterialAbility(veinMinerCodeName, veinMinerID, 2)), ChatFormatting.AQUA);
    
    // Decoration materials
    static Material netherQuartz = new Material(
            "nether_quartz", "Nether Quartz ", "Spiked ", netherQuartzTexture,
            3, 100, 1, 0.8, 2, 2,
            1,  Tiers.DIAMOND, 0xd4caba,
            List.of(), ChatFormatting.WHITE);
    
    static Material emerald = new Material(
            "emerald", "Emerald ", "Emered ", emeraldTexture,
            4, 100, 1, 0.8, 2.5, 2.5,
            1,  Tiers.DIAMOND, 0x17dd62,
            List.of(), ChatFormatting.GREEN);
    
    static Material diamond = new Material(
            "diamond", "Diamond ", "Expensive ", diamondTexture,
            5, 100, 1, 0.8, 2.7, 2.7,
            1,  Tiers.DIAMOND, 0x4aedd9,
            List.of(), ChatFormatting.DARK_AQUA);
    
    static Material amethyst = new Material(
            "amethyst", "Amethyst ", "Athysted ", amethystTexture,
            3, 100, 1, 0.8, 2.5, 2.5,
            1,  Tiers.DIAMOND, 0x8d6acc,
            List.of(), ChatFormatting.DARK_PURPLE);
    
    static Material enderPearl = new Material(
            "ender_pearl", "Ender Pearl ", "Endered ", enderPearlTexture,
            3, 100, 1, 0.8, 2, 2,
            1,  Tiers.DIAMOND, 0x258474,
            List.of(), ChatFormatting.DARK_GREEN);
    
    static Material netherStar = new Material(
            "nether_star", "Nether Star ", "Starred ", netherStarTexture,
            6, 100, 1, 0.8, 3, 3,
            1,  Tiers.DIAMOND, 0xfdffa8,
            List.of(), ChatFormatting.YELLOW);
    
    private ArrayList<Material> rodMaterials;
    private ArrayList<Material> headMaterials;
    private ArrayList<Material> coatingMaterials;
    private ArrayList<Material> decorationMaterials;
    
    public Materials()
    {
        rodMaterials = new ArrayList<Material>(List.of(
                wood, stone, gold, zinc, copper, iron, brass, netherite, mithril));
        headMaterials = new ArrayList<Material>(List.of(
                wood, stone, gold, zinc, copper, iron, brass, netherite, mithril));
        coatingMaterials = new ArrayList<Material>(List.of(
                none, gold, zinc, copper, iron, brass, netherite, mithril));
        decorationMaterials = new ArrayList<Material>(List.of(
                none, netherQuartz, emerald, diamond, amethyst, enderPearl, netherStar));
    }
    
    // Getters
    public ArrayList<Material> getRodMaterials() {return rodMaterials;}
    
    public ArrayList<Material> getHeadMaterials()
    {
        return headMaterials;
    }
    
    public ArrayList<Material> getCoatingMaterials()
    {
        return coatingMaterials;
    }
    
    public ArrayList<Material> getDecorationMaterials()
    {
        return decorationMaterials;
    }
    
}
