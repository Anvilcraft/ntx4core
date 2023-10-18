package net.anvilcraft.ntx4core.recipes;

import net.anvilcraft.ntx4core.Ntx4Core;
import net.anvilcraft.ntx4core.Util;
import net.anvilcraft.ntx4core.recipe.InputReplaceRecipeMapper;
import net.anvilcraft.ntx4core.recipe.RecipesEvent;
import net.minecraft.util.Identifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Ntx4Core.MODID, bus = Bus.MOD)
public class InputReplacements {
    @SubscribeEvent
    public static void onRecipeRegister(RecipesEvent ev) {
        var darkMatter = Util.ingredientFromString("projecte:dark_matter");

        ev.mapRecipeID(
            new Identifier("draconicevolution", "components/draconium_core"),
            new InputReplaceRecipeMapper().replace("#forge:ingots/draconium", darkMatter)
        );

        ev.mapRecipeID(
            new Identifier("draconicevolution", "components/wyvern_core"),
            new InputReplaceRecipeMapper().replace("#forge:ingots/draconium", darkMatter)
        );

        ev.mapRecipeID(
            new Identifier("projecte", "relay_mk1"),
            new InputReplaceRecipeMapper().replace(
                "#forge:storage_blocks/diamond",
                "mekanism:pellet_antimatter"
            )
        );

        var philosopherStoneMapper = new InputReplaceRecipeMapper().replace(
            "#forge:gems/diamond",
            "#forge:darkmatter"
        );
        ev.mapRecipeID(
            new Identifier("projecte", "philosophers_stone"), philosopherStoneMapper
        );
        ev.mapRecipeID(
            new Identifier("projecte", "philosophers_stone_alt"), philosopherStoneMapper
        );

        // Unify DeepResonance machine frames
        ev.mapRecipes(new InputReplaceRecipeMapper().replace(
            "deepresonance:machine_frame", "rftoolsbase:machine_frame"
        ));
    }
}
