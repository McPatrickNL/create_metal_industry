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
    
    int iRods = 10;
    int iHead = 8;
    int iCoating = 7;
    
    //public static RegistryObject<Item> createTool("bla")
    
    public Object createTool(String toolType)
    {
        for(int x=0; x < iRods; x++)
        {
            for(int y=0; y < iHead; y++)
            {
                for(int z=0; z < iCoating; z++)
                {
                    addTools(toolType, x, y, z);
                }
            }
        }
        return true;
    }
    
    ModTool[][][] Tools = new ModTool[iRods][iHead][iCoating];
    
    public static void addTools(String toolType, int iRod, int iHead, int iCoating)
    {
        // empty still
        final RegistryObject<Item> BRASS_HOE = TOOLS.register("brass_hoe",
                () -> new HoeItem(ModToolTiers.BRASS, 0, 0, new Item.Properties()));
    }
    
    public static void register(IEventBus eventBus)
    {
        TOOLS.register(eventBus);
    }
}
