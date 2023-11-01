package net.anvilcraft.ntx4core.cosmetics;

import net.anvilcraft.anvillib.cosmetics.ICosmetic;
import net.minecraft.util.Identifier;

public class AlecCosmetic implements ICosmetic {
    @Override
    public Identifier getAnimationFileLocation() {
        return new Identifier("ntx4core", "animations/alec.json");
    }

    @Override
    public Identifier getModelLocation() {
        return new Identifier("ntx4core", "geo/alec.json");
    }

    @Override
    public Identifier getTextureLocation() {
        return new Identifier("ntx4core", "textures/alec.png");
    }

    @Override
    public Identifier getID() {
        return new Identifier("ntx4core", "alec");
    }

    @Override
    public String getIdleAnimationName() {
        return "animation.alec.idle";
    }
}