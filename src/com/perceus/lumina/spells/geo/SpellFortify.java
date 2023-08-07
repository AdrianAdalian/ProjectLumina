package com.perceus.lumina.spells.geo;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellFortify extends Spell
{

	public SpellFortify()
	{
		super("Fortify", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fFortify&r&7&ko&r",
				"&r&fElement: &r&6Geo&r&f.",
				"&r&fSpell Type: &aSupport &6Buff &dAOE&f.",
				"&r&fFortify resistance of all nearby players.",
				"&r&fDuration: 1 minute.",
				"&r&fRange: 5 meters.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 50, 100, spelltype.GEO);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (player.getNearbyEntities(5, 5, 5).size() == 0) 
		{
			player.sendMessage("No Targets Found");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
		
		for (Entity target : player.getNearbyEntities(5, 5, 5)) 
		{
			if (!(target instanceof Player)) 
			{
				continue;
			}
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200, 0));
		}
		return true;
	}

}
