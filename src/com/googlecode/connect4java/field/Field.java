package com.googlecode.connect4java.field;

import java.awt.Point;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Field
 * 
 * @author richard.stromer
 * @version 1.0.22
 * @since 0.1
 */
public class Field implements FieldInterface {
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
		field = new FieldValue[FIELD_WIDTH][FIELD_HEIGHT];
		for(int x=0;x<FIELD_WIDTH;x++) {
			for(int y=0;y<FIELD_HEIGHT;y++) {
				field[x][y] = FieldValue.EMPTY;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add(short column, FieldValue value) {
		if(!isColumnFull(column)) {
			set(column, getHeight(column), value);
			return true;
		}
		return false;
	}

	/**
	 * Sets the value at the given positon.
	 * 
	 * @since 0.1
	 * @param column
	 * @param row
	 * @param value
	 */
	private void set(short column, short row, FieldValue value) {
		checkWin(column, row, value);
		field[column][row] = value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FieldValue get(short column, short row) {
		return get((int)column, (int)row);
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
		return get((short) p.x, (short) p.y);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FieldValue[] getColumn(short column) {
		return field[column];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FieldValue[] getRow(short row) {
		FieldValue[] res = new FieldValue[FIELD_WIDTH];
		for (short s = 0; s < FIELD_WIDTH; s++) {
			res[s] = get(s, row);
		}
		return res;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public short getHeight(short column) {
		short height = 0;
		for (short row = 0; row < FIELD_HEIGHT
				&& get(column, row) != FieldValue.EMPTY; row++) {
			height++;
		}
		return height;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isColumnFull(short column) {
		if(getHeight(column) >= FIELD_HEIGHT) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDraw() {
		for (short x = 0; x < FIELD_WIDTH; x++) {
			if (!isColumnFull(x)) {
				return false;
			}
		}
		return true;
	}
	
	public void checkWin(short column, short row, FieldValue player) {
		if(!player.equals(FieldValue.EMPTY)) {
//	    	System.out.print("checkWin: "+player+"@("+column+", "+row+") -> "+way.size()+"\t");
//	    	System.out.println();
	    	
	    	for(short x=(short) (column-1); x<(short) (column+2) && x<FIELD_WIDTH; x++) {
	    		if(x>=0) {
	    			for(short y=(short) (row-1);y<(short) (row+2) && y<FIELD_HEIGHT;y++) {
	    				if(y>=0) {
	    					if(!(column==x && row==y)) { //nicht die aktuelle position -> endlos!
	    						if(get(x, y)==player) {
	    							Vector<Point> way = new Vector<Point>();
	    							way.add(new Point(column, row));
	    							way.add(new Point(x, y));
	    							checkWin2(way, player);
	    						}
	    					}
	    				}
	    			}
	    		}
	    	}
//	    	System.out.println("-------------");
		}
	}
    
    private void checkWin2(Vector<Point> way, FieldValue player) {
    	Point pre = way.get(way.size()-2);
		Point cur = way.get(way.size()-1);
//		System.out.println("cur: ("+cur.x+", "+cur.y+") ... "+"pre: ("+pre.x+", "+pre.y+")");
		
		short dx = (short) (cur.x-pre.x);
		short dy = (short) (cur.y-pre.y);
		
		short x1 = (short) (cur.x+dx);
		short y1 = (short) (cur.y+dy);
		
		if(x1>=0 && x1<FIELD_WIDTH && y1>=0 && y1<FIELD_HEIGHT) {
			if(get(x1, y1)==player) {
				Point p1 = new Point(x1, y1);
				if(!way.contains(p1)) {
					way.add(p1);
					checkWin2(way, player);
				}
			}
		}
		
		short x2 = (short) (cur.x-dx);
		short y2 = (short) (cur.y-dy);
		
		if(x2>=0 && x2<FIELD_WIDTH && y2>=0 && y2<FIELD_HEIGHT) {
			if(get(x2, y2)==player) {
				Point p2 = new Point(x2, y2);
				if(!way.contains(p2)) {
					way.add(p2);
					checkWin2(way, player);
				}
			}
		}
//		for(Point w:way) {
//			System.out.print("("+w.x+", "+w.y+") ");
//		}System.out.println("\n-------- "+way.size()+" ----------");
		
		if(way.size()>=4) {
			JOptionPane.showMessageDialog(new JFrame(), "Win! "+player);
			System.exit(0);
		}
    }
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isWin() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reset() {
		for (short x = 0; x < FIELD_WIDTH; x++) {
			for (short y = 0; y < FIELD_HEIGHT; y++) {
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
		for (short row = 0; row < FIELD_HEIGHT; row++) {
			for (short column = 0; column < FIELD_WIDTH; column++) {
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
		for (short row = FIELD_HEIGHT - 1; row >= 0; row--) {
			for (short column = 0; column < FIELD_WIDTH; column++) {
				sb.append("(" + column + "|" + row + ")" + get(column, row)
						+ " ");
			}
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}
}
