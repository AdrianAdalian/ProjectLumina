package com.perceus.lumina.spells.fire;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellDragonBreath extends Spell
{

	public SpellDragonBreath()
	{
		super("DragonBreath", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fDragon Breath&r&7&ko&r",
				"&r&fElement: &r&cFire&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fSummons Dragon Breath that leaves", 
				"&r&fbehind a damaging &dAOE&f upon impact.",
				"&r&fMana cost: 30 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 30, 100, spelltype.FIRE);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_SHOOT, SoundCategory.MASTER, 1, 1);
		DragonFireball fireball = (DragonFireball) player.getWorld().spawnEntity(player.getEyeLocation().add(player.getEyeLocation().getDirection().normalize().multiply(1.5)), EntityType.DRAGON_FIREBALL);
		fireball.setYield(1);
		return false;
	}

}
