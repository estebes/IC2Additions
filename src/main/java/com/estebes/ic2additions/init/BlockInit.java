package com.estebes.ic2additions.init;

import com.estebes.ic2additions.block.OreBauxite;
import com.estebes.ic2additions.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class BlockInit
{
    public static final OreBauxite oreBauxite = new OreBauxite();

    public static void init()
    {
        GameRegistry.registerBlock(oreBauxite, "OreBauxite");
        //OreDictionary.registerOre("oreBauxite", oreBauxite);
    }
}

