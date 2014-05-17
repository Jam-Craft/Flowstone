package net.jamcraft.flowstone;

import java.util.Random;

import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class FlowtionHandler {

    @SubscribeEvent
    public void onLivingUpdate(LivingUpdateEvent event) {
	Random rand = new Random();
	
	if (event.entityLiving.isPotionActive(Flowstone.energyFlowtion)) {
	    
	}
    }
    
    
    
}
