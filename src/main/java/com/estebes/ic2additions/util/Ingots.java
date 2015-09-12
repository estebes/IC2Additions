package com.estebes.ic2additions.util;

public enum Ingots
{
    INGOT_SILVER {

    }
    ;
    private final String name;
    private final String texturePath;

    private Ingots()
    {
        this("Unknown");
    }

    private Ingots(final String name)
    {
        this(name, null);
    }

    private Ingots(final String name, final String texturePath)
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
