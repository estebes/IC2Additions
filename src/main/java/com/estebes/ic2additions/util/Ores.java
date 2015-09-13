package com.estebes.ic2additions.util;

import com.estebes.ic2additions.init.BlockInit;
import com.estebes.ic2additions.reference.Reference;
import ic2.api.item.IC2Items;
import net.minecraft.item.ItemStack;

public enum Ores
{
    // Bauxite ore info
    /*ORE_BAUXITE("OreBauxite") {
        @Override
        public ItemStack getMaceratorRecipe()
        {
            ItemStack maceratorProduct = new ItemStack(IC2Items.getItem("crushedSilverOre").getItem(), 2, 5);

            return maceratorProduct;
        }

        @Override
        public ItemStack getFurnaceRecipe()
        {
            ItemStack furnaceProduct = new ItemStack(IC2Items.getItem("silverIngot").getItem(), 1, 6);

            return null;
        }
    },*/

    /*// Titanium ore info
    ORE_TITANIUM("OreTitanium") {
        @Override
        public ArrayList addMaceratorRecipes()
        {
            ArrayList<CrushedOres> maceratorProducts = new ArrayList<CrushedOres>();

            maceratorProducts.add(CrushedOres.CRUSHED_ORE_BAUXITE);

            return maceratorProducts;
        }

        @Override
        public Map getProducts()
        {
            HashMap<IC2MachineTypes, ArrayList> products = new HashMap<IC2MachineTypes, ArrayList>();

            products.put(IC2MachineTypes.MACERATOR, addMaceratorRecipes());

            return products;
        }
    },

    // Chromite ore info
    ORE_CHROMITE("OreChromite") {
        @Override
        public ArrayList addMaceratorRecipes()
        {
            ArrayList<CrushedOres> maceratorProducts = new ArrayList<CrushedOres>();

            maceratorProducts.add(CrushedOres.CRUSHED_ORE_BAUXITE);

            return maceratorProducts;
        }

        @Override
        public Map getProducts()
        {
            HashMap<IC2MachineTypes, ArrayList> products = new HashMap<IC2MachineTypes, ArrayList>();

            products.put(IC2MachineTypes.MACERATOR, addMaceratorRecipes());

            return products;
        }
    },*/

    ORE_SILVER("OreSilver", "bauxite") {
        @Override
        public ItemStack  getItemStack()
        {
            return new ItemStack(BlockInit.oreSilver, 1);
        }

        @Override
        public ItemStack getMaceratorRecipe()
        {
            ItemStack maceratorProduct = new ItemStack(IC2Items.getItem("crushedSilverOre").getItem(), 2, 5);

            return maceratorProduct;
        }

        @Override
        public ItemStack getFurnaceRecipe()
        {
            ItemStack furnaceProduct = new ItemStack(IC2Items.getItem("silverIngot").getItem(), 1, 6);

            return furnaceProduct;
        }
    },

    ORE_IRIDIUM("OreIridium", "OreIridium") {
        @Override
        public ItemStack  getItemStack()
        {
            return new ItemStack(BlockInit.oreIridium, 1);
        }

        @Override
        public ItemStack getMaceratorRecipe()
        {
            return new ItemStack(IC2Items.getItem("iridiumOre").getItem(), 1);
        }

        @Override
        public ItemStack getFurnaceRecipe()
        {
            return null; //new ItemStack(IC2Items.getItem("silverIngot").getItem(), 1, 6);
        }

    },


