package net.jamcraft.flowstone;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;

public class BlockFlowstoneGlass extends Block {

    public BlockFlowstoneGlass() {
        super(Material.redstoneLight);
        setBlockName("flowstoneGlass");
        setBlockTextureName("flowstone:flowstone_glass");
        setHardness(0.197348526F);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean canHarvestBlock(EntityPlayer player, int meta)
    {
        return true;
    }


}
