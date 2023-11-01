package net.anvilcraft.ntx4core.cosmetics;

import java.util.Arrays;
import java.util.UUID;
import java.util.function.Consumer;

import net.anvilcraft.anvillib.cosmetics.ICosmetic;
import net.anvilcraft.anvillib.cosmetics.ICosmeticProvider;

public class StaticCosmeticProvider implements ICosmeticProvider {
    final static UUID[] HAS_ALEC
        = new UUID[] { UUID.fromString("380df991-f603-344c-a090-369bad2a924a"),
                       UUID.fromString("81f895e1-33ca-46ec-b1b6-124ba832a352") };
    final static ICosmetic ALEC = new AlecCosmetic();

    @Override
    public boolean requestsRefresh() {
        return false;
    }

    @Override
    public void addCosmetics(UUID player, Consumer<ICosmetic> cosmeticAdder) {
        if (Arrays.stream(HAS_ALEC).anyMatch(u -> u.equals(player))) {
            cosmeticAdder.accept(ALEC);
        }
    }
}
