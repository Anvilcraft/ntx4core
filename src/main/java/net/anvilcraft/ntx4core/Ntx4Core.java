package net.anvilcraft.ntx4core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.anvilcraft.anvillib.cosmetics.CosmeticsManager;
import net.anvilcraft.anvillib.event.Bus;
import net.anvilcraft.ntx4core.cosmetics.StaticCosmeticProvider;
import net.anvilcraft.ntx4core.recipes.InputReplacements;
import net.anvilcraft.ntx4core.recipes.RecipeRemovals;
import net.anvilcraft.ntx4core.recipes.RecipeReplacements;
import net.anvilcraft.ntx4core.recipes.ShapedRecipes;
import net.anvilcraft.ntx4core.worldgen.Ntx4CoreFeatures;
import net.anvilcraft.ntx4core.worldgen.Ntx4CoreStructures;
import net.minecraft.util.Identifier;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("ntx4core")
public class Ntx4Core {
    public static final String MODID = "ntx4core";
    public static final Logger LOGGER = LogManager.getLogger();

    public Ntx4Core() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        Ntx4CoreBlocks.BLOCKS.register(bus);
        Ntx4CoreItems.ITEMS.register(bus);
        Ntx4CoreFeatures.STRUCTURE_FEATURES.register(bus);
        Ntx4CoreStructures.CONFIGURED_STRUCTURE_FEATURES.register(bus);

        Bus.MAIN.register(new InputReplacements());
        Bus.MAIN.register(new RecipeRemovals());
        Bus.MAIN.register(new RecipeReplacements());
        Bus.MAIN.register(new ShapedRecipes());

        MinecraftForge.EVENT_BUS.register(Ntx4CoreShaders.class);
        CosmeticsManager.registerProvider(new StaticCosmeticProvider());
    }

    public static Identifier id(String s) {
        return new Identifier(MODID, s);
    }
}
