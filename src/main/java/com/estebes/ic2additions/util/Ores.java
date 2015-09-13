package com.estebes.ic2additions.util;

import com.estebes.ic2additions.init.BlockInit;
import com.estebes.ic2additions.reference.Reference;
import ic2.api.item.IC2Items;
import net.minecraft.item.ItemStack;

public enum Ores
{
    ORE_BAUXITE("OreBauxite"),
    ORE_TITANIUM("OreTitanium"),
    ORE_CHROMITE("OreChromite"),
    ORE_SILVER("OreSilver"),
    ORE_IRIDIUM("OreIridium"),
    ORE_PLATINUM("OrePlatinum"),
    ORE_GALENA("OreGalena"),
    ORE_SPHALERITE("OreSphalerite"),
    ORE_MONAZITE("OreMonazite"),
    ORE_COLUMBITE("OreColumbite"),
    ORE_WOLFRAMITE("OreWolframite");

    private final String itemName;
    private final String oreDictName;
    private final float hardness;

    private Ores()
    {
        this(null);
    }

    private Ores(final String itemName)
    {
        this(itemName, null);
    }

    private Ores(final String itemName, final String oreDictName)
    {
        this(itemName, oreDictName, 3.0F);
    }

    private Ores(final String itemName, final String oreDictName, final float hardness)
    {
        this.itemName = itemName;
        this.oreDictName = oreDictName;
        this.hardness = hardness;
    }

    public String getName()
    {
        return itemName;
    }

    public String getTexturePath()
    {
        return Reference.LOWERCASE_MOD_ID + ":" + itemName;
    }

    public float getHardness()
    {
        return hardness;
    }
}
