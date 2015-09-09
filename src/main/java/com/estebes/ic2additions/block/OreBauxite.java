package com.estebes.ic2additions.block;

// Imports
import com.estebes.ic2additions.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;


public class OreBauxite extends Block
{
    // Constructor
    public OreBauxite()
    {
        super(Material.rock);
        this.setHardness(5.0F);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setBlockName("OreBauxite");
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(Reference.LOWERCASE_MOD_ID + ":" + "bauxite");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return this.blockIcon;
    }
}
