package net.jamcraft.flowstone;

import java.lang.reflect.Field;

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
    
    public static Potion energyFlowtion;
    public static Potion lightFlowtion;
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        unstableFlowstone = new ItemFlowstoneMixture(5, 15, true);
        MinecraftForge.EVENT_BUS.register(new FlowtionHandler());
        registerFlowtions();
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerItem(unstableFlowstone, "unstableFlowstone");
        ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(new ItemStack(unstableFlowstone), 4, 16, 75));
    }
    
    public void registerFlowtions() {
	energyFlowtion = new Flowtion(47, true, 0).setIconIndex(0, 0).setPotionName("flowtion.energy");
	lightFlowtion = new Flowtion(48, true, 0).setIconIndex(0, 1).setPotionName("flowtion.light");		
	
	Potion[] types = null;
	Field[] fields = Potion.class.getDeclaredFields();
	int amount = fields.length;
	for (int currentField = 0; currentField < amount; ++currentField) {
		Field currentFeild = fields[currentField];
		currentFeild.setAccessible(true);

		try {
			if (currentFeild.getName().equals("potionTypes")
					|| currentFeild.getName().equals("potionTypes")) {
				Field error = Field.class.getDeclaredField("modifiers");
				error.setAccessible(true);
				error.setInt(currentFeild, currentFeild.getModifiers()
						& -17);
				types = (Potion[]) ((Potion[]) currentFeild
						.get((Object) null));
				Potion[] newPotionTypes = new Potion[256];
				System.arraycopy(types, 0, newPotionTypes, 0,
						types.length);
				currentFeild.set((Object) null, newPotionTypes);
			}
		} catch (Exception e) {
			System.err.println("Error. Please report this to MrComputerGhost!\nCrash Log: \n" + e);
		}
	}
    }
    
    
}
