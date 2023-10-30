package net.anvilcraft.ntx4core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class BlockAlecubus extends Block {
    public BlockAlecubus() {
        super(Settings.of(Material.STONE, MapColor.BRIGHT_RED)
                  .requiresTool()
                  .strength(2.f, 6.f)
                  .resistance(99999999.f));
    }

    @Override
    public boolean
    canEntityDestroy(BlockState state, BlockView level, BlockPos pos, Entity entity) {
        return entity instanceof PlayerEntity;
    }

    @Override
    public void
    onBlockExploded(BlockState state, World level, BlockPos pos, Explosion explosion) {}
}
