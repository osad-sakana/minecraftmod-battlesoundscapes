package com.osadsakana.battlesoundscapes;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = BattleSoundscapes.MODID)
public class CommandEventHandler {

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("playsoundtest").executes(context -> {
            CommandSourceStack source = context.getSource();
            if (source.getEntity() instanceof Player) {
                Player player = (Player) source.getEntity();
                ResourceLocation soundLocation = new ResourceLocation(BattleSoundscapes.MODID, "battle_music");
                SoundEvent soundEvent = ForgeRegistries.SOUND_EVENTS.getValue(soundLocation);
                if (soundEvent != null) {
                    player.level().playSound(null, player.blockPosition(), soundEvent, SoundSource.MUSIC, 1.0F, 1.0F);
                    System.out.println("Sound played successfully.");
                } else {
                    System.out.println("Sound event is null.");
                }
            }
            return 1;
        }));
    }
}
