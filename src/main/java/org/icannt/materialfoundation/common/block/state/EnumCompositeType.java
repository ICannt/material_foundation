package org.icannt.materialfoundation.common.block.state;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 23/12/16.
 */
public enum EnumCompositeType implements IStringSerializable {
	
    BASE ("base", 0, 5, 30, EnumRarity.COMMON),
    REINFORCED_GRATE_DARK ("reinforced_grate_dark", 0, 10, 50, EnumRarity.COMMON),
    REINFORCED_GRATE_LIGHT ("reinforced_grate_light", 0, 10, 50, EnumRarity.COMMON);

    private String name;
    private int light;
    private float hardness;
    private float resistance;
    private EnumRarity rarity;

    EnumCompositeType(String name, int light, float hardness, float resistance, EnumRarity rarity) {
        this.name = name;
        this.light = light;
        this.hardness = hardness;
        this.resistance = resistance;
        this.rarity = rarity;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getLight() {
        return light;
    }

    public float getHardness() {
        return hardness;
    }

    public float getResistance() {
        return resistance;
    }

    public EnumRarity getRarity() {
        return rarity;
    }
}
