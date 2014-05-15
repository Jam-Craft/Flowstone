package net.jamcraft.lasermod;

import net.jamcraft.lasermod.items.LaserItems;
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
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		
		LaserItems.init();
	}
	
	public void init(FMLInitializationEvent event) {
		
	}
	
}