    /*ORE_PLATINUM("OrePlatinum") {
        @Override
        public ArrayList addMaceratorRecipes()
        {
            ArrayList<CrushedOres> maceratorProducts = new ArrayList<CrushedOres>();

            maceratorProducts.add(CrushedOres.CRUSHED_ORE_BAUXITE);

            return maceratorProducts;
        }

        @Override
        public Map getProducts()
        {
            HashMap<IC2MachineTypes, ArrayList> products = new HashMap<IC2MachineTypes, ArrayList>();

            products.put(IC2MachineTypes.MACERATOR, addMaceratorRecipes());

            return products;
        }
    },

    ORE_GALENA("OreGalena") {
        @Override
        public ArrayList addMaceratorRecipes()
        {
            ArrayList<CrushedOres> maceratorProducts = new ArrayList<CrushedOres>();

            maceratorProducts.add(CrushedOres.CRUSHED_ORE_BAUXITE);

            return maceratorProducts;
        }

        public ArrayList addFurnaceRecipes()
        {
            ArrayList<Ingots> furnaceProducts = new ArrayList<Ingots>();

            furnaceProducts.add(Ingots.INGOT_SILVER);

            return furnaceProducts;
        }

        @Override
        public Map getProducts()
        {
            HashMap<IC2MachineTypes, ArrayList> products = new HashMap<IC2MachineTypes, ArrayList>();

            products.put(IC2MachineTypes.MACERATOR, addMaceratorRecipes());
            products.put(IC2MachineTypes.FURNACE, addFurnaceRecipes());

            return products;
        }
    },

    ORE_SPHALERITE("OreSphalerite") {
        @Override
        public ArrayList addMaceratorRecipes()
        {
            ArrayList<CrushedOres> maceratorProducts = new ArrayList<CrushedOres>();

            maceratorProducts.add(CrushedOres.CRUSHED_ORE_BAUXITE);

            return maceratorProducts;
        }

        @Override
        public Map getProducts()
        {
            HashMap<IC2MachineTypes, ArrayList> products = new HashMap<IC2MachineTypes, ArrayList>();

            products.put(IC2MachineTypes.MACERATOR, addMaceratorRecipes());

            return products;
        }
    },

    ORE_MONAZITE("OreMonazite") {
        @Override
        public ArrayList addMaceratorRecipes()
        {
            ArrayList<CrushedOres> maceratorProducts = new ArrayList<CrushedOres>();

            maceratorProducts.add(CrushedOres.CRUSHED_ORE_BAUXITE);

            return maceratorProducts;
        }

        @Override
        public Map getProducts()
        {
            HashMap<IC2MachineTypes, ArrayList> products = new HashMap<IC2MachineTypes, ArrayList>();

            products.put(IC2MachineTypes.MACERATOR, addMaceratorRecipes());

            return products;
        }
    },

    ORE_COLUMBITE("OreColumbite") {
        @Override
        public ArrayList addMaceratorRecipes()
        {
            ArrayList<CrushedOres> maceratorProducts = new ArrayList<CrushedOres>();

            maceratorProducts.add(CrushedOres.CRUSHED_ORE_BAUXITE);

            return maceratorProducts;
        }

        @Override
        public Map getProducts()
        {
            HashMap<IC2MachineTypes, ArrayList> products = new HashMap<IC2MachineTypes, ArrayList>();

            products.put(IC2MachineTypes.MACERATOR, addMaceratorRecipes());

            return products;
        }
    },

    ORE_WOLFRAMITE("OreWolframite") {
        @Override
        public ArrayList addMaceratorRecipes()
        {
            ArrayList<CrushedOres> maceratorProducts = new ArrayList<CrushedOres>();

            maceratorProducts.add(CrushedOres.CRUSHED_ORE_BAUXITE);

            return maceratorProducts;
        }

        @Override
        public Map getProducts()
        {
            HashMap<IC2MachineTypes, ArrayList> products = new HashMap<IC2MachineTypes, ArrayList>();

            products.put(IC2MachineTypes.MACERATOR, addMaceratorRecipes());

            return products;
        }
    }*/


    ;

    private final String name;
    private final String texturePath;
    private final float hardness;

    private Ores()
    {
        this("Unknown");
    }

    private Ores(final String name)
    {
        this(name, null);
    }

    private Ores(final String name, final String texturePath)
    {
        this(name, texturePath, 3.0F);
    }

    private Ores(final String name, final String texturePath, final float hardness)
    {
        this.name = name;
        this.texturePath = texturePath;
        this.hardness = hardness;
    }

    public String getName()
    {
        return name;
    }

    public String getTexturePath()
    {
        return Reference.LOWERCASE_MOD_ID + ":" + texturePath;
    }

    public float getHardness()
    {
        return hardness;
    }

    public abstract ItemStack getItemStack();
    public abstract ItemStack getMaceratorRecipe();
    public abstract ItemStack getFurnaceRecipe();

}
