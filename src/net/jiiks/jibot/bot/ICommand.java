package net.jiiks.jibot.bot;

public interface ICommand {

	public String author();
	public String name();
	public double version();
	public String description();
	
	public String command();
	public boolean enabled();
	public void enable();
	public void disable();
	
	public String action(Message m);
	
}
