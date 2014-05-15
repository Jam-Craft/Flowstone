package net.jamcraft.lasermod;

import net.jamcraft.lasermod.blocks.BlockLaser;
import net.jamcraft.lasermod.blocks.BlockLaserHolder;
import net.jamcraft.lasermod.entities.EntityLaser;
import net.jamcraft.lasermod.items.LaserItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = ModConstants.MODID, name = ModConstants.NAME)
public class Lasers {

    public static CreativeTabs creativeTab = new CreativeTabs("Lasers") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Items.stick;
        }
    };

    @Mod.Instance(ModConstants.MODID)
    public static Lasers instance;

    public static Logger logger;
    
    @SidedProxy(clientSide = "net.jamcraft.lasermod.client.ClientProxy", serverSide = "net.jamcraft.lasermod.CommonProxy")
    public static CommonProxy proxy;

    public static BlockLaser laserBlock;
    public static BlockLaserHolder laserHolderBlock;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        laserBlock = new BlockLaser();
        laserHolderBlock = new BlockLaserHolder();
        LaserItems.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerBlock(laserBlock, "laserblock");
        GameRegistry.registerBlock(laserHolderBlock, "apiblock");
        Lasers.proxy.init();
    }

}
