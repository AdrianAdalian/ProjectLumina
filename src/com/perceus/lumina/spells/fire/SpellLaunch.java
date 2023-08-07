package com.perceus.lumina.spells.fire;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
/**
 *  
 * Thanks for your spell idea, @Laeven!
 *
 */
public class SpellLaunch extends Spell
{

	public SpellLaunch()
	{
		super("Launch", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fLaunch&r&7&ko&r",
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fLaunches the player in the air via a rocket.",
				"&r&fDistance Traveled: 25 meters.",
				"&r&fMana cost: 20 &r&9mana&r&f.",
				"&r&fCooldown: 2 seconds."
		}, 20, 40, spelltype.FIRE);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, SoundCategory.MASTER, 1, 1);
		Firework fw = (Firework)player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
		fw.addPassenger(player);
		FireworkMeta meta = fw.getFireworkMeta();
		meta.setPower(2);
		fw.setFireworkMeta(meta);
		Bukkit.getScheduler().runTaskLater(Lumina.instance, ()->{
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 40, 0));
		}, 45);
		return true;
	}

}
