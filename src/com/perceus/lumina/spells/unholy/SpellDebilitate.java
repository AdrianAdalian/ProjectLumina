package com.perceus.lumina.spells.unholy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellDebilitate extends Spell
{

	public SpellDebilitate()
	{
		super("Debilitate", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fDebilitate&r&7&ko&r",
				"&r&fElement: &r&4&o&lUnholy&r&f.",
				"&r&fSpell Type: &6&lSignature&r &7&lCurse&r&f.",
				"&r&fDebilitate target player.",
				"&r&fRange: 20 meters.",
				"&r&fDuration: 30 seconds.",
				"&r&fMana cost: 150 &r&9mana&r&f."
		}, 150, 200, spelltype.UNHOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 20);
		if (target == null) 
		{
			player.sendMessage("Invalid Target");
		}
		if (target instanceof Player)
		{	
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_WITHER_SHOOT, SoundCategory.MASTER, 1, 1);
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 400, 2));
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 400, 2));
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 400, 2));
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 400, 2));
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 400, 2));
			return true;
		}  
		player.sendMessage("Invalid Target");
		return false;
	}

}
