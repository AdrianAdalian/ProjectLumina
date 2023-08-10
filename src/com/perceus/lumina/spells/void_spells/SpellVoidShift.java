package com.perceus.lumina.spells.void_spells;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellVoidShift extends Spell
{

	public SpellVoidShift()
	{
		super("VoidShift", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fVoid Shift&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &6&lSignature &r&bUtility&f.",
				"&r&fShift into the &r&3&lVOID&r&f momentarily.",
				"&r&fDuration: 15 seconds.",
				"&r&fMana cost: 500 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 500, 200, spelltype.VOID);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if(player.getGameMode()==GameMode.ADVENTURE) 
		{
			player.sendMessage("Adventure Mode is not a valid Gamemode for this spell.");
			return false;
		}
		if(player.getGameMode()==GameMode.CREATIVE) 
		{
			player.sendMessage("Creative Mode is not a valid Gamemode for this spell.");
			return false;
		}
		
		player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1); 
		player.setGameMode(GameMode.SPECTATOR);
		
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()->player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 30, 0)), 240);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()->{
			player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1); 
			player.setGameMode(GameMode.SURVIVAL);
		}, 300);
		return false;
	}

}
