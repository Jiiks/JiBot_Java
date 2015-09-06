/*
 * 06/09/2015
 */

package net.jiiks.jibot.bot;

import java.io.IOException;

import net.jiiks.jibot.Config;
import net.jiiks.jibot.managers.CommandManager;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import org.jibble.pircbot.PircBot;

public class BotMain extends PircBot{

	private static BotMain bot;
	
	public static BotMain getBot() {
		return bot == null ? bot = new BotMain() : bot;
	}
	
	/**
	 * Connect with loaded settings
	 */
	public void doConnect() {
		doConnect(Config.server, Config.me, Config.port, Config.oauth);
	}
	
	/**
	 * @param server Server host
	 * @param user Username
	 * @param port Port
	 * @param pw Password
	 */
	public void doConnect(final String server, final String user, final int port, final String pw) {
		doConnect(server, user, port, pw, new String[]{""});
	}
	
	/**
	 * @param server Server host
	 * @param user Username
	 * @param port Port
	 * @param pw Password
	 * @param autojoin Array of channels to autojoin
	 */
	public void doConnect(final String server, final String user, final int port, final String pw, final String[] autojoin) {
		setName(user);

		try {
			connect(server, port, pw);
		} catch (NickAlreadyInUseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IrcException e) {
			e.printStackTrace();
		}
		
		for(String channel : autojoin) {
			doJoin(channel);
		}
	}
	
	/**
	 * Add # if missing
	 * @param channel channel name
	 */
	public void doJoin(String channel) {
		joinChannel(channel.startsWith("#") ? channel : "#" + channel);
	}
	
	public void doSend(String channel, String message) {
		sendMessage(channel.startsWith("#") ? channel : "#" + channel, message);
	}
	
	/*
	 * On Connect event
	 * Request membership, commands and tags
	 * @see org.jibble.pircbot.PircBot#onConnect()
	 */
	public void onConnect() {
		
		sendRawLine("CAP REQ :twitch.tv/membership");
		sendRawLine("CAP REQ :twitch.tv/commands");
		sendRawLine("CAP REQ :twitch.tv/tags");
	}

	/*
	 * Well handle the line ourselves
	 * @see org.jibble.pircbot.PircBot#handleLine(java.lang.String)
	 */
	public void handleLine(String line) {
		System.out.println(line);
		if(line.contains("PRIVMSG")){ 
			Message m = new Message(line);
			String action = CommandManager.getCommandManager().getAction(m);
			
			if(action != null) {
				doSend(m.channel, action);
			}
			
		}
		
		
	}
}