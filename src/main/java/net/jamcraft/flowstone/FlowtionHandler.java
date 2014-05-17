package net.jamcraft.flowstone;

import java.util.Random;

import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class FlowtionHandler {

    @SubscribeEvent
    public void onLivingUpdate(LivingUpdateEvent event) {
	Random rand = new Random();
	
	/**if (event.entityLiving.isPotionActive(Flowstone.energyFlowtion)) {
	    event.entityLiving.setSprinting(true);
	    event.entityLiving.setAbsorptionAmount(1);
	    event.entityLiving.fireResistance = 45;
	    event.entityLiving.setJumping(true);
	}**/
    }
    
    
    
}
