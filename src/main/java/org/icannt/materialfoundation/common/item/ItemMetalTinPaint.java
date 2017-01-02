package org.icannt.materialfoundation.common.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.text.WordUtils;
import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.creativetab.TabMaterialFoundation;
import org.icannt.materialfoundation.common.init.ModItems;
import org.icannt.materialfoundation.common.item.variant.EnumPaintType;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ICannt on 26/12/16.
 */
public class ItemMetalTinPaint extends Item {

    public ItemMetalTinPaint() {
        setRegistryName(MaterialFoundation.MOD_ID, "metal_tin_paint");
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(TabMaterialFoundation.MATERIAL_FOUNDATION_TAB);
        setMaxStackSize(1);
        setMaxDamage(80);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        String variant = "empty";

        if (stack.getTagCompound() != null) {
            if (stack.getTagCompound().hasKey("colour")) {
                variant = stack.getTagCompound().getString("colour");
            }
        }
        return super.getUnlocalizedName() + "." + variant;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(ItemMetalTinPaint.getVariant(stack).getLocalised());
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        for (EnumPaintType type : EnumPaintType.values()) {
            subItems.add(ItemMetalTinPaint.create(type));
        }
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        stack.attemptDamageItem(1, itemRand);
        return stack;
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    /**
     * Helper method for passing an ItemStack of ItemMetalTinPaint and returning the appropriate variant based on NBT
     * @param stack ItemStack of ItemMetalTinPaint
     * @return EnumPaintType Enum containing the variant
     */
    public static EnumPaintType getVariant(ItemStack stack) {
        if (!stack.getItem().equals(ModItems.TIN_METAL_PAINT))
            return EnumPaintType.EMPTY;

        EnumPaintType result = EnumPaintType.EMPTY;

        if (stack.getTagCompound() != null) {
            if (stack.getTagCompound().hasKey("colour")) {
                String colour = stack.getTagCompound().getString("colour");
                result = Arrays.stream(EnumPaintType.values()).filter(type -> type.getName().equals(colour)).findFirst().get();
            }
        }

        return result;
    }

    /**
     * Helper method for creating an ItemStack with the appropriate variant NBT tags
     * @param paint EnumPaintType The EnumPaintType variant to create
     * @return ItemStack of variant
     */
    public static ItemStack create(EnumPaintType paint) {
        ItemStack out = new ItemStack(ModItems.TIN_METAL_PAINT);
        NBTTagCompound tag = new NBTTagCompound();

        tag.setString("colour", paint.getName());
        out.setTagCompound(tag);
        return out;
    }
    
}
