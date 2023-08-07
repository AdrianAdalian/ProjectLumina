package com.perceus.lumina.spells.fire;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellDragonFlare extends Spell
{

	public SpellDragonFlare()
	{
		super("DracoMeteor", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fDraco Meteor&r&7&ko&r",
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &cOffensive&f.", 
				"&r&fPlummit a ball of fire that leaves behind a damaging &dAOE&f.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 100, 200, spelltype.FIRE);
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
		DragonFireball fireball = target.getWorld().spawn(newlocation, DragonFireball.class);
		fireball.setShooter(event.getPlayer());
		fireball.setDirection(v);
		fireball.setYield(5);
		return true;
	}

}
