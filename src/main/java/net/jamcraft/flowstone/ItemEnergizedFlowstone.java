package net.jamcraft.flowstone;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEnergizedFlowstone extends ItemFood {

    public ItemEnergizedFlowstone(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
	super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
	this.setTextureName("flowstone:flowstone_mixture");
	this.setAlwaysEdible();
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
	    p.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 16000, 5));
	    p.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 16000, 5));
	    p.addPotionEffect(new PotionEffect(Potion.jump.id, 16000, 3));
	} else {
	    super.onFoodEaten(par1ItemStack, w, p);
	}

    }

}
