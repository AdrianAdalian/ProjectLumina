package com.perceus.lumina.spells.fire;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellOverheat extends Spell
{

	public SpellOverheat()
	{
		super("Overheat", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fOverheat&r&7&ko&r",
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &cOffensive&d AOE&f.",
				"&r&fLight all within range on fire.",
				"&r&fDuration: 15 seconds.",
				"&r&fRange: 15 meters.",
				"&r&fMana cost: 200 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 200, 100, spelltype.FIRE);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (event.getPlayer().getNearbyEntities(15, 15, 15).size() == 0)
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_AMBIENT, SoundCategory.MASTER, 1, 1);
		for (Entity target : event.getPlayer().getNearbyEntities(15, 15, 15)) 
		{
			target.setFireTicks(300);
		}
		return true; 
	}

}
