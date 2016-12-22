package org.icannt.materialfoundation.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.creativetab.TabMaterialFoundation;

/**
 * Created by Liam on 22/12/16.
 */
public class ItemFabricator extends Item {

    public ItemFabricator() {
        setRegistryName(MaterialFoundation.MOD_ID, "fabricator");
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(TabMaterialFoundation.MATERIAL_FOUNDATION_TAB);
        setMaxStackSize(1);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        return stack;
    }
}