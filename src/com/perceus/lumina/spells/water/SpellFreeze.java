package com.perceus.lumina.spells.water;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellFreeze extends Spell
{

	public SpellFreeze()
	{
		super("Freeze", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fFrostbite&r&7&ko&r",
				"&r&fElement: &r&9Water&r&f.",
				"&r&fSpell Type: &bUtility&f and &7&lCurse&r&f.",
				"&r&fAcutely &b&lFreeze&r&f target water source.",
				"&r&fIf not targeting a block, &b&lFreeze&r&f target mob.",
				"&r&fRange: 7 meters.",
				"&r&fMana cost: 5 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 5, 20, spelltype.WATER);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		
		Entity target = GetNearestEntity.getNearestEntityInSight(player, 15);
		
		if (target == null) 
		{			
			Block block = player.getTargetBlock(null, 7);
			if (!block.getType().equals(Material.WATER)) 
			{
				player.sendMessage("Invalid Target");
			}
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.AMBIENT_UNDERWATER_EXIT, SoundCategory.MASTER, 1, 1);
			block.getRelative(block.getFace(block)).setType(Material.ICE);
			
			return true;
		}
		if (target instanceof LivingEntity) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.AMBIENT_UNDERWATER_EXIT, SoundCategory.MASTER, 1, 1);
			((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 99));
			((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 2));
			return true;
		}
		player.sendMessage("Fizzle!");
		return false;
	}

}
