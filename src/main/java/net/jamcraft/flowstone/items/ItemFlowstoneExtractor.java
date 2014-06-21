package net.jamcraft.flowstone.items;

import net.jamcraft.flowstone.Flowstone;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemFlowstoneExtractor extends Item {

    public ItemFlowstoneExtractor() {
	super();
	this.setTextureName("flowstone:extractor");
	this.setFull3D();
	this.setMaxDamage(10);
    }
    
    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
	if (entity instanceof EntityCreeper && player.inventory.hasItem(Items.glass_bottle) && this.getDamage(stack) != this.getMaxDamage()) {
	    player.inventory.consumeInventoryItem(Items.glass_bottle);
	    player.inventory.addItemStackToInventory(new ItemStack(Flowstone.explodingFlowstone));
	    stack.damageItem(1, player);
	    if (this.getDamage(stack) == 0) --stack.stackSize;
	}
	return true;
    }

}
