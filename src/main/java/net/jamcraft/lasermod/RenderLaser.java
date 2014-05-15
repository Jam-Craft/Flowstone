package net.jamcraft.lasermod;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.jamcraft.lasermod.entities.EntityLaser;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderLaser extends Render {
    
    private static final ResourceLocation laserTextures = new ResourceLocation("textures/entity/experience_orb.png");

    public void doRender(EntityLaser laser, double par2, double par4, double par6, float par8, float par9) {
	GL11.glPushMatrix();
	GL11.glTranslatef((float)par2, (float)par4, (float)par6);
	this.bindEntityTexture(laser);
	OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)laser.getBrightnessForRender(par9) % 65536 / 1.0F, (float)laser.getBrightnessForRender(par9) / 65536 / 1.0F);
	GL11.glColor4f(1.0F, 0.0F, 0.0F, 1.0F);
	GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
	GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
	GL11.glScalef(0.3F, 0.3F, 0.3F);
	Tessellator tessellator = Tessellator.instance;
	tessellator.startDrawingQuads();
	tessellator.setColorRGBA_I(1, 128);
	tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.draw();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
	
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity var1) {
	return laserTextures;
    }

    @Override
    public void doRender(Entity var1, double var2, double var4, double var6,
	    float var8, float var9) {
	this.doRender((EntityLaser) var1, var2, var4, var6, var8, var9);
    }

}
