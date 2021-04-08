package com.deeplake.noteblockne.blocks.blockMisc;

import com.deeplake.noteblockne.IdlFramework;
import com.deeplake.noteblockne.blocks.ModBlocks;
import com.deeplake.noteblockne.blocks.tileEntity.TileEntityNoteBase;
import com.deeplake.noteblockne.init.ModCreativeTab;
import com.deeplake.noteblockne.item.ModItems;
import com.deeplake.noteblockne.util.IHasModel;
import com.deeplake.noteblockne.util.ModSoundHandler;
import com.google.common.collect.Lists;
import net.minecraft.block.BlockNote;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class BlockNoteBase extends BlockNote implements IHasModel {
    public static final List<SoundEvent> PUBLIC_INSTRUMENTS = Lists.newArrayList(
            ModSoundHandler.harp,
            ModSoundHandler.basedrum,
            ModSoundHandler.snare,
            ModSoundHandler.hat,
            ModSoundHandler.bass,
            ModSoundHandler.flute,
            ModSoundHandler.bell,
            ModSoundHandler.guitar,
            ModSoundHandler.chime,
            ModSoundHandler.xylophone
    );

    public float indexModifier = 0f;

    public BlockNoteBase(String name, float indexModifier)
    {
        super();
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(ModCreativeTab.IDL_MISC);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

        setLightOpacity(1);

        this.indexModifier = indexModifier;
    }

    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityNoteBase();
    }

    public SoundEvent publicGetInstrument(int eventId)
    {
        if (eventId < 0 || eventId >= PUBLIC_INSTRUMENTS.size())
        {
            eventId = 0;
        }

        return PUBLIC_INSTRUMENTS.get(eventId);
    }

    /**
     * Called on server when World#addBlockEvent is called. If server returns true, then also called on the client. On
     * the Server, this may perform additional changes to the world, like pistons replacing the block with an extended
     * base. On the client, the update may involve replacing tile entities or effects such as sounds or particles
     */
    public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int id, int param)
    {
        net.minecraftforge.event.world.NoteBlockEvent.Play e = new net.minecraftforge.event.world.NoteBlockEvent.Play(worldIn, pos, state, param, id);
        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(e)) return false;
        id = e.getInstrument().ordinal();
        param = e.getVanillaNoteId();
        float f = (float)Math.pow(2.0D, (double)(param - 12) / 12.0D + indexModifier);
        worldIn.playSound((EntityPlayer)null, pos, publicGetInstrument(id), SoundCategory.RECORDS, 3.0F, f);
        //SoundManager.getClampedPitch clamps it into 0.5~2, fk
        worldIn.spawnParticle(EnumParticleTypes.NOTE, (double)pos.getX() + 0.5D, (double)pos.getY() + 1.2D, (double)pos.getZ() + 0.5D, (double)param / 24.0D, 0.0D, 0.0D);
        return true;
    }

    @Override
    public void registerModels() {
        IdlFramework.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
