package com.estebes.ic2additions.block.ore;

// Imports
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;


public class OreSolid extends Block
{
    private final String oreTexture;

    // Constructor
    public OreSolid(String oreName, String oreTexture, float oreHardness)
    {
        super(Material.rock);
        this.setHardness(oreHardness);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setBlockName(oreName);
        this.oreTexture = oreTexture;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(oreTexture);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return this.blockIcon;
    }
}
