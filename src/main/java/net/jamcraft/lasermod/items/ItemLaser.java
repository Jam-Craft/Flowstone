package net.jamcraft.lasermod.items;

import net.jamcraft.lasermod.Lasers;
import net.jamcraft.lasermod.TextureConstants;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemLaser extends Item {

    public ItemLaser() {
        this.setTextureName(TextureConstants.RESOURCE_CONTEXT + ":laser_basic");
        this.setCreativeTab(Lasers.creativeTab);
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
        Vec3 dirL = player.getLook(1);
        Vec3 source = world.getWorldVec3Pool().getVecFromPool(player.posX + dirL.xCoord, player.posZ + dirL.yCoord + player.eyeHeight, player.posZ + dirL.zCoord);
        Vec3 foo = source.addVector(dirL.xCoord * 100, dirL.yCoord * 100, dirL.zCoord * 100);
        MovingObjectPosition mop = world.rayTraceBlocks(source, foo, true);
        Lasers.logger.debug(mop);
        System.out.println(mop);
        if (mop == null) return item;
        world.setBlock(mop.blockX, mop.blockY, mop.blockZ, Lasers.laserBlock);
        if (this.getUnlocalizedName().contains("explo"))
            world.createExplosion(null, mop.blockX, mop.blockY, mop.blockZ, 15, false);
        else world.spawnParticle("slime", mop.blockX, mop.blockY + 1, mop.blockZ, 0D, 0D, 0D);
        return item;
    }

}
