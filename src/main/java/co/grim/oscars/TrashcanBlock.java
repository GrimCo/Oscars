package co.grim.oscars;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class TrashcanBlock extends Block
{
	public TrashcanBlock()
	{
		super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(0.5f));
	}
	
	@Override
	public boolean hasTileEntity(BlockState state)
	{
		return true;
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world)
	{
		return new TrashcanTile();
	}
}
