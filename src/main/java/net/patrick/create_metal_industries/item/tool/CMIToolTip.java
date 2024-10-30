package net.patrick.create_metal_industries.item.tool;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.patrick.create_metal_industries.item.tool.material.Material;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CMIToolTip
{
    static List<Component> getToolTip(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced, int toolLevel)
    {
        // Make sure we're talking about the same thing here.
        if (!(pStack.getItem() instanceof CMITool tool))
        {
            return pTooltipComponents;
        }
        
        Material rodMaterial = tool.getRodMaterial();
        Material headMaterial = tool.getHeadMaterial();
        Material coatingMaterial = tool.getCoatingMaterial();
        Material decorationMaterial = tool.getDecorationMaterial();
        
        // Always visible basic information
        //pTooltipComponents.add(Component.literal(" "));
        
        
        // Shift-based advanced tooltip
        if (pIsAdvanced.isAdvanced() || Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.literal("- rod: ").append(Component.literal(rodMaterial.inGameNameGeneric).withStyle(rodMaterial.textFormat)));
            pTooltipComponents.add(Component.literal("- head: ").append(Component.literal(headMaterial.inGameNameGeneric).withStyle(headMaterial.textFormat)));
            pTooltipComponents.add(Component.literal("- coating: ").append(Component.literal(coatingMaterial.inGameNameGeneric).withStyle(coatingMaterial.textFormat)));
            pTooltipComponents.add(Component.literal("- decoration: ").append(Component.literal(decorationMaterial.inGameNameGeneric).withStyle(decorationMaterial.textFormat)));
            
            float defaultMiningSpeed = tool.getCustomMiningSpeed();
            float miningSpeed = defaultMiningSpeed * ((float) 128 * 2 / 128 * toolLevel) / 3;
            pTooltipComponents.add(Component.literal("Average speed: ").append(Component.literal(String.valueOf(miningSpeed)).withStyle(ChatFormatting.YELLOW)));
        } else
        {
            // Prompt to press Shift for more info
            pTooltipComponents.add(Component.literal("Hold [").withStyle(ChatFormatting.DARK_GRAY)
                    .append(Component.literal("Shift").withStyle(ChatFormatting.GRAY))
                    .append(Component.literal("] for more info").withStyle(ChatFormatting.DARK_GRAY)));
        }
        
        return pTooltipComponents;
    }
}
