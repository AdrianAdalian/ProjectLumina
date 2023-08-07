package com.perceus.lumina.spells.tox;

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

public class SpellPoisonCloud extends Spell
{

	public SpellPoisonCloud()
	{
		super("PoisonCloud", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fPoison Cloud&r&7&ko&r",
				"&r&fElement: &r&a&lTØX&r&f.",
				"&r&fSpell Type: &cOffensive&f &dAOE&f.",
				"&r&fEmit a cloud of poison around the caster, dealing",
				"&r&a&lPoison&r&c Damage&r&f to all targets over time.",
				"&r&fRange: 15 meters.",
				"&r&fMana cost: 150 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 150, 200, spelltype.TOX);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		
		if (player.getNearbyEntities(15, 15, 15).size() == 0) 
		{
			player.sendMessage("No Targets Found");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.AMBIENT_UNDERWATER_EXIT, SoundCategory.MASTER, 1, 1);
		
		for (Entity target : player.getNearbyEntities(15, 15, 15)) 
		{
			((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 0));
		}
		
		return true;
	}

}
