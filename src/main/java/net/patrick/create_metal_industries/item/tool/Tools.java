package net.patrick.create_metal_industries.item.tool;

import net.minecraft.resources.ResourceLocation;
import net.patrick.create_metal_industries.item.tool.material.*;

import java.util.ArrayList;
import java.util.List;


public class Tools
{
    
    public static ArrayList<Tool> pickaxes = new ArrayList<Tool>(List.of());
    public static Materials rod;
    public static Materials head;
    public static Materials coating;
    public static Materials decoration;
    
    public static void createToolCombinations()
    {
        rod = new Materials();
        head = new Materials();
        coating = new Materials();
        decoration = new Materials();
        ArrayList<Material> rods = rod.getRodMaterials();
        ArrayList<Material> heads = head.getHeadMaterials();
        ArrayList<Material> coatings = coating.getCoatingMaterials();
        ArrayList<Material> decorations = decoration.getDecorationMaterials();
        
        System.out.println("Number of tools: " + rods.size()*heads.size()*coatings.size()*
                decorations.size());
        
        rods.forEach( rod ->
                heads.forEach( head ->
                        coatings.forEach( coating ->
                                decorations.forEach( decoration ->
                                        addToolCombination(rod, head, coating, decoration)
                                )
                        )
                )
        );
        
    }
    
    public static void addToolCombination(Material rod, Material head, Material coating,
                                          Material decoration)
    {
        String codeName = CodeName(rod, head, coating, decoration);
        String inGameName = InGameName(rod, head, coating, decoration);
        ResourceLocation rodTexture = rod.texture;
        ResourceLocation headTexture = head.texture;
        ResourceLocation coatingTexture = coating.texture;
        ResourceLocation decorationTexture = decoration.texture;
        int miningLevel = MiningLevel(rod, head, coating, decoration);
        int durability = Durability(rod, head, coating, decoration);
        int miningSpeed = MiningSpeed(rod, head, coating, decoration);
        double durabilityModifier = DurabilityModifier(rod, head, coating, decoration);
        double miningSpeedModifier = MiningSpeedModifer(rod, head, coating, decoration);
        double attackSpeedModifier = AttackSpeedModifier(rod, head, coating, decoration);
        
        System.out.println(inGameName);
        pickaxes.add(new Pickaxe(rod, head, coating, decoration));
    }
    
    public static String InGameName(Material rod, Material head, Material coating,
                                    Material decoration)
    {
        return "ToolTest: " + head.inGameNameGeneric + " pickaxe with " + rod.inGameNameGeneric + " rod, " + coating.inGameNameGeneric +
                " coating and " + decoration.inGameNameGeneric + " decoration.";
    }
    
    private static String CodeName(Material rod, Material head, Material coating, Material decoration)
    {
        return "pickaxe_" + rod.codeName + "_" + head.codeName + "_" + coating.codeName + "_" + decoration.codeName;
    }
    
    private static int MiningLevel(Material rod, Material head, Material coating, Material decoration)
    {
        return 1;
    }
    
    private static int Durability(Material rod, Material head, Material coating, Material decoration)
    {
        return 1;
    }
    
    private static int MiningSpeed(Material rod, Material head, Material coating, Material decoration)
    {
        return 1;
    }
    
    private static double DurabilityModifier(Material rod, Material head, Material coating, Material decoration)
    {
        return 1;
    }
    
    private static double MiningSpeedModifer(Material rod, Material head, Material coating, Material decoration)
    {
        return 1;
    }
    
    private static double AttackSpeedModifier(Material rod, Material head, Material coating, Material decoration)
    {
        return 1;
    }
}
