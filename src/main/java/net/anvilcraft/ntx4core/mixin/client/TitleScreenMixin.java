package net.anvilcraft.ntx4core.mixin.client;

import java.util.Objects;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;

import net.anvilcraft.ntx4core.Ntx4Core;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.RotatingCubeMapRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.internal.BrandingControl;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
    @Shadow
    @Final
    public static Text COPYRIGHT
        // Mojang, FUCK YOU!
        = new LiteralText("Copyleft Anvilcraft. Licensed under AGPL-3.0+ALEC");

    @Unique
    private static final Identifier TITLE_TEXTURE
        = new Identifier(Ntx4Core.MODID, "textures/gui/title/notex4.png");

    @Shadow
    @Final
    private static Identifier PANORAMA_OVERLAY;

    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Shadow
    private String splashText;

    @Shadow
    private boolean doBackgroundFade;

    @Shadow
    private long backgroundFadeStart;

    @Shadow
    @Final
    private RotatingCubeMapRenderer backgroundRenderer;

    /**
     * @reason Custom title screen
     * @author LordMZTE
     */
    @Overwrite
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        int textureWidth = 414;
        int textureHeight = 73;
        if (this.backgroundFadeStart == 0L && this.doBackgroundFade) {
            this.backgroundFadeStart = Util.getMeasuringTimeMs();
        }

        float f = this.doBackgroundFade
            ? (float) (Util.getMeasuringTimeMs() - this.backgroundFadeStart) / 1000.0F
            : 1.0F;
        this.backgroundRenderer.render(delta, MathHelper.clamp(f, 0.0F, 1.0F));
        int j = this.width / 2 - textureWidth / 4;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, PANORAMA_OVERLAY);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE_MINUS_SRC_ALPHA);
        RenderSystem.setShaderColor(
            1.0F,
            1.0F,
            1.0F,
            this.doBackgroundFade
                ? (float) MathHelper.ceil(MathHelper.clamp(f, 0.0F, 1.0F))
                : 1.0F
        );
        drawTexture(
            matrices, 0, 0, this.width, this.height, 0.0F, 0.0F, 16, 128, 16, 128
        );
        float f1 = this.doBackgroundFade ? MathHelper.clamp(f - 1.0F, 0.0F, 1.0F) : 1.0F;
        int l = MathHelper.ceil(f1 * 255.0F) << 24;
        if ((l & -67108864) != 0) {
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderTexture(0, TITLE_TEXTURE);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, f1);
            drawTexture(
                matrices,
                j,
                30,
                textureWidth / 2,
                textureHeight / 2,
                0,
                0,
                textureWidth,
                textureHeight,
                textureWidth,
                textureHeight
            );

            ForgeHooksClient.renderMainMenu(
                (TitleScreen) (Screen) this,
                matrices,
                this.textRenderer,
                this.width,
                this.height,
                l
            );
            if (this.splashText != null) {
                matrices.push();
                matrices.translate((double) (this.width / 2 + 90), 70.0D, 0.0D);
                matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(-20.0F));
                float f2 = 1.8F
                    - MathHelper.abs(
                        MathHelper.sin(
                            (float) (Util.getMeasuringTimeMs() % 1000L) / 1000.0F
                            * 6.2831855F
                        )
                        * 0.1F
                    );
                f2 = f2 * 100.0F
                    / (float) (this.textRenderer.getWidth(this.splashText) + 32);
                matrices.scale(f2, f2, f2);
                drawCenteredText(
                    matrices, this.textRenderer, this.splashText, 0, -8, 16776960 | l
                );
                matrices.pop();
            }

            BrandingControl.forEachLine(true, true, (brdline, brd) -> {
                TextRenderer var10001 = this.textRenderer;
                int var10004 = this.height;
                int var10006 = brdline;
                Objects.requireNonNull(this.textRenderer);
                drawStringWithShadow(
                    matrices,
                    var10001,
                    brd,
                    2,
                    var10004 - (10 + var10006 * (9 + 1)),
                    16777215 | l
                );
            });
            BrandingControl.forEachAboveCopyrightLine((brdline, brd) -> {
                TextRenderer var10001 = this.textRenderer;
                int var10003 = this.width - this.textRenderer.getWidth(brd);
                int var10004 = this.height;
                int var10006 = brdline + 1;
                Objects.requireNonNull(this.textRenderer);
                drawStringWithShadow(
                    matrices,
                    var10001,
                    brd,
                    var10003,
                    var10004 - (10 + var10006 * (9 + 1)),
                    16777215 | l
                );
            });

            for (Element guieventlistener : this.children()) {
                if (guieventlistener instanceof ClickableWidget) {
                    ((ClickableWidget) guieventlistener).setAlpha(f1);
                }
            }

            super.render(matrices, mouseX, mouseY, delta);
        }
    }
}
