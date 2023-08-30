package com.perceus.lumina.spells.fire;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.GetNearestEntity;

public class SpellPrimedEruption extends Spell
{

	public SpellPrimedEruption()
	{
		super("PrimedEruption", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fPrimed Eruption&r&7&ko&r",
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fIgnite a target that explodes after 5 seconds.",
				"&r&fRange: 25 meters.",
				"&r&fMana cost: 200 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 200, 200, spelltype.FIRE);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 25);
		
		if (target == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		player.playSound(player.getLocation(), Sound.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1, 1);
		target.setFireTicks(100);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()->
		{
			target.getWorld().createExplosion(target.getLocation(), 3);
		}, 100);
		return true;
	}

}
