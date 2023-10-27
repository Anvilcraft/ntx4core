package net.anvilcraft.ntx4core.cosmetics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class CosmeticsManager {
    
    private static List<ICosmeticProvider> providers = new ArrayList<>();
    private static Map<UUID, List<ICosmetic>> cosmeticCache = new HashMap<>();
    private static Set<UUID> activePlayers = new HashSet<>();

    private static void refresh() {
        boolean doRefresh = false;
        for (ICosmeticProvider provider : providers) {
            doRefresh = doRefresh || provider.requestsRefresh();
        }
        if (!doRefresh) return;
        cosmeticCache.clear();
        for (UUID uuid : activePlayers) {
            loadPlayer(uuid);
        }
    }

    private static void loadPlayer(UUID player) {
        if (cosmeticCache.containsKey(player)) return;
        cosmeticCache.put(player, new ArrayList<>());
        List<ICosmetic> cosmetics = cosmeticCache.get(player);
        for (ICosmeticProvider provider : providers) {
            provider.addCosmetics(player, (cosmetic) -> cosmetics.add(cosmetic));
        }
    }

    public static void registerProvider(ICosmeticProvider provider) {
        providers.add(provider);
    }

    protected static List<ICosmetic> getCosmeticsForPlayer(UUID uuid) {
        if (!activePlayers.contains(uuid)) {
            activePlayers.add(uuid);
            loadPlayer(uuid);
        }
        refresh();
        return cosmeticCache.get(uuid);
    }

}