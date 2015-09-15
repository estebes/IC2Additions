package com.estebes.ic2additions.plugin;

import java.util.List;

import com.estebes.ic2additions.block.storage.BlockElectronicTank;
import com.estebes.ic2additions.tile.TileEntityElectronicTank;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import cpw.mods.fml.common.Optional;

@Optional.Interface(iface = "mcp.mobius.waila.api.IWailaDataProvider", modid = "Waila")
public class PluginWaila implements IWailaDataProvider
{
    @Optional.Method(modid = "Waila")
    public static void callbackRegister (IWailaRegistrar register)
    {
        PluginWaila instance = new PluginWaila();
        register.registerBodyProvider(instance, BlockElectronicTank.class);
        register.registerNBTProvider(instance, BlockElectronicTank.class);
    }

    @Override
    public List<String> getWailaBody(ItemStack item, List<String> tip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        TileEntityElectronicTank machine = (TileEntityElectronicTank) accessor.getTileEntity();
        if (machine.getTank().getFluid() != null)
        {
            tip.add(machine.getTank().getFluid().getLocalizedName());
            tip.add((int)(machine.getTank().getFluidAmount()) + "/" + (int)(machine.getTank().getCapacity()) + " mB");
        }
        else
        {
            tip.add("Empty Tank");
        }
        return tip;
    }

    @Override
    public List<String> getWailaHead(ItemStack item, List<String> tip, IWailaDataAccessor accessor, IWailaConfigHandler config) {

        return tip;
    }

    @Override
    public List<String> getWailaTail(ItemStack item, List<String> tip, IWailaDataAccessor accessor, IWailaConfigHandler config) {

        return tip;
    }

    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {

        return accessor.getStack();
    }

    @Override
    public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World w, int x, int y, int z) {

        return tag;
    }
}