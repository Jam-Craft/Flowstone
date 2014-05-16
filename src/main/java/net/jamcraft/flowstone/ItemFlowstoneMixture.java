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
	    int i = rand.nextInt(25);
	    if (i == 25) w.createExplosion(p, p.posX, p.posY, p.posX, 5, false);
	    if (i == 24) w.addWeatherEffect(new EntityLightningBolt());
	    else p.addPotionEffect(new PotionEffect(i, 6000, 0));
	    
        }
        
    }
    
}
