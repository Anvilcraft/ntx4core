package net.anvilcraft.ntx4core;

import java.io.IOException;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Shader;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;

public class Ntx4CoreShaders {
    public static Shader SPLASH;

    // This method is called from SplashOverlayMixin as Forge has no fitting event that
    // fires early enough (and not too early).
    public static void registerShaders() {
        Ntx4Core.LOGGER.info("Registering Shaders");

        try {
            SPLASH = new Shader(
                MinecraftClient.getInstance().getResourceManager(),
                new Identifier(Ntx4Core.MODID, "splash"),
                VertexFormats.POSITION
            );
        } catch (IOException e) {
            Ntx4Core.LOGGER.error("Error registering shaders", e);
            throw new RuntimeException(e);
        }
    }
}
