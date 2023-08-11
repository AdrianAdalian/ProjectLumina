package com.perceus.lumina.spells.fire;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellInferno extends Spell
{

	public SpellInferno()
	{
		super("Inferno", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fInferno&r&7&ko&r",
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &r&cOffensive &dAOE &6&lSignature&r&f.",
				"&r&fRain meteors down on all nearby targets.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 500 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 500, 200, spelltype.FIRE);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (event.getPlayer().getNearbyEntities(30,30,30).size() == 0)
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_AMBIENT, SoundCategory.MASTER, 1, 1);
		for (Entity target : event.getPlayer().getNearbyEntities(30,30,30)) 
		{
			Vector v = new Vector(0,-5,0);
			Location newlocation = target.getLocation().add(new Location(event.getPlayer().getWorld(), 0, 20, 0)) ;
			newlocation.add(0, 20, 0);
			Fireball fireball = target.getWorld().spawn(newlocation, Fireball.class);
			fireball.setShooter(event.getPlayer());
			fireball.setDirection(v);
			fireball.setYield(2);
		}
		return true; 
	}

}
