package net.anvilcraft.ntx4core;

import java.util.function.Function;

import org.apache.commons.lang3.function.TriFunction;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber(modid = Ntx4Core.MODID, bus = Bus.FORGE)
public class StartItems {
    public static final String LOGGED_IN_KEY = Ntx4Core.MODID + ":has_logged_in";

    @SubscribeEvent
    public static void onPlayerLogIn(PlayerEvent.PlayerLoggedInEvent ev) {
        var data = ev.getEntity().getPersistentData().getCompound(
            PlayerEntity.PERSISTED_NBT_TAG
        );

        if (data != null && !data.getBoolean(LOGGED_IN_KEY)) {
            data.putBoolean(LOGGED_IN_KEY, true);

            if (FMLEnvironment.production)
                giveStartingItemsTo(ev.getPlayer());
        }
    }

    public static void giveStartingItemsTo(PlayerEntity pl) {
        // Apples
        {
            var stack = new ItemStack(Items.APPLE, 16);
            stack.setCustomName(new LiteralText("Manufacturer of Inferior Devices"));
            ItemHandlerHelper.giveItemToPlayer(pl, stack);
        }

        // Akashic Tome
        {
            var tag = new NbtCompound();
            var dataTag = new NbtCompound();
            tag.put("akashictome:data", dataTag);

            TriFunction<String, String, NbtCompound, Void> add = (mod, id, btag) -> {
                var bookData = new NbtCompound();
                dataTag.put(mod, bookData);

                bookData.putString("id", id);
                bookData.putByte("Count", (byte) 1);

                if (btag != null) {
                    bookData.put("tag", btag);
                }

                return null;
            };

            Function<String, NbtCompound> patchouliTag = bookId -> {
                var ptag = new NbtCompound();
                ptag.putString("patchouli:book", bookId);
                return ptag;
            };

            // clang-format off
            add.apply("alchemistry", "patchouli:guide_book", patchouliTag.apply("alchemistry:alchemistry_book"));
            add.apply("alexsmobs", "alexsmobs:animal_dictionary", null);
            add.apply("apotheosis", "patchouli:guide_book", patchouliTag.apply("apotheosis:apoth_chronicle"));
            add.apply("ars_nouveau", "ars_nouveau:worn_notebook", null);
            add.apply("assemblylinemachines", "patchouli:guide_book", patchouliTag.apply("assemblylinemachines:assembly_lines_and_you"));
            add.apply("bloodmagic", "patchouli:guide_book", patchouliTag.apply("bloodmagic:guide_book"));
            add.apply("byg", "byg:biomepedia", null);
            add.apply("dmlreforged", "patchouli:guide_book", patchouliTag.apply("dmlreforged:book"));
            add.apply("electrodynamics", "electrodynamics:guidebook", null);
            add.apply("essentials", "essentials:guide_book", patchouliTag.apply("essentials:manual"));
            add.apply("exoticbirds", "exoticbirds:bird_book", null);
            add.apply("ftbic", "patchouli:guide_book", patchouliTag.apply("ftbic:ftbic_guide"));
            add.apply("hexcasting", "patchouli:guide_book", patchouliTag.apply("hexcasting:thehexbook"));
            add.apply("hexerei", "hexerei:book_of_shadows", null);
            add.apply("industrialforegoing", "patchouli:guide_book", patchouliTag.apply("industrialforegoing:industrial_foregoing"));
            add.apply("industrialrenewal", "patchouli:guide_book", patchouliTag.apply("industrialrenewal:ir_manual"));
            add.apply("integrateddynamics", "integrateddynamics:on_the_dynamics_of_integration", null);
            add.apply("laserio", "patchouli:guide_book", patchouliTag.apply("laserio:laseriobook"));
            add.apply("modularrouters", "patchouli:guide_book", patchouliTag.apply("modularrouters:book"));
            add.apply("pneumaticcraft", "patchouli:guide_book", patchouliTag.apply("pneumaticcraft:book"));
            add.apply("psi", "patchouli:guide_book", patchouliTag.apply("psi:encyclopaedia_psionica"));
            add.apply("rftoolsbase", "rftoolsbase:manual", null);
            add.apply("tconstruct", "tconstruct:materials_and_you", null);
            add.apply("thermal", "patchouli:guide_book", patchouliTag.apply("thermal:guidebook"));
            // clang-format on

            var stack = new ItemStack(
                ForgeRegistries.ITEMS.getValue(new Identifier("akashictome", "tome")), 1
            );
            stack.setNbt(tag);
            ItemHandlerHelper.giveItemToPlayer(pl, stack);
        }
    }
}
