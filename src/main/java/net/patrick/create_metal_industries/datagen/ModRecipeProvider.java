package net.patrick.create_metal_industries.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

// https://youtu.be/enzKJWq0vNI?t=821
public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public ModRecipeProvider(PackOutput pOutput)
    {
        super(pOutput);
    }
    
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer)
    {
        
    }
}