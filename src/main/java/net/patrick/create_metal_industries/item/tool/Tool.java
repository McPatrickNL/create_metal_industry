package net.patrick.create_metal_industries.item.tool;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.patrick.create_metal_industries.item.tool.material.Material;

public abstract class Tool
{
    public String codeName;
    public String inGameName;
    public Material rodMaterial;
    public Material headMaterial;
    public Material coatingMaterial;
    public Material decorationMaterial;
    public ResourceLocation rodTexture;
    public ResourceLocation headTexture;
    public ResourceLocation coatingTexture;
    public ResourceLocation decorationTexture;
    public int miningLevel; // no use - see tiers
    public int durability; // no use - see tiers
    public int miningSpeed; // no use - see tiers
    public double miningSpeedModifier;
    public double attackSpeedModifier;
    public Tier tier; ////// todo is this the right import?.
    
    public Tool(Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial)
    {
        // Materials
        this.rodMaterial = rodMaterial;
        this.headMaterial = headMaterial;
        this.coatingMaterial = coatingMaterial;
        this.decorationMaterial = decorationMaterial;
        
        // Textures
        this.rodTexture = rodMaterial.texture;
        this.headTexture = headMaterial.texture;
        this.coatingTexture = coatingMaterial.texture;
        this.decorationTexture = decorationMaterial.texture;
        
        // Attributes
        this.miningSpeedModifier = MiningSpeed(rodMaterial, headMaterial, coatingMaterial, decorationMaterial);
        this.attackSpeedModifier = AttackSpeed(rodMaterial, headMaterial, coatingMaterial, decorationMaterial);
        
        // Tier
        // todo function to determine the highest tier amongst the applied materials, decoration excluded
        this.tier = rodMaterial.tier;
    }
    
    private double AttackSpeed(Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial)
    {
        // All values multiplied and multiplied again by the highest factor
        return rodMaterial.attackSpeedModifier*
                headMaterial.attackSpeedModifier*
                coatingMaterial.attackSpeedModifier*
                decorationMaterial.attackSpeedModifier*
                Math.max(Math.max(rodMaterial.attackSpeedModifier,
                                headMaterial.attackSpeedModifier),
                        Math.max(coatingMaterial.attackSpeedModifier,
                                decorationMaterial.attackSpeedModifier));
    }
    
    private double MiningSpeed(Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial)
    {
        // All values multiplied and multiplied again by the highest factor
        return rodMaterial.miningSpeedModifier*
                headMaterial.miningSpeedModifier*
                coatingMaterial.miningSpeedModifier*
                decorationMaterial.miningSpeedModifier*
                Math.max(Math.max(rodMaterial.miningSpeedModifier,
                                headMaterial.miningSpeedModifier),
                        Math.max(coatingMaterial.miningSpeedModifier,
                                decorationMaterial.miningSpeedModifier));
    }
    
}
