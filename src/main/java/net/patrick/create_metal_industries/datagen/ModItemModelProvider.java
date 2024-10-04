package net.patrick.create_metal_industries.datagen;


import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.patrick.create_metal_industries.CreateMetalIndustries;
import net.patrick.create_metal_industries.item.Items;
import net.patrick.create_metal_industries.item.ToolItems;
import net.patrick.create_metal_industries.item.tool.Pickaxe;
import net.patrick.create_metal_industries.item.tool.Tool;
import net.patrick.create_metal_industries.item.tool.Tools;

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
        
        bucketItem(Items.MOLTEN_BRASS_BUCKET, "brass"); // 7:45
        bucketItem(Items.MOLTEN_COPPER_BUCKET, "copper");
        bucketItem(Items.MOLTEN_GOLD_BUCKET, "gold");
        bucketItem(Items.MOLTEN_IRON_BUCKET, "iron");
        bucketItem(Items.MOLTEN_NETHERITE_BUCKET, "netherite");
        bucketItem(Items.MOLTEN_ZINC_BUCKET, "zinc");
        
        liquidIngotMoldItem(Items.UNCOOKED_INGOT_MOLD, "uncooked");
        liquidIngotMoldItem(Items.EMPTY_INGOT_MOLD, "empty");
        
        ingotMoldItem(Items.BRASS_INGOT_MOLD, "brass");
        ingotMoldItem(Items.COPPER_INGOT_MOLD, "copper");
        ingotMoldItem(Items.GOLD_INGOT_MOLD, "gold");
        ingotMoldItem(Items.IRON_INGOT_MOLD, "iron");
        ingotMoldItem(Items.NETHERITE_INGOT_MOLD, "netherite");
        ingotMoldItem(Items.ZINC_INGOT_MOLD, "zinc");
        
        liquidIngotMoldItem(Items.MOLTEN_BRASS_INGOT_MOLD, "brass");
        liquidIngotMoldItem(Items.MOLTEN_COPPER_INGOT_MOLD, "copper");
        liquidIngotMoldItem(Items.MOLTEN_GOLD_INGOT_MOLD, "gold");
        liquidIngotMoldItem(Items.MOLTEN_IRON_INGOT_MOLD, "iron");
        liquidIngotMoldItem(Items.MOLTEN_NETHERITE_INGOT_MOLD, "netherite");
        liquidIngotMoldItem(Items.MOLTEN_ZINC_INGOT_MOLD, "zinc");
        
        handheldItem(ToolItems.BRASS_SWORD);
        handheldItem(ToolItems.BRASS_PICKAXE);
        handheldItem(ToolItems.BRASS_AXE);
        handheldItem(ToolItems.BRASS_SHOVEL);
        handheldItem(ToolItems.BRASS_HOE);
        
        for (Pickaxe pickaxe : Tools.pickaxes) {
            System.out.println("TEST6: " + pickaxe.getToolData().codeName);
            withExistingParent(pickaxe.getToolData().codeName, new ResourceLocation(CreateMetalIndustries.MOD_ID,"item/cmi_pickaxe"))
                    .texture("rod", pickaxe.getToolData().rodMaterial.texture)
                    .texture("head", pickaxe.getToolData().headMaterial.texture)
                    .texture("coating", pickaxe.getToolData().coatingMaterial.texture)
                    .texture("decoration", pickaxe.getToolData().decorationMaterial.texture);
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
