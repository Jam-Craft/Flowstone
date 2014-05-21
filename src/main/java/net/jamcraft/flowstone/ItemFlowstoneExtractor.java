package net.jamcraft.flowstone;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemFlowstoneExtractor extends Item {

    public ItemFlowstoneExtractor() {
	super();
	this.setTextureName("flowstone:extractor");
	this.setFull3D();
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
	if (entity instanceof EntityCreeper && player.inventory.hasItem(Items.glass_bottle)) {
	    player.inventory.consumeInventoryItem(Items.glass_bottle);
	    player.inventory.addItemStackToInventory(new ItemStack(Flowstone.explodingFlowstone));
	}
	return true;
    }

}
