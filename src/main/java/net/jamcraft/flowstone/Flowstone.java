package net.jamcraft.flowstone;

import net.minecraft.item.Item;

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
    
    public static Item flowstoneMixture;
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        flowstoneMixture = new ItemFlowstoneMixture(0, false);
        
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerItem(flowstoneMixture, "flowstoneMixture");
    }
    
}
