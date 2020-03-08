package co.grim.oscars;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

@Mod(OscarsMod.MOD_ID)
public class OscarsMod
{
	public static final String MOD_ID = "oscars";
	
	public OscarsMod()
	{
		IEventBus bus =FMLJavaModLoadingContext.get().getModEventBus();
		
		ITEMS.register(bus);
		BLOCKS.register(bus);
		TILES.register(bus);
	}
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MOD_ID);
	public static final DeferredRegister<TileEntityType<?>> TILES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, MOD_ID);
	
	public static RegistryObject<Item> itemOscar = ITEMS.register("trashcan", () -> new BlockItem(OscarsMod.blockOscar.get(), new Item.Properties().group(ItemGroup.REDSTONE))
	{
		@OnlyIn(Dist.CLIENT)
		@Override
		public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
		{
			tooltip.add(new TranslationTextComponent("block.oscars.trashcan.info").setStyle(new Style().setColor(TextFormatting.DARK_GRAY)));
			super.addInformation(stack, worldIn, tooltip, flagIn);
		}
	});
	public static RegistryObject<Block> blockOscar = BLOCKS.register("trashcan", TrashcanBlock::new);
	public static RegistryObject<TileEntityType<TrashcanTile>> tileOscar = TILES.register("trashcan", () ->TileEntityType.Builder.create(TrashcanTile::new, blockOscar.get()).build(null));
}