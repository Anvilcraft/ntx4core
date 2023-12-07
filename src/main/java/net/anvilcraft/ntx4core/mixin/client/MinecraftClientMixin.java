package net.anvilcraft.ntx4core.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.anvilcraft.ntx4core.RenderHelper;
import net.minecraft.client.MinecraftClient;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Shadow
    private float pausedTickDelta;

    @Unique
    private long lastFrameTime = System.nanoTime();

    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(boolean alec, CallbackInfo ci) {
        long now = System.nanoTime();
        float dt = ((float) ((now - this.lastFrameTime) / 1000)) / 50000; // in ticks

        RenderHelper.shaderTime += dt;
        this.lastFrameTime = now;
    }
}
