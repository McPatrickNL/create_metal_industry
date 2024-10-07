package net.patrick.create_metal_industries;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.patrick.create_metal_industries.block.ModBlocks;
import net.patrick.create_metal_industries.fluid.ModFluidTypes;
import net.patrick.create_metal_industries.fluid.ModFluids;
import net.patrick.create_metal_industries.item.CreativeModeTabs;
import net.patrick.create_metal_industries.item.Items;
import net.patrick.create_metal_industries.item.ToolItems;
import net.patrick.create_metal_industries.item.tool.Pickaxe;
import net.patrick.create_metal_industries.item.tool.Tools;
import net.patrick.create_metal_industries.item.tool.material.Material;
import net.patrick.create_metal_industries.item.tool.material.Materials;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CreateMetalIndustries.MOD_ID)
public class CreateMetalIndustries
{
    // ========================================================================== //
    //
    //  VARIABLE DECLARATION
    //  Tell the class about the existence of those variables
    //
    // ========================================================================== //
    
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "create_metal_industries";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    
    public static ArrayList<Material> rods;
    public static ArrayList<Material> heads;
    public static ArrayList<Material> coatings;
    public static ArrayList<Material> decorations;
    public static ArrayList<Pickaxe> pickaxes;
//    public static ArrayList<Axe> axes;
//    public static ArrayList<Shovel> shovels;
//    public static ArrayList<Hoe> hoes;
//    public static ArrayList<Sword> swords;
    
    // ========================================================================== //
    //
    //  STATIC INITIALIZERS
    //  Initializes ones at class initialization
    //
    // ========================================================================== //
//    static
//    {
//
//    }
    
    // ========================================================================== //
    //
    //  INSTANCE INITIALIZERS
    //  Initializes every time an object is initialized
    //
    // ========================================================================== //
    
//    {
//        System.out.println("Instance initialization.");
//        // empty
//    }
    
    // ========================================================================== //
    //
    //  CONSTRUCTORS
    //
    // ========================================================================== //
    public CreateMetalIndustries()
    {
        
        System.out.println("Class: CreateMetalIndustries - Static initialization.");
        System.out.println("Generate rods");
        rods = new Materials().getRodMaterials();
        System.out.println("Generate ");
        heads = new Materials().getHeadMaterials();
        System.out.println("Generate ");
        coatings = new Materials().getCoatingMaterials();
        System.out.println("Generate ");
        decorations = new Materials().getDecorationMaterials();
        System.out.println("Generate " + decorations.get(2).codeName);
        
        pickaxes = new ArrayList<Pickaxe>(List.of());
        pickaxes = Tools.createPickaxeCombinations(rods, heads, coatings, decorations);
        
        System.out.println("Test9 " + pickaxes.get(4).getToolData().codeName);
        
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        

        // Register the Deferred Register to the mod event bus so blocks get registered
        ModBlocks.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        Items.register(modEventBus);
        // Create Tool items and Register them
        ToolItems.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CreativeModeTabs.register(modEventBus);
        // Register Fluids
        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        // USE THIS MAYBE FOR LOADING DATA FROM JSON FOR MATERIALS???
        // https://stackoverflow.com/questions/62760706/read-from-external-file-in-a-minecraft-mod
        // https://cadiboo.github.io/tutorials/1.15.1/forge/3.3-config/
        // https://www.youtube.com/watch?v=QN9jq3_V-I8
        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    
    // ========================================================================== //
    //
    //  METHODS
    //
    // ========================================================================== //
    private void commonSetup(final FMLCommonSetupEvent event)
    {
        /*
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
        */
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == net.minecraft.world.item.CreativeModeTabs.INGREDIENTS)
        {
            //event.accept(ModItems.SAPPHIRE);
            //event.accept(ModItems.RAW_SAPPHIRE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        //LOGGER.info("HELLO from server starting");
    }
    
    
    // ========================================================================== //
    //
    //  INNER CLASSES
    //
    // ========================================================================== //
    
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            //ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_SOAP_WATER.get(), RenderType.translucent());
            //ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SOAP_WATER.get(), RenderType.translucent());
            
            // Molten metals
            // todo x copy this
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_MOLTEN_BRASS.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_MOLTEN_BRASS.get(), RenderType.solid());
            
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_MOLTEN_COPPER.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_MOLTEN_COPPER.get(), RenderType.solid());
            
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_MOLTEN_GOLD.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_MOLTEN_GOLD.get(), RenderType.solid());
            
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_MOLTEN_IRON.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_MOLTEN_IRON.get(), RenderType.solid());
            
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_MOLTEN_NETHERITE.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_MOLTEN_NETHERITE.get(), RenderType.solid());
            
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_MOLTEN_ZINC.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_MOLTEN_ZINC.get(), RenderType.solid());
        }
    }
}
