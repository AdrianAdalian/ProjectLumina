package com.perceus.lumina.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.perceus.lumina.utils.DataUtils.DType;



public class DataContainerCheatSheet
{
	public void cheatSheet() 
	{
		ItemStack stack = new ItemStack(Material.GRASS_BLOCK);
		DataUtils.set("Key", DType.STRING, "Value", stack);
		
		DataUtils.get("Key", stack).asString();
		
		DataUtils.has("Key", stack);
	}
}
