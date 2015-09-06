/*
 * 06/09/2015
 */
package net.jiiks.jibot;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.jiiks.jibot.bot.BotMain;
import net.jiiks.jibot.managers.CommandManager;
import net.jiiks.jibot.stock.CommandWr;
import net.jiiks.jibot.ui.UiMain;

import org.pushingpixels.substance.api.skin.SubstanceGraphiteGlassLookAndFeel;

public class Main {

	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {

		if(!Config.init()) {
			System.out.println("Failed to initialize");
			return;
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					UIManager.setLookAndFeel(new SubstanceGraphiteGlassLookAndFeel());
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				
				UiMain _ui = new UiMain();
			}
		});
		
		BotMain bot = BotMain.getBot();
		bot.setVerbose(true);
		bot.doConnect();
	}
}