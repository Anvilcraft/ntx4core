package net.anvilcraft.ntx4core.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.anvilcraft.ntx4core.RenderHelper;
import net.minecraft.client.gui.screen.Screen;

@Mixin(Screen.class)
public class ScreenMixin {
    /**
     * @reason Fancy background.
     * @author LordMZTE
     */
    @Overwrite
    public void renderBackgroundTexture(int vOffset) {
        RenderHelper.renderSplashScreen(1.0f);
    }
}
