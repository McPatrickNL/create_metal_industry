package net.patrick.create_metal_industries.item.tool;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.patrick.create_metal_industries.CreateMetalIndustries;
import net.patrick.create_metal_industries.item.Items;
import net.patrick.create_metal_industries.tag.ModTags;

import java.util.List;

public class ToolTiers
{
    public static final Tier BRASS = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1500, 5f, 4f,25,
                    ModTags.Blocks.NEEDS_BRASS_TOOL, ()-> Ingredient.of(Items.UNCOOKED_INGOT_MOLD.get())),
            new ResourceLocation(CreateMetalIndustries.MOD_ID, "brass"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));//diamond might have to be netherite
    
}
