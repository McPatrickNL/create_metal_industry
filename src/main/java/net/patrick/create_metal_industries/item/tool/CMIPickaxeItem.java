package net.patrick.create_metal_industries.item.tool;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

public class CMIPickaxeItem extends PickaxeItem
{
    private final int rodColor;
    private final int headColor;
    private final int coatingColor;
    private final int decorationColor;
    
    public CMIPickaxeItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier,
                          int rodColor, int headColor, int coatingColor, int decorationColor,
                          Properties pProperties)
    {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        this.rodColor = rodColor;
        this.headColor = headColor;
        this.coatingColor = coatingColor;
        this.decorationColor = decorationColor;
    }
    
    public int getColor(ItemStack stack, int tintIndex) {
        // tintIndex corresponds to the layer of the texture:
        // tintIndex 0 for layer0, tintIndex 1 for layer1, etc.
        switch (tintIndex) {
            case 0:
                return this.rodColor; // Red for layer 0
            case 1:
                return this.headColor; // Green for layer 1
            case 2:
                return this.coatingColor; // Blue for layer 2
            case 3:
                return this.decorationColor; // White for layer 3
            default:
                return 0xFFFFFF; // Default color (white)
        }
    }
    
}
