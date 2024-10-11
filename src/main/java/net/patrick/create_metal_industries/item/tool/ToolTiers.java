package net.patrick.create_metal_industries.item.tool;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.patrick.create_metal_industries.CreateMetalIndustries;
import net.patrick.create_metal_industries.item.Items;
import net.patrick.create_metal_industries.item.tool.material.Material;
import net.patrick.create_metal_industries.tag.ModTags;

import java.util.ArrayList;
import java.util.List;

public class ToolTiers
{
    
    
    
    public static final Tier BRASS = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1500, 5f, 4f,25,
                    ModTags.Blocks.NEEDS_BRASS_TOOL, ()-> Ingredient.of(Items.UNCOOKED_INGOT_MOLD.get())),
            new ResourceLocation(CreateMetalIndustries.MOD_ID, "brass"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));//diamond might have to be netherite
    
    
    public static final ArrayList<Tier> CMITiers = new ArrayList<>();
    
    // overwrite speed tiers in this class, so it gets called hopefully when retrieving the tools speed.
    // Make this speed method try to get block data from the runtime.
    // If fai then default? If success use dynamic formula.
    
    public static Tier NewCMITier(Material rod, Material head, Material coating, Material decoration)
    {
        return BRASS; // placeholder to avoid the error message.
    }
    
}
