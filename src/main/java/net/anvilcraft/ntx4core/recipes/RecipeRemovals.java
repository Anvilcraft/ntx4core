package net.anvilcraft.ntx4core.recipes;

import net.anvilcraft.anvillib.Util;
import net.anvilcraft.anvillib.event.Bus;
import net.anvilcraft.anvillib.event.IEventBusRegisterable;
import net.anvilcraft.anvillib.recipe.RecipeContainsPredicate;
import net.anvilcraft.anvillib.recipe.RecipesEvent;
import net.minecraft.util.Identifier;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class RecipeRemovals implements IEventBusRegisterable {
    public void removeRecipes(RecipesEvent ev) {
        if (!FMLEnvironment.production)
            return;

        ev.removeRecipesMatching(new RecipeContainsPredicate(
            Util.stackFromRegistry(new Identifier("projecte", "condenser_mk1"))
        ));
        ev.removeRecipesMatching(new RecipeContainsPredicate(
            Util.stackFromRegistry(new Identifier("projecte", "transmutation_table"))
        ));
    }

    @Override
    public void registerEventHandlers(Bus bus) {
        bus.register(RecipesEvent.class, this::removeRecipes);
    }
}
