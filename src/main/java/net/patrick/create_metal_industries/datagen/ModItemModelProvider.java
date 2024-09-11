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
        
        simpleItem(ModItems.MOLTEN_BRASS_BUCKET); // 7:45
        simpleItem(ModItems.MOLTEN_COPPER_BUCKET);
        simpleItem(ModItems.MOLTEN_GOLD_BUCKET);
        simpleItem(ModItems.MOLTEN_IRON_BUCKET);
        simpleItem(ModItems.MOLTEN_NETHERITE_BUCKET);
        simpleItem(ModItems.MOLTEN_ZINC_BUCKET);
        
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
                new ResourceLocation("item/ingot_mold/generated")).texture("layer0",
                new ResourceLocation(CreateMetalIndustries.MOD_ID,"item/ingot_mold/" + item.getId().getPath()));
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
