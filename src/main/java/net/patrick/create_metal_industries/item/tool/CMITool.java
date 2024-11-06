package net.patrick.create_metal_industries.item.tool;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.patrick.create_metal_industries.item.tool.material.Material;

import java.util.List;

public interface CMITool extends CMIWorldLayers
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
    
    default float calculateDestroySpeed(Player player, CMITool tool, int yLevel)
    {
        // todo POSSIBLY INDEX OUT OF BOUND WITH MAP USING LAYER + AND - 1.
        
        
        Material rodMaterial = this.getRodMaterial();
        Material headMaterial = this.getHeadMaterial();
        Material coatingMaterial = this.getCoatingMaterial();
        Material decorationMaterial = this.getDecorationMaterial();
        
        
        int rodSpeed = rodMaterial.miningSpeed;
        int headSpeed = headMaterial.miningSpeed;
        int coatingSpeed = coatingMaterial.miningSpeed;
        int decorationSpeed = decorationMaterial.miningSpeed;
        float globalSpeedModifier = 10;
        float toolSpeed = (rodSpeed + headSpeed + coatingSpeed + decorationSpeed) * globalSpeedModifier;
        
        int currentLayer;
        
        int distFromBedrock = yLevel + 64 + 3; // + 3 to compensate for the player being able to reach down from his level
        try {currentLayer = yToLayerMap.get(distFromBedrock);}
        catch(NullPointerException e)
        {
            currentLayer = 1;
        }
        int toolLevel = tool.getToolLevel();
        int layerMaxY = layerMaxYMap.get(currentLayer);
        int layerMinY = layerMinYMap.get(currentLayer);
        float layerDifference = layerMaxY - layerMinY;
        
        Msg(player,"==========");
        Msg(player,"y pos " + yLevel);
        Msg(player,"bedr. " + distFromBedrock);
        Msg(player,"layer " + currentLayer);
        Msg(player,"level " + toolLevel);
        
        if(currentLayer == toolLevel)
        {
            System.out.println("TEST1");
            return toolSpeed;
        }
        else if (currentLayer == toolLevel - 1 && currentLayer != 1)
        {
            System.out.println("TEST2");
            return toolSpeed / ( 100 * (layerMaxY - distFromBedrock) / layerDifference );
        }
        else if (currentLayer <= toolLevel - 1)
        {
            System.out.println("TEST3");
            return toolSpeed / 100;
        }
        else if (currentLayer == toolLevel + 1 && currentLayer != 8)
        {
            System.out.println("TEST4");
            return toolSpeed * ( 3 * (distFromBedrock - layerMinY) / layerDifference );
        }
        else
        {
            System.out.println("TEST5");
            return toolSpeed * 3;
        }
    }
    
    public static void Msg(Player player, String message)
    {
        player.sendSystemMessage(Component.literal(message));
    }
}
