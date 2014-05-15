package net.jamcraft.lasermod.items;

import net.jamcraft.lasermod.TextureConstants;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemLaser extends Item {
	
	public ItemLaser() {
		setTextureName(TextureConstants.RESOURCE_CONTEXT + ":laser_basic");
	}
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
        Vec3 dirL = player.getLook(1);
        Vec3 source = world.getWorldVec3Pool().getVecFromPool(player.posX+dirL.xCoord, player.posZ+dirL.yCoord+player.eyeHeight, player.posZ+dirL.zCoord);
        Vec3 foo = source.addVector(dirL.xCoord*100, dirL.yCoord*100, dirL.zCoord*100);
		MovingObjectPosition mop = world.rayTraceBlocks(source, foo, true);
		if (mop == null) return item;
		else {
			world.spawnParticle("smoke", , par4, par6, par8, par10, par12);
			return item;
		}
		
    }
	
}
