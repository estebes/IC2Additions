package com.estebes.ic2additions.block.storage;

import com.estebes.ic2additions.reference.Reference;
import com.estebes.ic2additions.tile.TileEntityElectronicTank;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class BlockElectronicTank extends BlockContainer
{
    public BlockElectronicTank()
    {
        super(Material.rock);
        this.setHardness(5.0F);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setBlockName("");
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(Reference.LOWERCASE_MOD_ID + ":" + "");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return this.blockIcon;
    }

    @Override
    public int damageDropped(int metaData)
    {
        return metaData;
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for (int metaData = 0; metaData < Reference.TIERS; metaData++)
        {
            list.add(new ItemStack(item, 1, metaData));
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return new TileEntityElectronicTank(64 * (int)(Math.pow(10, metaData)));
    }
}
