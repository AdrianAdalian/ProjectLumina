package com.perceus.lumina.spells.tox;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellCure extends Spell
{

	public SpellCure()
	{
		super("Cure", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fCure&r&7&ko&r",
				"&r&fElement: &r&a&lTØX&r&f.",
				"&r&fSpell Type: &6&lSignature &r&bUtility&f.",
				"&r&fCures &a&lPoison&r&f and Nausea.",
				"&r&fMana cost: 5 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 5, 20, spelltype.TOX);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		List<PotionEffectType> negEffects = List.of(
				PotionEffectType.CONFUSION,
				PotionEffectType.POISON);
		if (!player.hasPotionEffect(PotionEffectType.POISON) && !player.hasPotionEffect(PotionEffectType.CONFUSION)) 
		{
			player.sendMessage("You are not afflicted with an illness.");
			return false;
		}
		for(PotionEffectType pet : negEffects)
		{
			if(!player.hasPotionEffect(pet)) 
			{
				continue;
			}
			player.removePotionEffect(pet);
		}
		
		return true;
	}

}
