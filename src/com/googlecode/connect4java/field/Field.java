package com.googlecode.connect4java.field;

import java.awt.Point;
import java.io.IOException;
import java.util.Vector;

/**
 * Field
 * 
 * @author richard.stromer
 * @version 1.0.23
 * @since 0.1
 */
public class Field implements FieldInterface {
	private Vector<FieldListener> listeners;
	private boolean win;
	/**
	 * Saves the field.
	 */
	private FieldValue[][] field;
	
	/**
	 * Constructs a new empty field.
	 * 
	 * @since 0.1
	 */
	public Field() {
		listeners = new Vector<FieldListener>();
		win = false;
		field = new FieldValue[FIELD_WIDTH][FIELD_HEIGHT];
		for (int x = 0; x < FIELD_WIDTH; x++) {
			for (int y = 0; y < FIELD_HEIGHT; y++) {
				field[x][y] = FieldValue.EMPTY;
			}
		}
	}
	
	public void addFieldListener(FieldListener listener) {
		listeners.add(listener);
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
		if (!isColumnFull(column)) {
			set(column, getHeight(column), value);
			return true;
		}
		return false;
	}
	
	/**
	 * Sets the value at the given positon and checks if one player has won in this field.
	 * 
	 * @since 0.1
	 * @param column
	 * @param row
	 * @param value
	 */
	private void set(int column, int row, FieldValue value) {
		field[column][row] = value;
		if(!isWin()) {
			win = checkWin(column, row, value);
			fireFieldEvent(new FieldEvent(this));
		}
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
		for (int i = 0; i < FIELD_WIDTH; i++) {
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
		for (int row = 0; row < FIELD_HEIGHT
				&& get(column, row) != FieldValue.EMPTY; row++) {
			height++;
		}
		return height;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isColumnFull(int column) {
		if (getHeight(column) >= FIELD_HEIGHT) {
			return true;
		}
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDrawn() {
		if(isWin()) {
			return false;
		}
		for (int x = 0; x < FIELD_WIDTH; x++) {
			if (!isColumnFull(x)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param column
	 * @param row
	 * @param player
	 * @return
	 */
	public boolean checkWin(int column, int row, FieldValue player) {
		if (!player.equals(FieldValue.EMPTY)) {
			// System.out.print("checkWin: "+player+"@("+column+", "+row+") -> "+way.size()+"\t");
			// System.out.println();
			
			for (int x = column - 1; x < column + 2	&& x < FIELD_WIDTH; x++) {
				if (x >= 0) {
					for (int y = row - 1; (y < row + 2) && (y < FIELD_HEIGHT); y++) {
						if (y >= 0) {
							if (!(column == x && row == y)) { // nicht die aktuelle position -> endlos!
								if (get(x, y) == player) {
									Vector<Point> way = new Vector<Point>();
									way.add(new Point(column, row));
									way.add(new Point(x, y));
									if(checkWin2(way, player)) {
										return true;
									}
								}
							}
						}
					}
				}
			}
			// System.out.println("-------------");
		}
		return false;
	}
	/**
	 * 
	 * @param way
	 * @param player
	 * @return
	 */
	private boolean checkWin2(Vector<Point> way, FieldValue player) {
		Point pre = way.get(way.size() - 2);
		Point cur = way.get(way.size() - 1);
		// System.out.println("cur: ("+cur.x+", "+cur.y+") ... "+"pre: ("+pre.x+", "+pre.y+")");
		
		int dx = cur.x - pre.x;
		int dy = cur.y - pre.y;
		
		int x1 = cur.x + dx;
		int y1 = cur.y + dy;
		
		if (x1 >= 0 && x1 < FIELD_WIDTH && y1 >= 0 && y1 < FIELD_HEIGHT) {
			if (get(x1, y1) == player) {
				Point p1 = new Point(x1, y1);
				if (!way.contains(p1)) {
					way.add(p1);
					checkWin2(way, player);
				}
			}
		}
		
		int x2 = cur.x - dx;
		int y2 = cur.y - dy;
		
		if (x2 >= 0 && x2 < FIELD_WIDTH && y2 >= 0 && y2 < FIELD_HEIGHT) {
			if (get(x2, y2) == player) {
				Point p2 = new Point(x2, y2);
				if (!way.contains(p2)) {
					way.add(p2);
					checkWin2(way, player);
				}
			}
		}
		// for(Point w:way) {
		// System.out.print("("+w.x+", "+w.y+") ");
		// }System.out.println("\n-------- "+way.size()+" ----------");
		
		if (way.size() >= 4) {
			return true;
		}
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isWin() {
		return win;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reset() {
		win = false;
		for (int x = 0; x < FIELD_WIDTH; x++) {
			for (int y = 0; y < FIELD_HEIGHT; y++) {
				field[x][y] = FieldValue.EMPTY;
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doExport(String location) throws IOException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doImport(String location) throws IOException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field clone() {
		Field f = new Field();
		for (int row = 0; row < FIELD_HEIGHT; row++) {
			for (int column = 0; column < FIELD_WIDTH; column++) {
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
		for (int row = FIELD_HEIGHT - 1; row >= 0; row--) {
			for (int column = 0; column < FIELD_WIDTH; column++) {
				sb.append("(" + column + "|" + row + ")" + get(column, row)
						+ " ");
			}
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}
}
