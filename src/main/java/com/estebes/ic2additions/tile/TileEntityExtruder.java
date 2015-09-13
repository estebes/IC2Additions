package com.estebes.ic2additions.tile;

import com.estebes.ic2additions.api.Recipes;
import com.estebes.ic2additions.init.ItemInit;
import com.estebes.ic2additions.recipes.MachineRecipeManager;
import com.estebes.ic2additions.util.Plates;
import ic2.api.recipe.RecipeInputOreDict;
import net.minecraft.item.ItemStack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TileEntityExtruder
{
    public static void init()
    {
        Recipes.rollingMachine = new MachineRecipeManager();
        Pattern pattern = Pattern.compile("(plate)([a-zA-Z]+)");
        for(Plates plate : Plates.values())
        {
            Matcher matcher = pattern.matcher(plate.getOreDictName());
            if (matcher.matches())
            {
                Recipes.rollingMachine.addRecipe(new RecipeInputOreDict("ingot" + matcher.group(2), 1), null,
                        new ItemStack(ItemInit.itemPlate, 1, plate.ordinal()));
            }
        }
    }
}
