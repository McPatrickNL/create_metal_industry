package net.patrick.create_metal_industries.item.tool;

import net.minecraft.resources.ResourceLocation;
import net.patrick.create_metal_industries.item.tool.material.*;

import java.util.ArrayList;
import java.util.List;


public class ToolDataSets
{
    
    public static ArrayList<ToolData> pickaxeDataSets = new ArrayList<ToolData>(List.of());
    public static Materials materials;
    public static int iToolsCreated = 0;
    public static int iToolsSkipped = 0;
    public static int iToolsTotal = 0;
    
    public static void createToolDataSets()
    {
        materials = new Materials();
        ArrayList<Material> rods = materials.getRodMaterials();
        ArrayList<Material> heads = materials.getHeadMaterials();
        ArrayList<Material> coatings = materials.getCoatingMaterials();
        ArrayList<Material> decorations = materials.getDecorationMaterials();
        
        iToolsTotal = rods.size()*heads.size()*coatings.size()*
                decorations.size();
        System.out.println("Number of tools expected: " + iToolsTotal);
        
        rods.forEach( rod ->
                heads.forEach( head ->
                        coatings.forEach( coating ->
                                decorations.forEach( decoration ->
                                        addPickaxeDataSet(rod, head, coating, decoration)
                                )
                        )
                )
        );
        System.out.println("Number of tools created: " + iToolsCreated);
        System.out.println("Number of tools skipped: " + iToolsSkipped);
        System.out.println("Number of tools total: " + (iToolsCreated + iToolsSkipped));
        System.out.println("Generation successful: " + ((iToolsTotal == iToolsCreated + iToolsSkipped) ? "yes" : "no"));
    }
    
    public static void addPickaxeDataSet(Material rod, Material head, Material coating,
                                         Material decoration)
    {
        if (!(coating == head))
        {
            String codeName = codeName(rod, head, coating, decoration);
            String inGameName = inGameName(rod, head, coating, decoration);
            ResourceLocation rodTexture = rod.texture;
            ResourceLocation headTexture = head.texture;
            ResourceLocation coatingTexture = coating.texture;
            ResourceLocation decorationTexture = decoration.texture;
            int miningLevel = miningLevel(rod, head, coating, decoration);
            int durability = durability(rod, head, coating, decoration);
            int miningSpeed = miningSpeed(rod, head, coating, decoration);
            double durabilityModifier = durabilityModifier(rod, head, coating, decoration);
            double miningSpeedModifier = miningSpeedModifer(rod, head, coating, decoration);
            double attackSpeedModifier = attackSpeedModifier(rod, head, coating, decoration);
            
            //System.out.println("Tool " + iToolsCreated + ": " + inGameName);
            pickaxeDataSets.add(new PickaxeData(rod, head, coating, decoration));
            iToolsCreated++;
        }
        else
        {
            String inGameName = inGameName(rod, head, coating, decoration);
            //System.out.println("Skipped " + iToolsSkipped + ": skipped (same coating as head material): " + inGameName);
            iToolsSkipped++;
        }
        
    }
    
    public static String inGameName(Material rod, Material head, Material coating,
                                    Material decoration)
    {
        return "ToolTest: " + head.inGameNameGeneric + "pickaxe with " + rod.inGameNameGeneric + "rod, " + coating.inGameNameGeneric +
                "coating and " + decoration.inGameNameGeneric + "decoration.";
    }
    
    private static String codeName(Material rod, Material head, Material coating, Material decoration)
    {
        return "pickaxe_" + rod.codeName + "_" + head.codeName + "_" + coating.codeName + "_" + decoration.codeName;
    }
    
    private static int miningLevel(Material rod, Material head, Material coating, Material decoration)
    {
        return 1;
    }
    
    private static int durability(Material rod, Material head, Material coating, Material decoration)
    {
        return 1;
    }
    
    private static int miningSpeed(Material rod, Material head, Material coating, Material decoration)
    {
        return 1;
    }
    
    private static double durabilityModifier(Material rod, Material head, Material coating, Material decoration)
    {
        return 1;
    }
    
    private static double miningSpeedModifer(Material rod, Material head, Material coating, Material decoration)
    {
        return 1;
    }
    
    private static double attackSpeedModifier(Material rod, Material head, Material coating, Material decoration)
    {
        return 1;
    }
}
