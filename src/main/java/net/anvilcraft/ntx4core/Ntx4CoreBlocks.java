package net.anvilcraft.ntx4core;

import net.anvilcraft.ntx4core.blocks.BlockAlecubus;
import net.minecraft.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Ntx4CoreBlocks {
    public static final DeferredRegister<Block> BLOCKS
        = DeferredRegister.create(ForgeRegistries.BLOCKS, Ntx4Core.MODID);

    public static final RegistryObject<Block> ALECUBUS
        = BLOCKS.register("alecubus", BlockAlecubus::new);
}
