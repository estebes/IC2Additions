package com.estebes.ic2additions.tile;

import com.estebes.ic2additions.packethandler.PacketHandler;
import com.estebes.ic2additions.packethandler.message.MessageTileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

public class TileEntityElectronicTank extends TileEntity implements IFluidHandler
{
    private FluidTank tank;

    public TileEntityElectronicTank(int size)
    {
        this.tank = new FluidTank(FluidContainerRegistry.BUCKET_VOLUME * size);
    }

    @Override
    public void updateEntity()
    {
        super.updateEntity();

        if(worldObj.isRemote)
        {
            return;
        }

        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        markDirty();
    }

    // NBT Stuff
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);

        tank.readFromNBT(nbtTagCompound.getCompoundTag("tileEntityTank"));
    }

    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);

        NBTTagCompound tankTag = new NBTTagCompound();
        tank.writeToNBT(tankTag);
        nbtTagCompound.setTag("tileEntityTank", tankTag);
    }

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill)
    {
        if (!canFill(from, resource.getFluid()))
        {
            return 0;
        }

        return tank.fill(resource, doFill);
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain)
    {
        if ((resource == null) || (!resource.isFluidEqual(tank.getFluid())))
        {
            return null;
        }

        if (!canDrain(from, resource.getFluid()))
        {
            return null;
        }

        return tank.drain(resource.amount, doDrain);
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain)
    {
        return tank.drain(maxDrain, doDrain);
    }

    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid)
    {
        if(fluid != null)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid)
    {
        FluidStack fluidStack = tank.getFluid();
        if (fluidStack == null)
        {
            return false;
        }
        return fluidStack.isFluidEqual(new FluidStack(fluid, 1));
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from)
    {
        return new FluidTankInfo[] { tank.getInfo() };
    }

    public FluidTank getTank()
    {
        return tank;
    }

    public void setTank(FluidTank tank)
    {
        this.tank = tank;
    }

    @Override
    public Packet getDescriptionPacket()
    {
        return PacketHandler.INSTANCE.getPacketFrom(new MessageTileEntity(this));
    }
}
