package net.patrick.create_metal_industries.item.tool.material;

import net.patrick.create_metal_industries.item.tool.Abilities;

public class MaterialAbility implements Abilities
{
    public final String abilityName;
    public final int abilityID;
    public final int abilityLevel;
    
    public MaterialAbility(String abilityName, int abilityID, int abilityLevel)
    {
        this.abilityName = abilityName;
        this.abilityID = abilityID;
        this.abilityLevel = abilityLevel;
    }
}
