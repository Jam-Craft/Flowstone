package net.jamcraft.lasermod.entities;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityLaser extends Entity {

    private int laserLivingTime;

    public EntityLaser(World world, double x, double y, double z) {
	super(world);
	this.setLocationAndAngles(x, y, z, 0.0F, 0.0F);
	this.laserLivingTime = this.rand.nextInt(10) + 1;

    }

    public void onUpdate() {
		super.onUpdate();
		if (!this.worldObj.isRemote && this.laserLivingTime > 0) {
			double doo = 3.0D;
        	List nearby = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, AxisAlignedBB.getAABBPool().getAABB(this.posX - doo, this.posY - doo, this.posZ - doo, this.posX + doo, this.posY + 6.0D + doo, this.posZ + doo));
        	for (int i = 0; i < nearby.size(); ++i)
            {
                 Entity entity = (Entity)nearby.get(i);
                 entity.setFire(5);
            }
        	--this.laserLivingTime;}
		
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
