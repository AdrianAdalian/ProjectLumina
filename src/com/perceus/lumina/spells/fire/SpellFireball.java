package com.perceus.lumina.spells.fire;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellFireball extends Spell
{

	public SpellFireball()
	{
		super("Fireball", new String[] {"&r&7&ko&r&7&lSpell: &r&fFireball&r&7&ko&r",
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fSummons a small ball",
				"&r&fof fire that explodes on impact.",
				"&r&fMana cost: 5 &r&9mana&r&f.",
				"&r&fCooldown: 2 seconds."}, 5, 40, spelltype.FIRE);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		player.playSound(player.getLocation(), Sound.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1, 1);
		Fireball fireball = (Fireball) player.getWorld().spawnEntity(player.getEyeLocation().add(player.getEyeLocation().getDirection().normalize().multiply(1.5)), EntityType.FIREBALL);
		fireball.setYield(1);
		return true;
	}
}
