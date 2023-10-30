package net.anvilcraft.ntx4core;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Ntx4CoreItemGroup extends ItemGroup {
    public static final Ntx4CoreItemGroup INSTANCE = new Ntx4CoreItemGroup();

    private Ntx4CoreItemGroup() {
        super("ntx4core");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Ntx4CoreBlocks.ALECUBUS.get());
    }
}
