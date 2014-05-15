package net.jamcraft.lasermod.entities;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityLaser extends Entity {

    private int laserAge;

    public EntityLaser(World par1World, double par2, double par4, double par6, int par8) {
	super(par1World);
        this.setSize(0.5F, 0.5F);
        this.yOffset = this.height / 2.0F;
        this.setPosition(par2, par4, par6);
        this.rotationYaw = (float)(Math.random() * 360.0D);
        this.motionX = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
        this.motionY = (double)((float)(Math.random() * 0.2D) * 2.0F);
        this.motionZ = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
    }
    
    public EntityLaser(World par1World)
    {
        super(par1World);
        this.setSize(0.25F, 0.25F);
        this.yOffset = this.height / 2.0F;
    }

    public void onUpdate() {
	super.onUpdate();
	if (!this.worldObj.isRemote && this.laserLivingTime > 0) {
	    double doo = 3.0D;
	    List nearby = this.worldObj.getEntitiesWithinAABBExcludingEntity(
		    this,
		    AxisAlignedBB.getAABBPool().getAABB(this.posX - doo,
			    this.posY - doo, this.posZ - doo, this.posX + doo,
			    this.posY + 6.0D + doo, this.posZ + doo));
	    for (int i = 0; i < nearby.size(); ++i)
	    {
		Entity entity = (Entity) nearby.get(i);
		entity.setFire(5);
	    }
	    --this.laserLivingTime;
	}

    }

    @Override
    protected void entityInit() {

    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound var1) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound var1) {

    }

}
