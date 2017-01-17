package org.icannt.materialfoundation.common.integration.jei.recipe.paint.shaped;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IStackHelper;
import mezz.jei.api.recipe.wrapper.IShapedCraftingRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.ItemMetalTinPaint;
import org.icannt.materialfoundation.common.item.variant.EnumPaintType;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Liam on 17/1/17.
 */
public class ShapedPaintRecipeWrapper implements IShapedCraftingRecipeWrapper {

    private IJeiHelpers helper;
    private List inputs;
    private EnumPaintType paint;
    private ItemStack output;

    public ShapedPaintRecipeWrapper(IJeiHelpers helper, List inputs, EnumPaintType paint, ItemStack output) {
        this.helper = helper;
        this.inputs = inputs;
        this.paint = paint;
        this.output = output;
    }


    @Override
    public void getIngredients(IIngredients ingredients) {
        IStackHelper stackHelper = helper.getStackHelper();

        List<List<ItemStack>> input = stackHelper.expandRecipeItemStackInputs(this.inputs);
        for (List<ItemStack> inner : input) {
            for (int i = 0; i < inner.size(); i++) {
                if (inner.get(i).getItem() == ModItems.TIN_METAL_PAINT)
                    inner.set(i, ItemMetalTinPaint.create(this.paint));
            }
        }


        ingredients.setInputLists(ItemStack.class, input);
        ingredients.setOutputs(ItemStack.class, this.getOutputs());
    }

    @Override
    public List getInputs() {
        return inputs;
    }

    @Override
    public List getOutputs() {
        return Collections.singletonList(output);
    }

    @Override
    public List<FluidStack> getFluidInputs() {
        return null;
    }

    @Override
    public List<FluidStack> getFluidOutputs() {
        return null;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {

    }

    @Override
    public void drawAnimations(Minecraft minecraft, int recipeWidth, int recipeHeight) {

    }

    @Nullable
    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY) {
        return null;
    }

    @Override
    public boolean handleClick(Minecraft minecraft, int mouseX, int mouseY, int mouseButton) {
        return false;
    }

    @Override
    public int getWidth() {
        return 3;
    }

    @Override
    public int getHeight() {
        return 3;
    }
}