package net.anvilcraft.ntx4core;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.event.IModBusEvent;

public class RecipesEvent extends Event implements IModBusEvent {
    public Map<RecipeType<?>, Map<Identifier, Recipe<?>>> recipes;
    public Map<Identifier, Recipe<?>> recipesById;

    public RecipesEvent(
        Map<RecipeType<?>, Map<Identifier, Recipe<?>>> recipes,
        Map<Identifier, Recipe<?>> recipesById
    ) {
        this.recipes = recipes;
        this.recipesById = recipesById;
    }

    public void registerRecipe(Recipe<?> recipe) {
        if (!this.recipes.containsKey(recipe.getType()))
            this.recipes.put(recipe.getType(), new HashMap<>());

        this.recipes.get(recipe.getType()).put(recipe.getId(), recipe);
        this.recipesById.put(recipe.getId(), recipe);
    }
}
