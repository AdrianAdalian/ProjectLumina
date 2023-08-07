package com.perceus.lumina.spells.fire;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellMeteor extends Spell
{

	public SpellMeteor()
	{
		super("Meteor", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fMeteor&r&7&ko&r",
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &cOffensive&f.", 
				"&r&fPlummit a small ball of fire that explodes on impact.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 25 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 25, 100, spelltype.FIRE);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 30);
		Vector v = new Vector(0,-5,0);
		
		if (target == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1, 1);
		Location newlocation = target.getLocation().add(new Location(event.getPlayer().getWorld(), 0, 20, 0)) ;
		newlocation.add(0, 20, 0);
		Fireball fireball = target.getWorld().spawn(newlocation, Fireball.class);
		fireball.setShooter(event.getPlayer());
		fireball.setDirection(v);
		fireball.setYield(1);
		return true;
	}

}
