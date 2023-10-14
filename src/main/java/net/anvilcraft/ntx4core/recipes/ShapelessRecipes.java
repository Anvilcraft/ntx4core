package net.anvilcraft.ntx4core.recipes;

import net.anvilcraft.ntx4core.Ntx4Core;
import net.anvilcraft.ntx4core.RecipesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Ntx4Core.MODID, bus = Bus.MOD)
public class ShapelessRecipes {
    @SubscribeEvent
    public static void onRecipeRegister(RecipesEvent ev) {
        // TODO
    }
}
