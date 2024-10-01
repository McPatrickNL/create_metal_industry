package net.patrick.create_metal_industries.item;

public class ModTool
{
    public String codeName;
    public String inGameName;
    public String rodTexture;
    public String headTexture;
    public String coatingTexture;
    public String decorationTexture;
    public int miningLevel;
    public int durability;
    public int miningSpeed;
    public double durabilityModifier;
    public double miningSpeedModifier;
    public double attackSpeedModifier;
    
    public ModTool(String codeName, String inGameName,
                   String rodTexture, String headTexture, String coatingTexture, String decorationTexture,
                   int miningLevel, int durability, int miningSpeed,
                   double durabilityModifier, double miningSpeedModifier, double attackSpeedModifier)
    {
        this.codeName = codeName;
        this.inGameName = inGameName;
        this.rodTexture = rodTexture;
        this.headTexture = headTexture;
        this.coatingTexture = coatingTexture;
        this.decorationTexture = decorationTexture;
        this.miningLevel = miningLevel;
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.durabilityModifier = durabilityModifier;
        this.miningSpeedModifier = miningSpeedModifier;
        this.attackSpeedModifier = attackSpeedModifier;
    }
    
}
