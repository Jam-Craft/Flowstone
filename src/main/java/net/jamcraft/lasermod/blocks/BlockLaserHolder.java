package net.jamcraft.lasermod.blocks;

import net.jamcraft.lasermod.Lasers;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * @author Jackson Isted
 * @version 1.0
 */
public class BlockLaserHolder extends Block {
    public BlockLaserHolder() {
        super(Material.anvil);
        this.setCreativeTab(Lasers.creativeTab);
    }
}
