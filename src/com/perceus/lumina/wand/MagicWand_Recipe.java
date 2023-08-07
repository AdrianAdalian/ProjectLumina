package com.perceus.lumina.wand;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

import com.perceus.lumina.Lumina;

public class MagicWand_Recipe
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		final_item = new MagicWand().getAsItemStack();
	}
	
	public static void RegisterRecipe()
	{
		
		NamespacedKey key = new NamespacedKey(Lumina.instance, "magicwand");
		ShapelessRecipe recipe = new ShapelessRecipe(key, final_item);

		recipe.addIngredient(Material.STICK);
		recipe.addIngredient(Material.AMETHYST_SHARD);
		
		Bukkit.addRecipe(recipe);
		
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
