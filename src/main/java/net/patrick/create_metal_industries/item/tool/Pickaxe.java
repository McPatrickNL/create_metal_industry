package net.patrick.create_metal_industries.item.tool;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.patrick.create_metal_industries.item.tool.material.Material;

public class Pickaxe extends PickaxeItem
{
    public Tool getToolData()
    {
        return toolData;
    }
    
    private final Tool toolData;
    
    public String toolTypeName = "pickaxe";
    public boolean veinMiner;
    public int veinMinerMaxDepth; // 1 would be every adjacent block of the block that is being mined.
    
    public Pickaxe(Tool toolData, Item.Properties properties)
    {
        super(toolData.tier, toolData.attackDamage, toolData.attackSpeedModifier, properties);
        this.toolData = toolData;
        this.getToolData().codeName = CodeName(toolData);
        this.getToolData().inGameName = InGameName(toolData);
    }
    
    private String CodeName(Tool toolData)
    {
        // todo add a variable to indicate the type of tool created
        return toolData.rodMaterial.codeName + "_" +
                toolData.headMaterial.codeName + "_" +
                toolData.coatingMaterial.codeName + "_" +
                toolData.decorationMaterial.codeName;
    }
    
    private String InGameName(Tool toolData)
    {
        // I hope line breaks work in a tool name.....
        return toolData.coatingMaterial.inGameNameCoated +          // "Tainted " or "" if none
                toolData.headMaterial.inGameNameGeneric +           // "Iron "
                toolTypeName +                                      // "Pickaxe"
                "with " +                                           // new line "with "
                toolData.rodMaterial.inGameNameGeneric +            // "Copper "
                "Rod and " +                                        // "Rod" new line "and "
                toolData.decorationMaterial.inGameNameGeneric +     // "no "
                "Decorations";                                      // "Decorations"
                
    }
    
}
