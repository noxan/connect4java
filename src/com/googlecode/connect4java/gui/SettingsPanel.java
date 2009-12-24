package com.googlecode.connect4java.gui;

import info.clearthought.layout.TableLayout;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.googlecode.connect4java.listener.SettingsListener;

/**
 * 
 * @author noxan
 * @version 0.4.10
 * @since 0.1
 */
public class SettingsPanel extends AbstractPanel {
	private static final long serialVersionUID = 1L;
	
	private SettingsListener listener;
	
	private JButton backButton;
	private JTable table;
	
	public SettingsPanel(MainGUI gui) {
		super(gui, new Color(200, 50, 50));
		listener = new SettingsListener(gui);
		
		initLayout();
		initComponents();
	}
	
	private void initLayout() {
		double[][] size = {{MainGUI.MARGIN, TableLayout.FILL, 5, 100, MainGUI.MARGIN}, 
				{100, TableLayout.FILL, 5, TableLayout.PREFERRED, MainGUI.MARGIN}};
		setLayout(new TableLayout(size));
	}

	private void initComponents() {
		
		
		table = new JTable(new DefaultTableModel(new String[]{"key", "value"}, 5));
		add(new JScrollPane(table), "1,1 , 3,1");
		
		backButton = new JButton("Back");
		backButton.setActionCommand("$b_back");
		backButton.addActionListener(listener);
		add(backButton, "3,3");
	}
}
