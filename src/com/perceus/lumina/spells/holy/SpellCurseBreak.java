package com.perceus.lumina.spells.holy;

import java.util.List;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.GetNearestEntity;

public class SpellCurseBreak extends Spell
{

	public SpellCurseBreak()
	{
		super("CurseBreak", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fCurse Break&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &aSupport&f.", 
				"&r&fRoutes all &7&lCurses&r&f to self.",
				"&r&fMana cost: 100 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 100, 20, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 20);
		List<PotionEffectType> negEffects = List.of(PotionEffectType.WEAKNESS,
				PotionEffectType.BAD_OMEN,
				PotionEffectType.CONFUSION,
				PotionEffectType.POISON,
				PotionEffectType.SLOW_DIGGING,
				PotionEffectType.WITHER,
				PotionEffectType.BLINDNESS,
				PotionEffectType.DARKNESS,
				PotionEffectType.HUNGER,
				PotionEffectType.UNLUCK,
				PotionEffectType.SLOW);
		
		if (target == null) 
		{
			for(PotionEffectType pet : negEffects)
			{
				if(!player.hasPotionEffect(pet)) 
				{
					continue;
				}
				player.removePotionEffect(pet);
			}
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_CHAIN_BREAK, SoundCategory.MASTER, 1, 1);
			return true;
		}
		return false;
	}

}
