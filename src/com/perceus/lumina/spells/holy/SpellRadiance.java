package com.perceus.lumina.spells.holy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellRadiance extends Spell
{

	public SpellRadiance()
	{
		super("Radiance", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fRadiance&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &aSupport&f.",
				"&r&fCause mobs to glow within spell radius.",
				"&r&fDuration: 20 seconds.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 50, 20, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (event.getPlayer().getNearbyEntities(30, 30, 30).size() == 0)
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
		for (Entity target : event.getPlayer().getNearbyEntities(30, 30, 30)) 
		{
			if (target instanceof LivingEntity)
	    	{
				((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 400, 0));
	    	}
		}	
		return true;
	}

}
