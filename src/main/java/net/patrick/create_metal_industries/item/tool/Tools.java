package net.patrick.create_metal_industries.item.tool;

import net.minecraft.world.item.Item;
import net.patrick.create_metal_industries.item.tool.material.*;

import java.util.ArrayList;


public class Tools
{
    public static ArrayList<Pickaxe> pickaxes = new ArrayList<Pickaxe>();
    
    // method:
    public static ArrayList<Pickaxe> createPickaxeCombinations(ArrayList<Material> rods, ArrayList<Material> heads,
                                                               ArrayList<Material> coatings, ArrayList<Material> decorations)
    {
        System.out.println("Number of tools: " + rods.size()*heads.size()*coatings.size()*
                decorations.size());
        System.out.println("TEST8: 1st rod: " + rods.get(0).codeName);
        
        rods.forEach( rod ->
                heads.forEach( head ->
                        coatings.forEach( coating ->
                                decorations.forEach( decoration ->
                                        {
                                            System.out.println("spam");
                                            pickaxes.add(new Pickaxe(new Tool(rod, head, coating, decoration), new Item.Properties()));
                                        }
                                )
                        )
                )
        );
        
        return pickaxes;
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
    
    private static double MiningSpeedModifier(Material rod, Material head, Material coating, Material decoration)
    {
        return 1;
    }
    
    private static float AttackSpeedModifier(Material rod, Material head, Material coating, Material decoration)
    {
        return 1;
    }
}
