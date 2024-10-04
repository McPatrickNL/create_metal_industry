package net.patrick.create_metal_industries.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.patrick.create_metal_industries.CreateMetalIndustries;
import net.patrick.create_metal_industries.item.tool.Pickaxe;
import net.patrick.create_metal_industries.item.tool.Tool;
import net.patrick.create_metal_industries.item.tool.Tools;
import net.patrick.create_metal_industries.item.tool.ToolTiers;

import java.util.HashMap;
import java.util.Map;

public class ToolItems
{
    public static final DeferredRegister<Item> TOOLS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreateMetalIndustries.MOD_ID);
    
    // Map to store the registered tools for future reference
    public static final Map<String, RegistryObject<Item>> REGISTERED_TOOLS = new HashMap<>();
    
    
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
        
        for (Pickaxe toolData : Tools.pickaxes) {  // Iterate over tools in the list

            String toolName = toolData.getToolData().codeName;  // "brass_pickaxe"  // Use codeName as the registry name
            System.out.println("TEST4: " + toolName);
            // Register the tool and store it in the map for future reference
            RegistryObject<Item> registeredTool = TOOLS.register(
                    toolName,  // The tool's codeName is used for registration
                    () -> new PickaxeItem(
                            ToolTiers.BRASS,  // Using netherite for everything now. I will implement my own system at some point.
                            1,  // Dynamic mining speed
                            -2.8f,  // Default attack speed (adjust if needed)
                            new Item.Properties()  // Default properties, can be expanded
                    )
            );

            // Store the registered tool in the map for later access
            REGISTERED_TOOLS.put(toolName, registeredTool);
        }
    
    
    }
    
    public static void register(IEventBus eventBus)
    {
        System.out.println("Test1");
        Tools.createToolCombinations();
        registerTools(); // My own interpretation of where ot place this. Which is after creating the list.
        TOOLS.register(eventBus);
    }
}
