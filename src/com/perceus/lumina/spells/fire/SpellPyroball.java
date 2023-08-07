package com.perceus.lumina.spells.fire;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellPyroball extends Spell
{

	public SpellPyroball()
	{
		super("Pyroball", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fPyroball&r&7&ko&r",
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fSummons a large ball of fire that explodes on impact.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 10 seconds."
		}, 50, 200, spelltype.FIRE);
	}
	
	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		player.playSound(player.getLocation(), Sound.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1, 1);
		LargeFireball fireball = (LargeFireball) player.getWorld().spawnEntity(player.getEyeLocation().add(player.getEyeLocation().getDirection().normalize().multiply(1.5)), EntityType.FIREBALL);
		fireball.setYield(3);
		fireball.setIsIncendiary(true);
		return true;
	}

}
