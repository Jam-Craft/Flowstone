package net.jamcraft.lasermod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.Random;

/**
 * @author Jackson Isted
 * @version 1.0
 */
public class BlockLaser extends Block {
    protected BlockLaser(Material material) {
        super(material);
        this.setLightLevel(1);
        this.setBlockUnbreakable();
        this.setBlockBounds(0,0,0,0,0,0);
    }

    @Override
    public int quantityDropped(Random p_149745_1_) {
        return 0;
    }

    @Override
    public int getRenderBlockPass() {
        return 2;
    }

    @Override
    public boolean isOpaqueCube() {
        return true;
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        world.setBlockToAir(x,y,z);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 vector, Vec3 vector2) {
        this.setBlockBounds(0F,0F,0F,0F,0F,0F);
        return super.collisionRayTrace(world, x, y, z, vector, vector2);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
        return null;
    }
}
