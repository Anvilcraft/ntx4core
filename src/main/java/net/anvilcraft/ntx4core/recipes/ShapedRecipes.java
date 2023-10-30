package net.anvilcraft.ntx4core.recipes;

import net.anvilcraft.anvillib.recipe.RecipesEvent;
import net.anvilcraft.anvillib.recipe.ShapedRecipeBuilder;
import net.anvilcraft.ntx4core.Ntx4Core;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber(modid = Ntx4Core.MODID, bus = Bus.MOD)
public class ShapedRecipes {
    @SubscribeEvent
    public static void onRecipeRegister(RecipesEvent ev) {
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
    }
}
