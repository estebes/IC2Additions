package com.estebes.ic2additions.util;

import java.util.ArrayList;

public enum CrushedOres
{
    CRUSHED_ORE_BAUXITE {

    },

    CRUSHED_ORE_SILVER {

    }
    ;
    private final String name;
    private final String texturePath;

    private CrushedOres()
    {
        this("Unknown");
    }

    private CrushedOres(final String name)
    {
        this(name, null);
    }

    private CrushedOres(final String name, final String texturePath)
    {
        this.name = name;
        this.texturePath = texturePath;
    }

    public String getName()
    {
        return name;
    }

    public String getTexturePath()
    {
        return texturePath;
    }

    //public abstract ArrayList getProducts();
}
