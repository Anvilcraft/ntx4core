package net.anvilcraft.ntx4core.mixin.common;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.yollo.dmlreforged.common.events.PlayerHandler;

import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangeGameModeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;

@Mixin(PlayerHandler.class)
public abstract class PlayerHanlderMixin {

    /**
     * @author tilera
     * @reason remove flying events
     */
    @Overwrite(remap = false)
    public static void playerEuqipmentUpdate(LivingEquipmentChangeEvent event) {}
    
    /**
     * @author tilera
     * @reason remove flying events
     */
    @Overwrite(remap = false)
    public static void playerLogIn(PlayerLoggedInEvent event) {}


    /**
     * @author tilera
     * @reason remove flying events
     */
    @Overwrite(remap = false)
    public static void playerChangeGamemode(PlayerChangeGameModeEvent event) {}

}
