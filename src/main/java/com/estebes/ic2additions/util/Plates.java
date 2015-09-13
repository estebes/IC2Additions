package com.estebes.ic2additions.util;

import com.estebes.ic2additions.reference.Reference;

public enum Plates
{
    PLATE_BRONZE("PlateBronze", "plateBronze"),
    PLATE_COPPER("PlateCopper", "plateCopper"),
    PLATE_GOLD("PlateGold", "plateGold"),
    PLATE_IRON("PlateIron", "plateIron"),
    PLATE_LEAD("PlateLead", "plateLead"),
    PLATE_SILVER("PlateSilver", "plateSilver"),
    PLATE_STEEL("PlateSteel", "plateSteel"),
    PLATE_TIN("PlateTin", "plateTin"),
    PLATE_TITANIUM("PlateTitanium", "plateTitanium");

    private final String itemName;
    private final String oreDictName;

    private Plates()
    {
        this(null);
    }

    private Plates(final String itemName)
    {
        this(itemName, null);
    }

    private Plates(final String itemName, final String oreDictName)
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
