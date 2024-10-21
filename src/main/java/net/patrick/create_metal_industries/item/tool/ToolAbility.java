package net.patrick.create_metal_industries.item.tool;

import net.patrick.create_metal_industries.item.tool.material.Material;
import net.patrick.create_metal_industries.item.tool.material.MaterialAbility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToolAbility implements Abilities
{
    public final String abilityName;
    public final int abilityID;
    public final int abilityLevel;
    
    public ToolAbility(String abilityName, int abilityID, int abilityLevel)
    {
        this.abilityName = abilityName;
        this.abilityID = abilityID;
        this.abilityLevel = abilityLevel;
    }
    
}
