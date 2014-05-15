package net.jamcraft.lasermod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class LaserItems {

    public static Item basicLaser;
    public static Item trollLaser;
    public static Item trollDisk;

    public static void init() {
        basicLaser = new ItemLaser().setUnlocalizedName("basicLaser");
        trollLaser = new ItemLaser().setUnlocalizedName("explodingLaser");
        trollDisk =  new TrollDisk().setUnlocalizedName("sciDisk");

        GameRegistry.registerItem(basicLaser, "basicLaser");
        GameRegistry.registerItem(trollLaser, "explodingLaser");
        GameRegistry.registerItem(trollDisk, "trollDisk");
    }

}
