package com.estebes.ic2additions.gui.server;


import com.estebes.ic2additions.tile.TileEntityElectronicTank;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;

public class ContainerIC2Additions extends Container
{
    private TileEntity tileEntity;


    // Constructor
    public ContainerIC2Additions(IInventory inventoryPlayer, TileEntity tileEntity)
    {
        this.tileEntity = tileEntity;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        for (Object crafter : crafters)
        {
            ICrafting icrafting = (ICrafting) crafter;
            if(tileEntity instanceof TileEntityElectronicTank)
            {
                //icrafting.sendProgressBarUpdate(this, 0, ((TileEntityElectronicTank) tileEntity).getTank().);
            }
        }
    }
}
