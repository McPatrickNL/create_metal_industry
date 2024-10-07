package net.patrick.create_metal_industries.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.patrick.create_metal_industries.CreateMetalIndustries;
import net.patrick.create_metal_industries.item.tool.CMIPickaxeItem;
import net.patrick.create_metal_industries.item.tool.ToolData;
import net.patrick.create_metal_industries.item.tool.ToolDataSets;
import net.patrick.create_metal_industries.item.tool.ToolTiers;

import java.util.HashMap;
import java.util.Map;

public class ToolItems
{
    public static final DeferredRegister<Item> TOOLS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreateMetalIndustries.MOD_ID);
    
    // Map to store the registered tools for future reference
    public static final Map<String, RegistryObject<Item>> REGISTERED_PICKAXES = new HashMap<>();
    public static final Map<String, Integer> REGISTERED_PICKAXE_ROD_COLORS = new HashMap<>();
    public static final Map<String, Integer> REGISTERED_PICKAXE_HEAD_COLORS = new HashMap<>();
    public static final Map<String, Integer> REGISTERED_PICKAXE_COATING_COLORS = new HashMap<>();
    public static final Map<String, Integer> REGISTERED_PICKAXE_DECORATION_COLORS = new HashMap<>();
    
    
    public static final RegistryObject<Item> BRASS_SWORD = TOOLS.register("brass_sword",
            () -> new SwordItem(ToolTiers.BRASS, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> BRASS_PICKAXE = TOOLS.register("brass_pickaxe",
            () -> new PickaxeItem(ToolTiers.BRASS, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> BRASS_AXE = TOOLS.register("brass_axe",
            () -> new AxeItem(ToolTiers.BRASS, 7, 1, new Item.Properties()));
    public static final RegistryObject<Item> BRASS_SHOVEL = TOOLS.register("brass_shovel",
            () -> new ShovelItem(ToolTiers.BRASS, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> BRASS_HOE = TOOLS.register("brass_hoe",
            () -> new HoeItem(ToolTiers.BRASS, 0, 0, new Item.Properties()));
    
    
    // Test to add items to a list
    
    // Method to register tools dynamically
    public static void registerTools() {
        
        // todo convert tool dataset into a list of actual tools first, extending the PickaxeItem class etc.
        
        for (ToolData toolData : ToolDataSets.pickaxeDataSets) {  // Iterate over tools in the list

            String toolName = toolData.codeName;  // "brass_pickaxe"  // Use codeName as the registry name
            System.out.println("TEST4: " + toolName);
            // Register the tool and store it in the map for future reference
            RegistryObject<Item> registeredTool = TOOLS.register(toolName,
                    () -> new CMIPickaxeItem(ToolTiers.BRASS, 1,
                            -2.8f,
                            0xFF0000, 0x00FF00, 0x0000FF, 0xFFFFFF,
                            new Item.Properties())
            );

            // Store the registered tool in the map for later access
            REGISTERED_PICKAXES.put(toolName, registeredTool);
            REGISTERED_PICKAXE_ROD_COLORS.put(toolName, toolData.rodMaterial.color);
            REGISTERED_PICKAXE_HEAD_COLORS.put(toolName, toolData.headMaterial.color);
            REGISTERED_PICKAXE_COATING_COLORS.put(toolName, toolData.coatingMaterial.color);
            REGISTERED_PICKAXE_DECORATION_COLORS.put(toolName, toolData.decorationMaterial.color);
        }
    }
    
    public static void register(IEventBus eventBus)
    {
        System.out.println("Test1");
        ToolDataSets.createToolDataSets();
        registerTools(); // My own interpretation of where ot place this. Which is after creating the list.
        TOOLS.register(eventBus);
    }
}
