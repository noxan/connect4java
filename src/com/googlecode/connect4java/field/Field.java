package com.googlecode.connect4java.field;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import jkit.gui.KitConsole;

import com.googlecode.connect4java.core.Core;

/**
 * Field
 * 
 * @author richard.stromer
 * @version 1.1b2(r31)
 * @since 0.1
 */
public class Field implements FieldInterface {
	private Queue<FieldListener> listeners;
	private FieldValue[][] field;
	private FieldStatus status;
	private ArrayList<Point> winTokens;
	
	/**
	 * Creates a new empty field.
	 * 
	 * @since 0.1
	 */
	public Field() {
		listeners = new LinkedList<FieldListener>();
		status = FieldStatus.NORMAL;
		field = new FieldValue[FIELD_WIDTH][FIELD_HEIGHT];
		resetField();
	}
	
	public void addFieldListener(FieldListener listener) {
		listeners.add(listener);
	}
	
	public void removeFieldListener(FieldListener listener) {
		listeners.remove(listener);
	}
	
	private void fireFieldEvent(FieldEvent event) {
		for(FieldListener listener:listeners) {
			listener.handleFieldEvent(event);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add(int column, FieldValue value) {
		if(!isColumnFull(column)) {
			set(column, getHeight(column), value);
			return true;
		}
		return false;
	}
	
	/**
	 * Sets the value at the given positon and checks if one player has won in
	 * this field.
	 * 
	 * @since 0.1
	 * @param column
	 * @param row
	 * @param value
	 */
	private void set(int column, int row, FieldValue value) {
		field[column][row] = value;
		if(!isWin()) {
			if(checkWin(column, row, value)) {
				status = FieldStatus.WIN;
			} else if(checkDrawn()) {
				status = FieldStatus.DRAWN;
			}
			fireFieldEvent(new FieldEvent(this, status));
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDrawn() {
		return FieldStatus.DRAWN.equals(status);
	}
	
	public boolean checkDrawn() {
		if(isWin()) {
			return false;
		}
		for(int x = 0; x<FIELD_WIDTH; x++) {
			if(!isColumnFull(x)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isWin() {
		return FieldStatus.WIN.equals(status);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<Point> getWinTokens() {
		return winTokens;
	}
	
	/**
	 * 
	 * @param column
	 * @param row
	 * @param player
	 * @return
	 */
	public boolean checkWin(int column, int row, FieldValue player) {
		if(Core.DEBUG) {
			KitConsole.out.print("checkWin: "+player+"@("+column+"|"+row+"): ");
		}
		if(FieldValue.EMPTY.equals(player)) { //empty point to check
			return false;
		}
		
		for(int x = (column<=0?column:column-1); x<=(column+1<FIELD_WIDTH?column+1:FIELD_WIDTH-1); x++) { //x -> [0;6], width=7
			for(int y = (row>0?row-1:row); y<=(row+1<FIELD_HEIGHT?row+1:FIELD_HEIGHT-1); y++) { //y -> [0;5], height=6
				if(get(x, y)==player) {
					if(Core.DEBUG) {
						System.out.print("("+x+"|"+y+")");
					}
					ArrayList<Point> points = new ArrayList<Point>();
					points.add(new Point(column, row));
					points.add(new Point(x, y));
					if(checkWin(points, player)) {
						winTokens = points;
						return true;
					}
				}
			}
		}
		if(Core.DEBUG) {
			System.out.println();
		}
		return false;
	}
	
	private boolean checkWin(ArrayList<Point> points, FieldValue player) {
		int dx = points.get(points.size()-1).x-points.get(points.size()-2).x;
		int dy = points.get(points.size()-1).y-points.get(points.size()-2).y;
		
		int x1 = points.get(points.size()-1).x+dx;
		int y1 = points.get(points.size()-1).y+dy;
		
		if(x1>=0&&x1<FIELD_WIDTH&&y1>=0&&y1<FIELD_HEIGHT) {
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
		
		if(x2>=0&&x2<FIELD_WIDTH&&y2>=0&&y2<FIELD_HEIGHT) {
			if(get(x2, y2)==player) {
				Point p2 = new Point(x2, y2);
				if(!points.contains(p2)) {
					points.add(p2);
					checkWin(points, player);
				}
			}
		}
		if(Core.DEBUG) {
			System.out.print(" size="+points.size());
		}
		return points.size()>=4;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reset() {
		status = FieldStatus.NORMAL;
		winTokens.clear();
		resetField();
	}
	
	private void resetField() {
		for(int x = 0; x<FIELD_WIDTH; x++) {
			for(int y = 0; y<FIELD_HEIGHT; y++) {
				field[x][y] = FieldValue.EMPTY;
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doExport(String location) throws IOException {
		throw new RuntimeException("not implemented yet");
		// TODO Auto-generated method stub
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doImport(String location) throws IOException {
		throw new RuntimeException("not implemented yet");
		// TODO Auto-generated method stub
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public FieldValue get(int column, int row) {
		return field[column][row];
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public FieldValue get(Point p) {
		return get(p.x, p.y);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public FieldValue[] getColumn(int column) {
		return field[column];
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public FieldValue[] getRow(int row) {
		FieldValue[] res = new FieldValue[FIELD_WIDTH];
		for(int i = 0; i<FIELD_WIDTH; i++) {
			res[i] = get(i, row);
		}
		return res;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getHeight(int column) {
		int height = 0;
		for(int row = 0; row<FIELD_HEIGHT&&get(column, row)!=FieldValue.EMPTY; row++) {
			height++;
		}
		return height;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isColumnFull(int column) {
		if(getHeight(column)>=FIELD_HEIGHT) {
			return true;
		}
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field clone() {
		Field f = new Field();
		f.status = status;
		for(int row = 0; row<FIELD_HEIGHT; row++) {
			for(int column = 0; column<FIELD_WIDTH; column++) {
				f.set(column, row, get(column, row));
			}
		}
		return f;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int row = FIELD_HEIGHT-1; row>=0; row--) {
			for(int column = 0; column<FIELD_WIDTH; column++) {
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
}
