package com.estebes.ic2additions.recipes;

import com.estebes.ic2additions.init.BlockInit;
import com.estebes.ic2additions.util.CrushedOres;
import com.estebes.ic2additions.util.Ores;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class MaceratorRecipes
{
    public static void init()
    {
        // Diamond Ore
        Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Blocks.diamond_ore), 1), null,
                new ItemStack(Items.diamond, 2));

        // Redstone Ore
        Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Blocks.redstone_ore), 1), null,
                new ItemStack(Items.redstone, 8));

        // Coal Ore
        Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Blocks.coal_ore), 1), null,
                new ItemStack(Items.coal, 2));

        // Lapis Ore
        Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Blocks.lapis_ore), 1), null,
                new ItemStack(Items.dye, 10, 4));

        // Emerald Ore
        Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Blocks.emerald_ore), 1), null,
                new ItemStack(Items.emerald, 2));

        // Nether Quartz Ore
        Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Blocks.quartz_ore), 1), null,
                new ItemStack(Items.quartz, 2));

        /*for(Ores ore : Ores.values())
        {
            if(Recipes.macerator.getOutputFor(ore.getItemStack(), false) == null)
            {
                Recipes.macerator.addRecipe(new RecipeInputItemStack(ore.getItemStack()), null,
                        ore.getMaceratorRecipe());
            }
        }*/
    }
}
