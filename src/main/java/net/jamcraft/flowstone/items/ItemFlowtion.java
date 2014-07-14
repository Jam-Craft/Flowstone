package net.jamcraft.flowstone.items;

import net.jamcraft.flowstone.Flowstone;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import java.util.Map;
import java.util.Random;

public class ItemFlowtion extends ItemFood {

    public ItemFlowtion(int par1, float par2, boolean par3) {
        super(par1, par2, par3);
        this.setUnlocalizedName("flowtion");
        this.setMaxStackSize(16);
        this.setTextureName(Flowstone.getFMTexture());
        this.setAlwaysEdible();
    }

    @Override
    public boolean isValidArmor(ItemStack stack, int armorType, Entity entity)
    {
        return true;
    }

    @Override
    protected void onFoodEaten(ItemStack par1ItemStack, World w, EntityPlayer p)
    {
        if (!w.isRemote)
        {
            Map<String, Fluid> map = FluidRegistry.getRegisteredFluids();
            Fluid[] foo = (Fluid[]) map.values().toArray();
            Random rand = new Random();
            int r = rand.nextInt(foo.length);

        } else {
            super.onFoodEaten(par1ItemStack, w, p);
        }

    }



}
