package net.patrick.create_metal_industries.item.material;

public class ModToolMaterialDecoration extends ModToolMaterial
{
    
    public ModToolMaterialDecoration(String codeName, String inGameName, String texture,
                                     int miningLevel, int baseDurability, int miningSpeed,
                                     double durabilityModifier, double miningSpeedModifier)
    {
        super(codeName, inGameName, texture, miningLevel, baseDurability, miningSpeed, durabilityModifier, miningSpeedModifier);
    }
}