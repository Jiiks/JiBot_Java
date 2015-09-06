package net.jiiks.jibot.bot;

public class Message {

	public boolean broadcaster;
	public boolean mod;
	public boolean subscriber;
	public boolean turbo;
	
	public String nick;
	public String channel;
	public String message;
	public String command;
	public String action;
	
	public Message(String _message) {
		
		String tags = _message.split(" ")[0];
		String rest = _message.replace(tags, "");
		
		channel = rest.split(" ")[3];
		message = rest.split(" ")[4].substring(1);
		command = message.split(" ")[0];
		action = message.replace(command, "");
		
		for(String tag : tags.split(";")) {
			String key = tag.split("=")[0];

			switch(key) {
			case "display-name":
				nick = tag.split("=")[1];
				break;
			case "subscriber":
				subscriber = Integer.parseInt(tag.split("=")[1]) == 1 ? true : false;
				break;
			case "turbo":
				turbo = Integer.parseInt(tag.split("=")[1]) == 1 ? true : false;
				break;
			case "user-type":
				mod = tag.split("=")[1].contains("mod");
				broadcaster = tag.split("=")[1].contains("broadcaster");
				break;
			}
			
		}
		
		
	}
	
}
