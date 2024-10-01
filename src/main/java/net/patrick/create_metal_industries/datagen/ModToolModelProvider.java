package net.patrick.create_metal_industries.datagen;


import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.patrick.create_metal_industries.CreateMetalIndustries;
import net.patrick.create_metal_industries.item.ModTool;
import net.patrick.create_metal_industries.item.ModToolItems;
import net.patrick.create_metal_industries.item.material.ModToolCombinations;

// https://youtu.be/enzKJWq0vNI?t=406
public class ModToolModelProvider extends ItemModelProvider
{
    public ModToolModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
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
        
        handheldItem(ModToolItems.BRASS_SWORD);
        handheldItem(ModToolItems.BRASS_PICKAXE);
        handheldItem(ModToolItems.BRASS_AXE);
        handheldItem(ModToolItems.BRASS_SHOVEL);
        handheldItem(ModToolItems.BRASS_HOE);
        
        for (ModTool tool : ModToolCombinations.tools) {
            withExistingParent(tool.codeName, modLoc("item/cmi_pickaxe"))
                    .texture("rod", modLoc(tool.rodTexture))
                    .texture("head", modLoc(tool.headTexture))
                    .texture("coating", modLoc(tool.coatingTexture))
                    .texture("decoration", modLoc(tool.decorationTexture));
        }
        
        //////////////////////////////////////////////////
        //  WHEN ADDING NEW ELEMENTS TO THE ABOVE LIST  //
        //  MAKE SURE TO ALSO RUN THE "runData" GRADLE  //
        //////////////////////////////////////////////////
    }
    
    private ItemModelBuilder simpleItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CreateMetalIndustries.MOD_ID,"item/" + item.getId().getPath()));
    }
    
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(CreateMetalIndustries.MOD_ID,"item/" + item.getId().getPath()));
    }
    
}
