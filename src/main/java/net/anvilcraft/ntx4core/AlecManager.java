package net.anvilcraft.ntx4core;

import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

import net.minecraft.client.MinecraftClient;

public class AlecManager {
    private static final String[] ALEC_UUIDS = new String[] {
        "81f895e133ca46ecb1b6124ba832a352", // The great ALEC himself
        "49d8001bcdd846b2b7860537f02f0f2f", // jonasled
        "67e46577adb84f23ae1517a355a9aa8c", // LordMZTE
        "ff1df9500c2c48489c90f0aa0b084c04", // Kalykto
        "70ab32ed30344c60b66890618a71c5a4", // Realtox
        "833d996af09b47a7b5dd5ddfd20e3f18", // ACGaming
        "d65372eff2f64c44aa204db9e480e0fe", // Merlinmo
        "be693d87cb634783a264075a7c6ab0f8", // tilera
    };

    public static final UUID[] ALECUBUS_UUIDS
        = new UUID[] { UUID.fromString("380df991-f603-344c-a090-369bad2a924a"),
                       UUID.fromString("81f895e1-33ca-46ec-b1b6-124ba832a352") };

    public static final boolean HAS_ALEC
        = Arrays.stream(ALEC_UUIDS)
              .anyMatch(
                  u
                  -> u.equals(
                      MinecraftClient.getInstance().getSession().getUuid().replace(
                          "-", ""
                      )
                  )
              )
        || new Random().nextInt(16) == 0;
}
