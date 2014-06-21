
package net.jamcraft.flowstone.items;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.jamcraft.flowstone.Flowstone;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import org.apache.logging.log4j.Level;

import java.util.Random;

public class ItemFlowstoneMixture extends ItemFood {

    public ItemFlowstoneMixture(int par1, float par2, boolean par3) {
	    super(par1, par2, par3);
        this.setMaxStackSize(32);
	    this.setTextureName("flowstone:flowstone_mixture");
	    this.setAlwaysEdible();
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }

    public EnumRarity getRarity(ItemStack par1ItemStack) {
	    return EnumRarity.rare;
    }
    
    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.drink;
    }

    protected void onFoodEaten(ItemStack par1ItemStack, World w, EntityPlayer p)
    {
	    if (!w.isRemote)
	    {
	        WorldInfo worldinfo = MinecraftServer.getServer().worldServers[0].getWorldInfo();
	        Random rand = new Random();
	        int e = rand.nextInt(6);
            int i = rand.nextInt(50);
            int r = rand.nextInt(23);
            int s = rand.nextInt(15);
	        Flowstone.logger.log(Level.INFO, p.getCommandSenderName() + " Drank Flowtion " + i + ":" + e + ":" + r);
            if (i == 50) spawnExcessiveAmountOf(new ItemStack(Items.dye, e, s), r, p);
            if (i == 49) spawnExcessiveAmountOf(new ItemStack(Blocks.wool, e, s), r, p);
            if (i == 48) Minecraft.getMinecraft().gameSettings.smoothCamera = true;
            if (i == 47) p.capabilities.allowFlying = true;
            if (i == 46) p.setPosition(p.getBedLocation(0).posX, p.getBedLocation(0).posY, p.getBedLocation(0).posZ);
	        if (i == 45) worldinfo.setRaining(true);
	        if (i == 42) p.addToPlayerScore(p, e * e + e);
	        if (i == 41) p.capabilities.setPlayerWalkSpeed(0.1F);
	        if (i == 40 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(36, 6000, e));
	        if (i == 39 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(35, 6000, e));
	        if (i == 38 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(34, 6000, e));
	        if (i == 37 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(33, 6000, e));
	        if (i == 36 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(32, 6000, e));
	        if (i == 35 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(31, 6000, e));
	        if (i == 34 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(30, 6000, e));
	        if (i == 33) p.inventory.dropAllItems();
	        if (i == 32) p.attackEntityAsMob(p);
	        if (i == 31) p.setHealth(1F);
	        if (i == 30) p.inventory.dropAllItems();
	        if (i == 29) w.setWorldTime(12000 + e * i);
	        if (i == 28) p.fallDistance = 19 + e;
	        if (i == 27) p.addExhaustion(50F);
	        if (i == 26) p.addExperienceLevel(50);
	        if (i == 25) w.createExplosion(p, p.posX, p.posY, p.posX, 5, false);
	        if (i == 24) w.addWeatherEffect(new EntityLightningBolt(w, p.posX, p.posY, p.posZ));
	        if (i == 23) w.createExplosion(p, p.posX, p.posY, p.posX, 5, true);
	        if (i == 22) p.setPosition(p.posX += e, p.posY += e, p.posZ += e);
	        if (i == 21) p.addExperienceLevel(4);
	        if (i == 20) p.extinguish();
	        if (i == 19) p.capabilities.setPlayerWalkSpeed(0.01F);
	        if (i == 18) p.cameraPitch = 99F;
	        if (i == 17) w.difficultySetting = EnumDifficulty.HARD;
	        if (i == 15) p.cameraYaw = 0F;
	        if (i == 14) p.eyeHeight = -16F;
	        if (i == 13) {
		        p.setHealth(1);
                p.setLastAttacker(p);
                p.attackTargetEntityWithCurrentItem(p);
	        }
	        if (i == 12) {
                w.setBlockToAir((int) p.posX, (int) p.posY - 1, (int) p.posZ);
                w.setBlockToAir((int) p.posX, (int) p.posY - 2, (int) p.posZ);
                w.setBlockToAir((int) p.posX, (int) p.posY - 3, (int) p.posZ);
                w.setBlockToAir((int) p.posX, (int) p.posY - 4, (int) p.posZ);
                w.setBlockToAir((int) p.posX, (int) p.posY - 5, (int) p.posZ);
            }
	        if (i == 11) Minecraft.getMinecraft().entityRenderer.activateNextShader();
	        if (i == 10) p.addChatMessage(new ChatComponentText("The Conspiracy Attacks!"));
	        if (i ==  9) p.inventory.addItemStackToInventory(new ItemStack(Items.potato, 64, 0).setStackDisplayName("PotatOS"));
	        if (i ==  8) w.setBlock((int)p.posX, (int)p.posY, (int)p.posZ, Blocks.diamond_block);
	        if (i ==  7) p.inventory.addItemStackToInventory(new ItemStack(Flowstone.mystFlowstone).setStackDisplayName("Drink Me!"));
	        if (i ==  5) w.spawnEntityInWorld(new EntityTNTPrimed(w, p.posX, p.posY, p.posZ, null));
            if (i ==  4) w.setBlock((int)p.posX, (int)p.posY + 1, (int)p.posZ, Blocks.lava);
            if (i ==  3) {
                EntitySilverfish esf = new EntitySilverfish(w);
                esf.setPosition(p.posX, p.posY, p.posZ);
                w.spawnEntityInWorld(esf);
                w.spawnEntityInWorld(esf);
                w.spawnEntityInWorld(esf);
                w.spawnEntityInWorld(esf);
            }
            if (i ==  2) p.addExhaustion(e + r * e);
            if (i ==  1) p.capabilities.setPlayerWalkSpeed(1.337F);
            if (i ==  0) p.setFire(9999999);
            else if (r != 0) p.addPotionEffect(new PotionEffect(r, 6000, e));
	    } else {
	        super.onFoodEaten(par1ItemStack, w, p);
	    }

    }

    private void spawnExcessiveAmountOf(ItemStack whatever, int times, EntityPlayer p) {
        for (int i = times; i >= 0; i--) {
            EntityItem item = new EntityItem(p.worldObj, p.posX, p.posY + 2, p.posZ, whatever);
            item.delayBeforeCanPickup = 0;
            p.worldObj.spawnEntityInWorld(item);

        }
    }


    public int getEntityLifespan(ItemStack itemStack, World world) {
	    return 2147483647;
    }

}
