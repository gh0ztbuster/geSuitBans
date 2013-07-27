package com.minecraftdimensions.bungeesuitebans;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class KickAllCommand implements CommandExecutor {

	BungeeSuiteBans plugin;

	private static final String[] PERMISSION_NODES = { "bungeesuite.ban.kickall", "bungeesuite.ban.*", "bungeesuite.admin", "bungeesuite.*" };

	public KickAllCommand(BungeeSuiteBans bungeeSuiteBans){
		plugin = bungeeSuiteBans;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!CommandUtil.hasPermission(sender, PERMISSION_NODES)) {
			plugin.utils.getMessage(sender.getName(), "NO_PERMISSION");
			return true;
		}
		String msg = "";
		if(args.length>0){
			for(String data: args){
				msg+=data+" ";
			}
		}
		plugin.utils.kickAll(msg);
		return false;
	}

}