package com.estebes.ic2additions.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TEInventory extends TileEntity implements ISidedInventory
{
    private ItemStack[] machineInventory;

    public TEInventory(int inventorySize)
    {
        machineInventory = new ItemStack[inventorySize];
    }


    // ISidedInventory
    @Override
    public int[] getAccessibleSlotsFromSide(int side)
    {
        int[] indexArray = new int[machineInventory.length];
        for(int slotIndex = 0; slotIndex < machineInventory.length; slotIndex++)
        {
            indexArray[slotIndex] = slotIndex;
        }
        return indexArray;
    }

    @Override
    public boolean canInsertItem(int slotIndex, ItemStack itemStack, int side)
    {
        return true;
    }

    @Override
    public boolean canExtractItem(int slotIndex, ItemStack itemStack, int side)
    {
        return true;
    }

    @Override
    public int getSizeInventory()
    {
        return machineInventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slotIndex)
    {
        return machineInventory[slotIndex];
    }

    @Override
    public ItemStack decrStackSize(int slotOrigin, int slotDestination)
    {
        ItemStack itemStack = getStackInSlot(slotOrigin);
        if(itemStack != null)
        {
            if(itemStack.stackSize <= slotDestination)
            {
                setInventorySlotContents(slotOrigin, null);
            }
            else
            {
                itemStack = machineInventory[slotOrigin].splitStack(slotDestination);

                if(itemStack.stackSize == 0)
                {
                    setInventorySlotContents(slotOrigin, null);
                }
            }
        }

        return itemStack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slotIndex)
    {
        return null;
    }

    @Override
    public void setInventorySlotContents(int slotIndex, ItemStack itemStack)
    {
        this.machineInventory[slotIndex] = itemStack;
        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
        {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName()
    {
        return null;
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return true;
    }

    @Override
    public void openInventory()
    {
        //
    }

    @Override
    public void closeInventory()
    {
        //
    }

    @Override
    public boolean isItemValidForSlot(int slotIndex, ItemStack itemStack)
    {
        return true;
    }
    //


    //
}
