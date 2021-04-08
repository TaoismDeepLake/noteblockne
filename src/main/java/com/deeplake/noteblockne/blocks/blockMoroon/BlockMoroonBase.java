package com.deeplake.noteblockne.blocks.blockMoroon;

import com.deeplake.noteblockne.blocks.BlockBase;
import net.minecraft.block.material.Material;

public class BlockMoroonBase extends BlockBase {
    public BlockMoroonBase(String name, Material material) {
        super(name, material);
        setResistance(1.0F);
    }
}
