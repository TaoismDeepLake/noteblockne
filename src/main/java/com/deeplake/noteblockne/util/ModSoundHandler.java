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

    public static void soundRegister()
    {
        IdlFramework.Log("Registering %s sounds.", SOUNDS.size());
        ForgeRegistries.SOUND_EVENTS.registerAll(ModSoundHandler.SOUNDS.toArray(new SoundEvent[0]));
        IdlFramework.Log("Registered %s sounds.", SOUNDS.size());
    }

}
