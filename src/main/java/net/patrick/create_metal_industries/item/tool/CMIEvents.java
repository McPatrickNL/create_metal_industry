package net.patrick.create_metal_industries.item.tool;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.patrick.create_metal_industries.CreateMetalIndustries;
import net.patrick.create_metal_industries.KeyBindings;

import java.util.*;

@Mod.EventBusSubscriber(modid = CreateMetalIndustries.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CMIEvents implements Abilities
{
    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event)
    {
        Player player = event.getEntity();
//        Msg(player,"=============== Event: BreakSpeed ===============");
        BlockState blockState = event.getState();
        int playerPosY;
        int seaLevel = 64 - -64; // +64 from y = 0;
        int heightFromBedrock; // player pos height from bedrock
        ItemStack heldItem = player.getMainHandItem();
        float defaultDestroySpeed;
        float newDestroySpeed;
        float blockPosY;
        
        if (heldItem.getItem() instanceof CMIPickaxeItem)
        {
            defaultDestroySpeed = heldItem.getItem().getDestroySpeed(heldItem, blockState);
            playerPosY = event.getEntity().blockPosition().getY();
            heightFromBedrock = playerPosY - -64;
            newDestroySpeed = defaultDestroySpeed * ( (float) heightFromBedrock / seaLevel );
            
            event.setNewSpeed(newDestroySpeed);
        }
    }
    
    @SubscribeEvent
    public static void onBlockBreakEvent(BlockEvent.BreakEvent event)
    {
        Player player = event.getPlayer();
        Msg(player, "=============== Event: BlockEvent.BreakEvent ===============");
        Level world = (Level) event.getLevel();
        BlockPos origin = event.getPos();
        BlockState blockState = world.getBlockState(origin);
        ItemStack heldItem = player.getItemInHand(event.getPlayer().getUsedItemHand());
        
        // Check if the player is holding the right key and the correct tool for the block
        if (KeyBindings.toolSpecialAbilityKey.isDown() && heldItem.isCorrectToolForDrops(blockState)) {
            
            // Get the list of abilities of the pickaxe
            List<ToolAbility> pickaxeAbilities = ((CMIPickaxeItem) heldItem.getItem()).getPickaxeAbilities(heldItem);
            
            // Find the veinMiner ability based on its ID
            ToolAbility veinMinerAbility = pickaxeAbilities.stream()
                    .filter(ability -> ability.abilityID == veinMinerID)
                    .findFirst()
                    .orElse(null);
            
            // Set default radius, and update if veinMiner ability is found
            int radius = 0; // Default radius in case veinMiner is not present
            if (veinMinerAbility != null) {
                radius = veinMinerAbility.abilityLevel; // Set radius to the veinMiner ability level
            }
            
            // Find similar blocks within the set radius
            List<BlockPos> similarBlocks = findSimilarBlocks(world, origin, blockState, radius);
            
            // Highlight and break blocks
            for (BlockPos pos : similarBlocks) {
                highlightBlock(world, pos); // Visual indication
                world.destroyBlock(pos, true, player); // Break block
            }
            
            Msg(player, "Mined " + similarBlocks.size() + " blocks");
        }
    }
    
    // Recursive method to find similar blocks around the mined block
    public static List<BlockPos> findSimilarBlocks(Level world, BlockPos origin, BlockState originalState, int radius)
    {
        List<BlockPos> foundBlocks = new ArrayList<>();
        Set<BlockPos> visited = new HashSet<>();
        Queue<BlockPos> toCheck = new LinkedList<>();
        
        toCheck.add(origin);
        visited.add(origin);
        
        while (!toCheck.isEmpty() && foundBlocks.size() < 100) // Limit to 100 blocks to prevent overload
        {
            BlockPos current = toCheck.poll();
            BlockState state = world.getBlockState(current);
            
            if (state.getBlock() == originalState.getBlock())
            {
                foundBlocks.add(current);
                
                // Check surrounding blocks
                for (Direction direction : Direction.values())
                {
                    BlockPos neighbor = current.relative(direction);
                    if (!visited.contains(neighbor) && neighbor.distSqr(origin) <= radius * radius)
                    {
                        toCheck.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
        
        return foundBlocks;
    }
    
    // Method to highlight a block (e.g., using particles)
    public static void highlightBlock(Level world, BlockPos pos)
    {
        if (world instanceof ServerLevel serverLevel)
        {
            // Example: Spawn particles to highlight the block
//            serverLevel.sendParticles(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
//                    10, 0.5, 0.5, 0.5, 0.1);
            serverLevel.sendParticles(ParticleTypes.END_ROD, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    10, 0.5, 0.5, 0.5, 0.1);
        }
    }
    
    public static void Msg(Player player, String message)
    {
        player.sendSystemMessage(Component.literal(message));
    }
}