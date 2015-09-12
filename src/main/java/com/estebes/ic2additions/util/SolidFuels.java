package com.estebes.ic2additions.util;

import com.estebes.ic2additions.init.ItemInit;
import com.estebes.ic2additions.reference.Reference;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public enum SolidFuels
{
    SOLIDFUEL_COALCOKE("SolidFuelCoalCoke") {
        @Override
        public Map getCokeOvenRecipes()
        {
            HashMap<ItemStack, ItemStack> lel = new HashMap<ItemStack, ItemStack>();
            //lel.put(new ItemStack(Items.coal), new ItemStack(ItemInit.itemCoalCoke));
            //lel.put()
            return lel;
        }
    }
    ;
    private final String name;
    //private final String texturePath;

    private SolidFuels()
    {
        this("Unknown");
    }

    private SolidFuels(final String name)
    {
        this(name, null);
    }

    private SolidFuels(final String name, final String texturePath)
    {
        this.name = name;
        //this.texturePath = texturePath;
    }

    public String getName()
    {
        return name;
    }

    public String getTexturePath()
    {
        return Reference.LOWERCASE_MOD_ID + ":" + name;
    }

    public abstract Map getCokeOvenRecipes();

    //public abstract ArrayList getProducts();
}
