package com.googlecode.connect4java.field;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jkit.gui.KitConsole;

import com.googlecode.connect4java.core.Core;
import com.googlecode.connect4java.field.FieldValue;

/**
 * 
 * @author richard.stromer
 * @version 1.1b4(r34)
 * @since 1.1b4(r34)
 */
public class DefaultField implements Field<FieldValue>, FieldListener<FieldValue> {
	public static final int FIELD_WIDTH = 8;
	public static final int FIELD_HEIGHT = 7;
	
	private List<FieldListener<FieldValue>> listeners;
	private ArrayList<Point> tokens;
	private FieldValue[][] array;
	private FieldStatus status;
	private int width;
	private int height;
	
	public DefaultField() {
		this(FIELD_WIDTH, FIELD_HEIGHT, FieldStatus.NORMAL);
	}
	
	public DefaultField(int width, int height, FieldStatus status) {
		this.listeners = new LinkedList<FieldListener<FieldValue>>();
		this.array = new FieldValue[width][height];
		this.width = width;
		this.height = height;
		this.status = status;
		resetField();
		addFieldListener(this);
	}
	
	@Override
	public FieldValue get(int col, int row) {
		return array[col][row];
	}
	
	@Override
	public FieldValue get(Point p) {
		return get(p.x, p.y);
	}
	
	public FieldValue[] getRow(int row) {
		FieldValue[] res = new FieldValue[getWidth()];
		for(int i = 0; i<getWidth(); i++) {
			res[i] = get(i, row);
		}
		return res;
	}
	
	public FieldValue[] getColumn(int col) {
		return array[col];
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getWidth(int row) { // nobody needs this?!
		return -1;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getHeight(int col) {
		int res = 0;
		while(res<getHeight()&&!FieldValue.EMPTY.equals(get(col, res))) {
			res++;
		}
		return res;
	}
	
	protected void set(int col, int row, FieldValue e) {
		array[col][row] = e;
		fireTokenSetEvent(col, row, e);
	}
	
	protected void fireTokenSetEvent(int col, int row, FieldValue e) {
		for(int index = 0; index<listeners.size(); index++) {
			listeners.get(index).handleTokenSet(col, row, e);
		}
	}
	
	protected void fireStatusChangeEvent(FieldStatus status) {
		for(int index = 0; index<listeners.size(); index++) {
			listeners.get(index).handleStatusChange(status);
		}
	}
	
	public boolean add(int col, FieldValue e) {
		if(!isColumnFull(col)) {
			set(col, getHeight(col), e);
			return true;
		}
		return false;
	}
	
	public boolean isColumnFull(int col) {
		return getHeight(col)>=getHeight();
	}
	
	public boolean isDrawn() {
		return FieldStatus.DRAWN.equals(status);
	}
	
	public boolean isWin() {
		return FieldStatus.WIN.equals(status);
	}
	
	public ArrayList<Point> getWinTokens() {
		return tokens;
	}
	
	public void reset() {
		status = FieldStatus.NORMAL;
		resetField();
	}
	
	private void resetField() {
		for(int col = 0; col<getWidth(); col++) {
			for(int row = 0; row<getHeight(); row++) {
				set(col, row, FieldValue.EMPTY);
			}
		}
	}
	
	public void load(String location) throws IOException {
		throw new RuntimeException("not implemented yet");
		// TODO Auto-generated method stub
	}
	
	public void save(String location) throws IOException {
		throw new RuntimeException("not implemented yet");
		// TODO Auto-generated method stub
	}
	
	@Override
	public boolean addFieldListener(FieldListener<FieldValue> l) {
		return listeners.add(l);
	}
	
	@Override
	public boolean removeFieldListener(FieldListener<FieldValue> l) {
		return listeners.remove(l);
	}
	
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
	
	public DefaultField clone() {
		DefaultField field = new DefaultField(getWidth(), getHeight(), this.status);
		for(int row = 0; row<getHeight(); row++) {
			for(int col = 0; col<getWidth(); col++) {
				field.set(col, row, this.get(col, row));
			}
		}
		return field;
	}
	
	public String getString() {
		StringBuilder sb = new StringBuilder();
		for(int row = getHeight()-1; row>=0; row--) {
			for(int column = 0; column<getWidth(); column++) {
				sb.append("(");
				sb.append(column);
				sb.append("|");
				sb.append(row);
				sb.append(")");
				sb.append(get(column, row));
				sb.append(" ");
			}
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}
	
	public String toString() {
		return getClass().getName()+"["+hashCode()+"]";
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
