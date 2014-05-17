package net.jamcraft.flowstone;

import java.util.Random;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;

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
    
    protected void onFoodEaten(ItemStack par1ItemStack, World w, EntityPlayer p)
    {
	if (!w.isRemote)
        {
	    p.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 16000, 3));
	    p.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 16000, 3));
	    p.addPotionEffect(new PotionEffect(Potion.jump.id, 16000, 1));
        } else {
            super.onFoodEaten(par1ItemStack, w, p);
        }
        
    }

}
