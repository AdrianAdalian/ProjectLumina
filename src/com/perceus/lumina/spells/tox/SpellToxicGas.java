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

public class SpellToxicGas extends Spell
{

	public SpellToxicGas()
	{
		super("ToxicGas", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fToxic Gas&r&7&ko&r",
				"&r&fElement: &r&a&lTØX&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fDeals 4 hearts of &a&lPoison",
				"&r&cDamage&f over 5 seconds.",
				"&r&fRange: 10 meters.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 50, 100, spelltype.TOX);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 10);
		
		if (target == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		if (!(target instanceof LivingEntity)) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.AMBIENT_UNDERWATER_EXIT, SoundCategory.MASTER, 1, 1);
		((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
		return true;
	}

}
