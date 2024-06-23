package com.osadsakana.battlesoundscapes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundRegister {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BattleSoundscapes.MODID);

    public static final RegistryObject<SoundEvent> BATTLE_MUSIC = SOUNDS.register("battle_music",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(BattleSoundscapes.MODID, "battle_music")));

    public SoundRegister(){
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
