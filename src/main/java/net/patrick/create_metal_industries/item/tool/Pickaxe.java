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
    
    public String toolTypeName = "Pickaxe";
    public boolean veinMiner;
    public int veinMinerMaxDepth; // 1 would be every adjacent block of the block that is being mined.
    
    public Pickaxe(Tool toolData, Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial, Item.Properties properties)
    {
        super(toolData.tier, toolData.attackDamage, toolData.attackSpeedModifier, properties);
        this.toolData = toolData;
        this.getToolData().codeName = CodeName(rodMaterial, headMaterial, coatingMaterial, decorationMaterial);
        this.getToolData().inGameName = InGameName(rodMaterial, headMaterial, coatingMaterial, decorationMaterial);
    }
    
    private String CodeName(Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial)
    {
        return rodMaterial.codeName + "_" +
            headMaterial.codeName + "_" +
            coatingMaterial.codeName + "_" +
            decorationMaterial.codeName;
    }
    
    private String InGameName(Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial)
    {
        // I hope line breaks work in a tool name.....
        return coatingMaterial.inGameNameCoated +       // "Tainted " or "" if none
                headMaterial.inGameNameGeneric +        // "Iron "
                toolTypeName +                          // "Pickaxe"
                "\nwith " +                             // new line "with "
                rodMaterial.inGameNameGeneric +         // "Copper "
                "Rod\nand " +                           // "Rod" new line "and "
                decorationMaterial.inGameNameGeneric +  // "no "
                "Decorations";                          // "Decorations"
                
    }
    
}
