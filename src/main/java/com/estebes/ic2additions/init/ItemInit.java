package com.estebes.ic2additions.init;

import com.estebes.ic2additions.item.ItemPlate;
import com.estebes.ic2additions.item.fuel.ItemCoalCoke;
import com.estebes.ic2additions.reference.Reference;
import com.estebes.ic2additions.util.Plates;
import com.estebes.ic2additions.util.SolidFuels;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ItemInit
{
    public static final ItemCoalCoke itemCoalCoke = new ItemCoalCoke();
    public static final ItemPlate itemPlate = new ItemPlate();

    public static void init()
    {
        GameRegistry.registerItem(itemCoalCoke, SolidFuels.SOLIDFUEL_COALCOKE.getName());
        OreDictionary.registerOre("fuelCoke", new ItemStack(itemCoalCoke, 1));
        GameRegistry.registerItem(itemPlate, "Plate");
        for(Plates plate : Plates.values())
        {
            OreDictionary.registerOre(plate.getOreDictName(), new ItemStack(itemPlate, 1, plate.ordinal()));
        }
    }
}
