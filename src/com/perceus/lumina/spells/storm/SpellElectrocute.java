package com.perceus.lumina.spells.storm;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellElectrocute extends Spell
{

	public SpellElectrocute()
	{
		super("Electrocute", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fElectrocute&r&7&ko&r",
				"&r&fElement: &r&dStorm&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&d&lElectrocutes &r&ftarget during a storm.",
				"&r&fWeakens target during clear weather.",
				"&r&fRange: 20 meters.",
				"&r&fMana cost: 200 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 200, 100, spelltype.STORM);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		boolean weather = Bukkit.getWorlds().get(0).isClearWeather();
		
		if (weather == true) 
		{
			Entity target = GetNearestEntity.getNearestEntityInSight(player, 20);
			if (target == null) 
			{
				player.sendMessage("Invalid Target");
				return false;
			}
			if (target instanceof LivingEntity) 
			{
				target.getWorld().strikeLightningEffect(target.getLocation());
				((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 600, 0));
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
				target.getWorld().playSound((Location) target.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, SoundCategory.MASTER, 1, 1);
				return true;
			}
			player.sendMessage("Fizzle!");
			return false;
		}
		
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 20);
		if (target == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		if (target instanceof Damageable && target instanceof LivingEntity) 
		{
			target.getWorld().strikeLightningEffect(target.getLocation());
			((Damageable) target).damage(8);
			((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 600, 0));
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			target.getWorld().playSound((Location) target.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, SoundCategory.MASTER, 1, 1);
			return true;
		}		
		player.sendMessage("Fizzle!");
		return false;
	}

}
