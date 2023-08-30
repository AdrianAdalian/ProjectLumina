package com.perceus.lumina.utils;

import java.util.Arrays;
import java.util.function.Consumer;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ColorableArmorMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;


public class ItemUtils
{
	/**
	 * Licenced under GNU GPL v3. If the root of this project does not contain a copy of the mentioned licence, a copy may be found at https://www.gnu.org/licenses/gpl-3.0.en.html.
	 * @author Khyonie (http://khyonieheart.coffee)
	 * @see <a href="https://www.gnu.org/licenses/gpl-3.0.en.html">GNU GPLv3</a>
	 */
	@SuppressWarnings("unchecked")
	public static <T extends ItemMeta> ItemStack buildItem(Material material, String name, int amount, Class<T> metaClass, Consumer<T> metaSetter, String... lore) 
	{
		ItemStack item = new ItemStack(material, amount);
		
		T meta = (T) item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(Arrays.asList(lore));
		
		if (metaSetter != null) 
		{
			metaSetter.accept(meta);
		}
		
		item.setItemMeta(meta);
		
		return item;
	}
	
	public static ItemStack buildArmorItem(Material material, String name, Color color, TrimMaterial trimMaterial, TrimPattern pattern, String... lore) 
	{
		return buildItem(material, name, 1, ColorableArmorMeta.class, (meta)-> 
		{
			meta.setColor(color);
			meta.setTrim(new ArmorTrim(trimMaterial ,pattern));
		}, lore);
		
	}
}
