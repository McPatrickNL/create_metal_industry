package net.patrick.create_metal_industries.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.patrick.create_metal_industries.CreateMetalIndustries;

import java.util.Map;

public class CreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateMetalIndustries.MOD_ID);
    
    public static final RegistryObject<CreativeModeTab> CREATE_METAL_INDUSTRIES_TAB = CREATIVE_MODE_TABS.register("create_metal_industries_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.MOLTEN_ZINC_BUCKET.get()))
                    .title(Component.translatable("creativetab.create_metal_industries_tab"))
                    .displayItems((pParameters, pOutput) ->
                    {
                        // Empty bucket
                        pOutput.accept(net.minecraft.world.item.Items.BUCKET);
                        
                        // Vanilla items
                        pOutput.accept(net.minecraft.world.item.Items.WATER_BUCKET);
                        pOutput.accept(net.minecraft.world.item.Items.LAVA_BUCKET);
                        pOutput.accept(net.minecraft.world.item.Items.MILK_BUCKET);
                        pOutput.accept(net.minecraft.world.item.Items.POWDER_SNOW_BUCKET);
                        
                        // Molten Metal Buckets
                        // todo x copy this
                        pOutput.accept(Items.MOLTEN_BRASS_BUCKET.get());
                        pOutput.accept(Items.MOLTEN_COPPER_BUCKET.get());
                        pOutput.accept(Items.MOLTEN_GOLD_BUCKET.get());
                        pOutput.accept(Items.MOLTEN_IRON_BUCKET.get());
                        pOutput.accept(Items.MOLTEN_NETHERITE_BUCKET.get());
                        pOutput.accept(Items.MOLTEN_ZINC_BUCKET.get());
                        
                        // Item molds
                        pOutput.accept(Items.UNCOOKED_INGOT_MOLD.get());
                        pOutput.accept(Items.EMPTY_INGOT_MOLD.get());
                        pOutput.accept(Items.BRASS_INGOT_MOLD.get());
                        pOutput.accept(Items.MOLTEN_BRASS_INGOT_MOLD.get());
                        pOutput.accept(Items.COPPER_INGOT_MOLD.get());
                        pOutput.accept(Items.MOLTEN_COPPER_INGOT_MOLD.get());
                        pOutput.accept(Items.GOLD_INGOT_MOLD.get());
                        pOutput.accept(Items.MOLTEN_GOLD_INGOT_MOLD.get());
                        pOutput.accept(Items.IRON_INGOT_MOLD.get());
                        pOutput.accept(Items.MOLTEN_IRON_INGOT_MOLD.get());
                        pOutput.accept(Items.NETHERITE_INGOT_MOLD.get());
                        pOutput.accept(Items.MOLTEN_NETHERITE_INGOT_MOLD.get());
                        pOutput.accept(Items.ZINC_INGOT_MOLD.get());
                        pOutput.accept(Items.MOLTEN_ZINC_INGOT_MOLD.get());
                    })
                    .build());
    
    public static final RegistryObject<CreativeModeTab> CREATE_METAL_INDUSTRIES_TOOLS_TAB = CREATIVE_MODE_TABS.register("create_metal_industries_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ToolItems.BRASS_PICKAXE.get()))
                    .title(Component.translatable("creativetab.create_metal_industries_tools_tab"))
                    .displayItems((pParameters, pOutput) ->
                    {
                        // Tools
                        pOutput.accept(ToolItems.BRASS_SWORD.get());
                        pOutput.accept(ToolItems.BRASS_PICKAXE.get());
                        pOutput.accept(ToolItems.BRASS_AXE.get());
                        pOutput.accept(ToolItems.BRASS_SHOVEL.get());
                        pOutput.accept(ToolItems.BRASS_HOE.get());
                        
                        // Generated Tools
                        for (Map.Entry<String, RegistryObject<Item>> entry : ToolItems.REGISTERED_PICKAXES.entrySet())
                        {
                            //System.out.println("wa");
                            pOutput.accept(entry.getValue().get());
                        }
                        for (Map.Entry<String, RegistryObject<Item>> entry : ToolItems.REGISTERED_SHOVELS.entrySet())
                        {
                            //System.out.println("wa");
                            pOutput.accept(entry.getValue().get());
                        }
                        for (Map.Entry<String, RegistryObject<Item>> entry : ToolItems.REGISTERED_AXES.entrySet())
                        {
                            //System.out.println("wa");
                            pOutput.accept(entry.getValue().get());
                        }
                        
                    })
                    .build());
    
    public static final RegistryObject<CreativeModeTab> LIQUIDS_TAB = CREATIVE_MODE_TABS.register("liquids_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(net.minecraft.world.item.Items.BUCKET))
                    .title(Component.translatable("creativetab.liquids_tab"))
                    .displayItems((pParameters, pOutput) ->
                    {
                        // Empty bucket
                        pOutput.accept(net.minecraft.world.item.Items.BUCKET);
                        
                        // Vanilla items
                        pOutput.accept(net.minecraft.world.item.Items.WATER_BUCKET);
                        pOutput.accept(net.minecraft.world.item.Items.LAVA_BUCKET);
                        pOutput.accept(net.minecraft.world.item.Items.MILK_BUCKET);
                        pOutput.accept(net.minecraft.world.item.Items.POWDER_SNOW_BUCKET);
                        
                        // Example for a modded item
                        //pOutput.accept(ModItems.SAPPHIRE.get());
                        //pOutput.accept(ModItems.SOAP_WATER_BUCKET.get());
                        // todo x copy this
                        pOutput.accept(Items.MOLTEN_BRASS_BUCKET.get());
                        pOutput.accept(Items.MOLTEN_COPPER_BUCKET.get());
                        pOutput.accept(Items.MOLTEN_GOLD_BUCKET.get());
                        pOutput.accept(Items.MOLTEN_IRON_BUCKET.get());
                        pOutput.accept(Items.MOLTEN_NETHERITE_BUCKET.get());
                        pOutput.accept(Items.MOLTEN_ZINC_BUCKET.get());
                        
                        // Vanilla mob buckets
                        pOutput.accept(net.minecraft.world.item.Items.AXOLOTL_BUCKET);
                        pOutput.accept(net.minecraft.world.item.Items.TADPOLE_BUCKET);
                        pOutput.accept(net.minecraft.world.item.Items.PUFFERFISH_BUCKET);
                        pOutput.accept(net.minecraft.world.item.Items.SALMON_BUCKET);
                        pOutput.accept(net.minecraft.world.item.Items.COD_BUCKET);
                        pOutput.accept(net.minecraft.world.item.Items.TROPICAL_FISH_BUCKET);
                    })
                    .build());
    
    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
