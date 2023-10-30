package net.anvilcraft.ntx4core.mixin.accessor;

import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.StructureFeature;

@Mixin(StructureFeature.class)
public interface StructureFeatureAccessor {
    @Accessor("STRUCTURE_TO_GENERATION_STEP")
    public static Map<StructureFeature<?>, GenerationStep.Feature>
    getStructureToGenerationStepMap() {
        throw new AssertionError();
    }
}
