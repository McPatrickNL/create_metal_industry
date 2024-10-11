package net.patrick.create_metal_industries.item.tool;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.patrick.create_metal_industries.CreateMetalIndustries;

@Mod.EventBusSubscriber(modid = CreateMetalIndustries.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlockBreakSpeedModifier
{
    
    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event)
    {
        Player player = event.getEntity();
        BlockState blockState = event.getState();
        int playerPosY;
        int seaLevel = 64 - -64; // +64 from y = 0;
        int heightFromBedrock; // +128 from bedrock
        ItemStack heldItem = player.getMainHandItem();
        float defaultDestroySpeed;
        float newDestroySpeed;
        float blockPosY;
        
        // Example: If the player is holding a specific tool (e.g., Brass Pickaxe)
        if (heldItem.getItem() instanceof CMIPickaxeItem)
        {
            defaultDestroySpeed = heldItem.getItem().getDestroySpeed(heldItem, blockState);
            playerPosY = event.getEntity().blockPosition().getY();
            heightFromBedrock = playerPosY - -64;
            newDestroySpeed = defaultDestroySpeed * ( (float) heightFromBedrock / seaLevel );
            
            event.setNewSpeed(newDestroySpeed);
            
        }
        
        // You can also modify the speed based on other conditions, like block type
//        if (blockState.getBlock() == Blocks.STONE)
//        {
//            event.setNewSpeed(event.getNewSpeed() * 1.5f); // Increase speed for stone blocks
//        }
    }
}