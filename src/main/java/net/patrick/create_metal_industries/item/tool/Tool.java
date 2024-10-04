package net.patrick.create_metal_industries.item.tool;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.patrick.create_metal_industries.item.tool.material.Material;

public class Tool
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
    public int attackDamage;
    public float attackSpeedModifier;
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
        //this.miningSpeedModifier = MiningSpeed(rodMaterial, headMaterial, coatingMaterial, decorationMaterial);
        this.attackSpeedModifier = AttackSpeed(rodMaterial, headMaterial, coatingMaterial, decorationMaterial);
        this.attackDamage = AttackDamage(rodMaterial, headMaterial, coatingMaterial, decorationMaterial);
        //Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Item.Properties pProperties
        
        // Tier
        // todo function to determine the highest tier amongst the applied materials, decoration excluded
        this.tier = rodMaterial.tier;
    }
    
    private float AttackSpeed(Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial)
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
    
//    private double MiningSpeed(Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial)
//    {
//        // All values multiplied and multiplied again by the highest factor
//        return rodMaterial.attackDamageModifier *
//                headMaterial.attackDamageModifier *
//                coatingMaterial.attackDamageModifier *
//                decorationMaterial.attackDamageModifier *
//                Math.max(Math.max(rodMaterial.attackDamageModifier,
//                                headMaterial.attackDamageModifier),
//                        Math.max(coatingMaterial.attackDamageModifier,
//                                decorationMaterial.attackDamageModifier));
//    }
    
    private int AttackDamage(Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial)
    {
        return rodMaterial.attackDamage *
                headMaterial.attackDamage *
                coatingMaterial.attackDamage *
                decorationMaterial.attackDamage *
                Math.max(Math.max(rodMaterial.attackDamage,
                                headMaterial.attackDamage),
                        Math.max(coatingMaterial.attackDamage,
                                decorationMaterial.attackDamage));
    }
    
}
