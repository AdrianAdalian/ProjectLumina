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

public class SpellConstitution extends Spell
{

	public SpellConstitution()
	{
		super("Constitution", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fConstitution&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &aSupport&f &dAOE&f.",
				"&r&fRestore &aLife&f overtime to nearby players.",
				"&r&fDuration: 30 seconds.",
				"&r&fRange: 5 meters.",
				"&r&fMana cost: 200 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 200, 200, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		if (player.getNearbyEntities(5,5,5).size() == 0)
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		player.playSound(player.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, SoundCategory.MASTER, 1, 1);
		for (Entity target : player.getNearbyEntities(5,5,5))
		{
			if (!(target instanceof Player)) 
			{
				continue;
			}
			((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 600, 0));
		}
		return true;
	}

}
