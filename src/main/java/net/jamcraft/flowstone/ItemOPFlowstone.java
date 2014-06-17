package net.jamcraft.flowstone;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.Random;

public class ItemOPFlowstone extends ItemFood {

    public ItemOPFlowstone(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
	super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
	this.setTextureName("flowstone:flowstone_mixture");
	this.setAlwaysEdible();
	this.setFull3D();
    this.setMaxStackSize(32);
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

    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
	return EnumAction.drink;
    }

    @Override
    public boolean isWolfsFavoriteMeat()
    {
	return true;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
	return 64;
    }

    protected void onFoodEaten(ItemStack par1ItemStack, World w, EntityPlayer p)
    {
	if (!w.isRemote)
	{

	    Random rand = new Random();
	    int e = rand.nextInt(3);
	    int i = rand.nextInt(2);
	    if (i == 1) {
		p.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 6000 + e * e, e));
		p.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 6000 + e * e, e));
		p.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 6000 + e * e, e));
		p.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 6000 + e * e, e));
		p.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 6000 + e * e, e));
		p.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 6000 + e * e, 2));
		p.addPotionEffect(new PotionEffect(Potion.heal.getId(), 1, 15));
		p.addPotionEffect(new PotionEffect(Potion.jump.getId(), 6000 + e * e, 1));
		p.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 6000 + e * e, e));
		p.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 6000 + e * e, e));
		p.addPotionEffect(new PotionEffect(22, 6000 + e * e, e));
		p.addPotionEffect(new PotionEffect(23, 6000 + e * e, e));
		p.addPotionEffect(new PotionEffect(21, 6000 + e * e, e));
	    }
	    else {
		p.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 6000 + e * e, e));
		p.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 6000 + e * e, e));
		p.addPotionEffect(new PotionEffect(Potion.digSlowdown.getId(), 6000 + e * e, e));
		p.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 6000 + e * e, e));
		p.addPotionEffect(new PotionEffect(Potion.weakness.getId(), 6000 + e * e, e));
        p.setHealth(1);
		int f = rand.nextInt(7);
		EntityChicken ent = new EntityChicken(w);
		ent.setCustomNameTag("MrComputerGhost");
		w.createExplosion(ent, p.posX, p.posY, p.posZ, f, true);
		p.inventory.dropAllItems();
		p.setAir(22);
		p.addScore(1);
	    }
	} else {
	    super.onFoodEaten(par1ItemStack, w, p);
	}

    }

}
