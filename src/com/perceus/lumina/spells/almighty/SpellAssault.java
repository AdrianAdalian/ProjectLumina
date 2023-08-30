package com.perceus.lumina.spells.almighty;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.perceus.lumina.Spell;
import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.GetNearestEntity;
import com.perceus.lumina.utils.SpellParticle;

public class SpellAssault extends Spell
{

	public SpellAssault()
	{
		super("Assault", new String[] {
				"&r&7&ko&r&7&lSpell: &r&fAssault&r&7&ko&r",
				"&r&fElement: &r&f&lΔlmιghτγ&r&f.",
				"&r&fSpell Type: &cOffensive&f.",
				"&r&fStrike target entity within melee range,",
				"&r&fdealing 5 hearts of &cdamage&f.",
				"&r&fMana cost: 100 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 100, 20, spelltype.ALMIGHTY);
	}

	@Override
	public boolean Cast(Player player, PlayerInteractEvent event)
	{
		Entity t = GetNearestEntity.getNearestEntityInSight(player, 5);
		if (t == null) 
		{
			player.sendMessage("Invalid Target");
			return false;
		}
		player.playSound(player.getLocation(), Sound.ENTITY_ARMOR_STAND_HIT, SoundCategory.MASTER, 1, 1);
		player.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, t.getLocation().add(new Location(t.getWorld(), 0, 1, 0)), 1);
		((Damageable) t).damage(10);
		SpellParticle.drawLine(player.getLocation(), t.getLocation(), 1, Particle.WHITE_ASH, null);
		return true;
	}

}
