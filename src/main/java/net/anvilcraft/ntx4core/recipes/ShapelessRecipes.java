package net.anvilcraft.ntx4core.recipes;

import net.anvilcraft.anvillib.event.Bus;
import net.anvilcraft.anvillib.event.IEventBusRegisterable;
import net.anvilcraft.anvillib.recipe.RecipesEvent;
import net.anvilcraft.ntx4core.Ntx4Core;
import net.anvilcraft.ntx4core.Ntx4CoreItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.util.collection.DefaultedList;

public class ShapelessRecipes implements IEventBusRegisterable {
    public void registerRecipes(RecipesEvent ev) {
        ev.registerRecipe(new ShapelessRecipe(
            Ntx4Core.id("manual"),
            "",
            new ItemStack(Ntx4CoreItems.MANUAL.get()),
            DefaultedList.copyOf(
                null,
                Ingredient.ofItems(Items.BOOK),
                Ingredient.ofItems(Ntx4CoreItems.COMPUTATIONAL_CORE.get())
            )
        ));
    }

    @Override
    public void registerEventHandlers(Bus bus) {
        bus.register(RecipesEvent.class, this::registerRecipes);
    }
}
