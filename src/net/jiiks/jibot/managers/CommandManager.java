package net.jiiks.jibot.managers;

import java.util.ArrayList;
import java.util.List;

import net.jiiks.jibot.bot.ICommand;
import net.jiiks.jibot.bot.Message;

public class CommandManager {

	private static CommandManager commandManager;
	
	private List<ICommand> commands;
	
	public static CommandManager getCommandManager() {
		return commandManager == null ? commandManager = new CommandManager() : commandManager;
	}
	
	public CommandManager() {
		commands = new ArrayList<ICommand>();	
	}
	
	public List<ICommand> getCommands() {
		return commands;
	}
	
	public String getAction(Message m) {	
		for(ICommand command : commands) {
			if(command.command().equals(m.command)) {
				return command.action(m);
			}
		}
		
		return null;
	}
}
