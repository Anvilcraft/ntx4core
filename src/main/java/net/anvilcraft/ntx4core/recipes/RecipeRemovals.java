package net.anvilcraft.ntx4core.recipes;

import net.anvilcraft.anvillib.Util;
import net.anvilcraft.anvillib.recipe.RecipeContainsPredicate;
import net.anvilcraft.anvillib.recipe.RecipesEvent;
import net.anvilcraft.ntx4core.Ntx4Core;
import net.minecraft.util.Identifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.loading.FMLEnvironment;

@EventBusSubscriber(modid = Ntx4Core.MODID, bus = Bus.MOD)
public class RecipeRemovals {
    @SubscribeEvent
    public static void onRecipeRegister(RecipesEvent ev) {
        if (!FMLEnvironment.production)
            return;

        ev.removeRecipesMatching(new RecipeContainsPredicate(
            Util.stackFromRegistry(new Identifier("projecte", "condenser_mk1"))
        ));
        ev.removeRecipesMatching(new RecipeContainsPredicate(
            Util.stackFromRegistry(new Identifier("projecte", "transmutation_table"))
        ));
    }
}
