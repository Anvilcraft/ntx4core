package net.anvilcraft.ntx4core.recipes;

import net.anvilcraft.anvillib.recipe.RecipesEvent;
import net.anvilcraft.anvillib.recipe.ShapedRecipeBuilder;
import net.anvilcraft.ntx4core.Ntx4Core;
import net.minecraft.util.Identifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.loading.FMLEnvironment;

@EventBusSubscriber(modid = Ntx4Core.MODID, bus = Bus.MOD)
public class RecipeReplacements {
    @SubscribeEvent
    public static void onRecipeRegister(RecipesEvent ev) {
        if (!FMLEnvironment.production)
            return;

        ev.mapRecipeID(
            new Identifier("shrink", "shrinking_device"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("shrinking_device"), r.getOutput())
                   .pattern("IDI", "TFE", "IDI")
                   .ingredient('I', "#forge:ingots/osmium")
                   .ingredient('D', "projecte:dark_matter")
                   .ingredient('T', "rftoolsbase:tablet")
                   .ingredient('F', "ae2:fluix_pearl")
                   .ingredient('E', "mekanism:energy_tablet")
                   .build()
        );

        ev.mapRecipeID(
            new Identifier("compactmachines", "personal_shrinking_device"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("shrinking_device"), r.getOutput())
                   .pattern("IDI", "TFE", "IDI")
                   .ingredient('I', "#forge:ingots/iron")
                   .ingredient('D', "projecte:dark_matter")
                   .ingredient('T', "rftoolsbase:tablet")
                   .ingredient('F', "ae2:fluix_pearl")
                   .ingredient('E', "mekanism:energy_tablet")
                   .build()
        );

        ev.mapRecipeID(
            new Identifier("tempad", "tempad"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("tempad"), r.getOutput())
                   .pattern("MGM", "TCE", "MGM")
                   .ingredient('M', "#forge:ingots/copper")
                   .ingredient('G', "#forge:ingots/refined_glowstone")
                   .ingredient('T', "rftoolsbase:tablet")
                   .ingredient('C', "mekanism:teleportation_core")
                   .ingredient('E', "mekanism:energy_tablet")
                   .build()
        );

        ev.mapRecipeID(
            new Identifier("dmlreforged", "deep_learner"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("deep_learner"), r.getOutput())
                   .pattern("MGM", "TCE", "MGM")
                   .ingredient('M', "#forge:ingots/manyullyn")
                   .ingredient('G', "mekanism:elite_control_circuit")
                   .ingredient('T', "rftoolsbase:tablet")
                   .ingredient('C', "industrialforegoing:mob_imprisonment_tool")
                   .ingredient('E', "mekanism:energy_tablet")
                   .build()
        );

        ev.mapRecipeID(
            new Identifier("scannable", "scanner"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("scanner"), r.getOutput())
                   .pattern("MGM", "TCE", "MGM")
                   .ingredient('M', "#forge:ingots/iron")
                   .ingredient('G', "mekanism:advanced_control_circuit")
                   .ingredient('T', "rftoolsbase:tablet")
                   .ingredient('C', "projecte:divining_rod_3")
                   .ingredient('E', "mekanism:energy_tablet")
                   .build()
        );

        ev.mapRecipeID(
            new Identifier("enderrift", "rift"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("enderrift"), r.getOutput())
                   .pattern("PDP", "DCD", "PDP")
                   .ingredient('P', "ae2:fluix_pearl")
                   .ingredient('C', "mekanism:qio_drive_array")
                   .ingredient('D', "projecte:dark_matter")
                   .build()
        );

        ev.mapRecipeID(
            new Identifier("enderrift", "rift_orb"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("rift_orb"), r.getOutput())
                   .pattern("DPD", "PCP", "DPD")
                   .ingredient('D', "projecte:dark_matter")
                   .ingredient('P', "minecraft:ender_eye")
                   .ingredient('C', "ae2:singularity")
                   .build()
        );

        ev.mapRecipeID(
            new Identifier("projecte", "dark_matter"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("dark_matter"), r.getOutput())
                   .pattern("DFD", "FSF", "DFD")
                   .ingredient('F', "projecte:aeternalis_fuel")
                   .ingredient('S', "ae2:singularity")
                   .ingredient('D', "#forge:ingots/draconium")
                   .build()
        );

        ev.mapRecipeID(
            new Identifier("quantumquarryplus", "qqprcp"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("quantum_quarry"), r.getOutput())
                   .pattern("ECE", "BFD", "ECE")
                   .ingredient('E', "#forge:ingots/enderium")
                   .ingredient('C', "quantumquarryplus:endercell")
                   .ingredient('B', "rftoolsbuilder:builder")
                   .ingredient('F', "quantumquarryplus:quarry_framw") // framw.
                   .ingredient('D', "rftoolsdim:dimension_builder")
                   .build()
        );
    }
}
