package net.jamcraft.lasermod;

import org.lwjgl.opengl.GL11;

import net.jamcraft.lasermod.entities.EntityLaser;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderLaser extends Render {

    public void doRender(EntityLaser laser, double var2, double var4, double var6, float var8, float var9) {
	
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity var1) {
	return null;
    }

    @Override
    public void doRender(Entity var1, double var2, double var4, double var6,
	    float var8, float var9) {
	this.doRender((EntityLaser) var1, var2, var4, var6, var8, var9);
    }

}
