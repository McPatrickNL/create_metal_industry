package net.patrick.create_metal_industries.item.tool;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.patrick.create_metal_industries.item.tool.material.Material;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface CMITool
{
    public int getColor(ItemStack stack, int tintIndex);
    
    public int getToolLevel();
    
    default int setToolLevel(Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial)
    {
        int rodLevel = rodMaterial.miningLevel;
        int headLevel = headMaterial.miningLevel;
        int coatingLevel = coatingMaterial.miningLevel;
        int decorationLevel = decorationMaterial.miningLevel;
        int sum = rodLevel + headLevel + coatingLevel + decorationLevel;
        int highest = Math.max(
                Math.max(rodLevel, headLevel),
                Math.max(coatingLevel, decorationLevel));
        
        return highest + (int) (sum * 0.2);
    }
    
    public List<ToolAbility> getToolAbilities(ItemStack stack);
    
    public float getCustomMiningSpeed();
    
    public Material getRodMaterial();
    
    public Material getHeadMaterial();
    
    public Material getCoatingMaterial();
    
    public Material getDecorationMaterial();
}
