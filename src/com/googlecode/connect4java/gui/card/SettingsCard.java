package com.googlecode.connect4java.gui.card;

import info.clearthought.layout.TableLayout;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.listener.SettingsListener;

/**
 * 
 * @author noxan
 * @version 0.6.12
 * @since 0.1
 */
public class SettingsCard extends AbstractCard {
	private static final long serialVersionUID = 1L;
	
	private JButton backButton;
	private JTable table;
	
	public SettingsCard(MainGui gui) {
		super(gui, new SettingsListener(gui));
		
		initLayout();
		initComponents();
	}
	
	private void initLayout() {
		double[][] size = {{MainGui.MARGIN, TableLayout.FILL, 5, 100, MainGui.MARGIN}, 
				{100, TableLayout.FILL, 5, TableLayout.PREFERRED, MainGui.MARGIN}};
		setLayout(new TableLayout(size));
	}
	
	@Override
	protected void initComponents() {
		table = new JTable(new DefaultTableModel(new String[]{"key", "value"}, 5));
		add(new JScrollPane(table), "1,1 , 3,1");
		
		backButton = new JButton("Back");
		backButton.setActionCommand("$b_back");
		backButton.addActionListener(listener);
		add(backButton, "3,3");
	}
}
