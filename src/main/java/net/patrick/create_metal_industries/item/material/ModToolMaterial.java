package net.patrick.create_metal_industries.item.material;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;

import java.util.ArrayList;
import java.util.List;

public class ModToolMaterial
{
    // Move some of those to the child tool material classes. Just generic ones should stay here.
    public String codeName;
    public String inGameName;
    public ResourceLocation texture;
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
    
    public ModToolMaterial(String codeName, String inGameName, ResourceLocation texture,
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
    
}
