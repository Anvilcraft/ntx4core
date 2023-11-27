package net.anvilcraft.ntx4core.recipes;

import net.anvilcraft.anvillib.event.Bus;
import net.anvilcraft.anvillib.event.IEventBusRegisterable;
import net.anvilcraft.anvillib.recipe.RecipesEvent;
import net.anvilcraft.anvillib.recipe.ShapedRecipeBuilder;
import net.anvilcraft.ntx4core.Ntx4Core;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class RecipeReplacements implements IEventBusRegisterable {
    public void replaceRecipes(RecipesEvent ev) {
        if (!FMLEnvironment.production)
            return;

        ev.mapRecipeID(
            new Identifier("shrink", "shrinking_device"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("shrinking_device"), r.getOutput())
                   .pattern("IDI", "TFE", "IDI")
                   .ingredient('I', "#forge:ingots/osmium")
                   .ingredient('D', "fluxnetworks:flux_dust")
                   .ingredient('T', "rftoolsbase:tablet")
                   .ingredient('F', "ae2:fluix_pearl")
                   .ingredient('E', "mekanism:energy_tablet")
                   .build()
        );

        ev.mapRecipeID(
            new Identifier("compactmachines", "personal_shrinking_device"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("personal_shrinking_device"), r.getOutput())
                   .pattern("IDI", "TFE", "IDI")
                   .ingredient('I', "#forge:ingots/iron")
                   .ingredient('D', "fluxnetworks:flux_dust")
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
            new Identifier("buildinggadgets", "gadget_building"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("gadget_building"), r.getOutput())
                   .pattern("MGM", "TCE", "MGM")
                   .ingredient('M', "#forge:ingots/iron")
                   .ingredient('G', "fluxnetworks:flux_dust")
                   .ingredient('T', "rftoolsbase:tablet")
                   .ingredient('C', "constructionwand:diamond_wand")
                   .ingredient('E', "mekanism:energy_tablet")
                   .build()
        );

        ev.mapRecipeID(
            new Identifier("buildinggadgets", "gadget_exchanging"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("gadget_exchanging"), r.getOutput())
                   .pattern("MGM", "TCE", "MGM")
                   .ingredient('M', "#forge:ingots/iron")
                   .ingredient('G', "fluxnetworks:flux_dust")
                   .ingredient('T', "rftoolsbase:tablet")
                   .ingredient('C', "psi:psigem")
                   .ingredient('E', "mekanism:energy_tablet")
                   .build()
        );

        ev.mapRecipeID(
            new Identifier("buildinggadgets", "gadget_copy_paste"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("gadget_copy_paste"), r.getOutput())
                   .pattern("MGM", "TCE", "MGM")
                   .ingredient('M', "#forge:ingots/iron")
                   .ingredient('G', "fluxnetworks:flux_dust")
                   .ingredient('T', "rftoolsbase:tablet")
                   .ingredient('C', "rftoolsbuilder:builder")
                   .ingredient('E', "mekanism:energy_tablet")
                   .build()
        );

        ev.mapRecipeID(
            new Identifier("buildinggadgets", "gadget_destruction"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("gadget_destruction"), r.getOutput())
                   .pattern("MGM", "TCE", "MGM")
                   .ingredient('M', "#forge:ingots/iron")
                   .ingredient('G', "fluxnetworks:flux_dust")
                   .ingredient('T', "rftoolsbase:tablet")
                   .ingredient('C', "constructionwand:core_destruction")
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
                   .ingredient('D', "fluxnetworks:flux_dust")
                   .build()
        );

        ev.mapRecipeID(
            new Identifier("enderrift", "rift_orb"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("rift_orb"), r.getOutput())
                   .pattern("DPD", "PCP", "DPD")
                   .ingredient('D', "projecte:dark_matter")
                   .ingredient('P', Items.ENDER_EYE)
                   .ingredient('C', "ae2:singularity")
                   .build()
        );

        ev.mapRecipeID(
            new Identifier("projecte", "dark_matter"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("dark_matter"), r.getOutput())
                   .pattern("DFD", "FSF", "DFD")
                   .ingredient('F', "projecte:aeternalis_fuel")
                   .ingredient('S', "mekanism:pellet_antimatter")
                   .ingredient('D', "#forge:ingots/draconium")
                   .build()
        );

        ev.mapRecipeID(
            new Identifier("projecte", "red_matter"),
            r
            -> new ShapedRecipeBuilder(Ntx4Core.id("red_matter"), r.getOutput())
                   .pattern("CDC", "QSE", "CDC")
                   .ingredient('D', "projecte:dark_matter")
                   .ingredient('Q', "assemblylinemachines:quark_matter")
                   .ingredient('E', "dmlreforged:pristine_matter_dragon")
                   .ingredient('S', "ae2:singularity")
                   .ingredient('C', "powah:crystal_nitro")
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

        ev.mapRecipeID(
            new Identifier("laserio", "laser_connector"), 
            r -> new ShapedRecipeBuilder(Ntx4Core.id("laser_connector"), r.getOutput())
                .pattern(" R ", "BCB", " D ")
                .ingredient('R', "#forge:dusts/redstone")
                .ingredient('B', "powah:capacitor_blazing")
                .ingredient('C', "powah:dielectric_casing")
                .ingredient('D', "powah:dielectric_rod")
                .build()
        );

        ev.mapRecipeID(
            new Identifier("laserio", "laser_node"), 
            r -> new ShapedRecipeBuilder(Ntx4Core.id("laser_node"), r.getOutput())
                .pattern("BRB", "RCR", "BRB")
                .ingredient('R', "#forge:dusts/redstone")
                .ingredient('B', "powah:crystal_blazing")
                .ingredient('C', "powah:dielectric_casing")
                .build()
        );

        ev.mapRecipeID(
            new Identifier("dmlreforged", "simulation_chamber/simulation_chamber"), 
            r -> new ShapedRecipeBuilder(Ntx4Core.id("simulation_chamber"), r.getOutput())
                .pattern("NPN", "ECE", "NDN")
                .ingredient('N', "#forge:nuggets/enderium")
                .ingredient('E', "powah:energy_cell_niotic")
                .ingredient('C', "dmlreforged:machine_casing")
                .ingredient('P', "ae2:engineering_processor")
                .ingredient('D', "integrateddynamics:part_display_panel")
                .build()
        );

        ev.mapRecipeID(
            new Identifier("dmlreforged", "machine_casing"), 
            r -> new ShapedRecipeBuilder(Ntx4Core.id("machine_casing"), r.getOutput())
                .pattern("NON", "OCO", "NON")
                .ingredient('N', "#forge:nuggets/refined_obsidian")
                .ingredient('O', "dmlreforged:soot_covered_plate")
                .ingredient('C', "rftoolsbase:machine_frame")
                .build()
        );

        ev.mapRecipeID(
            new Identifier("dmlreforged", "extraction_chamber/extraction_chamber"), 
            r -> new ShapedRecipeBuilder(Ntx4Core.id("extraction_chamber"), r.getOutput())
                .pattern("NPN", "ECE", "NDN")
                .ingredient('N', "powah:crystal_blazing")
                .ingredient('E', "powah:energy_cell_niotic")
                .ingredient('C', "dmlreforged:machine_casing")
                .ingredient('P', "ae2:logic_processor")
                .ingredient('D', Items.NETHER_STAR)
                .build()
        );

        ev.mapRecipeID(
            new Identifier("alchemistry", "reactor_casing"), 
            r -> new ShapedRecipeBuilder(Ntx4Core.id("reactor_casing"), r.getOutput())
                .pattern("OPO", "PCP", "OPO")
                .ingredient('P', "#forge:ingots/platinum")
                .ingredient('O', "#forge:ingots/osmium")
                .ingredient('C', "mekanism:steel_casing")
                .build()
        );

        ev.mapRecipeID(
            new Identifier("alchemistry", "fission_chamber_controller"), 
            r -> new ShapedRecipeBuilder(Ntx4Core.id("fission_chamber_controller"), r.getOutput())
                .pattern("LFL", "GCA", "LFL")
                .ingredient('L', "#forge:ingots/lead")
                .ingredient('F', "mekanismgenerators:fission_reactor_casing")
                .ingredient('C', "#forge:circuits/elite")
                .ingredient('A', "#forge:alloys/advanced")
                .ingredient('G', "mekanismgenerators:reactor_glass")
                .build()
        );

        ev.mapRecipeID(
            new Identifier("alchemistry", "fusion_chamber_controller"), 
            r -> new ShapedRecipeBuilder(Ntx4Core.id("fusion_chamber_controller"), r.getOutput())
                .pattern("LFL", "GCA", "LFL")
                .ingredient('L', "#forge:ingots/steel")
                .ingredient('F', "mekanismgenerators:fusion_reactor_frame")
                .ingredient('C', "#forge:circuits/ultimate")
                .ingredient('A', "#forge:alloys/advanced")
                .ingredient('G', "mekanismgenerators:reactor_glass")
                .build()
        );

        ev.mapRecipeID(
            new Identifier("psi", "programmer"), 
            r -> new ShapedRecipeBuilder(Ntx4Core.id("psi_programmer"), r.getOutput())
                .pattern("SDS", "SCS", " S ")
                .ingredient('S', "#forge:ingots/pure_steel")
                .ingredient('D', "psi:psidust")
                .ingredient('C', "ae2:calculation_processor")
                .build()
        );

        ev.mapRecipeID(
            new Identifier("psi", "assembler"), 
            r -> new ShapedRecipeBuilder(Ntx4Core.id("psi_assembler"), r.getOutput())
                .pattern("SDS", "SCS", " S ")
                .ingredient('S', "#forge:ingots/pure_steel")
                .ingredient('D', "ae2:formation_core")
                .ingredient('C', "#forge:circuits/elite")
                .build()
        );

        ev.mapRecipeID(
            new Identifier("sfm", "manager"), 
            r -> new ShapedRecipeBuilder(Ntx4Core.id("sfm_manager"), r.getOutput())
                .pattern("SRS", "RCR", "SRS")
                .ingredient('S', "ae2:smooth_sky_stone_block")
                .ingredient('R', "dmlreforged:soot_covered_redstone")
                .ingredient('C', "ae2:logic_processor")
                .build()
        );

        ev.mapRecipeID(
            new Identifier("sfm", "cable"), 
            r -> new ShapedRecipeBuilder(Ntx4Core.id("sfm_cable"), r.getOutput())
                .pattern("SNS", "FFF", "SCS")
                .ingredient('S', "ae2:sky_dust")
                .ingredient('F', "#forge:gems/fluix")
                .ingredient('C', "#forge:gems/certus_quartz")
                .ingredient('N', "#forge:gems/quartz")
                .build()
        );

        ev.mapRecipeID(
            new Identifier("modularrouters", "modular_router"), 
            r -> new ShapedRecipeBuilder(Ntx4Core.id("modular_router"), new ItemStack(r.getOutput().getItem(), 1))
                .pattern("IFI", "NPC", "IFI")
                .ingredient('I', "#forge:ingots/iron")
                .ingredient('F', "#forge:gems/fluix")
                .ingredient('C', "#forge:gems/certus_quartz")
                .ingredient('N', "#forge:gems/quartz")
                .ingredient('P', "ae2:logic_processor")
                .build()
        );
    }

    @Override
    public void registerEventHandlers(Bus bus) {
        bus.register(RecipesEvent.class, this::replaceRecipes);
    }
}
