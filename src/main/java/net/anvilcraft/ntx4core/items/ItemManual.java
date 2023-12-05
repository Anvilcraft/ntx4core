package net.anvilcraft.ntx4core.items;

import java.util.List;

import net.anvilcraft.ntx4core.AlecManager;
import net.anvilcraft.ntx4core.Ntx4Core;
import net.anvilcraft.ntx4core.Ntx4CoreItemGroup;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import vazkii.patchouli.api.PatchouliAPI;
import vazkii.patchouli.common.base.PatchouliSounds;

/**
 * A custom item for the Patchouli book.
 * This exists so we don't have to deal with pointless NBT data on normal Patchouli books.
 */
public class ItemManual extends Item {
    public static final Identifier BOOK_ID = Ntx4Core.id("manual");

    public ItemManual() {
        super(new Item.Settings().group(Ntx4CoreItemGroup.INSTANCE).maxCount(1));
    }

    @Override
    public void appendTooltip(
        ItemStack stack, World world, List<Text> tooltip, TooltipContext context
    ) {
        tooltip.add(new LiteralText("World domination in Notex 4!"));
        if (AlecManager.HAS_ALEC)
            tooltip.add(new LiteralText("Alec mich doch am Arsch!"));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        var stack = user.getStackInHand(hand);

        if (user instanceof ServerPlayerEntity serverPlayer) {
            PatchouliAPI.get().openBookGUI(serverPlayer, BOOK_ID);
            user.playSound(
                PatchouliSounds.BOOK_OPEN, 1.0F, (float) (0.7D + Math.random() * 0.4D)
            );
        }

        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, stack);
    }
}
