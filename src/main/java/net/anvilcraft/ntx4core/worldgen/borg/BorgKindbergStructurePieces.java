package net.anvilcraft.ntx4core.worldgen.borg;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import net.anvilcraft.ntx4core.Ntx4Core;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryEntry;

public class BorgKindbergStructurePieces {
    public static final RegistryEntry<StructurePool> START
        = StructurePools.register(new StructurePool(
            Ntx4Core.id("borg/start_pool"),
            new Identifier("empty"),
            ImmutableList.of(
                Pair.of(StructurePoolElement.ofSingle("ntx4core:borg_start"), 1)
            ),
            StructurePool.Projection.RIGID
        ));
}
