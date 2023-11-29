package net.anvilcraft.ntx4core.recipes;

import net.anvilcraft.anvillib.Util;
import net.anvilcraft.anvillib.event.Bus;
import net.anvilcraft.anvillib.event.IEventBusRegisterable;
import net.anvilcraft.anvillib.recipe.InputReplaceRecipeMapper;
import net.anvilcraft.anvillib.recipe.RecipesEvent;
import net.minecraft.util.Identifier;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class InputReplacements implements IEventBusRegisterable {
    public void replaceInputs(RecipesEvent ev) {
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
                "#forge:storage_blocks/diamond", "mekanism:pellet_antimatter"
            )
        );

        ev.mapRecipeID(
            new Identifier("rftoolsbase", "machine_frame"),
            new InputReplaceRecipeMapper().replace(
                "minecraft:iron_ingot", "#forge:ingots/steel"
            )
        );

        var philosopherStoneMapper = new InputReplaceRecipeMapper()
            .replace("#forge:gems/diamond", "ae2:singularity")
            .replace("#forge:dusts/redstone", "chemlib:erbium_dust")
            .replace("#forge:dusts/glowstone", "psi:ivory_substance")
        ;
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

        ev.mapRecipes(new InputReplaceRecipeMapper().replace(
            "thermal:machine_frame", "industrialforegoing:machine_frame_simple"
        ));
    }

    @Override
    public void registerEventHandlers(Bus bus) {
        if (!FMLEnvironment.production)
            return;

        bus.register(RecipesEvent.class, this::replaceInputs);
    }
}
