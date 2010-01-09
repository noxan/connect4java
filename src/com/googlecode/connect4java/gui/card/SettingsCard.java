package com.googlecode.connect4java.gui.card;

import info.clearthought.layout.TableLayout;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jkit.pref.PreferenceChangeEvent;
import jkit.pref.PreferenceChangeListener;

import com.googlecode.connect4java.Main;
import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.listener.SettingsListener;

/**
 * 
 * @author richard.stromer
 * @version 0.8.17
 * @since 0.1
 */
public class SettingsCard extends AbstractCard {
	private static final long serialVersionUID = 1L;
	
	private JButton backButton;
	private JTable table;
	private DefaultTableModel model;
	
	public SettingsCard(MainGui gui) {
		super(gui);
		
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
		SettingsListener listener = new SettingsListener(this);
		Main.pref.addPreferenceChangeListener(new PreferenceChangeListener() {
			@Override public void preferenceChange(PreferenceChangeEvent evt) {
				updateTable();
			}
		});
		updateTable();
		
		table = new JTable(model);
		add(new JScrollPane(table), "1,1 , 3,1");
		
		backButton = new JButton("Back");
		backButton.setActionCommand("$b_back");
		backButton.addActionListener(listener);
		add(backButton, "3,3");
	}
	
	
	private void updateTable() {
		model = new DefaultTableModel(new String[]{"key", "value"}, 0) {
			private static final long serialVersionUID = 3102650059006418906L;
			@Override public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		for(String key:Main.pref.keySet()) {
			model.addRow(new String[]{key, Main.pref.get(key, "default")});
		}
		model.fireTableDataChanged();
	}
}
