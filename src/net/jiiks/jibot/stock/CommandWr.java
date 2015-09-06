package net.jiiks.jibot.stock;

import net.jiiks.jibot.bot.ICommand;
import net.jiiks.jibot.bot.Message;

public class CommandWr implements ICommand {

	private boolean e = true;
	
	@Override
	public String author() {
		return "Jiiks";
	}

	@Override
	public String name() {
		return "WR Command";
	}

	@Override
	public double version() {
		return 1.0;
	}

	@Override
	public String command() {
		return "!wr";
	}

	@Override
	public boolean enabled() {
		return e;
	}

	@Override
	public String action(Message m) {
		return "WORLD RECORD PLUGIN!";
	}

	@Override
	public void enable() {
		e = true;
	}

	@Override
	public void disable() {
		e = false;
	}

	@Override
	public String description() {
		return "Attempts to get speedrun world record for game";
	}

}
