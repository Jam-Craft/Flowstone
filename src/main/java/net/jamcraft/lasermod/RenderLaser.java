package net.jamcraft.lasermod;

import org.lwjgl.opengl.GL11;

import net.jamcraft.lasermod.entities.EntityLaser;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderLaser extends Render {

    public void doRender(EntityLaser laser, double var2, double var4, double var6, float var8, float var9) {
	Tessellator tessellator = Tessellator.instance;
	GL11.glDisable(GL11.GL_TEXTURE_2D);
	GL11.glDisable(GL11.GL_LIGHTING);
	for (int k1 = 0; k1 < 4; ++k1)
	{
	    tessellator.startDrawing(5);
	    float f2 = 0.5F;
	    tessellator.setColorRGBA_F(0.9F * f2, 0.9F * f2, 1.0F * f2, 0.3F);
	    double d9 = 0.1D + (double) k1 * 0.2D;
	    tessellator.draw();
	}
	GL11.glDisable(GL11.GL_BLEND);
	GL11.glEnable(GL11.GL_LIGHTING);
	GL11.glEnable(GL11.GL_TEXTURE_2D);
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
