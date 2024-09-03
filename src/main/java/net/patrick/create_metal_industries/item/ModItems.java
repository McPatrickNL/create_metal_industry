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
    public static final RegistryObject<Item> MOLTEN_BRASS_BUCKET = ITEMS.register("molten_brass_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_BRASS, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    
    public static final RegistryObject<Item> MOLTEN_COPPER_BUCKET = ITEMS.register("molten_copper_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_COPPER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    
    public static final RegistryObject<Item> MOLTEN_GOLD_BUCKET = ITEMS.register("molten_gold_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_GOLD, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    
    public static final RegistryObject<Item> MOLTEN_IRON_BUCKET = ITEMS.register("molten_iron_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_IRON, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    
    public static final RegistryObject<Item> MOLTEN_NETHERITE_BUCKET = ITEMS.register("molten_netherite_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_NETHERITE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    
    public static final RegistryObject<Item> MOLTEN_ZINC_BUCKET = ITEMS.register("molten_zinc_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_ZINC, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    
    
    
    
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
