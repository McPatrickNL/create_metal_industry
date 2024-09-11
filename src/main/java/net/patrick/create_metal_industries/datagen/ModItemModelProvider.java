package net.patrick.create_metal_industries.datagen;


import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.patrick.create_metal_industries.CreateMetalIndustries;
import net.patrick.create_metal_industries.item.ModItems;

// https://youtu.be/enzKJWq0vNI?t=406
public class ModItemModelProvider extends ItemModelProvider
{
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, CreateMetalIndustries.MOD_ID, existingFileHelper);
    }
    
    @Override
    protected void registerModels()
    {
        //////////////////////////////////////////////////
        //  WHEN ADDING NEW ELEMENTS TO THE BELOW LIST  //
        //  MAKE SURE TO ALSO RUN THE "runData" GRADLE  //
        //////////////////////////////////////////////////
        
        bucketItem(ModItems.MOLTEN_BRASS_BUCKET); // 7:45
        bucketItem(ModItems.MOLTEN_COPPER_BUCKET);
        bucketItem(ModItems.MOLTEN_GOLD_BUCKET);
        bucketItem(ModItems.MOLTEN_IRON_BUCKET);
        bucketItem(ModItems.MOLTEN_NETHERITE_BUCKET);
        bucketItem(ModItems.MOLTEN_ZINC_BUCKET);
        
        ingotMoldItem(ModItems.UNCOOKED_INGOT_MOLD);
        ingotMoldItem(ModItems.EMPTY_INGOT_MOLD);
        ingotMoldItem(ModItems.BRASS_INGOT_MOLD);
        ingotMoldItem(ModItems.MOLTEN_BRASS_INGOT_MOLD);
        ingotMoldItem(ModItems.COPPER_INGOT_MOLD);
        ingotMoldItem(ModItems.MOLTEN_COPPER_INGOT_MOLD);
        ingotMoldItem(ModItems.GOLD_INGOT_MOLD);
        ingotMoldItem(ModItems.MOLTEN_GOLD_INGOT_MOLD);
        ingotMoldItem(ModItems.IRON_INGOT_MOLD);
        ingotMoldItem(ModItems.MOLTEN_IRON_INGOT_MOLD);
        ingotMoldItem(ModItems.NETHERITE_INGOT_MOLD);
        ingotMoldItem(ModItems.MOLTEN_NETHERITE_INGOT_MOLD);
        ingotMoldItem(ModItems.ZINC_INGOT_MOLD);
        ingotMoldItem(ModItems.MOLTEN_ZINC_INGOT_MOLD);
        
        //////////////////////////////////////////////////
        //  WHEN ADDING NEW ELEMENTS TO THE BELOW LIST  //
        //  MAKE SURE TO ALSO RUN THE "runData" GRADLE  //
        //////////////////////////////////////////////////
    }
    
    private ItemModelBuilder simpleItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CreateMetalIndustries.MOD_ID,"item/" + item.getId().getPath()));
    }
    
    private ItemModelBuilder ingotMoldItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CreateMetalIndustries.MOD_ID, "item/ingot_mold/" + item.getId().getPath()));
    }
    
    private ItemModelBuilder bucketItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CreateMetalIndustries.MOD_ID,"item/bucket/" + item.getId().getPath()));
    }
    
    /*
    // Create items with 3 texture layers.
    private ItemModelBuilder threeLayerItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0",
                new ResourceLocation(CreateMetalIndustries.MOD_ID,"item/" + item.getId().getPath()))
                .texture("layer1",
                new ResourceLocation(CreateMetalIndustries.MOD_ID,"item/" + item.getId().getPath()))
                .texture("layer2",
                new ResourceLocation(CreateMetalIndustries.MOD_ID,"item/" + item.getId().getPath()));
    }
    */
}
