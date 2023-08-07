package com.perceus.lumina.spells.holy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellMinorHeal extends Spell
{

	public SpellMinorHeal()
	{
		super("MinorHeal", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fMinor Heal&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &aSupport&f.",
				"&r&aHeals &r&f3 hearts to self.",
				"&r&fMana cost: 5 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 5, 20, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (player.getHealth() == player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) 
		{
			player.sendMessage("You are already at Maximum Health.");
			return false;
		}
		try
		{
			player.playSound(player.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
			player.setHealth(player.getHealth()+6);		
		}
		catch(IllegalArgumentException e)
		{			
			player.playSound(player.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
			player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
		}	
		return true;
	}

}
