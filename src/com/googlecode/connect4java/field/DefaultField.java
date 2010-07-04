package com.googlecode.connect4java.field;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

import jkit.gui.KitConsole;

import com.googlecode.connect4java.core.Core;

/**
 * 
 * @author richard.stromer
 * @version 1.1b4(r34)
 * @since 1.1b4(r34)
 */
public class DefaultField extends AbstractField<FieldValue> implements FieldListener<FieldValue> {
	public static final int FIELD_WIDTH = 8;
	public static final int FIELD_HEIGHT = 7;
	
	private ArrayList<Point> tokens;
	private FieldStatus status;
	
	public DefaultField() {
		this(FIELD_WIDTH, FIELD_HEIGHT, FieldStatus.NORMAL);
	}
	
	public DefaultField(int width, int height, FieldStatus status) {
		super(width, height);
		this.status = status;
		resetField();
		addFieldListener(this);
	}
	
	@Override
	public boolean isDrawn() {
		return FieldStatus.DRAWN.equals(status);
	}
	
	@Override
	public boolean isWin() {
		return FieldStatus.WIN.equals(status);
	}
	
	@Override
	public ArrayList<Point> getWinTokens() {
		return tokens;
	}
	
	@Override
	public void reset() {
		status = FieldStatus.NORMAL;
		resetField();
	}
	
	@Override
	public void load(String location) throws IOException {
		throw new UnsupportedOperationException("not implemented yet");
		// TODO Auto-generated method stub
	}
	
	@Override
	public void save(String location) throws IOException {
		throw new UnsupportedOperationException("not implemented yet");
		// TODO Auto-generated method stub
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof DefaultField) {
			DefaultField field = (DefaultField)obj;
			for(int row = getHeight()-1; row>=0; row--) {
				for(int col = 0; col<getWidth(); col++) {
					if(!get(col, row).equals(field.get(col, row))) {
						return false;
					}
				}
			}
			return true;
		}
		return super.equals(obj);
	}
	
	@Override
	public DefaultField clone() {
		DefaultField field = new DefaultField(getWidth(), getHeight(), this.status);
		for(int row = 0; row<getHeight(); row++) {
			for(int col = 0; col<getWidth(); col++) {
				field.set(col, row, this.get(col, row));
			}
		}
		return field;
	}
	
	@Override
	public void handleTokenSet(int col, int row, FieldValue e) {
		if(FieldStatus.NORMAL.equals(status)) {
			if(checkDrawn()) {
				status = FieldStatus.DRAWN;
			} else if(checkWin(col, row, e)) {
				status = FieldStatus.WIN;
			}
		}
	}
	
	@Override
	public void handleStatusChange(FieldStatus status) {
	}
	
	private void resetField() {
		for(int col = 0; col<getWidth(); col++) {
			for(int row = 0; row<getHeight(); row++) {
				set(col, row, FieldValue.EMPTY);
			}
		}
	}
	
	private boolean checkWin(int column, int row, FieldValue player) {
		if(Core.DEBUG) {
			KitConsole.out.print("checkWin: "+player+"@("+column+"|"+row+"): ");
		}
		if(FieldValue.EMPTY.equals(player)) { // empty point to check
			return false;
		}
		for(int x = (column<=0?column:column-1); x<=(column+1<getWidth()?column+1:getWidth()-1); x++) { // x -> [0;6], width=7
			for(int y = (row>0?row-1:row); y<=(row+1<getHeight()?row+1:getHeight()-1); y++) { // y -> [0;5], height=6
				if(get(x, y)==player) {
					if(Core.DEBUG) {
						KitConsole.out.print("("+x+"|"+y+")");
					}
					ArrayList<Point> points = new ArrayList<Point>();
					points.add(new Point(column, row));
					points.add(new Point(x, y));
					if(checkWin(points, player)) {
						tokens = points;
						return true;
					}
				}
			}
		}
		if(Core.DEBUG) {
			KitConsole.out.println();
		}
		return false;
	}
	
	private boolean checkWin(ArrayList<Point> points, FieldValue player) {
		int dx = points.get(points.size()-1).x-points.get(points.size()-2).x;
		int dy = points.get(points.size()-1).y-points.get(points.size()-2).y;
		
		int x1 = points.get(points.size()-1).x+dx;
		int y1 = points.get(points.size()-1).y+dy;
		
		if(x1>=0&&x1<getWidth()&&y1>=0&&y1<getHeight()) {
			if(get(x1, y1)==player) {
				Point p1 = new Point(x1, y1);
				if(!points.contains(p1)) {
					points.add(p1);
					checkWin(points, player);
				}
			}
		}
		
		int x2 = points.get(points.size()-1).x-dx;
		int y2 = points.get(points.size()-1).y-dy;
		
		if(x2>=0&&x2<getWidth()&&y2>=0&&y2<getHeight()) {
			if(get(x2, y2)==player) {
				Point p2 = new Point(x2, y2);
				if(!points.contains(p2)) {
					points.add(p2);
					checkWin(points, player);
				}
			}
		}
		if(Core.DEBUG) {
			KitConsole.out.print(" size="+points.size());
		}
		return points.size()>=4;
	}
	
	private boolean checkDrawn() {
		for(int x = 0; x<getWidth(); x++) {
			if(!isColumnFull(x)) {
				return false;
			}
		}
		return true;
	}
}
