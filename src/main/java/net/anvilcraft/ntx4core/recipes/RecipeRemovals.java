package net.anvilcraft.ntx4core.recipes;

import net.anvilcraft.ntx4core.Ntx4Core;
import net.anvilcraft.ntx4core.Util;
import net.anvilcraft.ntx4core.recipe.RecipeContainsPredicate;
import net.anvilcraft.ntx4core.recipe.RecipesEvent;
import net.minecraft.util.Identifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Ntx4Core.MODID, bus = Bus.MOD)
public class RecipeRemovals {
    @SubscribeEvent
    public static void onRecipeRegister(RecipesEvent ev) {
        ev.removeRecipesMatching(new RecipeContainsPredicate(
            Util.stackFromRegistry(new Identifier("projecte", "condenser_mk1"))
        ));
        ev.removeRecipesMatching(new RecipeContainsPredicate(
            Util.stackFromRegistry(new Identifier("projecte", "transmutation_table"))
        ));
    }
}
