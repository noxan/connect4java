package com.googlecode.connect4java.gui.card;

import info.clearthought.layout.TableLayout;

import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.listener.SettingsListener;

/**
 * 
 * @author richard.stromer
 * @version 1.1b5
 * @since 0.1
 */
public class SettingsCard extends AbstractCard {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, String> changes;
	
	private JTabbedPane tabbedPane;
	
	private JComboBox guiLookAndFeelBox;
	
	private JButton backButton;
	private JButton saveButton;
	
	public SettingsCard(MainGui gui) {
		super(gui);
		
		changes = new HashMap<String, String>();
		
		initLayout();
		initComponents();
	}
	
	private void initLayout() {
		double[][] size = {{MainGui.MARGIN, TableLayout.FILL, 5, 100, 5, 100, MainGui.MARGIN}, 
				{100, TableLayout.FILL, 5, TableLayout.PREFERRED, MainGui.MARGIN}};
		setLayout(new TableLayout(size));
	}
	
	@Override
	protected void initComponents() {
		SettingsListener listener = new SettingsListener(this);
		
		tabbedPane = new JTabbedPane();
		
		//general
		JPanel generalPanel = new JPanel();
		generalPanel.setName("General");
		tabbedPane.add(generalPanel);
		//gui
		JPanel guiPanel = new JPanel(new TableLayout(new double[][] {{5, TableLayout.PREFERRED, 5, TableLayout.FILL, 5}, {5, TableLayout.PREFERRED, 5}}));
		guiPanel.setName("GUI");
		guiPanel.add(new JLabel("LookAndFeel"), "1,1");
		DefaultComboBoxModel guiLookAndFeelBoxModel = new DefaultComboBoxModel();
		for(LookAndFeelInfo lafinfo:UIManager.getInstalledLookAndFeels()) {
			guiLookAndFeelBoxModel.addElement(lafinfo.getClassName());
		}
		guiLookAndFeelBox = new JComboBox(guiLookAndFeelBoxModel);
		guiLookAndFeelBox.setName("gui.laf");
		guiLookAndFeelBox.addItemListener(listener);
		guiPanel.add(guiLookAndFeelBox, "3,1");
		tabbedPane.add(guiPanel);
		
		add(tabbedPane, "1,1 , 5,1");
		
		backButton = new JButton("Back");
		backButton.setActionCommand("$b_back");
		backButton.addActionListener(listener);
		add(backButton, "3,3");

		saveButton = new JButton("Save");
		saveButton.setActionCommand("$b_save");
		saveButton.addActionListener(listener);
		add(saveButton, "5,3");
	}
	
	public String getLookAndFeelBoxValue() {
		return (String)guiLookAndFeelBox.getSelectedItem();
	}
	
	public String addSettingsChange(String key, String value) {
		return changes.put(key, value);
	}
	public HashMap<String, String> getSettingsChanges() {
		return changes;
	}
	public void clearSettingsChanges() {
		changes.clear();
	}
	@Override
	public void update() {
	}
}
