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
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.resource.ResourcePackSource;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forgespi.language.IModFileInfo;
import net.minecraftforge.forgespi.locating.IModFile;

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
        bus.addListener(Ntx4Core::addPackFinders);

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

    public static void addPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() == ResourceType.SERVER_DATA) {
            IModFileInfo modFileInfo = ModList.get().getModFileById(Ntx4Core.MODID);
            if (modFileInfo == null) {
                Ntx4Core.LOGGER.error("Could not find Ntx4Core mod file info; built-in resource packs will be missing!");
                return;
            }
            IModFile modFile = modFileInfo.getFile();
            event.addRepositorySource(
                (consumer, constructor) 
                    -> consumer.accept(ResourcePackProfile.of(
                        Ntx4Core.id("oregen_tweaks").toString(), 
                        false, () -> new ModFilePackResources("NTX4 Oregen Tweaks", modFile, "datapacks/oregen_tweaks"), 
                        constructor, 
                        ResourcePackProfile.InsertionPosition.TOP, 
                        ResourcePackSource.PACK_SOURCE_NONE
                    ))
            );
        }
    }
}
