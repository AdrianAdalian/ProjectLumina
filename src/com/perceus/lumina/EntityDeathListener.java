package com.perceus.lumina;

import java.net.http.WebSocket.Listener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

import com.perceus.lumina.SpellControlSystem.spelltype;

public class EntityDeathListener implements Listener
{
	public Random r = new Random();
	private static Set<Player> protectedPlayers = new HashSet<>();

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
	public void onLethalDamage(
		EntityDamageEvent event
	) {
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

		if (!protectedPlayers.contains((Player) event.getEntity()))
		{
			return;
		}

		event.setCancelled(true);
		protectedPlayers.remove((Player) event.getEntity());
	}

	public static boolean isProtected(
		Player player
	) {
		return protectedPlayers.contains(player);
	}

	public static void protectPlayer(
		Player player
	) {
		protectedPlayers.add(player);

		Bukkit.getScheduler().runTaskLater(Lumina.instance, () -> protectedPlayers.remove(player), 100l);
	}
}
