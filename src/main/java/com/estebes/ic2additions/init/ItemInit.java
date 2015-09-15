package com.estebes.ic2additions.init;

import com.estebes.ic2additions.item.ItemIngot;
import com.estebes.ic2additions.item.ItemPlate;
import com.estebes.ic2additions.item.fuel.ItemCoalCoke;
import com.estebes.ic2additions.reference.Reference;
import com.estebes.ic2additions.util.Ingots;
import com.estebes.ic2additions.util.Plates;
import com.estebes.ic2additions.util.SolidFuels;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ItemInit
{
    public static final ItemCoalCoke itemCoalCoke = new ItemCoalCoke();
    public static final ItemPlate itemPlate = new ItemPlate();
    public static final ItemIngot itemIngot = new ItemIngot();

    public static void init()
    {
        GameRegistry.registerItem(itemCoalCoke, SolidFuels.SOLIDFUEL_COALCOKE.getName());
        OreDictionary.registerOre("fuelCoke", new ItemStack(itemCoalCoke, 1));
        GameRegistry.registerItem(itemPlate, "ItemPlate");
        for(Plates plate : Plates.values())
        {
            OreDictionary.registerOre(plate.getOreDictName(), new ItemStack(itemPlate, 1, plate.ordinal()));
        }
        GameRegistry.registerItem(itemIngot, "ItemIngot");
        for(Ingots ingot : Ingots.values())
        {
            OreDictionary.registerOre(ingot.getOreDictName(), new ItemStack(itemIngot, 1, ingot.ordinal()));
        }
        OreDictionary.registerOre("copperCable", new ItemStack(IC2Items.getItem("copperCableItem").getItem(), 1, 1));
    }
}
