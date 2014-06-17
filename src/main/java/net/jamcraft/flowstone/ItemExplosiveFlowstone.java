package net.jamcraft.flowstone;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class ItemExplosiveFlowstone extends ItemFood {

    public ItemExplosiveFlowstone(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
	super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
	this.setTextureName("flowstone:flowstone_mixture");
    this.setMaxStackSize(32);
	this.setAlwaysEdible();
    }

    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
	return EnumRarity.uncommon;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
	return true;
    }
    
    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }

    protected void onFoodEaten(ItemStack par1ItemStack, World w, EntityPlayer p)
    {
	if (!w.isRemote)
	{
	    Random rand = new Random();
	    int e = rand.nextInt(6);
	    if (e == 6) w.createExplosion(p, p.posX, p.posY, p.posZ, 15, true);
	    if (e == 5) w.createExplosion(null, p.posX, p.posY, p.posZ, 5, false);
	    if (e == 4) w.createExplosion(null, p.posX, p.posY - 5, p.posZ, 15, true);
	    if (e == 3) w.createExplosion(p, p.posX, p.posY, p.posZ, 1, false);
	    if (e == 2) w.createExplosion(null, p.posX, p.posY + 15, p.posZ, 15, true);
	    if (e == 1) w.createExplosion(p, p.posX - 5, p.posY + 15, p.posZ + 5, 15, false);
	    if (e == 0) w.createExplosion(null, p.posX, p.posY + 0, p.posZ, 1, true);
	} else {
	    super.onFoodEaten(par1ItemStack, w, p);
	}

    }

}
