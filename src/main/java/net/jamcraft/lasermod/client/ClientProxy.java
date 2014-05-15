package net.jamcraft.lasermod.client;

import net.jamcraft.lasermod.CommonProxy;
import net.jamcraft.lasermod.RenderLaser;
import net.jamcraft.lasermod.entities.EntityLaser;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
    @Override
	public void init()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityLaser.class, new RenderLaser());
	}
}
