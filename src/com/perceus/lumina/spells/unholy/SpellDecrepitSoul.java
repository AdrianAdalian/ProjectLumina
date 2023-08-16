package com.perceus.lumina.spells.unholy;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;

public class SpellDecrepitSoul extends Spell
{

	public SpellDecrepitSoul()
	{
		super("DecrepitSoul", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fDecrepit Soul&r&7&ko&r",
				"&r&fElement: &r&4&o&lUnholy&r&f.",
				"&r&fSpell Type: &cOffensive&6&l Signature&r&f.",
				"&r&fCast a lost soul that explodes on impact.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 2 seconds."
		}, 50, 40, spelltype.UNHOLY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		WitherSkull ws = (WitherSkull) player.launchProjectile(WitherSkull.class);
		player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT, SoundCategory.MASTER, 1, 1);
		ws.setYield(5);
		ws.setGravity(true);
		ws.setIsIncendiary(true);
		return true;
	}

}
