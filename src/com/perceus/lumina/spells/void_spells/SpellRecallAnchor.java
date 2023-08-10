package com.perceus.lumina.spells.void_spells;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellRecallAnchor extends Spell
{

	public SpellRecallAnchor()
	{
		super("RecallAnchor", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fRecall Anchor&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fCreates a recall anchor that the caster",
				"&r&fcan teleport back to. Decays upon relog.",
				"&r&fMana cost: 25 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 25, 20, spelltype.VOID);
	}
	
	private static Map<UUID, Location> playerStoredLocations = new HashMap<>();
	
	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		
		if (!playerStoredLocations.containsKey(player.getUniqueId())) 
		{
			playerStoredLocations.put(player.getUniqueId(), player.getLocation());
			player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, SoundCategory.MASTER, 1, 1);
			player.sendMessage("Your location has been saved!");
			return true;
		}
		
		if (playerStoredLocations.containsKey(player.getUniqueId())) 
		{
			player.teleport(playerStoredLocations.get(player.getUniqueId()));
			Bukkit.getScheduler().runTaskLater(Lumina.instance, ()->
			{
				player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, SoundCategory.MASTER, 1, 1);
				player.sendMessage("You have returned to your recall location.");
				playerStoredLocations.remove(player.getUniqueId());
			}, 10);
			return true;
		}
		player.sendMessage("Fizzle!");
		return false;
	}

}
