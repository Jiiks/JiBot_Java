/*
 * 06/09/2015
 */

package net.jiiks.jibot;

import java.io.File;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

public class Config {

	public static String admin = "";
	public static String me = "";
	public static String server = "";
	public static int port = 6667;
	public static String oauth = "";
	public static final double version = 0.1;
	public static final String stage = "b";
	public static final SimpleDateFormat twitchDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	public static String secret = "";
	
	public static class Paths {
		public static String home;
		public static String data;
	}
	
	public static class Files {
		
	}
	
	public static class Urls {
		public static String twitchApi = "https://api.twitch.tv/kraken/";
		public static String channelApi = twitchApi + "channels/";
		public static String streamApi = twitchApi + "streams/";
		public static String gitHub = "https://github.com/JiBot_Java";
	}
	
	public static boolean init() {
		try {
			File jar = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
			Paths.home = jar.getParentFile().getPath() + "/";
			Paths.data = Paths.home + "data/";
			
			return true;
		}catch(URISyntaxException e) {
			e.printStackTrace();
		}
		
		return false;
	}


}
