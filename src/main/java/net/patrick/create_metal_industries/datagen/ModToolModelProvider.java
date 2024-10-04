package net.patrick.create_metal_industries.datagen;


import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.patrick.create_metal_industries.CreateMetalIndustries;
import net.patrick.create_metal_industries.item.tool.Tool;
import net.patrick.create_metal_industries.item.tool.Tools;

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
        
//        Left out for now.
//        handheldItem(ModToolItems.BRASS_SWORD);
//        handheldItem(ModToolItems.BRASS_PICKAXE);
//        handheldItem(ModToolItems.BRASS_AXE);
//        handheldItem(ModToolItems.BRASS_SHOVEL);
//        handheldItem(ModToolItems.BRASS_HOE);
        
        for (Tool pickaxe : Tools.pickaxes) {
            System.out.println("TEST6: " + pickaxe.codeName);
            withExistingParent(pickaxe.codeName, modLoc("item/cmi_pickaxe"))
                    .texture("rod", pickaxe.rodTexture)
                    .texture("head", pickaxe.headTexture)
                    .texture("coating", pickaxe.coatingTexture)
                    .texture("decoration", pickaxe.decorationTexture);
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
