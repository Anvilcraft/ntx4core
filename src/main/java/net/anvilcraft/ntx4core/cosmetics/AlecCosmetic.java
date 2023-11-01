package net.anvilcraft.ntx4core.cosmetics;

import net.anvilcraft.anvillib.cosmetics.ICosmetic;
import net.anvilcraft.ntx4core.Ntx4Core;
import net.minecraft.util.Identifier;

public class AlecCosmetic implements ICosmetic {
    @Override
    public Identifier getAnimationFileLocation() {
        return Ntx4Core.id("animations/alec.json");
    }

    @Override
    public Identifier getModelLocation() {
        return Ntx4Core.id("geo/alec.json");
    }

    @Override
    public Identifier getTextureLocation() {
        return Ntx4Core.id("textures/alec.png");
    }

    @Override
    public Identifier getID() {
        return Ntx4Core.id("alec");
    }

    @Override
    public String getIdleAnimationName() {
        return "animation.alec.idle";
    }
}
