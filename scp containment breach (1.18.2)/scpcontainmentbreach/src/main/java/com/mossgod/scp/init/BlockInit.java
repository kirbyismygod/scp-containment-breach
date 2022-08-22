package com.mossgod.scp.init;

import com.mossgod.scp.SCP;
import com.mossgod.scp.init.custom.blocks.CeilingLamp;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SCP.MOD_ID);

    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

    public static final RegistryObject<Block> TILE   = registerBlock("tile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f,6).sound(SoundType.STONE).requiresCorrectToolForDrops()), SCP.SCP_TAB);
    public static final RegistryObject<Block> WHITE_WALL   = registerBlock("white_wall",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f,6).sound(SoundType.STONE).requiresCorrectToolForDrops()), SCP.SCP_TAB);
    public static final RegistryObject<Block> BROWN_WALL   = registerBlock("brown_wall",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f,6).sound(SoundType.STONE).requiresCorrectToolForDrops()), SCP.SCP_TAB);
    public static final RegistryObject<Block> BROWN_STRIPED_WALL   = registerBlock("brown_striped_wall",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f,6).sound(SoundType.STONE).requiresCorrectToolForDrops()), SCP.SCP_TAB);

    public static final RegistryObject<Block> CEILING_LAMP = registerBlock("ceiling_lamp",
            () -> new CeilingLamp(BlockBehaviour.Properties.of(Material.METAL).noCollission()
                    .strength(2f).requiresCorrectToolForDrops().lightLevel(
                            (state) -> state.getValue(CeilingLamp.CLICKED) ? 15 : 0)
                    .sound(SoundType.COPPER)),
           SCP.SCP_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

