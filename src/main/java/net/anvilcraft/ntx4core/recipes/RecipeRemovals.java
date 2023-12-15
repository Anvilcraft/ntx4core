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
        ev.removeRecipesMatching((r) -> {
            var id = r.getId();
            return id.getNamespace().equals("createappliedkinetics")
                && id.getPath().startsWith("inscriber");
        });
        ev.removeRecipeID(new Identifier("projecte", "red_matter_alt"));
        ev.removeRecipeID(new Identifier("draconicevolution", "components/awakened_core")
        );
        ev.removeRecipeID(new Identifier("electrodynamics", "ingotsteel_ingot_smelting"));
        ev.removeRecipeID(new Identifier("beyond_earth", "steel_ingot_blasting"));
        ev.removeRecipeID(new Identifier("enderrift", "rift_orb"));
        ev.removeRecipeID(new Identifier("crossroads", "base_materials/bronze_alloy_ingot"));
    }

    @Override
    public void registerEventHandlers(Bus bus) {
        bus.register(RecipesEvent.class, this::removeRecipes);
    }
}
