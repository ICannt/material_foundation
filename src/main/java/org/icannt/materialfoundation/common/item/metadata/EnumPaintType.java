package org.icannt.materialfoundation.common.item.metadata;

import net.minecraft.util.IStringSerializable;

/**
 * Created by ICannt on 01/10/17.
 */
public enum EnumPaintType implements IStringSerializable {

	BLACK ("black", "Black", new Object[]{"dyeBlack"}),
	LIGHT_GRAY ("light_gray", "Light Gray", new Object[]{"dyeLightGray"}),
	GREEN ("green", "Green", new Object[]{"dyeGreen"}),
	BROWN ("brown", "Brown", new Object[]{"dyeBrown"}),
	BLUE ("blue", "Blue", new Object[]{"dyeBlue"}),
	RED ("red", "Red", new Object[]{"dyeRed"}),
	CYAN ("cyan", "Cyan", new Object[]{"dyeCyan"}),
	LIME ("lime", "Lime", new Object[]{"dyeLime"}),
	GRAY ("gray", "Gray", new Object[]{"dyeGray"}),
	PURPLE ("purple", "Purple", new Object[]{"dyePurple"}),
	MAGENTA ("magenta", "Magenta", new Object[]{"dyeMagenta"}),
	YELLOW ("yellow", "Yellow", new Object[]{"dyeYellow"}),
	LIGHT_BLUE ("light_blue", "Light Blue", new Object[]{"dyeLightBlue"}),
	ORANGE ("orange", "Orange", new Object[]{"dyeOrange"}),
	PINK ("pink", "Pink", new Object[]{"dyePink"}),
	WHITE ("white", "White", new Object[]{"dyeWhite"}),
	SLIME ("slime", "Slime", new Object[]{"dustSlimeLime"}),
	BLAZE ("blaze", "Blaze", new Object[]{"dustBlazeLime"}),
	FLUXED ("fluxed", "Fluxed", new Object[]{"dustFluxedLime"});

    private String name;
    private String localised;
    private Object[] catalyst;

    EnumPaintType(String name, String localised, Object[] catalyst) {
        this.name = name;
        this.localised = localised;
        this.catalyst = catalyst;
    }

    @Override
    public String getName() {
        return name;
    }

	public String getLocalisedName() {
		return localised;
	}

	public Object[] getRecipeCatalyst() {
		return catalyst;
	}
}
