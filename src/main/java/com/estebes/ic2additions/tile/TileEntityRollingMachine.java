package com.estebes.ic2additions.tile;

import com.estebes.ic2additions.api.Recipes;
import com.estebes.ic2additions.init.ItemInit;
import com.estebes.ic2additions.recipes.MachineRecipeManager;
import com.estebes.ic2additions.util.Plates;
import ic2.api.recipe.RecipeInputOreDict;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TileEntityRollingMachine extends TileEntity implements ISidedInventory
{
    private final ItemStack[] machineInventory;

    public TileEntityRollingMachine()
    {
        this.machineInventory = new ItemStack[2];
    }

    public static void init()
    {
        Recipes.rollingMachine = new MachineRecipeManager();
        Pattern pattern = Pattern.compile("(plate)([a-zA-Z]+)");
        for(Plates plate : Plates.values())
        {
            Matcher matcher = pattern.matcher(plate.getOreDictName());
            if (matcher.matches())
            {
                Recipes.rollingMachine.addRecipe(new RecipeInputOreDict("ingot" + matcher.group(2), 1), null,
                        new ItemStack(ItemInit.itemPlate, 1, plate.ordinal()));
            }
        }
    }

    private int ticks = 0;

    @Override
    public void updateEntity()
    {
        super.updateEntity();

        if(worldObj.isRemote)
        {
            return;
        }

        if(machineInventory[1] != null)
        {
            if(machineInventory[1].stackSize >= 64)
            {
                return;
            }
        }

        if(ticks > 10)
        {
            if(removeItemStacktoInput())
            {
                addItemStacktoOutput();
            }
            ticks = 0;
        }
        else
        {
            ticks++;
        }

        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        markDirty();
    }

    public boolean removeItemStacktoInput()
    {

        if(machineInventory[0] == null)
        {
            return false;
        }
        else if(Recipes.rollingMachine.getOutputFor(machineInventory[0], false) != null)
        {
            if(machineInventory[0].stackSize > 0)
            {
                return true;
            }
        }
        else
        {
            return false;
        }
        return false;
    }

    public void addItemStacktoOutput()
    {
        //ItemStack cobbleStack =  new ItemStack(IC2Items.getItem("plateiron").getItem(), 1);//
        ItemStack cobbleStack = Recipes.rollingMachine.getOutputFor(machineInventory[0], false).items.get(0);
        int maxStackSize = Math.min(getInventoryStackLimit(), cobbleStack.getMaxStackSize());

        if(machineInventory[1] == null)
        {
            machineInventory[1] = cobbleStack.copy();
        }
        else if(machineInventory[1].getItem() == cobbleStack.getItem())
        {
            if(machineInventory[1].stackSize < maxStackSize)
            {
                machineInventory[1].stackSize += cobbleStack.stackSize;
            }
        }
        machineInventory[0].stackSize -= 1;
        if (machineInventory[0].stackSize == 0)
        {
            machineInventory[0] = null;
        }
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
        return slotIndex == 0 ? true : false;
    }

    @Override
    public boolean canExtractItem(int slotIndex, ItemStack itemStack, int side)
    {
        return slotIndex == 1 ? true : false;
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
        return false;
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
}
