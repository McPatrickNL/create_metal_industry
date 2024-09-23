package net.patrick.create_metal_industries.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.patrick.create_metal_industries.CreateMetalIndustries;

public class ModToolItems
{
    public static final DeferredRegister<Item> TOOLS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreateMetalIndustries.MOD_ID);
    
    public static final RegistryObject<Item> BRASS_SWORD = TOOLS.register("brass_sword",
            () -> new SwordItem(ModToolTiers.BRASS, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> BRASS_PICKAXE = TOOLS.register("brass_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BRASS, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> BRASS_AXE = TOOLS.register("brass_axe",
            () -> new AxeItem(ModToolTiers.BRASS, 7, 1, new Item.Properties()));
    public static final RegistryObject<Item> BRASS_SHOVEL = TOOLS.register("brass_shovel",
            () -> new ShovelItem(ModToolTiers.BRASS, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> BRASS_HOE = TOOLS.register("brass_hoe",
            () -> new HoeItem(ModToolTiers.BRASS, 0, 0, new Item.Properties()));

    // EXAMPLE FROM THE ModItems CLASS
    // Ingot molds
    //private static String ingotMold(String str)         {return str + "_ingot_mold";}
    
    //public static final RegistryObject<Item> UNCOOKED_INGOT_MOLD = ITEMS.register (ingotMold("uncooked"),
    //        () -> new Item(new Item.Properties()));
    
    int iNumberRods = new ModToolData().iNumberRods;
    int iNumberHeads = new ModToolData().iNumberHeads;
    int iNumberCoatings = new ModToolData().iNumberCoatings;
    ModTool[][][] Swords = new ModTool[iNumberRods][iNumberHeads][iNumberCoatings];
    ModTool[][][] Pickaxes = new ModTool[iNumberRods][iNumberHeads][iNumberCoatings];
    ModTool[][][] Axes = new ModTool[iNumberRods][iNumberHeads][iNumberCoatings];
    ModTool[][][] Shovels = new ModTool[iNumberRods][iNumberHeads][iNumberCoatings];
    ModTool[][][] Hoes = new ModTool[iNumberRods][iNumberHeads][iNumberCoatings];
    ModToolData[][][] ToolData = new ModToolData[iNumberRods][iNumberHeads][iNumberCoatings];
    
    public ModToolItems ()
    {
        CreateTools(Swords, ToolData, "sword");
        CreateTools(Pickaxes, ToolData, "pickaxe");
        CreateTools(Axes, ToolData, "axe");
        CreateTools(Shovels, ToolData, "shovel");
        CreateTools(Hoes, ToolData, "hoe");
    }
    
    public void CreateTools(ModTool[][][] currentTool, ModToolData[][][] currentToolData, String currentToolName)
    {
        for(int iRod = 0; iRod < iNumberRods; iRod++)
        {
            for(int iHead = 0; iHead < iNumberHeads; iHead++)
            {
                for(int iCoating = 0; iCoating < iNumberCoatings; iCoating++)
                {
                    currentTool[iRod][iHead][iRod] = new ModTool();
                    currentTool[iRod][iHead][iCoating].sRodMaterial = currentToolData[iRod][iHead][iCoating].sRodMaterials[iRod];
                    currentTool[iRod][iHead][iCoating].sHeadMaterial = currentToolData[iRod][iHead][iCoating].sHeadMaterials[iHead];
                    currentTool[iRod][iHead][iCoating].sCoatingMaterial = currentToolData[iRod][iHead][iCoating].sCoatingMaterials[iCoating];
                    currentTool[iRod][iHead][iCoating].sToolName =
                            currentToolData[iRod][iHead][iCoating].sHeadMaterials[iHead]
                            +"_"+currentToolName+"_with_"+
                            currentToolData[iRod][iHead][iCoating].sRodMaterials[iRod]
                            +"_rod_and_"+
                            currentToolData[iRod][iHead][iCoating].sCoatingMaterials[iCoating]
                            +"_coating";
                    if (currentToolName.equals("sword"))
                    {
                        currentTool[iRod][iHead][iCoating].oTool = TOOLS.register(currentTool[iRod][iHead][iCoating].sToolName,
                                () -> new SwordItem(ModToolTiers.BRASS, 0, 0, new Item.Properties()));
                    }
                    if (currentToolName.equals("pickaxe"))
                    {
                        currentTool[iRod][iHead][iCoating].oTool = TOOLS.register(currentTool[iRod][iHead][iCoating].sToolName,
                                () -> new PickaxeItem(ModToolTiers.BRASS, 0, 0, new Item.Properties()));
                    }
                    if (currentToolName.equals("axe"))
                    {
                        currentTool[iRod][iHead][iCoating].oTool = TOOLS.register(currentTool[iRod][iHead][iCoating].sToolName,
                                () -> new AxeItem(ModToolTiers.BRASS, 0, 0, new Item.Properties()));
                    }
                    if (currentToolName.equals("shovel"))
                    {
                        currentTool[iRod][iHead][iCoating].oTool = TOOLS.register(currentTool[iRod][iHead][iCoating].sToolName,
                                () -> new ShovelItem(ModToolTiers.BRASS, 0, 0, new Item.Properties()));
                    }
                    if (currentToolName.equals("hoe"))
                    {
                        currentTool[iRod][iHead][iCoating].oTool = TOOLS.register(currentTool[iRod][iHead][iCoating].sToolName,
                                () -> new HoeItem(ModToolTiers.BRASS, 0, 0, new Item.Properties()));
                    }
                    
                }
            }
        }
    }
    
    
    // Simulated method to register a tool and return a RegistryObject<Item>
    private RegistryObject<Item> registerTool(String toolName) {
        // Simulate the registration process for each tool and return the corresponding RegistryObject<Item>
        // In actual code, this would use the Minecraft Forge registry system to register tools.
        return RegistryObject.of("somewhere", Item.class);
        
    }
    
    public static void register(IEventBus eventBus)
    {
        TOOLS.register(eventBus);
    }
}
