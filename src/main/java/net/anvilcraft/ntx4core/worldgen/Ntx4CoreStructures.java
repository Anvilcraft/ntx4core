package net.anvilcraft.ntx4core.worldgen;

import net.anvilcraft.anvillib.worldgen.AdvancedStructurePoolFeatureConfig;
import net.anvilcraft.ntx4core.Ntx4Core;
import net.anvilcraft.ntx4core.worldgen.borg.BorgKindbergStructurePieces;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Ntx4CoreStructures {
    public static final DeferredRegister<ConfiguredStructureFeature<?, ?>>
        CONFIGURED_STRUCTURE_FEATURES = DeferredRegister.create(
            BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE.getKey(), Ntx4Core.MODID
        );

    public static final RegistryObject<ConfiguredStructureFeature<?, ?>> BORG_KINDBERG
        = CONFIGURED_STRUCTURE_FEATURES.register(
            "borg",
            ()
                -> Ntx4CoreFeatures.BORG_KINDBERG.configure(
                    new AdvancedStructurePoolFeatureConfig(
                        BorgKindbergStructurePieces.START, 7, 256, true
                    ),
                    TagKey.of(Registry.BIOME_KEY, Ntx4Core.id("has_structure/borg")),
                    true
                )
        );
}
