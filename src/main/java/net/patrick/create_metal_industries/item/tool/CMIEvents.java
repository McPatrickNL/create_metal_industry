package net.patrick.create_metal_industries.item.tool;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.patrick.create_metal_industries.CreateMetalIndustries;
import net.patrick.create_metal_industries.KeyBindings;
import net.patrick.create_metal_industries.item.tool.material.Material;

import java.util.*;

@Mod.EventBusSubscriber(modid = CreateMetalIndustries.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CMIEvents implements Abilities, CMIWorldLayers
{
    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event)
    {
        Player player = event.getEntity();
        BlockState blockState = event.getState();
        int playerPosY;
        int distFromBedrock; // player pos height from bedrock
        ItemStack heldItem = player.getMainHandItem();
        float defaultDestroySpeed;
        int toolLevel;
        
        if (heldItem.getItem() instanceof CMITool tool)
        {
            event.setNewSpeed(tool.calculateDestroySpeed(player, tool, (int)player.getY()));
        }
    }
    
    public static float calculateDestroySpeed(CMITool tool, int yLevel)
    {
        Material rodMaterial = tool.getRodMaterial();
        Material headMaterial = tool.getHeadMaterial();
        Material coatingMaterial = tool.getCoatingMaterial();
        Material decorationMaterial = tool.getDecorationMaterial();
        
        int rodSpeed = rodMaterial.miningSpeed;
        int headSpeed = headMaterial.miningSpeed;
        int coatingSpeed = coatingMaterial.miningSpeed;
        int decorationSpeed = decorationMaterial.miningSpeed;
        float globalSpeedModifier = 1;
        float toolSpeed = (rodSpeed + headSpeed + coatingSpeed + decorationSpeed) * globalSpeedModifier;
        
        int distFromBedrock = yLevel + 64 + 3; // + 3 to compensate for the player being able to reach down from his level
        int currentLayer = yToLayerMap.get(distFromBedrock);
        int toolLevel = tool.getToolLevel();
        int layerMaxY = layerMaxYMap.get(currentLayer);
        int layerMinY = layerMinYMap.get(currentLayer);
        float layerDifference = layerMaxY - layerMinY;
        
        if(currentLayer == toolLevel)
        {
            return toolSpeed;
        }
        else if (currentLayer == toolLevel - 1)
        {
            return toolSpeed / ( 100 * (layerMaxY - distFromBedrock) / layerDifference );
        }
        else if (currentLayer <= toolLevel - 1)
        {
            return toolSpeed / 100;
        }
        else if (currentLayer == toolLevel + 1)
        {
            return toolSpeed * ( 3 * (distFromBedrock - layerMinY) / layerDifference );
        }
        else
        {
            return toolSpeed * 3;
        }
    }
    
    @SubscribeEvent
    public static void onBlockBreakEvent(BlockEvent.BreakEvent event)
    {
        Player player = event.getPlayer();
        Level world = (Level) event.getLevel();
        BlockPos origin = event.getPos();
        BlockState blockState = world.getBlockState(origin);
        ItemStack heldItem = player.getItemInHand(event.getPlayer().getUsedItemHand());
        
        if (KeyBindings.toolSpecialAbilityKey.isDown() && heldItem.isCorrectToolForDrops(blockState) && heldItem.getItem() instanceof CMIPickaxeItem)
        {
            List<ToolAbility> pickaxeAbilities = ((CMIPickaxeItem) heldItem.getItem()).getToolAbilities(heldItem);
            ToolAbility veinMinerAbility = pickaxeAbilities.stream()
                    .filter(ability -> ability.abilityID == veinMinerID)
                    .findFirst()
                    .orElse(null);
            
            int blockLimit = 0;
            int blocksPerLevel = 16; // Set how many blocks per ability level
            
            // Determine the block limit based on the treeFeller ability level
            if (veinMinerAbility != null) {
                blockLimit = veinMinerAbility.abilityLevel * blocksPerLevel;
            }
            
            // Only proceed if the blockLimit is greater than zero
            if (blockLimit > 0) {
                if (!findSimilarBlocks(player, world, origin, blockState, blockLimit, true))
                {
                    // not used because mining from the start always involves the origin
                    //event.setCanceled(true);
                }
            }
        }
        
        if (KeyBindings.toolSpecialAbilityKey.isDown() && heldItem.isCorrectToolForDrops(blockState) && heldItem.getItem() instanceof CMIAxeItem)
        {
            List<ToolAbility> axeAbilities = ((CMIAxeItem) heldItem.getItem()).getToolAbilities(heldItem);
            ToolAbility treeFellerAbility = axeAbilities.stream()
                    .filter(ability -> ability.abilityID == treeFellerID)
                    .findFirst()
                    .orElse(null);
            
            int blockLimit = 0;
            int blocksPerLevel = 8; // Set how many blocks per ability level
            
            // Determine the block limit based on the treeFeller ability level
            if (treeFellerAbility != null) {
                blockLimit = treeFellerAbility.abilityLevel * blocksPerLevel;
            }
            
            // Only proceed if the blockLimit is greater than zero
            if (blockLimit > 0) {
                if (!findSimilarBlocks(player, world, origin, blockState, blockLimit, false))
                {
                    Msg(player, "THIS IS A TEST");
                    event.setCanceled(true);
                }
            }
            
        }
    }
    
    // ====== TREE FELLER ====== //
    
    public static boolean findSimilarBlocks(Player player, Level world, BlockPos origin, BlockState originalState, int blockLimit,
                                            boolean mineFromBeginning)
    {
        //Msg(player, "Started searching the surroundings of this block");
        //Msg(player, "Origin coördinates: X = " + origin.getX() + ", Y = " + origin.getY() + ", Z = " + origin.getZ());
        
        Map<Integer, Map<Integer, BlockPos>> foundBlocksLists = new HashMap<>();
        
        // A map with all the BlockPos found, with incrementing integer (highest value is always furthest away)
        // Only matches
        Map<Integer, BlockPos> foundBlocks = new HashMap<>();
        
        // A map with all blocks that have already been checked to prevent duplicates.
        // Matches AND other
        Map<Integer, BlockPos> checkedBlocks = new HashMap<>();
        
        // A map to put all the blocks surrounding the currently checked blocks in
        // Next layer of blocks to check
        // Not needed because I directly process the blocks as I check which are surrounding the current layer.
        Map<Integer, BlockPos> toCheckBlocks = new HashMap<>();
        
        // A map to with the last round of matching blocks
        Map<Integer, BlockPos> lastFoundBlocks = new HashMap<>();
        
        // A map to with the last round of matching blocks
        Map<Integer, BlockPos> blocksToMine = new HashMap<>();
        
        // Put the origin in the new maps
        checkedBlocks.put(0, origin);
        foundBlocks.put(0, origin);
        lastFoundBlocks.put(0, origin);
        foundBlocksLists.put(0, lastFoundBlocks); // make 1 a dynamic integer
        toCheckBlocks.put(0, origin);
        
        int numBlocksFound = 1; // start as 1 because that's the origin
        int numLastBlocksFound = 0; // start as 0 because it resets every iteration
        int blocksChecked = 1; // start as 1 because that's the origin
        int iCurrentLayer = 0; // start as 0 because I first have to check the origin inside the main loop
        int failSafe = 256; // Max number of blocks to index to prevent overloading
        boolean stop = false;
        BlockPos currentPos;
        boolean mineOrigin = false;
        
        // add a super loop (while loop?)
        
        boolean continueSearching = true;
        //Msg(player, "About to enter the while loop");
        while (continueSearching)
        {
            //Msg(player, "Current layer: " + iCurrentLayer);
            //Msg(player, "toCheckBlocks size: " + toCheckBlocks.size());
            // Loop all blocks that were found in the latest iteration
            for(BlockPos previouslyFoundBlock : toCheckBlocks.values())
            {
                //Msg(player, "prevFoundBl: X = " + previouslyFoundBlock.getX() + ", Y = " + previouslyFoundBlock.getY() + ", Z = " + previouslyFoundBlock.getZ());
                // Offset combinations for surrounding blocks in a 3x3x3 cube
                for (int x = -1; x <= 1 && !stop; x++) {
                    for (int y = -1; y <= 1 && !stop; y++) {
                        for (int z = -1; z <= 1 && !stop; z++) {
                            // check all blocks surrounding the previously found block
                            currentPos = previouslyFoundBlock.offset(x,y,z);
                            //Msg(player, "currentPos: X = " + currentPos.getX() + ", Y = " + currentPos.getY() + ", Z = " + currentPos.getZ());
                            
                            // Skip the current block (0,0,0) since it's not a surrounding block
                            // Also skip if it has already been checked and added to the checkedBlocks map
                            if ((x != 0 || y != 0 || z != 0) && !checkedBlocks.containsValue(currentPos))
                            {
                                //Msg(player, "It's a match!"); // confirmed working
                                // add it to the checkedBlocks map and increment the counter
                                checkedBlocks.put(blocksChecked, currentPos);
                                blocksChecked++;
                                
                                // Check to see if it's a match
                                if (world.getBlockState(currentPos).getBlock() == originalState.getBlock())
                                {
                                    lastFoundBlocks.put(numLastBlocksFound, currentPos);
                                    numLastBlocksFound++;
                                    //Msg(player, "lastFoundBlocks size: " + lastFoundBlocks.size());
                                    foundBlocks.put(numBlocksFound, currentPos);
                                    numBlocksFound++;
                                    if(numBlocksFound >= failSafe)
                                    {
                                        stop = true;
                                    }
                                }
                            }
                        }
                    }
                }
                if(stop)
                {
                    break; // exit for loop, continue While loop
                }
            }
            numLastBlocksFound = 0;
            if (lastFoundBlocks.isEmpty() || stop) // search till empty or overload
            {
                //Msg(player, "lastFoundBlocks is empty, end while loop");
                continueSearching = false;
            }
            iCurrentLayer++;
            foundBlocksLists.put(iCurrentLayer, new HashMap<Integer,BlockPos>(lastFoundBlocks));
            toCheckBlocks.clear();
            toCheckBlocks.putAll(lastFoundBlocks);
            lastFoundBlocks.clear();
        }
        
        if(mineFromBeginning)
        {
            mineOrigin = MineFirstBlocks(player, world, origin, originalState, foundBlocksLists, blockLimit, numBlocksFound, iCurrentLayer);
        }
        else // mine from end
        {
            mineOrigin = MineLastBlocks(player, world, origin, originalState, foundBlocksLists, blockLimit, numBlocksFound, iCurrentLayer);
        }
        
        return mineOrigin;
    }
    
    public static boolean MineLastBlocks(Player player, Level world, BlockPos origin, BlockState originalState,
                                         Map<Integer, Map<Integer, BlockPos>> foundBlocksLists,
                                         int numBlocksToMine, int numBlocksFound, int numLayers)
    {
        // A map to with the last round of matching blocks
        Map<Integer, BlockPos> blocksToMine = new HashMap<>();
        
        boolean mineOrigin = false;
        
        // Find some blocks to mine
        int toMineBlocks = numBlocksToMine;
        if(toMineBlocks >= numBlocksFound)
        {
            toMineBlocks=numBlocksFound-1;
            mineOrigin = true;
        }
        
        //Msg(player, "Found " + numBlocksFound + ", about to mine " + toMineBlocks + " blocks and origin");
        
        while(toMineBlocks > 0)
        {
            for(var foundBlock : foundBlocksLists.get(numLayers).entrySet())
            {
                blocksToMine.put(toMineBlocks, foundBlock.getValue());
                toMineBlocks--;
            }
            numLayers--;
        }
        
        // Loop through the list of found tree blocks and destroy each block
        for (BlockPos pos : blocksToMine.values()) {
            highlightBlock(world, pos); // Highlight the block before destroying
            if( pos != origin)
            {
                world.destroyBlock(pos, true, player); // Destroy the block and drop the items
            }
        }
        
        return mineOrigin;
    }
    
    public static boolean MineFirstBlocks(Player player, Level world, BlockPos origin, BlockState originalState,
                                         Map<Integer, Map<Integer, BlockPos>> foundBlocksLists,
                                         int numBlocksToMine, int numBlocksFound, int numLayers)
    {
        // A map to with the last round of matching blocks
        Map<Integer, BlockPos> blocksToMine = new HashMap<>();
        
        boolean mineOrigin = false;
        
        // Find some blocks to mine
        int toMineBlocks = numBlocksToMine;
        if(toMineBlocks >= numBlocksFound)
        {
            toMineBlocks=numBlocksFound-1;
            mineOrigin = true;
        }
        
        Msg(player, "Found " + numBlocksFound + ", about to mine " + toMineBlocks + " blocks and origin");
        
        int currentBlock = 0;
        int currentLayer = 0;
        while(currentBlock < toMineBlocks)
        {
            for(var foundBlock : foundBlocksLists.get(currentLayer).entrySet())
            {
                blocksToMine.put(currentBlock, foundBlock.getValue());
                currentBlock++;
            }
            currentLayer++;
            if(currentLayer > numLayers)
            {
                Msg(player, "Searching for layer " + currentLayer + ", max layers: " + numLayers);
                break;
            }
        }
        
        // Loop through the list of found tree blocks and destroy each block
        for (BlockPos pos : blocksToMine.values()) {
            highlightBlock(world, pos); // Highlight the block before destroying
            if( pos != origin)
            {
                world.destroyBlock(pos, true, player); // Destroy the block and drop the items
            }
        }
        
        return mineOrigin;
    }
    
    public static void highlightBlock(Level world, BlockPos pos)
    {
        if (world instanceof ServerLevel serverLevel)
        {
            serverLevel.sendParticles(ParticleTypes.END_ROD, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    10, 0.5, 0.5, 0.5, 0.1);
        }
    }
    
    public static void Msg(Player player, String message)
    {
        player.sendSystemMessage(Component.literal(message));
    }
}