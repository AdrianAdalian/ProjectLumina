package com.perceus.lumina;

import java.util.Random;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import com.perceus.lumina.SpellControlSystem.spelltype;

public class EntityDeathListener implements Listener
{
	public Random r = new Random();
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
}
