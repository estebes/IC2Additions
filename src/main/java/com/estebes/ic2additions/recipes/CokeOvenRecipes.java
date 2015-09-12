package com.estebes.ic2additions.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class CokeOvenRecipes
{
    private static final CokeOvenRecipes cokeOvenRecipes = new CokeOvenRecipes();

    private Map recipeList = new HashMap();

    public static CokeOvenRecipes getCokeOvenRecipes()
    {
        return cokeOvenRecipes;
    }

    private CokeOvenRecipes()
    {

    }

    public void addRecipe(Block input, ItemStack output)
    {
        addRecipe(Item.getItemFromBlock(input), output);
    }

    public void addRecipe(Item input, ItemStack output)
    {
        addRecipe(new ItemStack(input, 1), output);
    }

    public void addRecipe(ItemStack input, ItemStack output)
    {
        recipeList.put(input, output);
        //GameRegistry.addSmelting(input, output, 0.0F);
    }

    public Map getRecipeList()
    {
        return recipeList;
    }
}
