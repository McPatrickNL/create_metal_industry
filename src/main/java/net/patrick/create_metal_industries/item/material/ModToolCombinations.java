package net.patrick.create_metal_industries.item.material;

import net.patrick.create_metal_industries.item.ModTool;

import java.util.ArrayList;
import java.util.List;


public class ModToolCombinations
{
    public static ArrayList<ModToolMaterial> toolRodMaterials = ModToolMaterial.getToolRodMaterials();
    public static ArrayList<ModToolMaterial> toolHeadMaterials = ModToolMaterial.getToolHeadMaterials();
    public static ArrayList<ModToolMaterial> toolCoatingMaterials = ModToolMaterial.getToolCoatingMaterials();
    public static ArrayList<ModToolMaterial> toolDecorationMaterials = ModToolMaterial.getToolDecorationMaterials();
    public static ArrayList<ModTool> tools = new ArrayList<ModTool>(List.of());
    
    public static void createToolCombinations()
    {
        System.out.println("Number of tools: " + toolRodMaterials.size()*toolHeadMaterials.size()*toolCoatingMaterials.size()*
                toolDecorationMaterials.size());
        
        toolRodMaterials.forEach( rod ->
                toolHeadMaterials.forEach( head ->
                        toolCoatingMaterials.forEach( coating ->
                                toolDecorationMaterials.forEach( decoration ->
                                        addToolCombination(rod, head, coating, decoration)
                                )
                        )
                )
        );
        
    }
    
    public static void addToolCombination(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating,
                                          ModToolMaterial decoration)
    {
        String codeName = CodeName(rod, head, coating, decoration);
        String inGameName = InGameName(rod, head, coating, decoration);
        int miningLevel = MiningLevel(rod, head, coating, decoration);
        int durability = Durability(rod, head, coating, decoration);
        int miningSpeed = MiningSpeed(rod, head, coating, decoration);
        double durabilityModifier = DurabilityModifier(rod, head, coating, decoration);
        double miningSpeedModifier = MiningSpeedModifer(rod, head, coating, decoration);
        double attackSpeedModifier = AttackSpeedModifier(rod, head, coating, decoration);
        
        System.out.println(inGameName);
        tools.add(new ModTool(codeName, inGameName, miningLevel, durability, miningSpeed, durabilityModifier,
                miningSpeedModifier, attackSpeedModifier));
    }
    
    public static String InGameName(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating,
                       ModToolMaterial decoration)
    {
        return "ToolTest: " + head.inGameName + " pickaxe with " + rod.inGameName + " rod, " + coating.inGameName +
                " coating and " + decoration.inGameName + " decoration.";
    }
    
    private static String CodeName(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating, ModToolMaterial decoration)
    {
        return "pickaxe_" + rod.codeName + "_" + head.codeName + "_" + coating.codeName + "_" + decoration.codeName;
    }
    
    private static int MiningLevel(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating, ModToolMaterial decoration)
    {
        return 1;
    }
    
    private static int Durability(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating, ModToolMaterial decoration)
    {
        return 1;
    }
    
    private static int MiningSpeed(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating, ModToolMaterial decoration)
    {
        return 1;
    }
    
    private static double DurabilityModifier(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating, ModToolMaterial decoration)
    {
        return 1;
    }
    
    private static double MiningSpeedModifer(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating, ModToolMaterial decoration)
    {
        return 1;
    }
    
    private static double AttackSpeedModifier(ModToolMaterial rod, ModToolMaterial head, ModToolMaterial coating, ModToolMaterial decoration)
    {
        return 1;
    }
}
