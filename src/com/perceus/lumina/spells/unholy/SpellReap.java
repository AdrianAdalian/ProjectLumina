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

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellReap extends Spell
{

	public SpellReap()
	{
		super("Reap", new String[] {
				"&r&e&ko&r&7&lCantrip: &r&fReap&r&7&ko&r",
				"&r&fElement: &r&4&o&lUnholy&r&f.",
				"&r&fSpell Type: &cOffensive.",
				"&r&fSteal the lifeforce of any target- Undead Immune.",
				"&r&fDeals 4 hearts of &r&cdamage&r&f.",
				"&r&4Drain&r&f 2 hearts.",
				"&r&fRange: 15 meters.",
				"&r&fMana cost: 15 &r&9mana&r&f.",
				"&r&fCooldown: 3 seconds."
		}, 15, 60, spelltype.UNHOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 10);
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
	
		if (target==null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
	
		if (entity.contains(target.getType())) 
		{
			player.sendMessage("Invalid Target");
			return false;	
		}
		
		if (target instanceof Damageable) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_WITHER_AMBIENT, SoundCategory.MASTER, 1, 1);
			((Damageable) target).damage(8, player);
			try 
			{
				player.setHealth(event.getPlayer().getHealth()+4);
			}
			catch(IllegalArgumentException e)
			{
				player.setHealth(event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
			}
		}
		return true;
		}

}
