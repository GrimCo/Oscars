package co.grim.oscars;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TrashcanTile extends TileEntity
{
	public TrashcanTile()
	{
		super(OscarsMod.tileOscar.get());
	}
	
	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side)
	{
		if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
		{
			return ItemTrashHandler.INSTANCE.cast();
		}
		else if(cap ==CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)
		{
			return FluidTrashHandler.INSTANCE.cast();
		}
		
		return super.getCapability(cap, side);
	}
	
	public static class FluidTrashHandler implements IFluidHandler
	{
		public static LazyOptional<IFluidHandler> INSTANCE = LazyOptional.of(FluidTrashHandler::new);
		
		
		@Override
		public int getTanks()
		{
			return 1;
		}
		
		@Nonnull
		@Override
		public FluidStack getFluidInTank(int tank)
		{
			return FluidStack.EMPTY;
		}
		
		@Override
		public int getTankCapacity(int tank)
		{
			return 1;
		}
		
		@Override
		public boolean isFluidValid(int tank, @Nonnull FluidStack stack)
		{
			return true;
		}
		
		@Override
		public int fill(FluidStack resource, FluidAction action)
		{
			return resource.isEmpty()? 0 : resource.getAmount();
		}
		
		@Nonnull
		@Override
		public FluidStack drain(FluidStack resource, FluidAction action)
		{
			return FluidStack.EMPTY;
		}
		
		@Nonnull
		@Override
		public FluidStack drain(int maxDrain, FluidAction action)
		{
			return FluidStack.EMPTY;
		}
	}
	
	public static class ItemTrashHandler implements IItemHandler
	{
		public static LazyOptional<IItemHandler> INSTANCE = LazyOptional.of(ItemTrashHandler::new);
		
		@Override
		public int getSlots()
		{
			return 1;
		}
		
		@Nonnull
		@Override
		public ItemStack getStackInSlot(int slot)
		{
			return ItemStack.EMPTY;
		}
		
		@Nonnull
		@Override
		public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate)
		{
			return ItemStack.EMPTY;
		}
		
		@Nonnull
		@Override
		public ItemStack extractItem(int slot, int amount, boolean simulate)
		{
			return ItemStack.EMPTY;
		}
		
		@Override
		public int getSlotLimit(int slot)
		{
			return 1;
		}
		
		@Override
		public boolean isItemValid(int slot, @Nonnull ItemStack stack)
		{
			return true;
		}
	}
}
