package net.anvilcraft.ntx4core;

import java.io.IOException;

import com.mojang.blaze3d.platform.GlDebugInfo;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Shader;
import net.minecraft.client.render.VertexFormats;

public class Ntx4CoreShaders {
    public static Shader SPLASH;
    public static Shader ALECUBUS;

    // This method is called from SplashOverlayMixin as Forge has no fitting event that
    // fires early enough (and not too early).
    public static void registerShaders() {
        // This shader is somehow borked on Intel. Not My fault!
        if (GlDebugInfo.getVendor().equals("Intel"))
            return;
        Ntx4Core.LOGGER.info("Registering Shaders");

        try {
            SPLASH = new Shader(
                MinecraftClient.getInstance().getResourceManager(),
                Ntx4Core.id("splash"),
                VertexFormats.POSITION
            );
            ALECUBUS = new Shader(
                MinecraftClient.getInstance().getResourceManager(),
                Ntx4Core.id("alecubus"),
                VertexFormats.POSITION_TEXTURE
            );
        } catch (IOException e) {
            Ntx4Core.LOGGER.error("Error registering shaders", e);
            throw new RuntimeException(e);
        }
    }
}
