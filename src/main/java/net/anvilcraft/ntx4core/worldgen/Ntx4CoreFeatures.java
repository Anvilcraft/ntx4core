package net.anvilcraft.ntx4core.worldgen;

import net.anvilcraft.anvillib.worldgen.AdvancedStructurePoolFeatureConfig;
import net.anvilcraft.ntx4core.Ntx4Core;
import net.anvilcraft.ntx4core.mixin.accessor.StructureFeatureAccessor;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.VillageFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Ntx4CoreFeatures {
    public static final DeferredRegister<StructureFeature<?>> STRUCTURE_FEATURES
        = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, Ntx4Core.MODID);

    public static final VillageFeature BORG_KINDBERG
        = new VillageFeature(AdvancedStructurePoolFeatureConfig.CODEC);

    static {
        StructureFeatureAccessor.getStructureToGenerationStepMap().put(
            BORG_KINDBERG, GenerationStep.Feature.SURFACE_STRUCTURES
        );
        STRUCTURE_FEATURES.register("borg", () -> BORG_KINDBERG);
    }
}
