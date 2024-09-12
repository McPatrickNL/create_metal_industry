package net.patrick.create_metal_industries.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.patrick.create_metal_industries.CreateMetalIndustries;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateMetalIndustries.MOD_ID);
    
    public static final RegistryObject<CreativeModeTab> CREATE_METAL_INDUSTRIES_TAB = CREATIVE_MODE_TABS.register("create_metal_industries_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MOLTEN_ZINC_BUCKET.get()))
                    .title(Component.translatable("creativetab.create_metal_industries_tab"))
                    .displayItems((pParameters, pOutput) ->
                    {
                        // Empty bucket
                        pOutput.accept(Items.BUCKET);
                        
                        // Vanilla items
                        pOutput.accept(Items.WATER_BUCKET);
                        pOutput.accept(Items.LAVA_BUCKET);
                        pOutput.accept(Items.MILK_BUCKET);
                        pOutput.accept(Items.POWDER_SNOW_BUCKET);
                        
                        // Molten Metal Buckets
                        // todo x copy this
                        pOutput.accept(ModItems.MOLTEN_BRASS_BUCKET.get());
                        pOutput.accept(ModItems.MOLTEN_COPPER_BUCKET.get());
                        pOutput.accept(ModItems.MOLTEN_GOLD_BUCKET.get());
                        pOutput.accept(ModItems.MOLTEN_IRON_BUCKET.get());
                        pOutput.accept(ModItems.MOLTEN_NETHERITE_BUCKET.get());
                        pOutput.accept(ModItems.MOLTEN_ZINC_BUCKET.get());
                        
                        // Item molds
                        pOutput.accept(ModItems.UNCOOKED_INGOT_MOLD.get());
                        pOutput.accept(ModItems.EMPTY_INGOT_MOLD.get());
                        pOutput.accept(ModItems.BRASS_INGOT_MOLD.get());
                        pOutput.accept(ModItems.MOLTEN_BRASS_INGOT_MOLD.get());
                        pOutput.accept(ModItems.COPPER_INGOT_MOLD.get());
                        pOutput.accept(ModItems.MOLTEN_COPPER_INGOT_MOLD.get());
                        pOutput.accept(ModItems.GOLD_INGOT_MOLD.get());
                        pOutput.accept(ModItems.MOLTEN_GOLD_INGOT_MOLD.get());
                        pOutput.accept(ModItems.IRON_INGOT_MOLD.get());
                        pOutput.accept(ModItems.MOLTEN_IRON_INGOT_MOLD.get());
                        pOutput.accept(ModItems.NETHERITE_INGOT_MOLD.get());
                        pOutput.accept(ModItems.MOLTEN_NETHERITE_INGOT_MOLD.get());
                        pOutput.accept(ModItems.ZINC_INGOT_MOLD.get());
                        pOutput.accept(ModItems.MOLTEN_ZINC_INGOT_MOLD.get());
                    })
                    .build());
    
    public static final RegistryObject<CreativeModeTab> CREATE_METAL_INDUSTRIES_TOOLS_TAB = CREATIVE_MODE_TABS.register("create_metal_industries_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModToolItems.BRASS_PICKAXE.get()))
                    .title(Component.translatable("creativetab.create_metal_industries_tools_tab"))
                    .displayItems((pParameters, pOutput) ->
                    {
                        // Tools
                        pOutput.accept(ModToolItems.BRASS_SWORD.get());
                        pOutput.accept(ModToolItems.BRASS_PICKAXE.get());
                        pOutput.accept(ModToolItems.BRASS_AXE.get());
                        pOutput.accept(ModToolItems.BRASS_SHOVEL.get());
                        pOutput.accept(ModToolItems.BRASS_HOE.get());
                    })
                    .build());
    
    public static final RegistryObject<CreativeModeTab> LIQUIDS_TAB = CREATIVE_MODE_TABS.register("liquids_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.BUCKET))
                    .title(Component.translatable("creativetab.liquids_tab"))
                    .displayItems((pParameters, pOutput) ->
                    {
                        // Empty bucket
                        pOutput.accept(Items.BUCKET);
                        
                        // Vanilla items
                        pOutput.accept(Items.WATER_BUCKET);
                        pOutput.accept(Items.LAVA_BUCKET);
                        pOutput.accept(Items.MILK_BUCKET);
                        pOutput.accept(Items.POWDER_SNOW_BUCKET);
                        
                        // Example for a modded item
                        //pOutput.accept(ModItems.SAPPHIRE.get());
                        //pOutput.accept(ModItems.SOAP_WATER_BUCKET.get());
                        // todo x copy this
                        pOutput.accept(ModItems.MOLTEN_BRASS_BUCKET.get());
                        pOutput.accept(ModItems.MOLTEN_COPPER_BUCKET.get());
                        pOutput.accept(ModItems.MOLTEN_GOLD_BUCKET.get());
                        pOutput.accept(ModItems.MOLTEN_IRON_BUCKET.get());
                        pOutput.accept(ModItems.MOLTEN_NETHERITE_BUCKET.get());
                        pOutput.accept(ModItems.MOLTEN_ZINC_BUCKET.get());
                        
                        // Vanilla mob buckets
                        pOutput.accept(Items.AXOLOTL_BUCKET);
                        pOutput.accept(Items.TADPOLE_BUCKET);
                        pOutput.accept(Items.PUFFERFISH_BUCKET);
                        pOutput.accept(Items.SALMON_BUCKET);
                        pOutput.accept(Items.COD_BUCKET);
                        pOutput.accept(Items.TROPICAL_FISH_BUCKET);
                    })
                    .build());
    
    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
