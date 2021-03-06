package com.estebes.ic2additions.packethandler;

import com.estebes.ic2additions.packethandler.message.MessageTileEntity;
import com.estebes.ic2additions.reference.Reference;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.LOWERCASE_MOD_ID);

    public static void init()
    {
        INSTANCE.registerMessage(MessageTileEntity.class, MessageTileEntity.class, 0, Side.CLIENT);
    }
}
