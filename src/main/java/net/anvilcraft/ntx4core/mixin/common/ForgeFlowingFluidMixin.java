package net.anvilcraft.ntx4core.mixin.common;

import java.util.function.Supplier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.fluid.Fluid;
import net.minecraftforge.fluids.ForgeFlowingFluid;

/**
 * This fixes a bug in forge where `ForgeFlowingFluid.matchesType` would always assume
 * that this.flowing != null.
 *
 * Fixes: https://github.com/Creators-of-Create/Create/issues/3712
 */
@Mixin(ForgeFlowingFluid.class)
public class ForgeFlowingFluidMixin {
    @Shadow(remap = false)
    private Supplier<? extends Fluid> flowing;
    @Shadow(remap = false)
    private Supplier<? extends Fluid> still;

    /**
     * @reason Forge has a bullshit implementation here that NPEs when this.flowing is
     * null.
     * @author LordMZTE
     */
    @Overwrite
    public boolean matchesType(Fluid fluid) {
        return (still != null && still.get() == fluid)
            || (flowing != null && flowing.get() == fluid);
    }
}
