package net.anvilcraft.ntx4core.cosmetics;

import java.util.Arrays;
import java.util.UUID;
import java.util.function.Consumer;

import net.anvilcraft.anvillib.cosmetics.ICosmetic;
import net.anvilcraft.anvillib.cosmetics.ICosmeticProvider;
import net.anvilcraft.ntx4core.AlecManager;

public class StaticCosmeticProvider implements ICosmeticProvider {
    final static ICosmetic ALEC = new AlecCosmetic();

    @Override
    public boolean requestsRefresh() {
        return false;
    }

    @Override
    public void addCosmetics(UUID player, Consumer<ICosmetic> cosmeticAdder) {
        if (Arrays.stream(AlecManager.ALECUBUS_UUIDS).anyMatch(u -> u.equals(player))) {
            cosmeticAdder.accept(ALEC);
        }
    }
}
