package net.jamcraft.flowstone;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlowstoneMixture extends ItemFood {

    public ItemFlowstoneMixture(int par1, float par2, boolean par3) {
	super(par1, par2, par3);
	this.setTextureName("flowstone:flowstone_mixture");
	this.setAlwaysEdible();
	
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
	    i = 9;
	    System.out.println(i + " , " + e);
	    if (i == 45) worldinfo.setRaining(!worldinfo.isRaining());
	    if (i == 43) w.spawnEntityInWorld(new EntitySilverfish(w));
	    if (i == 42) p.addToPlayerScore(p, 1);
	    if (i == 41) p.capabilities.setPlayerWalkSpeed(0.1F);
	    if (i == 40 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(i, 6000, 0)); 
	    if (i == 39 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(i, 6000, 0));
	    if (i == 38 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(i, 6000, 0));
	    if (i == 37 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(i, 6000, 0));
	    if (i == 36 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(i, 6000, 0));
	    if (i == 35 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(i, 6000, 0));
	    if (i == 34 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(i, 6000, 0));
	    if (i == 33) p.inventory.dropAllItems();
	    if (i == 32) p.attackEntityAsMob(p);
	    if (i == 31) p.setHealth(1F);
	    if (i == 30) p.inventory.dropAllItems();
	    if (i == 29) w.setWorldTime(12000);
	    if (i == 28) p.fallDistance = 50 + e;
	    if (i == 27) p.addExhaustion(50F);
	    if (i == 26) p.addExperienceLevel(50);
	    if (i == 00) p.setFire(9999999);
	    if (i == 25) w.createExplosion(p, p.posX, p.posY, p.posX, 5, false);
	    if (i == 24) w.addWeatherEffect(new EntityLightningBolt(w, p.posX, p.posY, p.posZ));
	    if (i == 23) w.createExplosion(p, p.posX, p.posY, p.posX, 5, true);
	    if (i == 22) p.setPosition(p.posX += e, p.posY += e, p.posZ += e);
	    if (i == 21) p.addExperienceLevel(4);
	    if (i == 20) p.extinguish();
	    if (i == 19) p.capabilities.setPlayerWalkSpeed(0.01F);
	    if (i == 18) p.cameraPitch = 99F;
	    if (i == 17) w.difficultySetting = EnumDifficulty.HARD;
	    if (i == 16) {
		Minecraft.getMinecraft().entityRenderer.deactivateShader();
		Minecraft.getMinecraft().entityRenderer.activateNextShader();
		Minecraft.getMinecraft().entityRenderer.activateNextShader();
		Minecraft.getMinecraft().entityRenderer.activateNextShader();
		Minecraft.getMinecraft().entityRenderer.activateNextShader();
		Minecraft.getMinecraft().entityRenderer.activateNextShader();
	    } 
	    if (i == 15) p.cameraYaw = 0F;
	    if (i == 14) p.eyeHeight = -5F;
	    if (i == 13) {
		p.setHealth(1);
		p.hitByEntity(p);
		p.attackEntityAsMob(p);
	    }
	    if (i == 12) w.setBlockToAir((int)p.posX, (int)p.posY - 1,(int) p.posZ);
	    if (i == 11) Minecraft.getMinecraft().entityRenderer.activateNextShader();
	    if (i == 10) p.addChatMessage(new ChatComponentText("The KKaylium Conspiracy Attacks!"));
	    if (i == 9) p.inventory.addItemStackToInventory(new ItemStack(Items.potato).setStackDisplayName("PotatOS"));
        } else {
            super.onFoodEaten(par1ItemStack, w, p);
        }
        
    }
    
}
