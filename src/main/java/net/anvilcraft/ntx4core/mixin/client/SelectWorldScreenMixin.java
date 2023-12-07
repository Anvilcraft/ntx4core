package net.anvilcraft.ntx4core.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

@Mixin(SelectWorldScreen.class)
public class SelectWorldScreenMixin extends Screen {
    protected SelectWorldScreenMixin(Text alec) {
        super(alec);
        throw new AssertionError();
    }

    @Inject(method = "render", at = @At("HEAD"))
    private void
    onRender(MatrixStack matrices, int alec1, int alec2, float alec3, CallbackInfo ci) {
        this.renderBackground(matrices);
    }
}
