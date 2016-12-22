package org.icannt.materialfoundation.common.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.icannt.materialfoundation.common.MaterialFoundation;
import org.icannt.materialfoundation.common.block.BlockMetalChecker;
import org.icannt.materialfoundation.common.block.BlockMetalScale;
import org.icannt.materialfoundation.common.block.itemblock.ItemBlockMetal;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ICannt on 20/12/16.
 */

@GameRegistry.ObjectHolder(MaterialFoundation.MOD_ID)
public class BlockRegistry {

    @GameRegistry.ObjectHolder("block_metal_checker")
    public static final BlockMetalChecker METAL_CHECKER = new BlockMetalChecker();

    @GameRegistry.ObjectHolder("block_metal_scale")
    public static final BlockMetalScale METAL_SCALE = new BlockMetalScale();

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            final IForgeRegistry<Block> registry = event.getRegistry();

            final Block[] blocks = {
                    METAL_CHECKER,
                    METAL_SCALE
            };

            registry.registerAll(blocks);
        }

        @SubscribeEvent
        public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> registry = event.getRegistry();

            final ItemBlock[] items = {
                new ItemBlockMetal(METAL_CHECKER),
                new ItemBlockMetal(METAL_SCALE)
            };

            for (ItemBlock item : items) {
                registry.register(item.setRegistryName(item.getBlock().getRegistryName()));
                ITEM_BLOCKS.add(item);
            }
        }

    }

    public static void initBlockModels() {
        METAL_CHECKER.initClient();
        METAL_SCALE.initClient();
    }
}
