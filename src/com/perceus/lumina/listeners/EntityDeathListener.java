package com.perceus.lumina.listeners;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.scheduler.BukkitTask;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class EntityDeathListener implements Listener
{
	public Random r = new Random();
	private static Map<Player, BukkitTask> protectedPlayers = new HashMap<>();

	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) 
	{
		for (spelltype type : spelltype.values()) 
		{
			if (!type.carriers.contains(e.getEntityType())) 
			{
				continue;
			}
			if (r.nextDouble()>= 0.05) 
			{
				return;
			}
			e.getDrops().add(type.grimoire);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onLethalDamage(EntityDamageEvent event) 
	{
		if (event.isCancelled())
		{
			return;
		}

		if (!(event.getEntity() instanceof Player))
		{
			return;
		}

		if (event.getFinalDamage() < ((Damageable) event.getEntity()).getHealth())
		{
			return;
		}

		if (!protectedPlayers.containsKey((Player) event.getEntity()))
		{
			return;
		}

		event.setCancelled(true);
		protectedPlayers.get((Player) event.getEntity()).cancel();;
		protectedPlayers.remove((Player) event.getEntity());
		((Damageable) event.getEntity()).setHealth(1.0d);
	}
	
	public static boolean isProtected(Player player) 
	{
		return protectedPlayers.containsKey(player);
	}

	public static void protectPlayer(Player player) 
	{
		protectedPlayers.put(player, Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> protectedPlayers.remove(player), 100l));
	}
}
