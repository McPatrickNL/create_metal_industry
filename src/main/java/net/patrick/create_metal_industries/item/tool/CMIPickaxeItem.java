package net.patrick.create_metal_industries.item.tool;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.patrick.create_metal_industries.item.tool.material.Material;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CMIPickaxeItem extends PickaxeItem implements CMITool
{
    private final Material rodMaterial;
    private final Material headMaterial;
    private final Material coatingMaterial;
    private final Material decorationMaterial;
    private final List<ToolAbility> pickaxeAbilities;
    private final int toolLevel;
    
    public CMIPickaxeItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier,
                          Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial,
                          Properties pProperties, List<ToolAbility> pickaxeAbilities)
    {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        this.rodMaterial = rodMaterial;
        this.headMaterial = headMaterial;
        this.coatingMaterial = coatingMaterial;
        this.decorationMaterial = decorationMaterial;
        this.pickaxeAbilities = pickaxeAbilities;
        this.toolLevel = setToolLevel(rodMaterial, headMaterial, coatingMaterial, decorationMaterial);
    }
    
    public int getColor(ItemStack stack, int tintIndex) {
        // tintIndex corresponds to the layer of the texture:
        // tintIndex 0 for layer0, tintIndex 1 for layer1, etc.
        switch (tintIndex) {
            case 0:
                return this.rodMaterial.color; // Red for layer 0
            case 1:
                return this.headMaterial.color; // Green for layer 1
            case 2:
                return this.coatingMaterial.color; // Blue for layer 2
            case 3:
                return this.decorationMaterial.color; // White for layer 3
            default:
                return 0xFFFFFF; // Default color (white)
        }
    }
    
    public int getToolLevel()
    {
        return toolLevel;
    }
    
    public List<ToolAbility> getToolAbilities(ItemStack stack)
    {
        return this.pickaxeAbilities;
    }
    
    public float getCustomMiningSpeed() {
        return this.getAttackDamage();
    }
    
    @Override
    public Material getRodMaterial()
    {
        return rodMaterial;
    }
    
    @Override
    public Material getHeadMaterial()
    {
        return headMaterial;
    }
    
    @Override
    public Material getCoatingMaterial()
    {
        return coatingMaterial;
    }
    
    @Override
    public Material getDecorationMaterial()
    {
        return decorationMaterial;
    }
    
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        
        List<Component> pNewTooltipComponents = CMIToolTip.getToolTip(pStack, pLevel, pTooltipComponents, pIsAdvanced, toolLevel);
        
        super.appendHoverText(pStack, pLevel, pNewTooltipComponents, pIsAdvanced);
    }
}
