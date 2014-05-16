package net.jamcraft.flowstone;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlowstoneMixture extends ItemFood {

    public ItemFlowstoneMixture(int par1, float par2, boolean par3) {
	super(par1, par2, par3);
	this.setUnlocalizedName("flowstoneMixure");
    }
    
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }

    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return par1ItemStack.getItemDamage() == 0 ? EnumRarity.uncommon : EnumRarity.rare;
    }
    
    protected void onFoodEaten(ItemStack par1ItemStack, World w, EntityPlayer p)
    {
	if (!w.isRemote)
        {
	    WorldInfo worldinfo = MinecraftServer.getServer().worldServers[0].getWorldInfo();
	    Random rand = new Random();
	    int e = rand.nextInt(6);
	    int i = rand.nextInt(45);
	    System.out.println(i + " , " + e);
	    if (i == 45) worldinfo.setRaining(!worldinfo.isRaining());
	    if (i == 43) w.spawnEntityInWorld(new EntitySilverfish(w));
	    if (i == 42) p.addToPlayerScore(p, 1);
	    if (i == 41) p.capabilities.setPlayerWalkSpeed(0.1F);
	    if (i == 40) {
		Minecraft.getMinecraft().entityRenderer.deactivateShader();
		Minecraft.getMinecraft().entityRenderer.activateNextShader();
		Minecraft.getMinecraft().entityRenderer.activateNextShader();
		Minecraft.getMinecraft().entityRenderer.activateNextShader();
		Minecraft.getMinecraft().entityRenderer.activateNextShader();
		Minecraft.getMinecraft().entityRenderer.activateNextShader();
	    }
	    if (i == 39) w.createExplosion(p, p.posX, p.posY, p.posX, 5, true);
	    if (i == 38) p.setPosition(p.posX += e, p.posY += e, p.posZ += e);
	    if (i == 37) p.addExperienceLevel(4);
	    if (i == 36) p.extinguish();
	    if (i == 35 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(i, 6000, 0));
	    if (i == 35 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(i, 6000, 0));
	    if (i == 34 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(i, 6000, 0));
	    if (i == 33) p.travelToDimension(0);
	    if (i == 32) p.addVelocity(0D, 1.0D, 0D);
	    if (i == 31) p.setHealth(1F);
	    if (i == 30) p.travelToDimension(1);
	    if (i == 29) w.setWorldTime(12000);
	    if (i == 28) p.fallDistance = 50 + e;
	    if (i == 27) p.addExhaustion(50F);
	    if (i == 26) p.addExperienceLevel(50);
	    if (i == 00) p.setFire(9999999);
	    if (i == 25) w.createExplosion(p, p.posX, p.posY, p.posX, 5, false);
	    if (i == 24) w.addWeatherEffect(new EntityLightningBolt(w, p.posX, p.posY, p.posZ));
	    else p.addPotionEffect(new PotionEffect(new PotionEffect(i, 6000, 0)));	    
        } else {
            super.onFoodEaten(par1ItemStack, w, p);
        }
        
    }
    
}
