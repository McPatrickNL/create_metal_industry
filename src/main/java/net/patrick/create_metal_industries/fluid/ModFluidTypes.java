package net.patrick.create_metal_industries.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.patrick.create_metal_industries.CreateMetalIndustries;
import org.joml.Vector3f; ///!!!


public class ModFluidTypes
{
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation LAVA_STILL_RL = new ResourceLocation("block/lava_still");
    public static final ResourceLocation LAVA_FLOWING_RL = new ResourceLocation("block/lava_flow");
    //public static final ResourceLocation METAL_STILL_RL = new ResourceLocation("block/molten_metal_still");
    //public static final ResourceLocation METAL_FLOWING_RL = new ResourceLocation("block/molten_metal_flow");
    public static final ResourceLocation METAL_STILL_RL = new ResourceLocation(CreateMetalIndustries.MOD_ID, "block/lava_still");
    public static final ResourceLocation METAL_FLOWING_RL = new ResourceLocation(CreateMetalIndustries.MOD_ID, "block/lava_flow");
    ///* might not be used */public static final ResourceLocation SOAP_OVERLAY_RL = new ResourceLocation(CreateMetalIndustries.MOD_ID, "misc/in_soap_water");
    
    // Molten metals ///// I SKIPPED THIS ONE
    // todo x copy this
    /* might not be used */public static final ResourceLocation MOLTEN_IRON_OVERLAY_RL = new ResourceLocation(CreateMetalIndustries.MOD_ID, "misc/in_soap_water");
    
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, CreateMetalIndustries.MOD_ID);
    
    // vvv Add new fluids below vvv
    //public static final RegistryObject<FluidType> SOAP_WATER_FLUID_TYPE = register("soap_water_fluid",
    //        FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
    //                SoundEvents.HONEY_DRINK));
    
    // Molten metals //// THIS IS STILL GENERIC NEEDS TO BE SPECIFIC
    // todo x copy this
    public static final RegistryObject<FluidType> MOLTEN_BRASS_FLUID_TYPE = registerMetals("molten_brass_fluid",
            FluidType.Properties.create().lightLevel(7).density(200).viscosity(300).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK).canHydrate(false).temperature(800),
            0xA1FF9B2F,
            255f,
            155f,
            47f);
    
    public static final RegistryObject<FluidType> MOLTEN_COPPER_FLUID_TYPE = registerMetals("molten_copper_fluid",
            FluidType.Properties.create().lightLevel(7).density(200).viscosity(300).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK).canHydrate(false).temperature(800),
            0xA1FF6C40,
            255f,
            108f,
            64f);
    
    public static final RegistryObject<FluidType> MOLTEN_GOLD_FLUID_TYPE = registerMetals("molten_gold_fluid",
            FluidType.Properties.create().lightLevel(7).density(200).viscosity(300).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK).canHydrate(false).temperature(800),
            0xA1FFBA1E,
            255f,
            200f,
            30f);
    
    public static final RegistryObject<FluidType> MOLTEN_IRON_FLUID_TYPE = registerMetals("molten_iron_fluid",
            FluidType.Properties.create().lightLevel(7).density(200).viscosity(300).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK).canHydrate(false).temperature(800),
            0xA1FF4140,
            255f,
            65f,
            64f);
    
    public static final RegistryObject<FluidType> MOLTEN_NETHERITE_FLUID_TYPE = registerMetals("molten_netherite_fluid",
            FluidType.Properties.create().lightLevel(7).density(200).viscosity(300).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK).canHydrate(false).temperature(800),
            0xA1473F40,
            71f,
            63f,
            64f);
    
    public static final RegistryObject<FluidType> MOLTEN_ZINC_FLUID_TYPE = registerMetals("molten_zinc_fluid",
            FluidType.Properties.create().lightLevel(7).density(200).viscosity(300).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK).canHydrate(false).temperature(800),
            0xA1256E5F,
            37f,
            110f,
            95f);
    
    // ^^^ Add new fluids above ^^^
    
    //private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
    //    return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, SOAP_OVERLAY_RL,
    //            0xA1E038D0, new Vector3f(224f / 255f, 56f / 255f, 208f / 255f), properties));
    //}
    
    // Molten metals  //// MAYBE DON'T COPY THIS AFTER ALL, I MADE IT GENERIC NOW
    // todo x copy this
    private static RegistryObject<FluidType> registerMetals(String name, FluidType.Properties properties, int hex, float r, float g, float b) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(METAL_STILL_RL, METAL_FLOWING_RL, MOLTEN_IRON_OVERLAY_RL,
                hex, new Vector3f(r / 255f, g / 255f, b / 255f), properties));
    }
    
    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
