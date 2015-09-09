package com.estebes.ic2additions;

import com.estebes.ic2additions.init.BlockInit;
import com.estebes.ic2additions.oregen.OreGenerator;
import com.estebes.ic2additions.proxy.ServerProxy;
import com.estebes.ic2additions.recipes.MaceratorRecipes;
import com.estebes.ic2additions.reference.Reference;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class IC2Additions
{
    @SidedProxy(clientSide = Reference.PROXY_CLIENT, serverSide = Reference.PROXY_SERVER)
    public static ServerProxy proxy;

    @Instance(Reference.MOD_ID)
    public static IC2Additions instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent preinit)
    {
        //PacketHandler.init();

        BlockInit.init();

        //ItemInit.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent init)
    {
        //NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

        //TileEntityInit.init();

        OreGenerator.INSTANCE.addFeature(BlockInit.oreBauxite, 15, 1);

        GameRegistry.registerWorldGenerator(OreGenerator.INSTANCE, 0);

        proxy.registerRenderInformation();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent postinit)
    {
        MaceratorRecipes.init();
    }

}
