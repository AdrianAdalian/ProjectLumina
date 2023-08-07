package com.perceus.lumina.spells.holy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellSatiate extends Spell
{

	public SpellSatiate()
	{
		super("Satiate", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fSatiate&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fSatiates the caster.",
				"&r&fCounteracts the Hunger debuff.",
				"&r&fRestore saturation over 5 seconds.",
				"&r&fMana cost: 10 &r&9mana&r&f.",
				"&r&fCooldown: 3 seconds."
		}, 10, 60, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		
		if (event.getPlayer().hasPotionEffect(PotionEffectType.HUNGER)) 
		{
			event.getPlayer().removePotionEffect(PotionEffectType.HUNGER);
		}
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_BONE_MEAL_USE, SoundCategory.MASTER, 1, 1);
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 100, 0));
		return true;
	}

}
