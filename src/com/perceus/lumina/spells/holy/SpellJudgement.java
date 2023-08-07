package com.perceus.lumina.spells.holy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellJudgement extends Spell
{

	public SpellJudgement()
	{
		super("Judgement", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fJudgement&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &cOffensive &6&lSignature&r&f.",
				"&r&fEnact divine judgement.",
				"&r&fIf target's health is <=25%, destroy target.",
				"&r&fIf target's health is >25%, heal target.", 
				"&r&fRange: 20 meters.",
				"&r&fMana cost: 250 &r&9mana&r&f."
		}, 250, 200, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 20);
		
		if (target == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		if (target instanceof LivingEntity) 
		{
			double healthPercent = ((LivingEntity) target).getHealth() / ((LivingEntity) target).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
			
			if (healthPercent <= 0.25)
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BELL_USE, SoundCategory.MASTER, 1, 1);
				target.getWorld().playSound(target.getLocation(), Sound.BLOCK_BELL_USE, SoundCategory.MASTER, 1, 1);
				((Damageable) target).damage(84);
				return true;
			}
			
			if (healthPercent > 0.75)
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
				target.getWorld().playSound(target.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
				((LivingEntity) target).setHealth(((LivingEntity) target).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
				return true;
			}	
		}
		return false;
	}

}
