package com.estebes.ic2additions.item;

import com.estebes.ic2additions.util.Ingots;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemIngot extends Item
{
    public ItemIngot()
    {
        this.maxStackSize = 64;
        this.setHasSubtypes(true);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setUnlocalizedName("");
    }

    private IIcon[] icons = new IIcon[Ingots.values().length];

    @Override
    public void registerIcons(IIconRegister icon)
    {
        for (Ingots ingot : Ingots.values())
        {
            icons[ingot.ordinal()] = icon.registerIcon(ingot.getTexturePath());
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
        for (Ingots ingot : Ingots.values())
        {
            list.add(new ItemStack(item, 1, ingot.ordinal()));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return this.getUnlocalizedName() + Ingots.values()[stack.getItemDamage()].getName();
    }
}
