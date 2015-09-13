package com.estebes.ic2additions.item;

import com.estebes.ic2additions.util.Plates;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemPlate extends Item
{
    public ItemPlate()
    {
        this.maxStackSize = 64;
        this.setHasSubtypes(true);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setUnlocalizedName("");
    }

    private IIcon[] icons = new IIcon[Plates.values().length];

    @Override
    public void registerIcons(IIconRegister icon)
    {
        for (Plates plate : Plates.values())
        {
            icons[plate.ordinal()] = icon.registerIcon(plate.getTexturePath());
        }
    }

    @Override
    public IIcon getIconFromDamage(int meta)
    {
        return icons[meta];
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
        for (Plates plate : Plates.values())
        {
            list.add(new ItemStack(item, 1, plate.ordinal()));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return this.getUnlocalizedName() + Plates.values()[stack.getItemDamage()].getName();
    }
}
