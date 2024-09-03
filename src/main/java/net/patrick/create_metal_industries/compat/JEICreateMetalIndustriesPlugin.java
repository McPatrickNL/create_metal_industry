package net.patrick.create_metal_industries.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.patrick.create_metal_industries.CreateMetalIndustries;

@JeiPlugin
public class JEICreateMetalIndustriesPlugin implements IModPlugin
{
    @Override
    public ResourceLocation getPluginUid()
    {
        return new ResourceLocation(CreateMetalIndustries.MOD_ID, "jei_plugin");
    }
    
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration)
    {
        IModPlugin.super.registerCategories(registration);
    }
    
    @Override
    public void registerRecipes(IRecipeRegistration registration)
    {
        IModPlugin.super.registerRecipes(registration);
    }
    
    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration)
    {
        IModPlugin.super.registerGuiHandlers(registration);
    }
}
