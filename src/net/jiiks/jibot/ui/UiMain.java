package net.jiiks.jibot.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import java.awt.Component;
import javax.swing.SwingConstants;

public class UiMain extends JFrame	{
	private JTextField textField;
	
	public UiMain() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		getContentPane().add(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new MigLayout("insets 0", "[:624.00:250.00][grow]", "[300.00:370.00,grow]"));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "cell 0 0,grow");
		panel_2.setLayout(new MigLayout("insets 5", "[grow]", "[7.00][][][][grow]"));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, "cell 0 0,grow");
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblChannel = new JLabel("Channel:");
		panel_4.add(lblChannel, BorderLayout.WEST);
		
		textField = new JTextField();
		panel_4.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		panel_2.add(btnConnect, "cell 0 1,growx");
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, "cell 1 0,grow");
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		panel_3.add(textArea_1, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		panel_1.add(textArea);
		
		JLabel lblLog = new JLabel("LOG");
		lblLog.setHorizontalAlignment(SwingConstants.CENTER);
		lblLog.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(lblLog, BorderLayout.NORTH);
		setVisible(true);
		
		setSize(1000, 650);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);
	}
}
