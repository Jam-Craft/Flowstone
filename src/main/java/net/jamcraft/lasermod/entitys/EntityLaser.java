package net.jamcraft.lasermod.entitys;

import net.jamcraft.lasermod.Lasers;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * @author Jackson Isted
 * @version 1.0
 */
public class EntityLaser extends Entity {

    public EntityLaser(World world) {
        super(world);
    }

    @Override
    protected void entityInit() {
        this.worldObj.setBlock((int)this.lastTickPosX, (int)this.lastTickPosY, (int)this.lastTickPosZ, Lasers.laserBlock);
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound var1) {
        //nothing
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound var1) {
        //nothing
    }
}
