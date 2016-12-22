package org.icannt.materialfoundation.common.item;

import net.minecraft.item.Item;
import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.creativetab.TabMaterialFoundation;

/**
 * Created by Liam on 22/12/16.
 */
public class ItemBurntLime extends Item {

    public ItemBurntLime() {
        setRegistryName(MaterialFoundation.MOD_ID, "burnt_lime");
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(TabMaterialFoundation.MATERIAL_FOUNDATION_TAB);
        setMaxStackSize(64);
    }
}
