package net.jamcraft.flowstone;

import java.util.Random;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTrollFlowstone extends ItemFood {

    public ItemTrollFlowstone(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
	super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
	this.setTextureName("flowstone:flowstone_mixture");
	this.setAlwaysEdible();
    }

    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
	return EnumRarity.epic;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
	return true;
    }

    protected void onFoodEaten(ItemStack par1ItemStack, World w, EntityPlayer p)
    {
	if (!w.isRemote)
	{
	    Random rand = new Random();
	    int e = rand.nextInt(6);
	    w.createExplosion(new EntityChicken(w), p.posX, p.posY, p.posZ, e, true);
	    p.inventory.dropAllItems();
	    p.setAir(22);
	    p.addScore(1);
	} else {
	    super.onFoodEaten(par1ItemStack, w, p);
	}

    }

}
