package com.mossgod.scp.init;

import com.mossgod.scp.SCP;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SCP.MOD_ID);

    public static final RegistryObject<Item> SCP_420_J = ITEMS.register("scp_420_j",
        () -> new Item(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1)));

    public static final RegistryObject<Item> SCP_500 = ITEMS.register("scp_500",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1)));











    }

