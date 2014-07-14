package net.jamcraft.flowstone.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.jamcraft.flowstone.Flowstone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.Random;

public class ItemEnergizedFlowstone extends ItemFood {

    public ItemEnergizedFlowstone(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
	super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
    this.setMaxStackSize(32);
	this.setTextureName(Flowstone.getFMTexture());
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
        Random rand = new Random();
        int e = rand.nextInt(6);
        int r = rand.nextInt(4);
        if (r == 4) {
	        p.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 191 * e + e, e));
	        p.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 122 * e + e, e));
	        p.addPotionEffect(new PotionEffect(Potion.jump.id, 142 * e + e, e));
        }
        if (r == 3) p.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 191 * e + e, e));
        if (r == 2) p.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 122 * e + e, e));
        if (r == 1) p.addPotionEffect(new PotionEffect(Potion.jump.id, 142 * e + e, e));
        if (r == 0) ;
	} else {
	    super.onFoodEaten(par1ItemStack, w, p);
	}

    }

}
