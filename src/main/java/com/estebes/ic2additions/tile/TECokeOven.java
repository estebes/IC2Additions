package com.estebes.ic2additions.tile;

import com.estebes.ic2additions.api.Recipes;
import com.estebes.ic2additions.recipes.MachineRecipeManager;

public class TECokeOven extends TEInventory
{
    public TECokeOven()
    {
        super(2);
    }

    public static void init()
    {
        Recipes.cokeOven = new MachineRecipeManager();
    }
}
