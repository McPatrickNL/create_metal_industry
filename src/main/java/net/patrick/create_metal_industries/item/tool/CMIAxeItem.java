package net.patrick.create_metal_industries.item.tool;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.patrick.create_metal_industries.item.tool.material.Material;

import java.util.List;

public class CMIAxeItem extends AxeItem
{
    private final Material rodMaterial;
    private final Material headMaterial;
    private final Material coatingMaterial;
    private final Material decorationMaterial;
    private final List<ToolAbility> axeAbilities;
    
    public CMIAxeItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier,
                      Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial,
                      Properties pProperties, List<ToolAbility> axeAbilities)
    {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        this.rodMaterial = rodMaterial;
        this.headMaterial = headMaterial;
        this.coatingMaterial = coatingMaterial;
        this.decorationMaterial = decorationMaterial;
        this.axeAbilities = axeAbilities;
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
    
    public List<ToolAbility> getAxeAbilities(ItemStack stack)
    {
        return this.axeAbilities;
    }
    
}