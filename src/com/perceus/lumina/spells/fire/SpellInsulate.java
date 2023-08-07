package com.perceus.lumina.spells.fire;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellInsulate extends Spell
{

	public SpellInsulate()
	{
		super("Insulate", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fInsulate&r&7&ko&r",
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &6Buff&f.",
				"&r&fGrants full fire immunity for 1 minute.",
				"&r&fMana cost: 10 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 10, 200, spelltype.FIRE);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200, 4));
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()-> 
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, SoundCategory.MASTER, 1, 1), 1205);
		return true;
	}

}
