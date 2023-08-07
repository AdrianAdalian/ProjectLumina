package com.perceus.lumina.spells.tox;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellNauseate extends Spell
{

	public SpellNauseate()
	{
		super("Nauseate", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fNauseate&r&7&ko&r",
				"&r&fElement: &r&a&lTØX&r&f.",
				"&r&fSpell Type: &7&lCurse&r&f.",
				"&r&fNauseates the target for 15 seconds.",
				"&r&fRange: 15 meters",
				"&r&fMana cost: 10 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 10, 20, spelltype.TOX);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 15);
		
		if (target == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		if (target instanceof LivingEntity) 
		{
			player.playSound(event.getPlayer().getLocation(), Sound.AMBIENT_UNDERWATER_EXIT, SoundCategory.MASTER, 1, 1);
			((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 300, 0));
			return true;
		}
		return false;
	}

}
