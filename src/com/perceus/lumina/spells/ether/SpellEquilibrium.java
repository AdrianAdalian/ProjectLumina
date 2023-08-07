package com.perceus.lumina.spells.ether;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.wand.Wand;

public class SpellEquilibrium extends Spell
{

	public SpellEquilibrium()
	{
		super("Equilibrium", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fEquilibrium&r&7&ko&r",
				"&r&fElement: &r&9Ether&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fSacrifice 1 heart of &aHealth&f for 100 &9Mana&f.",
				"&r&fMana cost: 0 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 0, 20, spelltype.ETHER);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		player.playSound(player.getLocation(), Sound.ENTITY_ALLAY_HURT, SoundCategory.MASTER, 1, 1);
		player.damage(2);
		Wand wand = new Wand(event.getPlayer().getInventory().getItemInMainHand());
		wand.addMana(100);
		event.getPlayer().getInventory().setItemInMainHand(wand.getAsItemStack());
		
		return false;
	}

}
