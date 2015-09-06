package net.jiiks.jibot;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.jiiks.jibot.ui.UiMain;

import org.pushingpixels.substance.api.skin.SubstanceGraphiteGlassLookAndFeel;

public class Main {

	public static void main(String[] args) {
		
		new Main();
		
	}
	
	public Main() {
		
		
		
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
		
		

		
	}
	
}
