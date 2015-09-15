package com.estebes.ic2additions.init;

import com.estebes.ic2additions.block.OreBauxite;
import com.estebes.ic2additions.block.machine.BlockRollingMachine;
import com.estebes.ic2additions.block.ore.OreSolid;
import com.estebes.ic2additions.reference.Reference;
import com.estebes.ic2additions.tile.TileEntityElectronicTank;
import com.estebes.ic2additions.tile.TileEntityRollingMachine;
import com.estebes.ic2additions.util.Ores;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class TileEntityInit
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TileEntityRollingMachine.class, "TileEntityRollingMachine");
        TileEntityRollingMachine.init();
        GameRegistry.registerTileEntity(TileEntityElectronicTank.class, "TileEntityElectronicTank");
    }
}