package net.jamcraft.lasermod.items;

import java.io.IOException;

import net.jamcraft.lasermod.Lasers;
import net.jamcraft.lasermod.TextureConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonSyntaxException;

import cpw.mods.fml.relauncher.ReflectionHelper;

public class ItemLaser extends Item {

    public ItemLaser() {
	this.setTextureName(TextureConstants.RESOURCE_CONTEXT + ":laser_basic");
	this.setCreativeTab(Lasers.creativeTab);
    }

    public ItemStack onItemRightClick(ItemStack item, World world,
	    EntityPlayer player) {
	Vec3 dirL = player.getLook(1);
	Vec3 source = world.getWorldVec3Pool().getVecFromPool(
		player.posX + dirL.xCoord,
		player.posZ + dirL.yCoord + player.eyeHeight,
		player.posZ + dirL.zCoord);
	Vec3 foo = source.addVector(dirL.xCoord * 100, dirL.yCoord * 100,
		dirL.zCoord * 100);
	MovingObjectPosition mop = world.rayTraceBlocks(source, foo, true);
	System.out.println(mop);
	if (mop == null)
	    return item;
	world.setBlock(mop.blockX, mop.blockY, mop.blockZ, Lasers.laserBlock);
	if (this.getUnlocalizedName().contains("explo"))
	    world.createExplosion(null, mop.blockX, mop.blockY, mop.blockZ, 15,
		    false);
	
    
	return item;
	
    }

    public void activateExstacy() {
	Logger logger = LogManager.getLogger();
	Minecraft mc = Minecraft.getMinecraft();
	EntityRenderer er = Minecraft.getMinecraft().entityRenderer;
	if (OpenGlHelper.shadersSupported)
	{
	    try
	    {
		logger.info("Selecting effect shaders/post/wobble.json");
		er.theShaderGroup = new ShaderGroup(null, mc.getFramebuffer(),
			new ResourceLocation("shaders/post/wobble.json"));
		er.theShaderGroup.createBindFramebuffers(mc.displayWidth,
			mc.displayHeight);
	    } catch (IOException ioexception)
	    {
		logger.warn("Failed to load shader: shaders/post/wobble.json",
			ioexception);
	    } catch (JsonSyntaxException jsonsyntaxexception)
	    {
		logger.warn("Failed to load shader: shaders/post/wobble.json",
			jsonsyntaxexception);
	    }
	}
	else
	{
	    er.theShaderGroup = null;
	    logger.info("No effect selected");
	}

    }
}
