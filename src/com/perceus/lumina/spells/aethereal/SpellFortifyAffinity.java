package com.perceus.lumina.spells.aethereal;

import org.bukkit.enchantments.Enchantment;

import com.perceus.lumina.SpellControlSystem.spelltype;
import com.perceus.lumina.utils.ItemEnchantUtility;

public class SpellFortifyAffinity extends ItemEnchantUtility
{

	public SpellFortifyAffinity()
	{
		super("FortifyAffinity", new String[] {
				"&r&f&ko&r&bAethereal Spell&f: Fortify Affinity&r&f&ko&r",
				"&r&fElement: &r&b&l&oAethereal&r&f.",
				"&r&fSpell Type: &bUtility&f.",
				"&r&fEnchant offhand applicable item with aqua affinity.",
				"&r&fMana cost: 500 &r&9mana&r&f.",
				"&r&fCooldown: 5 seconds."
		}, 500, 100, spelltype.AETHEREAL, Enchantment.WATER_WORKER);
	}

}
