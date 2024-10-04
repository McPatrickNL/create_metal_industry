package net.patrick.create_metal_industries.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.patrick.create_metal_industries.CreateMetalIndustries;
import net.patrick.create_metal_industries.fluid.ModFluids;
import net.patrick.create_metal_industries.item.Items;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CreateMetalIndustries.MOD_ID);
    
    
    //public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
    //        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    //public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block",
    //        () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));
    
    //public static final RegistryObject<LiquidBlock> SOAP_WATER_BLOCK = BLOCKS.register("soap_water_block",
    //        () -> new LiquidBlock(ModFluids.SOURCE_SOAP_WATER, BlockBehaviour.Properties.
    //                /*in his tutorial just "copy"*/copy(Blocks.WATER)));
    
    // Molten metals
    // todo x copy this
    public static final RegistryObject<LiquidBlock> MOLTEN_BRASS_BLOCK = BLOCKS.register("molten_brass_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_BRASS, BlockBehaviour.Properties.
                    copy(Blocks.LAVA).liquid().randomTicks()));
    
    public static final RegistryObject<LiquidBlock> MOLTEN_COPPER_BLOCK = BLOCKS.register("molten_copper_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_COPPER, BlockBehaviour.Properties.
                    copy(Blocks.LAVA).liquid().randomTicks()));
    
    public static final RegistryObject<LiquidBlock> MOLTEN_GOLD_BLOCK = BLOCKS.register("molten_gold_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_GOLD, BlockBehaviour.Properties.
                    copy(Blocks.LAVA).liquid().randomTicks()));
    
    public static final RegistryObject<LiquidBlock> MOLTEN_IRON_BLOCK = BLOCKS.register("molten_iron_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_IRON, BlockBehaviour.Properties.
                    copy(Blocks.LAVA).liquid().randomTicks()));
    
    public static final RegistryObject<LiquidBlock> MOLTEN_NETHERITE_BLOCK = BLOCKS.register("molten_netherite_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_NETHERITE, BlockBehaviour.Properties.
                    copy(Blocks.LAVA).liquid().randomTicks()));
    
    public static final RegistryObject<LiquidBlock> MOLTEN_ZINC_BLOCK = BLOCKS.register("molten_zinc_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_ZINC, BlockBehaviour.Properties.
                    copy(Blocks.LAVA).liquid().randomTicks()));
    
    
    
    
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return Items.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }
    
    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
