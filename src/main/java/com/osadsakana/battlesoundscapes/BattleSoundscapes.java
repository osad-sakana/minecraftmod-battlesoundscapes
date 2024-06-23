package com.osadsakana.battlesoundscapes;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;


@Mod(BattleSoundscapes.MODID)
public class BattleSoundscapes {

  public static final String MODID = "battlesoundscapes";

  public BattleSoundscapes() {
    MinecraftForge.EVENT_BUS.register(new SoundEventHandler());
    MinecraftForge.EVENT_BUS.register(new CommandEventHandler());
    new SoundRegister();
  }
}
