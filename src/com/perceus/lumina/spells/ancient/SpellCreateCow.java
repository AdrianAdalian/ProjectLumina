package com.perceus.lumina.spells.ancient;

import org.bukkit.entity.EntityType;

import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.EntitySpawnUtility;

public class SpellCreateCow extends EntitySpawnUtility
{
	public SpellCreateCow()
	{
		super("CreateCow", new String[] {
				"&r&f&ko&r&e&lRune&f: Materialize Cow&r&f&ko&r",
				"&r&fElement: &r&eAncient&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fSummon a cow to target block.",
				"&r&fMana cost: 50 &r&9mana&r&f.",
				"&r&fCooldown: 1 second."
		}, 50, 20, spelltype.ANCIENT, EntityType.COW);
	}
}