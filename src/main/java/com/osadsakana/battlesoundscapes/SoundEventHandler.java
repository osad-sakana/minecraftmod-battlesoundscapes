package com.osadsakana.battlesoundscapes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.event.entity.living.LivingEvent;

import java.util.List;

public class SoundEventHandler {

  private static final ResourceLocation BATTLE_MUSIC = new ResourceLocation(BattleSoundscapes.MODID, "battle_music");
  private static final double DETECTION_RADIUS = 20.0;

  @SubscribeEvent
  public void update(LivingEvent event) {
    if (event.getEntity() instanceof Player) {
      Player player = (Player) event.getEntity();
      Level world = player.level();
      playMusic(world, player, BATTLE_MUSIC);
      if (!world.isClientSide && isHostileMobNearby(player, DETECTION_RADIUS)) {
        // 戦闘音楽を再生する
        System.out.println("sakuteki");
      }
    }
  }

  private boolean isHostileMobNearby(Player player, double radius) {
    AABB detectionBox = player.getBoundingBox().inflate(radius);
    List<Entity> entities = player.level().getEntities(player, detectionBox, entity -> entity instanceof Monster);
    return !entities.isEmpty();
  }

  private void playMusic(Level world, Player player, ResourceLocation sound){
    SoundEvent soundEvent = ForgeRegistries.SOUND_EVENTS.getValue(sound);
    if (soundEvent != null) {
      System.out.println("再生するサウンド: " + soundEvent.getLocation());
      System.out.println("サウンドの再生位置: " + player.blockPosition());
      world.playSound(null, player.blockPosition(), soundEvent, SoundSource.MUSIC, 1.0F, 1.0F);
    }
  }
}
