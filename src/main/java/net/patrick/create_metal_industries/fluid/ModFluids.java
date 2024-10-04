package net.patrick.create_metal_industries.fluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.patrick.create_metal_industries.CreateMetalIndustries;
import net.patrick.create_metal_industries.block.ModBlocks;
import net.patrick.create_metal_industries.item.Items;

public class ModFluids
{
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, CreateMetalIndustries.MOD_ID);
    
    // vvv Add new fluids below (flowing, source amd properties!) vvv
    //public static final RegistryObject<FlowingFluid> SOURCE_SOAP_WATER = FLUIDS.register("soap_water_fluid",
    //        () -> new ForgeFlowingFluid.Source(ModFluids.SOAP_WATER_FLUID_PROPERTIES));
    //public static final RegistryObject<FlowingFluid> FLOWING_SOAP_WATER = FLUIDS.register("flowing_soap_water",
    //        () -> new ForgeFlowingFluid.Flowing(ModFluids.SOAP_WATER_FLUID_PROPERTIES));
    //
    //public static final ForgeFlowingFluid.Properties SOAP_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
    //        ModFluidTypes.SOAP_WATER_FLUID_TYPE, SOURCE_SOAP_WATER, FLOWING_SOAP_WATER)
    //        /* de slope number is how much the height decreases. 1 is the longest flow, higher is shorter */
    //        .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.SOAP_WATER_BLOCK)
    //        .bucket(ModItems.SOAP_WATER_BUCKET);
    
    
    // Molten metals
    // todo x copy this
    public static final RegistryObject<FlowingFluid> SOURCE_MOLTEN_BRASS = FLUIDS.register("molten_brass_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_BRASS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_BRASS = FLUIDS.register("flowing_molten_brass_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_BRASS_PROPERTIES));
    
    public static final RegistryObject<FlowingFluid> SOURCE_MOLTEN_COPPER = FLUIDS.register("molten_copper_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_COPPER_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_COPPER = FLUIDS.register("flowing_molten_copper_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_COPPER_PROPERTIES));
    
    public static final RegistryObject<FlowingFluid> SOURCE_MOLTEN_GOLD = FLUIDS.register("molten_gold_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_GOLD_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_GOLD = FLUIDS.register("flowing_molten_gold_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_GOLD_PROPERTIES));
    
    public static final RegistryObject<FlowingFluid> SOURCE_MOLTEN_IRON = FLUIDS.register("molten_iron_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_IRON_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_IRON = FLUIDS.register("flowing_molten_iron_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_IRON_PROPERTIES));
    
    public static final RegistryObject<FlowingFluid> SOURCE_MOLTEN_NETHERITE = FLUIDS.register("molten_netherite_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_NETHERITE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_NETHERITE = FLUIDS.register("flowing_molten_netherite_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_NETHERITE_PROPERTIES));
    
    public static final RegistryObject<FlowingFluid> SOURCE_MOLTEN_ZINC = FLUIDS.register("molten_zinc_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_ZINC_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_ZINC = FLUIDS.register("flowing_molten_zinc_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_ZINC_PROPERTIES));
    
    // Molten metals
    // todo x copy this
    public static final ForgeFlowingFluid.Properties MOLTEN_BRASS_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_BRASS_FLUID_TYPE, SOURCE_MOLTEN_BRASS, FLOWING_MOLTEN_BRASS)
            /* de slope number is how much the height decreases. 1 is the longest flow, higher is shorter */
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.MOLTEN_BRASS_BLOCK)
            .bucket(Items.MOLTEN_BRASS_BUCKET);
    
    public static final ForgeFlowingFluid.Properties MOLTEN_COPPER_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_COPPER_FLUID_TYPE, SOURCE_MOLTEN_COPPER, FLOWING_MOLTEN_COPPER)
            /* de slope number is how much the height decreases. 1 is the longest flow, higher is shorter */
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.MOLTEN_COPPER_BLOCK)
            .bucket(Items.MOLTEN_COPPER_BUCKET);
    
    public static final ForgeFlowingFluid.Properties MOLTEN_GOLD_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_GOLD_FLUID_TYPE, SOURCE_MOLTEN_GOLD, FLOWING_MOLTEN_GOLD)
            /* de slope number is how much the height decreases. 1 is the longest flow, higher is shorter */
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.MOLTEN_GOLD_BLOCK)
            .bucket(Items.MOLTEN_GOLD_BUCKET);
    
    public static final ForgeFlowingFluid.Properties MOLTEN_IRON_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_IRON_FLUID_TYPE, SOURCE_MOLTEN_IRON, FLOWING_MOLTEN_IRON)
            /* de slope number is how much the height decreases. 1 is the longest flow, higher is shorter */
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.MOLTEN_IRON_BLOCK)
            .bucket(Items.MOLTEN_IRON_BUCKET);
    
    public static final ForgeFlowingFluid.Properties MOLTEN_NETHERITE_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_NETHERITE_FLUID_TYPE, SOURCE_MOLTEN_NETHERITE, FLOWING_MOLTEN_NETHERITE)
            /* de slope number is how much the height decreases. 1 is the longest flow, higher is shorter */
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.MOLTEN_NETHERITE_BLOCK)
            .bucket(Items.MOLTEN_NETHERITE_BUCKET);
    
    public static final ForgeFlowingFluid.Properties MOLTEN_ZINC_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_ZINC_FLUID_TYPE, SOURCE_MOLTEN_ZINC, FLOWING_MOLTEN_ZINC)
            /* de slope number is how much the height decreases. 1 is the longest flow, higher is shorter */
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.MOLTEN_ZINC_BLOCK)
            .bucket(Items.MOLTEN_ZINC_BUCKET);
    
    
    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
