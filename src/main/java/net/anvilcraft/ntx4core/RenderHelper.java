package net.anvilcraft.ntx4core;

import com.mojang.blaze3d.platform.GlDebugInfo;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.math.Vec3f;

public class RenderHelper {
    private static final Identifier ALEC = Ntx4Core.id("textures/alec.png");

    public static float shaderTime = 0f;

    public static void renderSplashScreen(float alpha) {
        // This shader is somehow borked on Intel. Not My fault!
        if (!GlDebugInfo.getVendor().equals("Intel")) {
            RenderSystem.setShader(() -> Ntx4CoreShaders.SPLASH);
            Ntx4CoreShaders.SPLASH.getUniform("Time").set(shaderTime / 20.0f);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, alpha);
            BufferBuilder buf = Tessellator.getInstance().getBuffer();
            buf.begin(DrawMode.QUADS, VertexFormats.POSITION);
            buf.vertex(-1.0, -1.0, 0.0).next();
            buf.vertex(1.0, -1.0, 0.0).next();
            buf.vertex(1.0, 1.0, 0.0).next();
            buf.vertex(-1.0, 1.0, 0.0).next();
            buf.end();
            BufferRenderer.draw(buf);

            if (AlecManager.HAS_ALEC) {
                float offset_x = (float) Math.sin(shaderTime / 25.);
                float offset_y = (float) Math.cos(shaderTime / 25.);

                var mtx = Matrix4f.viewboxMatrix(45., 1.f, 0.1f, 100.f);
                mtx.multiply(Matrix4f.translate(offset_x, offset_y, -5.f));
                mtx.multiply(Vec3f.NEGATIVE_Y.getDegreesQuaternion(shaderTime * 4.f));
                // clang-format off
                mtx.multiply(new Matrix4f(new float[]{
                    1.f, 0.f, 0.f, 0.f,
                    0.f, -1.f, 0.f, 0.f,
                    0.f, 0.f, 1.f, 0.f,
                    0.f, 0.f, 0.f, 1.f,
                }));
                // clang-format on

                RenderSystem.setShader(() -> Ntx4CoreShaders.ALECUBUS);
                RenderSystem.setShaderTexture(0, ALEC);
                Ntx4CoreShaders.ALECUBUS.getUniform("Mtx").set(mtx);

                buf.begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);

                alecVert(buf, -0.5, -0.5, -0.5, 1.0, 0.0);
                alecVert(buf, 0.5, -0.5, -0.5, 0.0, 0.0);
                alecVert(buf, 0.5, 0.5, -0.5, 0.0, 1.0);
                alecVert(buf, -0.5, 0.5, -0.5, 1.0, 1.0);

                alecVert(buf, -0.5, -0.5, 0.5, 0.0, 0.0);
                alecVert(buf, 0.5, -0.5, 0.5, 1.0, 0.0);
                alecVert(buf, 0.5, 0.5, 0.5, 1.0, 1.0);
                alecVert(buf, -0.5, 0.5, 0.5, 0.0, 1.0);

                alecVert(buf, -0.5, 0.5, 0.5, 1.0, 1.0);
                alecVert(buf, -0.5, 0.5, -0.5, 0.0, 1.0);
                alecVert(buf, -0.5, -0.5, -0.5, 0.0, 0.0);
                alecVert(buf, -0.5, -0.5, 0.5, 1.0, 0.0);

                alecVert(buf, 0.5, 0.5, 0.5, 0.0, 1.0);
                alecVert(buf, 0.5, 0.5, -0.5, 1.0, 1.0);
                alecVert(buf, 0.5, -0.5, -0.5, 1.0, 0.0);
                alecVert(buf, 0.5, -0.5, 0.5, 0.0, 0.0);

                alecVert(buf, -0.5, -0.5, -0.5, 0.0, 1.0);
                alecVert(buf, 0.5, -0.5, -0.5, 1.0, 1.0);
                alecVert(buf, 0.5, -0.5, 0.5, 1.0, 0.0);
                alecVert(buf, -0.5, -0.5, 0.5, 0.0, 0.0);

                alecVert(buf, -0.5, 0.5, -0.5, 0.0, 1.0);
                alecVert(buf, 0.5, 0.5, -0.5, 1.0, 1.0);
                alecVert(buf, 0.5, 0.5, 0.5, 1.0, 0.0);
                alecVert(buf, -0.5, 0.5, 0.5, 0.0, 0.0);

                buf.end();

                GlStateManager._enableDepthTest();
                GlStateManager._disableCull();
                BufferRenderer.draw(buf);
                GlStateManager._disableDepthTest();
                GlStateManager._enableCull();
            }
        } else {
            int width = MinecraftClient.getInstance().getWindow().getScaledWidth();
            int height = MinecraftClient.getInstance().getWindow().getScaledHeight();

            var bgTexture = AlecManager.HAS_ALEC
                ? ALEC
                : new Identifier("textures/gui/options_background.png");

            Tessellator tesselator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tesselator.getBuffer();
            RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
            RenderSystem.setShaderTexture(0, bgTexture);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            bufferbuilder.begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
            bufferbuilder.vertex(0.0D, (double) height, 0.0D)
                .texture(0.0F, (float) height / 32.0F)
                .color(64, 64, 64, 255)
                .next();
            bufferbuilder.vertex((double) width, (double) height, 0.0D)
                .texture((float) width / 32.0F, (float) height / 32.0F)
                .color(64, 64, 64, 255)
                .next();
            bufferbuilder.vertex((double) width, 0.0D, 0.0D)
                .texture((float) width / 32.0F, 0f)
                .color(64, 64, 64, 255)
                .next();
            bufferbuilder.vertex(0.0D, 0.0D, 0.0D)
                .texture(0.0F, 0f)
                .color(64, 64, 64, 255)
                .next();
            tesselator.draw();
        }
    }

    private static void
    alecVert(BufferBuilder buf, double x, double y, double z, double u, double v) {
        buf.vertex((float) x, (float) y, (float) z).texture((float) u, (float) v).next();
    }
}
