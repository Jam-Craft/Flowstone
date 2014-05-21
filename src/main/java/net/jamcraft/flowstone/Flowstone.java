package net.jamcraft.flowstone;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
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
    public static Item explodingFlowstone;
    public static Item opFlowstone;
    public static Item trollFlowstone;
    public static Item flowstoneExtractor;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
	logger = event.getModLog();
	unstableFlowstone = new ItemFlowstoneMixture(5, 15, true).setUnlocalizedName("unstableFlowstone");
	energizedFlowstone = new ItemEnergizedFlowstone(5, 15, true).setUnlocalizedName("energizedFlowstone");
	explodingFlowstone = new ItemExplosiveFlowstone(5, 15, true).setUnlocalizedName("explodingFlowstone");
	opFlowstone = new ItemOPFlowstone(8, 32, true).setUnlocalizedName("opFlowstone");
	trollFlowstone = new ItemTrollFlowstone(8, 32, true).setUnlocalizedName("trollFlowstone");
	flowstoneExtractor = new ItemFlowstoneExtractor().setUnlocalizedName("flowstoneExtractor");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
	GameRegistry.registerItem(unstableFlowstone, "unstableFlowstone");
	GameRegistry.registerItem(energizedFlowstone, "energizedFlowstone");
	GameRegistry.registerItem(explodingFlowstone, "explodingFlowstone");
	GameRegistry.registerItem(opFlowstone, "opFlowstone");
	GameRegistry.registerItem(flowstoneExtractor, "flowstoneExtractor");
	GameRegistry.registerItem(trollFlowstone, "trollFlowstone");
	ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(new ItemStack(unstableFlowstone), 1, 12, 75));
	ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(new ItemStack(energizedFlowstone), 1, 5, 10));
	ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(new ItemStack(explodingFlowstone), 1, 5, 10));
	ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(new ItemStack(opFlowstone), 2, 4, 1));
	ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(new ItemStack(trollFlowstone), 2, 4, 5));
	GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.leather, 1), 5);
	GameRegistry.addSmelting(explodingFlowstone, new ItemStack(Items.gunpowder, 5), 10);
	GameRegistry.addSmelting(opFlowstone, new ItemStack(Items.golden_apple, 5, 1), 10);
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
	if (!Loader.isModLoaded("flowstoneenergy")) MinecraftForge.EVENT_BUS.register(new CapeEventHandler());
    }

}
