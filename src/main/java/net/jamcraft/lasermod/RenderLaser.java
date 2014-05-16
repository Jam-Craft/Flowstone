package net.jamcraft.lasermod;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.jamcraft.lasermod.entities.EntityLaser;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;

public class RenderLaser extends Render {
    
    private static final ResourceLocation laserTextures = new ResourceLocation("textures/entity/experience_orb.png");
    
    public void doRender(EntityLaser laser, double par2, double par4, double par6, float par8, float par9) {
	GL11.glPushMatrix();
	GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
	
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity var1) {
	return laserTextures;
	//Minecraft.getMinecraft().thePlayer.sendChatMessage(par1Str);
    }

    @Override
    public void doRender(Entity var1, double var2, double var4, double var6,
	    float var8, float var9) {
	this.doRender((EntityLaser) var1, var2, var4, var6, var8, var9);
    }

}
