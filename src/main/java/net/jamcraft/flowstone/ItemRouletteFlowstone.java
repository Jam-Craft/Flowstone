package net.jamcraft.flowstone;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

public class ItemRouletteFlowstone extends ItemFood {

    public ItemRouletteFlowstone(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
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

    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }

    public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5)
    {
        EntityPlayer player;
        if (entity instanceof EntityPlayer) //Checks if it's a player, not a mob. Cause that would be annoying.
        {
            player = (EntityPlayer)entity;
            float radius = 10;
            AxisAlignedBB bounds = player.boundingBox.expand(radius, radius, radius);
            List<EntityItem> list = world.getEntitiesWithinAABB(EntityItem.class, bounds); //All items in a redius of 10 around you.
            for (EntityItem e : list) {
                if (e.age >= 16) //Makes sure the item isn't too new
                {
                    //And Finally... Stuffs that make items move towards you!
                    double x = player.posX - e.posX;
                    double y = player.posY - e.posY;
                    double z = player.posZ - e.posZ;

                    double length = Math.sqrt(x * x + y * y + z * z) * 2.0D;

                    x = x / length + player.motionX / 2.0D;
                    y = y / length + player.motionY / 2.0D;
                    z = z / length + player.motionZ / 2.0D;

                    e.motionX = x;
                    e.motionY = y;
                    e.motionZ = z;
                    e.isAirBorne = true;
                    if (e.isCollidedHorizontally) {
                        e.motionY += 1.0D;
                    }
                }
            }
        }
    }

}
