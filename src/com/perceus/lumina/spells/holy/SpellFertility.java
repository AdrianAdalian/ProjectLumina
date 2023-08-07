package com.perceus.lumina.spells.holy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Breedable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.perceus.lumina.GetNearestEntity;
import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellFertility extends Spell
{

	public SpellFertility()
	{
		super("Fertility", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fFertility&r&7&ko&r",
				"&r&fElement: &r&f&o&lHoly&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fSet target Livestock to breedable.",
				"&r&fRange: 10 meters.",
				"&r&fMana cost: 10 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 10, 20, spelltype.HOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{

		Entity target = GetNearestEntity.getNearestEntityInSight(player, 10);
		
		if (target == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		
		if (target instanceof Breedable && !((Breedable) target).canBreed()) 
		{
			((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100, 0));
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			((Breedable) target).setBreed(true);
			return true;
		}
		
		player.sendMessage("Fizzle!");
		return false;
	}

}
