package com.deeplake.noteblockne.init;

import com.deeplake.noteblockne.blocks.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModCreativeTab {
	public static final CreativeTabs IDL_MISC = new CreativeTabs(CreativeTabs.getNextID(), "neNoteblock")
	{
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ModBlocks.NOTE_BLOCK_P);
        }
    };
}
