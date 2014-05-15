package net.jamcraft.lasermod.items;

import net.jamcraft.lasermod.TextureConstants;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemLaser extends Item {
	
	public ItemLaser() {
		setTextureName(TextureConstants.RESOURCE_CONTEXT + ":laser_basic");
	}
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
        Vec3 directionLooking = player.getLook(1);
        Vec3
		
		return item;
    }
	
}
