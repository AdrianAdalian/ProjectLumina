package com.perceus.lumina.spells.holy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.GetNearestEntity;

public class SpellProtect extends Spell
{

	public SpellProtect()
	{
		super("Protect", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fProtect&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &aSupport&f &6Buff&f.",
				"&r&fProtect target player.",
				"&r&fDuration: 30 seconds.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 50, 20, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 30);
		
		if (target == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		if (target instanceof Player) 
		{
			player.playSound(player.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 600, 4));
			return true;
		}
		player.sendMessage("Invalid Target");
		return false;
	}

}
