package com.estebes.ic2additions.block.storage;

import com.estebes.ic2additions.init.BlockInit;
import com.estebes.ic2additions.tile.TileEntityElectronicTank;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemBlockElectronicTank extends ItemBlockWithMetadata
{
    public ItemBlockElectronicTank(Block block)
    {
        super(block, block);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return this.getUnlocalizedName() + "ElectronicTankMark" + (stack.getItemDamage() + 1);
    }
}
