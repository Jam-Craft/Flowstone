package net.jamcraft.flowstone;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFlowtion extends EntityThrowable {

    public String flowtionType;

    public EntityFlowtion(World par1World)
    {
        super(par1World);
    }

    public EntityFlowtion(World par1World, EntityLivingBase par2EntityLivingBase, String type)
    {
        super(par1World, par2EntityLivingBase);
        this.flowtionType = type;
    }

    @Override
    protected void onImpact(MovingObjectPosition var1) {

    }

    @Override
    protected float getGravityVelocity()
    {
        return 0.025F;
    }
}
