package com.estebes.ic2additions.recipes;

import com.estebes.ic2additions.init.BlockInit;
import com.estebes.ic2additions.util.Ores;
import com.estebes.ic2additions.util.SolidFuels;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FurnaceRecipes
{
    public static void init()
    {
        for(Ores ore : Ores.values())
        {
            if(ore.getFurnaceRecipe() != null)
            {
                //GameRegistry.addSmelting(ore.getFurnaceRecipe()., ore.getFurnaceRecipe(), 0.0F);
            }
        }

        /*for(SolidFuels solidFuels: SolidFuels.values())
        {
            /*Set set = solidFuels.getCokeOvenRecipes().entrySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry)iterator.next();
                CokeOvenRecipes.getCokeOvenRecipes().addRecipe((ItemStack) mentry.getKey(), (ItemStack) mentry.getValue());
            }
            for (Map.Entry<Object, ItemStack> entry : solidFuels.getCokeOvenRecipes().entrySet())
            {
                CokeOvenRecipes.getCokeOvenRecipes().addRecipe((ItemStack)entry.getKey(), (ItemStack)entry.getValue());
            }
        }

        for (ItemStack stack : OreDictionary.getOres("fuelCoke"))
        {
            //GameRegistry.addSmelting(stack, new ItemStack(Items.coal, 1), 0.0f);
        }*/
    }
}
