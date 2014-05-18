package net.jamcraft.flowstone;

import java.lang.reflect.Field;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModConstants.MODID, name = ModConstants.NAME)
public class Flowstone {

    @Mod.Instance(ModConstants.MODID)
    public static Flowstone instance;
    
    public static Logger logger;
    
    @SidedProxy(clientSide = "net.jamcraft.flowstone.ClientProxy", serverSide = "net.jamcraft.flowstone.CommonProxy")
    public static CommonProxy proxy;
    
    public static Item unstableFlowstone;
    public static Item energizedFlowstone;
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        unstableFlowstone = new ItemFlowstoneMixture(5, 15, true).setUnlocalizedName("unstableFlowstone");
        energizedFlowstone = new ItemEnergizedFlowstone(5, 15, true).setUnlocalizedName("energizedFlowstone");
        
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerItem(unstableFlowstone, "unstableFlowstone");
        GameRegistry.registerItem(energizedFlowstone, "energizedFlowstone");
        ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(new ItemStack(unstableFlowstone), 1, 12, 75));
        ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(new ItemStack(energizedFlowstone), 1, 5, 10));
        GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.leather, 1), 5);
        GameRegistry.addSmelting(unstableFlowstone, new ItemStack(Items.gunpowder, 5), 10);
    }
    
    
}
