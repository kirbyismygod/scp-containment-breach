package com.mossgod.scp;

import com.mossgod.scp.init.BlockInit;
import com.mossgod.scp.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("scp")
public class SCP {
	public static String MOD_ID = "scp";


	public static final CreativeModeTab SCP_TAB = new CreativeModeTab(MOD_ID) {

		@Override
		public ItemStack makeIcon() {
			return new ItemStack(BlockInit.TILE.get());
		}
	};
	
	
	
	public SCP() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		BlockInit.BLOCKS.register(bus);
		ItemInit.ITEMS.register(bus);
		MinecraftForge.EVENT_BUS.register(this);

	}

}
