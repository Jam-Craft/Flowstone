package net.jamcraft.flowstone;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.Logger;

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
    public static Item mystFlowstone;
    public static Item flowstoneExtractor;
    public static Block flowstoneGlass;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
	    logger = event.getModLog();
	    unstableFlowstone = new ItemFlowstoneMixture(5, 15, true).setUnlocalizedName("unstableFlowstone");
	    energizedFlowstone = new ItemEnergizedFlowstone(5, 15, true).setUnlocalizedName("energizedFlowstone");
	    explodingFlowstone = new ItemExplosiveFlowstone(5, 15, true).setUnlocalizedName("explodingFlowstone");
	    mystFlowstone = new ItemOPFlowstone(8, 32, true).setUnlocalizedName("opFlowstone");
	    flowstoneExtractor = new ItemFlowstoneExtractor().setUnlocalizedName("flowstoneExtractor");
        flowstoneGlass = new BlockFlowstoneGlass().setResistance(6000000.0F).setLightLevel(1.0F).setStepSound(Block.soundTypeGlass);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
	    GameRegistry.registerItem(unstableFlowstone, "unstableFlowstone");
	    GameRegistry.registerItem(energizedFlowstone, "energizedFlowstone");
	    GameRegistry.registerItem(explodingFlowstone, "explodingFlowstone");
	    GameRegistry.registerItem(mystFlowstone, "mystFlowstone");
	    GameRegistry.registerItem(flowstoneExtractor, "flowstoneExtractor");
        GameRegistry.registerBlock(flowstoneGlass, "flowstoneGlass");
	    ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(unstableFlowstone), 1, 12, 75));
        ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(unstableFlowstone), 1, 12, 75));
	    ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(unstableFlowstone), 1, 12, 75));
	    ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(energizedFlowstone), 1, 5, 10));
	    ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(energizedFlowstone), 1, 5, 10));
	    ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(energizedFlowstone), 1, 5, 10));
	    ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(explodingFlowstone), 1, 5, 10));
        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(explodingFlowstone), 1, 5, 10));
	    ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(explodingFlowstone), 1, 5, 10));
	    ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(mystFlowstone), 2, 4, 5));
        ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(mystFlowstone), 2, 4, 1));
	    ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(mystFlowstone), 2, 4, 1));
	    ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(mystFlowstone), 2, 4, 1));
	    ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(mystFlowstone), 2, 4, 1));
	    GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.leather, 1), 5);
	    GameRegistry.addSmelting(explodingFlowstone, new ItemStack(Items.gunpowder, 5), 10);
	    GameRegistry.addSmelting(mystFlowstone, new ItemStack(Items.golden_apple, 5, 1), 10);
	    if (Loader.isModLoaded("lucky")) GameRegistry.addShapelessRecipe(new ItemStack(this.unstableFlowstone), new ItemStack(Items.glass_bottle), new ItemStack(GameRegistry.findItem("lucky", "lucky_block")));
	    GameRegistry.addShapelessRecipe(new ItemStack(this.flowstoneExtractor), new ItemStack(Items.glass_bottle), new ItemStack(Blocks.glass_pane), new ItemStack(Blocks.glass_pane), new ItemStack(Items.iron_ingot), new ItemStack(Items.stick));
	
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
	    if (event.getSide() == Side.CLIENT && !Loader.isModLoaded("jccapes")) {
            MinecraftForge.EVENT_BUS.register(new CapeEventHandler());
        }
    }

}
