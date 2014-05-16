package net.jamcraft.flowstone;

import java.util.Random;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlowstoneMixture extends ItemFood {

    public ItemFlowstoneMixture(int par1, boolean par2) {
	super(par1, par2);
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
	    Random rand = new Random();
	    int i = rand.nextInt(35);
	    if (i == 35 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(i, 6000, 0));
	    if (i == 35 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(i, 6000, 0));
	    if (i == 34 && Loader.isModLoaded("VirusMod")) p.addPotionEffect(new PotionEffect(i, 6000, 0));
	    if (i == 33) p.travelToDimension(0);
	    if (i == 32) p.addVelocity(0D, 1.0D, 0D);
	    if (i == 31) p.setHealth(1F);
	    if (i == 30) p.travelToDimension(1);
	    if (i == 29) w.setWorldTime(12000);
	    if (i == 28) p.fallDistance = 50;
	    if (i == 27) p.addExhaustion(50F);
	    if (i == 26) p.addExperienceLevel(50);
	    if (i ==  0) p.setFire(9999999);
	    if (i == 25) w.createExplosion(p, p.posX, p.posY, p.posX, 5, false);
	    if (i == 24) w.addWeatherEffect(new EntityLightningBolt(w, p.posX, p.posY, p.posZ));
	    else p.addPotionEffect(new PotionEffect(i, 6000, 0));
	    
        }
        
    }
    
}
