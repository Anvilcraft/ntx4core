package net.anvilcraft.ntx4core.recipes;

import net.anvilcraft.anvillib.Util;
import net.anvilcraft.anvillib.event.Bus;
import net.anvilcraft.anvillib.event.IEventBusRegisterable;
import net.anvilcraft.anvillib.recipe.RecipesEvent;
import net.anvilcraft.anvillib.recipe.ShapedRecipeBuilder;
import net.anvilcraft.ntx4core.Ntx4Core;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.ForgeRegistries;

public class ShapedRecipes implements IEventBusRegisterable {
    public void registerRecipes(RecipesEvent ev) {
        if (!FMLEnvironment.production)
            return;

        ev.registerRecipe(new ShapedRecipeBuilder(
                              Ntx4Core.id("he_who_remains_tempad"),
                              new ItemStack(ForgeRegistries.ITEMS.getValue(
                                  new Identifier("tempad", "he_who_remains_tempad")
                              ))
        )
                              .pattern("MGM", "TCE", "MGM")
                              .ingredient('M', "projecte:dark_matter")
                              .ingredient('G', "#forge:ingots/refined_glowstone")
                              .ingredient('T', "rftoolsbase:tablet")
                              .ingredient('C', "mekanism:teleportation_core")
                              .ingredient('E', "mekanism:energy_tablet")
                              .build());
        ev.registerRecipe(
            new ShapedRecipeBuilder(
                Ntx4Core.id("dark_matter_conversion"),
                Util.stackFromRegistry(new Identifier("projecte", "dark_matter"))
            )
                .pattern("FDF", "DDD", "FDF")
                .ingredient('D', "nuclearscience:celldarkmatter")
                .ingredient('F', "projecte:aeternalis_fuel")
                .build()
        );

        ev.registerRecipe(new ShapedRecipeBuilder(
                              Ntx4Core.id("inscriber"),
                              Util.stackFromRegistry(new Identifier("ae2", "inscriber"))
        )
                              .pattern("IPI", "DCD", "IPI")
                              .ingredient('I', "#forge:ingots/steel")
                              .ingredient('D', "#forge:dusts/fluix")
                              .ingredient('C', "industrialforegoing:machine_frame_simple")
                              .ingredient('P', "minecraft:piston")
                              .build());
    }

    @Override
    public void registerEventHandlers(Bus bus) {
        bus.register(RecipesEvent.class, this::registerRecipes);
    }
}
