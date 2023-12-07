package net.anvilcraft.ntx4core.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.widget.EntryListWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;

@Mixin(EntryListWidget.class)
public class EntryListWidgetMixin {
    @Shadow
    private boolean renderBackground;

    @Shadow
    private boolean renderHorizontalShadows;

    @Shadow
    private int left;

    @Shadow
    private int right;

    @Shadow
    private int bottom;

    @Shadow
    private int top;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void onInit(CallbackInfo ci) {
        this.renderBackground = false;
        this.renderHorizontalShadows = false;
    }

    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(MatrixStack matrices, int mouseX, int mouseY, float dt, CallbackInfo ci) {
        // transparent background
        var tes = Tessellator.getInstance();
        var bb = tes.getBuffer();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        bb.begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        bb.vertex(this.left, this.bottom, 0f).color(0f, 0f, 0f, 0.6f).next();
        bb.vertex(this.right, this.bottom, 0f).color(0f, 0f, 0f, 0.6f).next();
        bb.vertex(this.right, this.top, 0f).color(0f, 0f, 0f, 0.6f).next();
        bb.vertex(this.left, this.top, 0f).color(0f, 0f, 0f, 0.6f).next();

        RenderSystem.defaultBlendFunc();
        RenderSystem.enableBlend();
        tes.draw();
        RenderSystem.disableBlend();
    }

    /**
     * @reason Never render the boring dirt background.
     * @author LordMZTE
     */
    @Overwrite
    public void setRenderBackground(boolean alec) {}

    /**
     * @reason This doesn't work with our background.
     * @author LordMZTE
     */
    @Overwrite
    public void setRenderHorizontalShadows(boolean alec) {}
}
