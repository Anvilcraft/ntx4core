package net.anvilcraft.ntx4core;

import net.anvilcraft.ntx4core.items.ItemManual;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Ntx4CoreItems {
    public static final DeferredRegister<Item> ITEMS
        = DeferredRegister.create(ForgeRegistries.ITEMS, Ntx4Core.MODID);

    public static final RegistryObject<Item> ALEC = ITEMS.register(
        "alecubus",
        ()
            -> new BlockItem(
                Ntx4CoreBlocks.ALECUBUS.get(),
                new Item.Settings().group(Ntx4CoreItemGroup.INSTANCE)
            )
    );

    public static final RegistryObject<Item> COMPUTATIONAL_CORE
        = registerCraftingIngredient("computational_core");

    public static final RegistryObject<Item> ENERGY_INFUSED_CORE
        = registerCraftingIngredient("energy_infused_core");

    public static final RegistryObject<Item> MAGICAL_CORE
        = registerCraftingIngredient("magical_core");

    public static final RegistryObject<Item> SENTIENT_SINGULARITY
        = registerCraftingIngredient("sentient_singularity");

    public static final RegistryObject<Item> STABILIZED_SENTIENCE
        = registerCraftingIngredient("stabilized_sentience");

    public static final RegistryObject<Item> MAGICALLY_STABILIZED_SENTIENCE
        = registerCraftingIngredient("magically_stabilized_sentience");

    public static final RegistryObject<Item> IRRADIATED_ESSENCE
        = registerCraftingIngredient("irradiated_essence");

    public static final RegistryObject<Item> CORRUPTED_ESSENCE
        = registerCraftingIngredient("corrupted_essence");

    public static final RegistryObject<Item> STRANGE_CONSTRUCT
        = registerCraftingIngredient("strange_construct");

    public static final RegistryObject<Item> AWAKENED_CONSTRUCT
        = registerCraftingIngredient("awakened_construct");

    public static final RegistryObject<Item> CHAOTIC_CONSTRUCT
        = registerCraftingIngredient("chaotic_construct");

    public static final RegistryObject<Item> MANUAL
        = ITEMS.register("manual", () -> new ItemManual());

    private static RegistryObject<Item> registerCraftingIngredient(String id) {
        return ITEMS.register(
            id, () -> new Item(new Item.Settings().group(Ntx4CoreItemGroup.INSTANCE))
        );
    }
}
