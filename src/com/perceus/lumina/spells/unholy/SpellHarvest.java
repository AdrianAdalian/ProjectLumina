package com.perceus.lumina.spells.unholy;

import java.util.List;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellHarvest extends Spell
{

	public SpellHarvest()
	{
		super("Harvest", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fDark Harvest&r&7&ko&r",
				"&r&fElement: &r&4&o&lUnholy&r&f.",
				"&r&fSpell Type: &cOffensive&f &dAOE&f.",
				"&r&4Drain&f the life-force of nearby mobs.",
				"&r&fUndead are immune.",
				"&r&fRange: 15 meters.",
				"&r&fMana cost: 300 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 300, 100, spelltype.UNHOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (event.getPlayer().getNearbyEntities(15, 15, 15).size() == 0)
		{
			player.sendMessage("Invalid Target.");
			return false;
		}
		
		List<EntityType> entity = List.of(EntityType.SKELETON,
				EntityType.ZOMBIE,
				EntityType.DROWNED,
				EntityType.STRAY,
				EntityType.HUSK,
				EntityType.ZOMBIE_VILLAGER,
				EntityType.ZOMBIFIED_PIGLIN,
				EntityType.WITHER_SKELETON,
				EntityType.VEX,
				EntityType.ZOMBIE_HORSE,
				EntityType.SKELETON_HORSE,
				EntityType.ZOGLIN,
				EntityType.WARDEN,
				EntityType.WITHER);
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_WITHER_AMBIENT, SoundCategory.MASTER, 1, 1);
		
		for (Entity target : event.getPlayer().getNearbyEntities(15, 15, 15))
		{
		  if (entity.contains(target.getType()))
		  {
		    continue;
		  }

		  if (!(target instanceof Damageable))
		  {
		    continue;
		  }

		  ((Damageable) target).damage(2, event.getPlayer());

		  double maxHealth = event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
		  if (event.getPlayer().getHealth() + 2 >= maxHealth)
		  {
		    event.getPlayer().setHealth(maxHealth);
		    continue; // Maybe return?
		  }  

		  event.getPlayer().setHealth(event.getPlayer().getHealth() + 1);
		}
		return true;
	}

}
