package net.jamcraft.lasermod;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.jamcraft.lasermod.blocks.BlockLaser;
import net.jamcraft.lasermod.items.LaserItems;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
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

    public static BlockLaser laserBlock;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
        laserBlock = new BlockLaser();
		LaserItems.init();
	}
	
	public void init(FMLInitializationEvent event) {
        GameRegistry.registerBlock(laserBlock, "laserblock");
	}
	
}
