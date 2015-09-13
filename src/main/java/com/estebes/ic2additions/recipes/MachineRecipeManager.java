package com.estebes.ic2additions.recipes;

import ic2.api.recipe.IMachineRecipeManagerExt;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeOutput;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MachineRecipeManager implements IMachineRecipeManagerExt
{
    private Map<IRecipeInput, RecipeOutput> recipes = new HashMap<IRecipeInput, RecipeOutput>();
    private Map<Item, RecipeOutput> auxRecipes = new HashMap<Item, RecipeOutput>();

    public MachineRecipeManager()
    {
        //TODO
    }

    @Override
    public void addRecipe(IRecipeInput input, NBTTagCompound metadata, ItemStack... outputs)
    {
        addRecipe(input, metadata, false, outputs);
    }

    @Override
    public boolean addRecipe(IRecipeInput input, NBTTagCompound metadata, boolean overwrite, ItemStack... outputs)
    {
        return addRecipe(input, new RecipeOutput(metadata, outputs));
    }

    @Override
    public RecipeOutput getOutputFor(ItemStack input, boolean adjustInput)
    {
        if(input == null)
        {
            return null;
        }
        else
        {
            for(IRecipeInput recipe : recipes.keySet())
            {
                if(recipe.matches(input))
                {
                    if(input.stackSize >= recipe.getAmount())
                    {
                        if(adjustInput)
                        {
                            input.stackSize -= recipe.getAmount();
                        }
                    }
                    return recipes.get(recipe);
                }
            }
        }
        return null;
    }

    @Override
    public Map<IRecipeInput, RecipeOutput> getRecipes()
    {
        return recipes;
    }

    public Set<Item> getAcceptedItems()
    {
        return auxRecipes.keySet();
    }

    private Boolean addRecipe(IRecipeInput input, RecipeOutput output)
    {
        if(input == null || output == null)
        {
            return false;
        }

        recipes.put(input, output);

        for(ItemStack itemstack : input.getInputs())
        {
            auxRecipes.put(itemstack.getItem(), output);
        }

        return true;
    }
}
