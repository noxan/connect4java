package com.googlecode.connect4java.swing;

import info.clearthought.layout.TableLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import com.googlecode.connect4java.img.ImageLoader;
import com.googlecode.connect4java.pref.Version;

/**
 * 
 * @author noxan
 * @version 0.5.11
 * @since 0.5.11
 */
public class JStatusBar extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel statusLabel;
	private JLabel statusVersionLabel;
	private JLabel statusIconLabel;
	
	public JStatusBar() {
		super();
		double[][] size = {{2, TableLayout.FILL, 2, TableLayout.PREFERRED, 10, TableLayout.PREFERRED, 2}, 
				{TableLayout.PREFERRED, 2, TableLayout.PREFERRED}};
		
		setLayout(new TableLayout(size));
		
		add(new JSeparator(), "0,0 , 6,0");
		statusLabel = new JLabel();
		add(statusLabel, "1,2");
		
		statusVersionLabel = new JLabel("v"+Version.string());
		statusVersionLabel.setEnabled(false);
		add(statusVersionLabel, "3,2");
		
		statusIconLabel = new JLabel();
		add(statusIconLabel, "5,2");
		
		setStatus("Ready", false);
	}
	
	public void setLoading(boolean b) {
		if(b) {
			statusIconLabel.setIcon(ImageLoader.load("loading.gif"));
		} else {
			statusIconLabel.setIcon(ImageLoader.load("loaded.gif"));
		}
	}
	public void setStatus(String msg) {
		statusLabel.setText(msg);
	}
	public void setStatus(String msg, boolean loading) {
		setStatus(msg);
		setLoading(loading);
	}
}
