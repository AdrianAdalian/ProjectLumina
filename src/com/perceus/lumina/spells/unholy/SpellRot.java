package com.perceus.lumina.spells.unholy;

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
import com.perceus.lumina.utils.GetNearestEntity;

public class SpellRot extends Spell
{

	public SpellRot()
	{
		super("Rot", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fRot&r&7&ko&r",
				"&r&fElement: &r&4&o&lUnholy&r&f.",
				"&r&fSpell Type: &7&lCurse&r&f.",
				"&r&fCause acute necrosis at target.",
				"&r&fThe target is slowed as a result.",
				"&r&4Wither &r&f4-5 hearts over 10 seconds.",
				"&r&fRange: 10 meters.",
				"&r&fMana cost: 30 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 30, 100, spelltype.UNHOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{

		Entity target = GetNearestEntity.getNearestEntityInSight(player, 10);
		if (!(target instanceof LivingEntity)) 
		{
			player.sendMessage("Invalid Target");
			return false; 
		}
		player.playSound(event.getPlayer().getLocation(), Sound.ENTITY_WITHER_SHOOT, SoundCategory.MASTER, 1, 1);
		
		((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 200, 4));
		((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0));
		return true;
	}
}
