package com.estebes.ic2additions.init;

import com.estebes.ic2additions.block.OreBauxite;
import com.estebes.ic2additions.block.ore.OreSolid;
import com.estebes.ic2additions.reference.Reference;
import com.estebes.ic2additions.util.Ores;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class BlockInit
{
    public static final OreBauxite oreBauxite = new OreBauxite();
    public static final OreSolid oreSilver = new OreSolid(Ores.ORE_SILVER.getName(), Ores.ORE_SILVER.getTexturePath(), Ores.ORE_SILVER.getHardness());
    public static final OreSolid oreIridium = new OreSolid(Ores.ORE_IRIDIUM.getName(), Ores.ORE_IRIDIUM.getTexturePath(), Ores.ORE_IRIDIUM.getHardness());

    public static void init()
    {
        GameRegistry.registerBlock(oreBauxite, "OreBauxite");
        GameRegistry.registerBlock(oreSilver, Ores.ORE_SILVER.getName());
        OreDictionary.registerOre("oreSilver", new ItemStack(oreSilver, 1));
        GameRegistry.registerBlock(oreIridium, Ores.ORE_IRIDIUM.getName());
        OreDictionary.registerOre("oreIridium", new ItemStack(oreIridium, 1));
        //OreDictionary.registerOre("oreBauxite", oreBauxite);
    }
}

