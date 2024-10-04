package net.patrick.create_metal_industries.item.tool;

import net.minecraft.resources.ResourceLocation;
import net.patrick.create_metal_industries.item.tool.material.Material;

public class Pickaxe extends Tool
{
    public String toolTypeName = "Pickaxe";
    public boolean veinMiner;
    public int veinMinerMaxDepth; // 1 would be every adjacent block of the block that is being mined.
    
    public Pickaxe(Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial)
    {
        super(rodMaterial, headMaterial, coatingMaterial, decorationMaterial);
        
        this.codeName = CodeName(rodMaterial, headMaterial, coatingMaterial, decorationMaterial);
        this.inGameName = InGameName(rodMaterial, headMaterial, coatingMaterial, decorationMaterial);
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
