package net.anvilcraft.ntx4core.cosmetics;

import net.anvilcraft.ntx4core.Ntx4Core;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Ntx4Core.MODID, bus = Bus.MOD, value = {Dist.CLIENT})
public class ClientEventHandler {
    
    @SubscribeEvent
    public static void clientSetup(EntityRenderersEvent.AddLayers event) {
        Ntx4Core.LOGGER.info("Client Setup: adding CosmeticLayer");
        for (String skin : event.getSkins()){
            Ntx4Core.LOGGER.info("Client Setup: player check");
            if (event.getSkin(skin) instanceof PlayerEntityRenderer render) {
                Ntx4Core.LOGGER.info("Client Setup: added CosmeticLayer");
                render.addFeature(new CosmeticFeatureRenderer(render, skin));
            }
            
        }
    }

}
