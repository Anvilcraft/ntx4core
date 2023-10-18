package net.anvilcraft.ntx4core.mixin.common;

import java.util.HashMap;
import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.google.gson.JsonElement;

import net.anvilcraft.ntx4core.Ntx4Core;
import net.anvilcraft.ntx4core.recipe.RecipesEvent;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import net.minecraftforge.fml.ModLoader;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {
    @Shadow
    private Map<RecipeType<?>, Map<Identifier, Recipe<?>>> recipes;

    @Shadow
    private Map<Identifier, Recipe<?>> recipesById;

    @Inject(method = "apply", at = @At("RETURN"))
    private void afterLoad(
        Map<Identifier, JsonElement> alec1,
        ResourceManager alec2,
        Profiler alec3,
        CallbackInfo ci
    ) {
        if (!FMLEnvironment.production) {
            Ntx4Core.LOGGER.warn("Running in dev env, skipping Recipe Event!");
            return;
        }

        Ntx4Core.LOGGER.info("Firing Recipe Event");
        Map<RecipeType<?>, Map<Identifier, Recipe<?>>> recipes = new HashMap<>();
        this.recipes.forEach((k, v) -> recipes.put(k, new HashMap<>(v)));

        var ev = new RecipesEvent(recipes, new HashMap<>(this.recipesById));
        ModLoader.get().postEvent(ev);
        this.recipes = ev.recipes;
        this.recipesById = ev.recipesById;
    }
}
