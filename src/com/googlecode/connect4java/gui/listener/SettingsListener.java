package com.googlecode.connect4java.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.googlecode.connect4java.core.Core;
import com.googlecode.connect4java.gui.GuiCard;
import com.googlecode.connect4java.gui.card.SettingsCard;

/**
 * 
 * @author richard.stromer
 * @version 1.1b5
 * @since 0.4
 */
public class SettingsListener extends AbstractListener<SettingsCard> implements ItemListener {
	public SettingsListener(SettingsCard card) {
		super(card);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand(); 
		
		if(action.equals("$b_save")) {
			HashMap<String, String> map = card.getSettingsChanges();
			for(String key:map.keySet()) {
				Core.pref.put(key, map.get(key));
			}
			card.clearSettingsChanges();
			card.getGui().showCard(GuiCard.MENU);
		} else if(action.equals("$b_back")) {
			if(card.getSettingsChanges().size()<1 || JOptionPane.showConfirmDialog(card.getGui().getFrame(), "Discard changes?", "Select an Option", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION) {
				card.clearSettingsChanges();
				card.getGui().showCard(GuiCard.MENU);
			}
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() instanceof JComboBox) {
			JComboBox box = (JComboBox) e.getSource();
			card.addSettingsChange(box.getName(), box.getSelectedItem().toString());
		}
	}
}
