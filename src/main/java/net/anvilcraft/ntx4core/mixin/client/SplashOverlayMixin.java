package net.anvilcraft.ntx4core.mixin.client;

import java.util.Optional;
import java.util.function.Consumer;

import org.lwjgl.opengl.GL31;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import net.anvilcraft.ntx4core.Ntx4Core;
import net.anvilcraft.ntx4core.Ntx4CoreShaders;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Overlay;
import net.minecraft.client.gui.screen.SplashOverlay;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.resource.ResourceReload;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.ColorHelper.Argb;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.loading.ClientModLoader;

@Mixin(SplashOverlay.class)
public class SplashOverlayMixin extends Overlay {
    @Unique
    private static final Identifier LOGO
        = new Identifier(Ntx4Core.MODID, "textures/gui/title/splash.png");

    @Shadow
    @Final
    private MinecraftClient client;

    @Shadow
    @Final
    private boolean reloading;

    @Shadow
    @Final
    private ResourceReload reload;

    @Shadow
    @Final
    private Consumer<Optional<Throwable>> exceptionHandler;

    @Shadow
    private float progress;

    @Shadow
    private long reloadStartTime;

    @Shadow
    private long reloadCompleteTime;

    @Unique
    private float time = 0.0f;

    /**
     * @reason Replaces the vanilla spash screen
     * @author LordMZTE
     */
    @Overwrite
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        time += delta;
        if (Ntx4CoreShaders.SPLASH == null) {
            Ntx4CoreShaders.registerShaders();
        }
        int i = this.client.getWindow().getScaledWidth();
        int j = this.client.getWindow().getScaledHeight();
        long k = Util.getMeasuringTimeMs();
        if (this.reloading && this.reloadStartTime == -1L) {
            this.reloadStartTime = k;
        }

        float f = this.reloadCompleteTime > -1L
            ? (float) (k - this.reloadCompleteTime) / 1000.0F
            : -1.0F;
        float f1 = this.reloadStartTime > -1L
            ? (float) (k - this.reloadStartTime) / 500.0F
            : -1.0F;
        float f2;
        int l1;
        GlStateManager._clearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager._clear(GL31.GL_COLOR_BUFFER_BIT, false);
        if (f >= 1.0F) {
            if (this.client.currentScreen != null) {
                this.client.currentScreen.render(matrices, 0, 0, delta);
            }

            l1 = MathHelper.ceil(
                (1.0F - MathHelper.clamp(f - 1.0F, 0.0F, 1.0F)) * 255.0F
            );
            //fill(matrices, 0, 0, i, j, withAlpha(BRAND_ARGB.getAsInt(), l1));
            f2 = 1.0F - MathHelper.clamp(f - 1.0F, 0.0F, 1.0F);
        } else if (this.reloading) {
            if (this.client.currentScreen != null && f1 < 1.0F) {
                this.client.currentScreen.render(matrices, mouseX, mouseY, delta);
            }

            l1 = MathHelper.ceil(MathHelper.clamp((double) f1, 0.15D, 1.0D) * 255.0D);
            //fill(matrices, 0, 0, i, j, withAlpha(BRAND_ARGB.getAsInt(), l1));
            f2 = MathHelper.clamp(f1, 0.0F, 1.0F);
        } else {
            f2 = 1.0F;
        }
        //RenderSystem.enableBlend();
        //RenderSystem.blendEquation(32774);
        //RenderSystem.blendFunc(770, 1);
        RenderSystem.setShader(() -> Ntx4CoreShaders.SPLASH);
        Ntx4CoreShaders.SPLASH.getUniform("Time").set(this.time / 20.0f);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, f2);
        BufferBuilder buf = Tessellator.getInstance().getBuffer();
        buf.begin(DrawMode.QUADS, VertexFormats.POSITION);
        buf.vertex(-1.0, -1.0, 0.0).next();
        buf.vertex(1.0, -1.0, 0.0).next();
        buf.vertex(1.0, 1.0, 0.0).next();
        buf.vertex(-1.0, 1.0, 0.0).next();
        buf.end();
        BufferRenderer.draw(buf);

        l1 = (int) ((double) this.client.getWindow().getScaledWidth() * 0.5D);
        int k2 = (int) ((double) this.client.getWindow().getScaledHeight() * 0.5D);
        double d1 = Math.min(
                        (double) this.client.getWindow().getScaledWidth() * 0.75D,
                        (double) this.client.getWindow().getScaledHeight()
                    )
            * 0.25D;
        int i1 = (int) (d1 * 0.5D);
        double d0 = d1 * 6.0D;
        int j1 = (int) (d0 * 0.5D);
        RenderSystem.setShaderTexture(0, LOGO);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, f2);
        int texWidth = 642;
        int texHeight = 254;
        drawTexture(
            matrices,
            l1 - j1 / 2,
            k2 - i1,
            j1,
            (int) d1,
            0.0F,
            0.0F,
            texWidth,
            texHeight,
            texWidth,
            texHeight
        );
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
        int k1 = (int) ((double) this.client.getWindow().getScaledHeight() * 0.8325D);
        float f6 = this.reload.getProgress();
        this.progress
            = MathHelper.clamp(this.progress * 0.95F + f6 * 0.050000012F, 0.0F, 1.0F);
        ClientModLoader.renderProgressText();
        if (f < 1.0F) {
            this.renderProgressBar(
                matrices,
                i / 2 - j1,
                k1 - 5,
                i / 2 + j1,
                k1 + 5,
                1.0F - MathHelper.clamp(f, 0.0F, 1.0F)
            );
        }

        if (f >= 2.0F) {
            this.client.setOverlay((Overlay) null);
        }

        if (this.reloadCompleteTime == -1L && this.reload.isComplete()
            && (!this.reloading || f1 >= 2.0F)) {
            this.reloadCompleteTime = Util.getMeasuringTimeMs();

            try {
                this.reload.throwException();
                this.exceptionHandler.accept(Optional.empty());
            } catch (Throwable var23) {
                this.exceptionHandler.accept(Optional.of(var23));
            }

            if (this.client.currentScreen != null) {
                this.client.currentScreen.init(
                    this.client,
                    this.client.getWindow().getScaledWidth(),
                    this.client.getWindow().getScaledHeight()
                );
            }
        }
    }

    private void renderProgressBar(
        MatrixStack matrices, int minX, int minY, int maxX, int maxY, float opacity
    ) {
        int i = MathHelper.ceil((float) (maxX - minX - 2) * this.progress);
        int j = Math.round(opacity * 255.0F);
        int k = Argb.getArgb(j, 116, 119, 236);
        fill(matrices, minX + 2, minY + 2, minX + i, maxY - 2, Argb.getArgb(j, 203, 166, 247));
        fill(matrices, minX + 1, minY, maxX - 1, minY + 1, k);
        fill(matrices, minX + 1, maxY, maxX - 1, maxY - 1, k);
        fill(matrices, minX, minY, minX + 1, maxY, k);
        fill(matrices, maxX, minY, maxX - 1, maxY, k);
    }
}
