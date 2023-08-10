package com.perceus.lumina;

import java.util.HashSet;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpellKitCommand implements CommandExecutor
{
	private static HashSet<UUID> playerregistry = new HashSet<>(); 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args)
	{
		Player player = (Player) sender;
		if (playerregistry.contains(player.getUniqueId()) && !player.isOp()) 
		{
			player.sendMessage("You've already used this command before, thus you may not use it again. If you believe this is an error, please contact administration.");
			return false;
		}
		playerregistry.add(player.getUniqueId());
		LuminaGui.openGUI(player, Bukkit.createInventory(null, 27, "Lumina GUI: Choose a Spell"));	
		return true;
	}

}
