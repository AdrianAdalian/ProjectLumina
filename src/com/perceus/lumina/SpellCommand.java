package com.perceus.lumina;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SpellCommand implements CommandExecutor , TabCompleter
{
	
	public SpellCommand() 
	{
		Bukkit.getPluginCommand("givespell").setTabCompleter(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args)
	{
		if (!(sender instanceof Player)) 
		{
			return false;
		}
		
		if (!sender.isOp()) 
		{
			return false;
		}
		Player player = (Player) sender;
		
		if (args.length == 0) 
		{
			return false;
		}
		
		if (SpellControlSystem.spell_registry.containsKey(args[0])) 
		{
			Spell spell = SpellControlSystem.spell_registry.get(args[0]);
			ItemStack stack = spell.getAsItemStack();
			player.getInventory().addItem(stack);
			return true;
		}
		else
		{
			player.sendMessage("Invalid Spell Name.");
		}
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args)
	{
		return new ArrayList<>(SpellControlSystem.spell_registry.keySet());
	}

}
