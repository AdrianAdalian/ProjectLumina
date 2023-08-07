package com.perceus.lumina.spells.unholy;

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

public class SpellDoom extends Spell
{

	public SpellDoom()
	{
		super("Doom", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fDoom&r&7&ko&r",
				"&r&fElement: &r&4&o&lUnholy&r&f.",
				"&r&fSpell Type: &7&lCurse&f &dAOE&f.",
				"&r&fAfflict the &4&lDOOM&r &7&lCurse&r&f on all nearby.",
				"&r&fDuration: 30 seconds.",
				"&r&fRange: 30 meters.",
				"&r&fMana cost: 100 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 100, 100, spelltype.UNHOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (event.getPlayer().getNearbyEntities(30, 30, 30).size() == 0)
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_WITHER_SHOOT, SoundCategory.MASTER, 1, 1);
		
		for (Entity target : event.getPlayer().getNearbyEntities(30, 30, 30)) 
		{
			if (target instanceof LivingEntity)
			{	
				((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 600, 0));
				((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 600, 0));
				((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.BAD_OMEN, 600, 0));
				
			}  
		}	
		return true; 
	}

}
