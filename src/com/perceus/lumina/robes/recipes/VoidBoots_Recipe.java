package com.perceus.lumina.robes.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ColorableArmorMeta;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;

import com.perceus.lumina.Lumina;
import com.perceus.lumina.utils.DataUtils;
import com.perceus.lumina.utils.ItemUtils;
import com.perceus.lumina.utils.PrintUtils;
import com.perceus.lumina.utils.DataUtils.DType;

public class VoidBoots_Recipe
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		final_item = ItemUtils.buildItem(Material.LEATHER_BOOTS, PrintUtils.ColorParser("&r&fVoid Boots"), 1, ColorableArmorMeta.class, (meta) -> {
		      meta.setColor(Color.TEAL);
		      meta.setTrim(new ArmorTrim(TrimMaterial.DIAMOND, TrimPattern.SENTRY));

		      DataUtils.set("void_armor", DType.STRING, "magic_armor", meta);
		    });
	}
	
	public static void Register() 
	{
		NamespacedKey k = new NamespacedKey(Lumina.instance, "void_boots");
		ShapelessRecipe r = new ShapelessRecipe(k, final_item);
		
		r.addIngredient(Material.LEATHER_BOOTS);
		r.addIngredient(Material.ENDER_PEARL);
		
		Bukkit.addRecipe(r);
	}
	
	public static ItemStack getFinal_item() 
	{
		return final_item;
	}
}
