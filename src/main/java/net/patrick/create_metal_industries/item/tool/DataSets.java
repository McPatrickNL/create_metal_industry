package net.patrick.create_metal_industries.item.tool;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.patrick.create_metal_industries.item.tool.material.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataSets implements Abilities
{
    public static ArrayList<ToolData> pickaxeDataSets = new ArrayList<ToolData>(List.of());
    public static ArrayList<ToolData> shovelDataSets = new ArrayList<ToolData>(List.of());
    public static ArrayList<ToolData> axeDataSets = new ArrayList<ToolData>(List.of());
    public static Map<Integer, Boolean> hasAbility;
    public static List<ToolAbility> toolAbilities;
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
        System.out.println("Number of pickaxes expected: " + iToolsTotal);
        System.out.println("Number of shovels expected: " + iToolsTotal);
        System.out.println("Number of axes expected: " + iToolsTotal);
        System.out.println("Number of tools expected: " + iToolsTotal * 3);
        
        for (Material rod : rods)
        {
            for (Material head : heads)
            {
                for (Material coating : coatings)
                {
                    for (Material decoration : decorations)
                    {
                        addPickaxeDataSet(rod, head, coating, decoration);
                        addShovelDataSet(rod, head, coating, decoration);
                        addAxeDataSet(rod, head, coating, decoration);
                    }
                }
            }
        }
        
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
            String codeName = codeName("Pickaxe", rod, head, coating, decoration);
            String inGameName = inGameName("pickaxe", rod, head, coating, decoration);
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
            iToolsSkipped++;
        }
        
    }
    
    public static void addShovelDataSet(Material rod, Material head, Material coating,
                                         Material decoration)
    {
        if (!(coating == head))
        {
            String codeName = codeName("Shovel", rod, head, coating, decoration);
            String inGameName = inGameName("shovel", rod, head, coating, decoration);
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
            shovelDataSets.add(new ShovelData(rod, head, coating, decoration));
            iToolsCreated++;
        }
        else
        {
            iToolsSkipped++;
        }
        
    }
    
    public static void addAxeDataSet(Material rod, Material head, Material coating,
                                         Material decoration)
    {
        if (!(coating == head))
        {
            String codeName = codeName("Axe", rod, head, coating, decoration);
            String inGameName = inGameName("axe", rod, head, coating, decoration);
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
            axeDataSets.add(new AxeData(rod, head, coating, decoration));
            iToolsCreated++;
        }
        else
        {
            iToolsSkipped++;
        }
        
    }
    
    public static String inGameName(String toolName, Material rod, Material head, Material coating,
                                    Material decoration)
    {
        return head.inGameNameGeneric + toolName + " with " + rod.inGameNameGeneric + "rod, " + coating.inGameNameGeneric +
                "coating and " + decoration.inGameNameGeneric + "decoration.";
    }
    
    private static String codeName(String toolName, Material rod, Material head, Material coating, Material decoration)
    {
        return toolName + "_" + rod.codeName + "_" + head.codeName + "_" + coating.codeName + "_" + decoration.codeName;
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
