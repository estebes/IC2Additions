package com.estebes.ic2additions.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BaseItem extends Item
{
    private final String texturePath;

    public BaseItem(String itemName, int maxStackSize, String texturePath)
    {
        this.maxStackSize = maxStackSize;
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setUnlocalizedName(itemName);
        this.texturePath = texturePath;
        this.setTextureName(texturePath);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(this.texturePath);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return this.itemIcon;
    }
}
