package com.perceus.lumina.spells.void_spells;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.GetNearestEntity;

public class SpellCrush extends Spell
{

	public SpellCrush()
	{
		super("Crush", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fCrush&r&7&ko&r",
				"&r&fElement: &r&3&lVOID&r&f.",
				"&r&fSpell Type: &cOffensive&d AOE&f.",
				"&r&fSummon a collapsing singularity upon any target.",
				"&r&fThose affected are dealt 2 hearts of &r&cdamage&r&f.",
				"&r&fCast Range: 40 meters.",
				"&r&fField Range: 7 meters.",
				"&r&fMana cost: 200 &r&9mana&r&f.",
				"&r&fCooldown: 3 seconds."
		}, 200, 60, spelltype.VOID);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity InitialTarget = GetNearestEntity.getNearestEntityInSight(player, 40);
		
		if (InitialTarget == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		if (InitialTarget.getNearbyEntities(7, 7, 7).size() == 0)
		{
			player.sendMessage("No Surrounding Targets Detected");
			return false;
		}
		player.playSound(player.getLocation(), Sound.ENTITY_SHULKER_SHOOT, SoundCategory.MASTER, 1, 1);
		for (Entity TargetsOfTarget : InitialTarget.getNearbyEntities(7, 7, 7)) 
		{
			TargetsOfTarget.setVelocity(InitialTarget.getLocation().toVector().subtract(TargetsOfTarget.getLocation().toVector()).normalize().multiply(5));
			if(!(TargetsOfTarget instanceof LivingEntity)) 
			{ 
				continue; 
			}
			((LivingEntity) TargetsOfTarget).damage(4);
			((LivingEntity) InitialTarget).damage(4);
			
		}
		
		return true;
		
	}

}
