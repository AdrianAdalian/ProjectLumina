package com.perceus.lumina.spells.unholy;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellUndeadEffigy extends Spell
{

	public SpellUndeadEffigy()
	{
		super("UndeadEffigy", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fUndead Effigy&r&7&ko&r",
				"&r&fElement: &r&4&o&lUnholy&r&f.",
				"&r&fSpell Type: &6&lSignature&r &bUtility&f.",
				"&r&fSet respawn location.",
				"&r&fMana cost: 500 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 500, 200, spelltype.UNHOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Location loc = event.getPlayer().getLocation();
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_WITHER_SHOOT, SoundCategory.MASTER, 1, 1);
		event.getPlayer().setBedSpawnLocation(loc, true);
		player.sendMessage("Respawn location set to coordinate: " + loc);
		return true;
	}

}
