package com.perceus.lumina.spells.geo;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellSandstorm extends Spell
{

	public SpellSandstorm()
	{
		super("Sandstorm", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fSandstorm&r&7&ko&r",
				"&r&fElement: &r&6Geo&r&f.",
				"&r&fSpell Type: &7&lCurse &r&dAOE&f.",
				"&r&fCreate a sandstorm that blinds and slows targets within.",
				"&r&fDuration: 15 seconds.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 250 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 250, 200, spelltype.GEO);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (event.getPlayer().getNearbyEntities(30, 30, 30).size() == 0)
		{
			player.sendMessage("No Target Found");
			return false;
		}
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_SAND_BREAK, SoundCategory.MASTER, 1, 1);
		
		for (Entity target : event.getPlayer().getNearbyEntities(30, 30, 30)) 
		{
			if (target instanceof LivingEntity)
			{
				((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 0, true));
				((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300, 0, true));
			}
		}
		return true;
	}

}
