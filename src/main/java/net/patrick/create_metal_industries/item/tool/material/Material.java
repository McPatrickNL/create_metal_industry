package net.patrick.create_metal_industries.item.tool.material;

import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.patrick.create_metal_industries.item.tool.Abilities;

import java.util.List;
import java.util.regex.Pattern;

public class Material implements Abilities
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
    public double attackDamageModifier;
    public double attackSpeedModifier;
    public double toolRangeModifier;    // no actual use yet
    public Tier tier;
    public int color;
    public List<MaterialAbility> materialAbilities;
    public ChatFormatting textFormat;
    
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
                    double durabilityModifier, double attackDamageModifier, double attackSpeedModifier, double toolRangeModifier,
                    Tier tier, int color, List<MaterialAbility> materialAbilities, ChatFormatting textFormat)
    {
        this.codeName = codeName;
        this.inGameNameGeneric = inGameNameGeneric;
        this.inGameNameCoated = inGameNameCoated;
        this.texture = texture;
        this.miningLevel = miningLevel;
        this.baseDurability = baseDurability;
        this.miningSpeed = miningSpeed;
        this.durabilityModifier = durabilityModifier;
        this.attackDamageModifier = attackDamageModifier;
        this.attackSpeedModifier = attackSpeedModifier;
        this.toolRangeModifier = toolRangeModifier;
        this.tier = tier;
        this.color = color;
        this.materialAbilities = materialAbilities;
        this.textFormat = textFormat;
    }
}
