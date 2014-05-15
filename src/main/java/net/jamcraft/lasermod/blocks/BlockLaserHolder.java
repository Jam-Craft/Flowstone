package net.jamcraft.lasermod.blocks;

import net.jamcraft.lasermod.Lasers;
import net.jamcraft.lasermod.ModConstants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

/**
 * @author Jackson Isted
 * @version 1.0
 */
public class BlockLaserHolder extends Block {
    public BlockLaserHolder() {
        super(Material.anvil);
        this.setCreativeTab(Lasers.creativeTab);
        this.setBlockTextureName(ModConstants.MODID+":apiblock");
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        return super.getLightValue(world, x, y, z);
        //If laser is in and turned on then show light
    }

    @Override
    public String getUnlocalizedName() {
        return "block.laser.apiblock.name";
    }
}
