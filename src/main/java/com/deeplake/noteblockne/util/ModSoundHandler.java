package com.deeplake.noteblockne.util;

import com.deeplake.noteblockne.IdlFramework;
import com.deeplake.noteblockne.util.sound.ModSoundEvent;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class ModSoundHandler {
    //To add a sound, remember assets.noteblockne.sounds.json
    public static final List<ModSoundEvent> SOUNDS = new ArrayList<>();

    public static SoundEvent harp = new ModSoundEvent("harp_pp");
    public static SoundEvent basedrum = new ModSoundEvent("basedrum_pp");
    public static SoundEvent snare = new ModSoundEvent("snare_pp");
    public static SoundEvent hat = new ModSoundEvent("hat_pp");
    public static SoundEvent bass = new ModSoundEvent("bass_pp");
    public static SoundEvent flute = new ModSoundEvent("flute_pp");
    public static SoundEvent bell = new ModSoundEvent("bell_pp");
    public static SoundEvent guitar = new ModSoundEvent("guitar_pp");
    public static SoundEvent chime = new ModSoundEvent("chime_pp");
    public static SoundEvent xylophone = new ModSoundEvent("xylophone_pp");

    public static SoundEvent mm_harp = new ModSoundEvent("harp_mm");
    public static SoundEvent mm_basedrum = new ModSoundEvent("basedrum_mm");
    public static SoundEvent mm_snare = new ModSoundEvent("snare_mm");
    public static SoundEvent mm_hat = new ModSoundEvent("hat_mm");
    public static SoundEvent mm_bass = new ModSoundEvent("bass_mm");
    public static SoundEvent mm_flute = new ModSoundEvent("flute_mm");
    public static SoundEvent mm_bell = new ModSoundEvent("bell_mm");
    public static SoundEvent mm_guitar = new ModSoundEvent("guitar_mm");
    public static SoundEvent mm_chime = new ModSoundEvent("chime_mm");
    public static SoundEvent mm_xylophone = new ModSoundEvent("xylophone_mm");

    public static SoundEvent p4_harp = new ModSoundEvent("harp_pp_pp");
    public static SoundEvent p4_basedrum = new ModSoundEvent("basedrum_pp_pp");
    public static SoundEvent p4_snare = new ModSoundEvent("snare_pp_pp");
    public static SoundEvent p4_hat = new ModSoundEvent("hat_pp_pp");
    public static SoundEvent p4_bass = new ModSoundEvent("bass_pp_pp");
    public static SoundEvent p4_flute = new ModSoundEvent("flute_pp_pp");
    public static SoundEvent p4_bell = new ModSoundEvent("bell_pp_pp");
    public static SoundEvent p4_guitar = new ModSoundEvent("guitar_pp_pp");
    public static SoundEvent p4_chime = new ModSoundEvent("chime_pp_pp");
    public static SoundEvent p4_xylophone = new ModSoundEvent("xylophone_pp_pp");

    public static void soundRegister()
    {
        IdlFramework.Log("Registering %s sounds.", SOUNDS.size());
        ForgeRegistries.SOUND_EVENTS.registerAll(ModSoundHandler.SOUNDS.toArray(new SoundEvent[0]));
        IdlFramework.Log("Registered %s sounds.", SOUNDS.size());
    }

}
