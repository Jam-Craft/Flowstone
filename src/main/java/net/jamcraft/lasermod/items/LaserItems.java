package net.jamcraft.lasermod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class LaserItems {
	
	public static Item basicLaser;
	
	public static void init() {
		basicLaser = new ItemLaser().setUnlocalizedName("basicLaser");
		
		GameRegistry.registerItem(basicLaser, "basicLaser");
	}
	
}
