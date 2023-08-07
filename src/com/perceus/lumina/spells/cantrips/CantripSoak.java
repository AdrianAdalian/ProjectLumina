package com.perceus.lumina.spells.cantrips;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class CantripSoak extends Spell
{

	public CantripSoak()
	{
		super("Soak", new String[]{"&r&e&ko&r&7&lCantrip: &r&fSoak&r&e&ko&r",
				"&r&fElement: &r&9Water&r&f.",
				"&r&fSpell Type: &7&lCurse &r&eCantrip&f.",
				"&r&fSlightly decreases targets ability to move and inflicts weakness.",
				"&r&fReduces Movement and Digging Speed by 10%.",
				"&r&fAlso reduces resistance by 10%.",
				"&r&fMana cost: 0 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."}, 0, 100, spelltype.WATER);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		LivingEntity target = (LivingEntity) GetNearestEntity.getNearestEntityInSight(player, 10);
		if (target == null) 
		{
			player.sendMessage("Invalid Target.");
			return false;
		}
		player.playSound(player.getLocation(), Sound.AMBIENT_UNDERWATER_EXIT, SoundCategory.MASTER, 1, 1);
		target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0));
		target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 200, 0));
		target.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 0));
		return true;
	}

}
