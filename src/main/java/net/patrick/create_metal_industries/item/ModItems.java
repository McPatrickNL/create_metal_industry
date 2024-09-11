package net.patrick.create_metal_industries.item;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.patrick.create_metal_industries.CreateMetalIndustries;
import net.patrick.create_metal_industries.fluid.ModFluids;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CreateMetalIndustries.MOD_ID);
    
    //public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
    //        () -> new Item(new Item.Properties()));
    //public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
    //        () -> new Item(new Item.Properties()));
    
    // Bucket Items
    //public static final RegistryObject<Item> SOAP_WATER_BUCKET = ITEMS.register("soap_water_bucket",
    //        () -> new BucketItem(ModFluids.SOURCE_SOAP_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    
    // Molten metals
    // todo x copy this
    private static String bucket(String str)    {return "molten_" + str + "_bucket";}
    
    public static final RegistryObject<Item> MOLTEN_BRASS_BUCKET = ITEMS.register(bucket("brass"),
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_BRASS, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    
    public static final RegistryObject<Item> MOLTEN_COPPER_BUCKET = ITEMS.register(bucket("copper"),
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_COPPER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    
    public static final RegistryObject<Item> MOLTEN_GOLD_BUCKET = ITEMS.register(bucket("gold"),
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_GOLD, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    
    public static final RegistryObject<Item> MOLTEN_IRON_BUCKET = ITEMS.register(bucket("iron"),
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_IRON, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    
    public static final RegistryObject<Item> MOLTEN_NETHERITE_BUCKET = ITEMS.register(bucket("netherite"),
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_NETHERITE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    
    public static final RegistryObject<Item> MOLTEN_ZINC_BUCKET = ITEMS.register(bucket("zinc"),
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_ZINC, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    
    
    // Ingot molds
    private static String ingotMold(String str)         {return str + "_ingot_mold";}
    private static String moltenIngotMold(String str)   {return "molten_" + str + "_ingot_mold";}
    
    public static final RegistryObject<Item> UNCOOKED_INGOT_MOLD = ITEMS.register (ingotMold("uncooked"),
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMPTY_INGOT_MOLD = ITEMS.register (ingotMold("empty"),
            () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> BRASS_INGOT_MOLD = ITEMS.register (ingotMold("brass"),
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MOLTEN_BRASS_INGOT_MOLD = ITEMS.register (moltenIngotMold("brass"),
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_INGOT_MOLD = ITEMS.register (ingotMold("copper"),
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MOLTEN_COPPER_INGOT_MOLD = ITEMS.register (moltenIngotMold("copper"),
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_INGOT_MOLD = ITEMS.register (ingotMold("gold"),
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MOLTEN_GOLD_INGOT_MOLD = ITEMS.register (moltenIngotMold("gold"),
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_INGOT_MOLD = ITEMS.register (ingotMold("iron"),
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MOLTEN_IRON_INGOT_MOLD = ITEMS.register (moltenIngotMold("iron"),
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_INGOT_MOLD = ITEMS.register (ingotMold("netherite"),
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MOLTEN_NETHERITE_INGOT_MOLD = ITEMS.register (moltenIngotMold("netherite"),
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZINC_INGOT_MOLD = ITEMS.register (ingotMold("zinc"),
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MOLTEN_ZINC_INGOT_MOLD = ITEMS.register (moltenIngotMold("zinc"),
            () -> new Item(new Item.Properties()));
    
    
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
