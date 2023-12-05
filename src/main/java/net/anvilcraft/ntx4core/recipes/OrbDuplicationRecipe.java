package net.anvilcraft.ntx4core.recipes;

import net.minecraftforge.common.crafting.IShapedRecipe;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class OrbDuplicationRecipe
    extends SpecialCraftingRecipe implements IShapedRecipe<CraftingInventory> {
    @ObjectHolder("ntx4core:orb_duplication")
    public static SpecialRecipeSerializer<OrbDuplicationRecipe> SERIALIZER;

    private Item flux
        = ForgeRegistries.ITEMS.getValue(new Identifier("fluxnetworks", "flux_dust"));
    private Item nitro
        = ForgeRegistries.ITEMS.getValue(new Identifier("powah", "crystal_nitro"));
    private Item orb
        = ForgeRegistries.ITEMS.getValue(new Identifier("enderrift", "rift_orb"));
    private DefaultedList<Ingredient> ingredients = DefaultedList.copyOf(
        Ingredient.EMPTY,
        Ingredient.ofItems(this.flux),
        Ingredient.ofItems(this.nitro),
        Ingredient.ofItems(this.flux),
        Ingredient.ofItems(this.nitro),
        Ingredient.ofItems(this.orb),
        Ingredient.ofItems(this.nitro),
        Ingredient.ofItems(this.flux),
        Ingredient.ofItems(this.nitro),
        Ingredient.ofItems(this.flux)
    );
    private ItemStack output = new ItemStack(this.orb, 2);

    public OrbDuplicationRecipe(Identifier recipeId) {
        super(recipeId);
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public boolean matches(CraftingInventory crafting, World worldIn) {
        if (crafting.size() < 9)
            return false;

        ItemStack stack = crafting.getStack(4);
        if (stack.getCount() <= 0)
            return false;

        if (stack.getItem() != this.orb)
            return false;

        NbtCompound tag = stack.getNbt();
        if (tag == null || !tag.contains("RiftId"))
            return false;

        if (!slotHasItem(crafting, 0, this.flux))
            return false;

        if (!slotHasItem(crafting, 1, this.nitro))
            return false;

        if (!slotHasItem(crafting, 2, this.flux))
            return false;

        if (!slotHasItem(crafting, 3, this.nitro))
            return false;

        if (!slotHasItem(crafting, 5, this.nitro))
            return false;

        if (!slotHasItem(crafting, 6, this.flux))
            return false;

        if (!slotHasItem(crafting, 7, this.nitro))
            return false;

        if (!slotHasItem(crafting, 8, this.flux))
            return false;

        return true;
    }

    private boolean slotHasItem(CraftingInventory crafting, int slot, Item item) {
        ItemStack stack = crafting.getStack(slot);
        return stack.getItem() == item;
    }

    @Override
    public ItemStack craft(CraftingInventory crafting) {
        ItemStack stack = crafting.getStack(4).copy();
        stack.setCount(2);
        return stack;
    }

    @Override
    public boolean fits(int width, int height) {
        return (width == 3) && (height == 3);
    }

    @Override
    public ItemStack getOutput() {
        return output;
    }

    @Override
    public DefaultedList<ItemStack> getRemainder(CraftingInventory inv) {
        return DefaultedList.ofSize(inv.size(), ItemStack.EMPTY);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public int getRecipeWidth() {
        return 3;
    }

    @Override
    public int getRecipeHeight() {
        return 3;
    }
}
