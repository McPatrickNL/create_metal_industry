package net.patrick.create_metal_industries.item.tool.material;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;

public class Material
{
    // Move some of those to the child tool material classes. Just generic ones should stay here.
    public String codeName;
    public String inGameNameCoated;
    public String inGameNameGeneric;
    public ResourceLocation texture;
    public int miningLevel;             // no actual use, this is part of the tier
    public int baseDurability;          // no actual use, this is part of the tier
    public int miningSpeed;             // no actual use, this is part of the tier
    public double durabilityModifier;
    public double miningSpeedModifier;
    public double attackSpeedModifier;
    public double toolRangeModifier;    // no actual use yet
    public Tier tier;
    
    // todo convert to a map?
    // todo Convert them all to lists???
    // todo a level for the effects based on number of times the material is used, or this might be a tool property...
    public boolean veinMiner = false;
    public boolean multiMiner = false;
    public boolean trowel = false;
    public boolean torcher = false;
    public boolean constructionWand = false;
    public boolean treeFeller = false;
    public boolean linkedStorage = false;
    
    //Just if I want to make the textures specific
    public ResourceLocation textureRod;
    public ResourceLocation textureHead;
    public ResourceLocation textureCoating;
    public ResourceLocation textureDecoration;
    
    //Thoughts:
    //public String materialType;
    //public String fluidSourceMaterial; // "none" would be for example for diamond
    //public String recipeType;
    
    public Material(String codeName, String inGameNameGeneric, String inGameNameCoated, ResourceLocation texture,
                    int miningLevel, int baseDurability, int miningSpeed,
                    double durabilityModifier, double miningSpeedModifier, double attackSpeedModifier, double toolRangeModifier,
                    Tier tier)
    {
        this.codeName = codeName;
        this.inGameNameGeneric = inGameNameGeneric;
        this.inGameNameCoated = inGameNameCoated;
        this.texture = texture;
        this.miningLevel = miningLevel;
        this.baseDurability = baseDurability;
        this.miningSpeed = miningSpeed;
        this.durabilityModifier = durabilityModifier;
        this.miningSpeedModifier = miningSpeedModifier;
        this.attackSpeedModifier = attackSpeedModifier;
        this.toolRangeModifier = toolRangeModifier;
        this.tier = tier;
    }
    
}
