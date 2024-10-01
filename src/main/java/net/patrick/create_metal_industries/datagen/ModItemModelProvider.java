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
import net.patrick.create_metal_industries.item.ModTool;
import net.patrick.create_metal_industries.item.ModToolCombinations;
import net.patrick.create_metal_industries.item.ModToolItems;

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
        
        bucketItem(ModItems.MOLTEN_BRASS_BUCKET, "brass"); // 7:45
        bucketItem(ModItems.MOLTEN_COPPER_BUCKET, "copper");
        bucketItem(ModItems.MOLTEN_GOLD_BUCKET, "gold");
        bucketItem(ModItems.MOLTEN_IRON_BUCKET, "iron");
        bucketItem(ModItems.MOLTEN_NETHERITE_BUCKET, "netherite");
        bucketItem(ModItems.MOLTEN_ZINC_BUCKET, "zinc");
        
        liquidIngotMoldItem(ModItems.UNCOOKED_INGOT_MOLD, "uncooked");
        liquidIngotMoldItem(ModItems.EMPTY_INGOT_MOLD, "empty");
        
        ingotMoldItem(ModItems.BRASS_INGOT_MOLD, "brass");
        ingotMoldItem(ModItems.COPPER_INGOT_MOLD, "copper");
        ingotMoldItem(ModItems.GOLD_INGOT_MOLD, "gold");
        ingotMoldItem(ModItems.IRON_INGOT_MOLD, "iron");
        ingotMoldItem(ModItems.NETHERITE_INGOT_MOLD, "netherite");
        ingotMoldItem(ModItems.ZINC_INGOT_MOLD, "zinc");
        
        liquidIngotMoldItem(ModItems.MOLTEN_BRASS_INGOT_MOLD, "brass");
        liquidIngotMoldItem(ModItems.MOLTEN_COPPER_INGOT_MOLD, "copper");
        liquidIngotMoldItem(ModItems.MOLTEN_GOLD_INGOT_MOLD, "gold");
        liquidIngotMoldItem(ModItems.MOLTEN_IRON_INGOT_MOLD, "iron");
        liquidIngotMoldItem(ModItems.MOLTEN_NETHERITE_INGOT_MOLD, "netherite");
        liquidIngotMoldItem(ModItems.MOLTEN_ZINC_INGOT_MOLD, "zinc");
        
        handheldItem(ModToolItems.BRASS_SWORD);
        handheldItem(ModToolItems.BRASS_PICKAXE);
        handheldItem(ModToolItems.BRASS_AXE);
        handheldItem(ModToolItems.BRASS_SHOVEL);
        handheldItem(ModToolItems.BRASS_HOE);
        
        for (ModTool tool : ModToolCombinations.tools) {
            System.out.println("TEST6: " + tool.codeName);
            withExistingParent(tool.codeName, modLoc("item/cmi_pickaxe"))
                    .texture("rod", tool.rodTexture)
                    .texture("head", tool.headTexture)
                    .texture("coating", tool.coatingTexture)
                    .texture("decoration", tool.decorationTexture);
        }
        
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
    
    private ItemModelBuilder liquidIngotMoldItem(RegistryObject<Item> item, String metal)
    {
        if(metal.equals("uncooked"))
        {
            return withExistingParent(item.getId().getPath(),
                    new ResourceLocation("item/generated"))
                    .texture("layer0",
                            new ResourceLocation(CreateMetalIndustries.MOD_ID, "item/mold/uncooked_ingot_mold"));
        }
        else if (metal.equals("empty"))
        {
            return withExistingParent(item.getId().getPath(),
                    new ResourceLocation("item/generated"))
                    .texture("layer0",
                            new ResourceLocation(CreateMetalIndustries.MOD_ID, "item/mold/empty_ingot_mold"));
        }
        else
        {
            return withExistingParent(item.getId().getPath(),
                    new ResourceLocation("item/generated"))
                    .texture("layer0",
                            new ResourceLocation(CreateMetalIndustries.MOD_ID, "item/fluid/molten_" + metal + "_fluid"))
                    .texture("layer1",
                            new ResourceLocation(CreateMetalIndustries.MOD_ID, "item/mold/empty_ingot_mold"));
        }
    }
    
    private ItemModelBuilder ingotMoldItem(RegistryObject<Item> item, String metal)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0",
                        new ResourceLocation(CreateMetalIndustries.MOD_ID, "item/mold/blank_mold"))
                .texture("layer1",
                        new ResourceLocation(CreateMetalIndustries.MOD_ID, "item/ingot/" + metal + "_ingot"));
    }
    
    private ItemModelBuilder bucketItem(RegistryObject<Item> item, String metal)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CreateMetalIndustries.MOD_ID,"item/bucket/" + item.getId().getPath()));
    }
    
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(CreateMetalIndustries.MOD_ID,"item/" + item.getId().getPath()));
    }
    
}
