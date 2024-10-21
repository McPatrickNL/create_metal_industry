package net.patrick.create_metal_industries.item.tool;

import net.patrick.create_metal_industries.item.tool.material.Material;

public class AxeData extends ToolData
{
    public String toolTypeName = "Axe";
    public String toolCodeTypeName = "axe";
    public boolean veinMiner;
    public int veinMinerMaxDepth; // 1 would be every adjacent block of the block that is being mined.
    
    public AxeData(Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial)
    {
        super(rodMaterial, headMaterial, coatingMaterial, decorationMaterial);
        
        this.codeName = CodeName(rodMaterial, headMaterial, coatingMaterial, decorationMaterial);
        this.inGameName = InGameName(rodMaterial, headMaterial, coatingMaterial, decorationMaterial);
    }
    
    private String CodeName(Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial)
    {
        return toolCodeTypeName + "_" +
            rodMaterial.codeName + "_" +
            headMaterial.codeName + "_" +
            coatingMaterial.codeName + "_" +
            decorationMaterial.codeName;
    }
    
    private String InGameName(Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial)
    {
        // I hope line breaks work in a tool name..... UPDATE: they don't.
        return coatingMaterial.inGameNameCoated +       // "Tainted " or "" if none
                headMaterial.inGameNameGeneric +        // "Iron "
                toolTypeName +                          // "Shovel"
                "with " +                               // "with "
                rodMaterial.inGameNameGeneric +         // "Copper "
                "Rod and " +                            // "Rod and "
                decorationMaterial.inGameNameGeneric +  // "no "
                "Decorations";                          // "Decorations"
                
    }
    
}
