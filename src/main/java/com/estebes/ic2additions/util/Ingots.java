package com.estebes.ic2additions.util;

import com.estebes.ic2additions.reference.Reference;

public enum Ingots
{
    INGOT_ALUMINIUM("IngotAluminium", "ingotAluminium"),
    INGOT_SILVER("IngotSilver", "ingotSilver"),
    INGOT_STEEL("IngotSteel", "ingotSteel");

    private final String itemName;
    private final String oreDictName;

    private Ingots()
    {
        this(null);
    }

    private Ingots(final String itemName)
    {
        this(itemName, null);
    }

    private Ingots(final String itemName, final String oreDictName)
    {
        this.itemName = itemName;
        this.oreDictName = oreDictName;
    }

    public String getName()
    {
        return itemName;
    }

    public String getOreDictName()
    {
        return oreDictName;
    }

    public String getTexturePath()
    {
        return Reference.LOWERCASE_MOD_ID + ":" + itemName;
    }
}
