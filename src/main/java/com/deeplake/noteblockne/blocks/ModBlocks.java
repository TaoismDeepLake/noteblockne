package com.deeplake.noteblockne.blocks;

import com.deeplake.noteblockne.blocks.blockMisc.BlockNoteBase;
import com.deeplake.noteblockne.init.ModCreativeTab;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	/*
	 * To add a block, put a line here,
	 * -Create a json at assets.eo.blockstates
	 * -Create a json at assets.eo.models.block
	 * -Create a json at assets.eo.models.item
	 * -Add corresponding texture png
	 */

//	public static final Block NOTE_BLOCK_M = new BlockNoteBase("noteblock_m", -1f);
//	public static final Block NOTE_BLOCK_M2 = new BlockNoteBase("noteblock_m2", -2f);
	public static final Block NOTE_BLOCK_P = new BlockNoteBase("noteblock_p", 0);
//	public static final Block NOTE_BLOCK_P2 = new BlockNoteBase("noteblock_p2", 2f);
}
