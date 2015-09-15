package com.estebes.ic2additions.packethandler.message;

import com.estebes.ic2additions.tile.TileEntityElectronicTank;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class MessageTileEntity implements IMessage, IMessageHandler<MessageTileEntity, IMessage>
{
    // Variables
    private int x, y, z;
    private NBTTagCompound tankInfo;


    // Constructor
    public MessageTileEntity()
    {
        //
    }

    public MessageTileEntity(TileEntity tileEntity)
    {
        x = tileEntity.xCoord;
        y = tileEntity.yCoord;
        z = tileEntity.zCoord;
        if(tileEntity instanceof TileEntityElectronicTank)
        {
            tankInfo = new NBTTagCompound();
            ( (TileEntityElectronicTank)tileEntity).writeToNBT(tankInfo);
        }
    }


    // Buffer Stuff
    @Override
    public void fromBytes(ByteBuf in)
    {
        x = in.readInt();
        y = in.readInt();
        z = in.readInt();
        tankInfo = ByteBufUtils.readTag(in);
    }

    @Override
    public void toBytes(ByteBuf out)
    {
        out.writeInt(x);
        out.writeInt(y);
        out.writeInt(z);
        ByteBufUtils.writeTag(out, tankInfo);
    }

    @Override
    public IMessage onMessage(MessageTileEntity message, MessageContext ctx)
    {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);
        if (tileEntity instanceof TileEntityElectronicTank)
        {
            ((TileEntityElectronicTank) tileEntity).readFromNBT(message.tankInfo);
        }
        return null;
    }

    @Override
    public String toString()
    {
        return String.format("MessageTileEntity - x:%s, y:%s, z:%s, tankInfo:%s", x, y, z, tankInfo);
    }
}