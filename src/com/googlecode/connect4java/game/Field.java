package com.googlecode.connect4java.game;

import java.awt.Point;
import java.io.IOException;

/**
 * Field
 * @author noxan
 * @version 0.0.1
 * @since 0.0.1
 */
public class Field implements FieldInterface {
	/**
	 * Speichert das Spielfeld.
	 */
	private short[][] field;
	
	/**
	 * Constructs a new empty field.
	 * @since 0.0.1
	 */
	public Field() {
		field = new short[FIELD_WIDTH][FIELD_HEIGHT];
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add(short column, short value) throws FieldException {
		if(column>FIELD_WIDTH) throw new FieldException();
		if(!isColumnFull(column)) {
			field[column][getHeight(column)] = value;
			return true;
		}
		return false;
	}
	/**
	 * Sets the value at the given positon.
	 * @param column
	 * @param row
	 * @param value
	 * @since 0.0.1
	 */
	private void set(short column, short row, short value) {
		field[column][row] = value;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public short get(short column, short row) throws FieldException {
		return field[column][row];
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public short get(Point p) throws FieldException {
		return get((short)p.x, (short)p.y);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public short[] getColumn(short column) throws FieldException {
		return field[column];
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public short[] getRow(short row) throws FieldException {
		short[] res = new short[FIELD_WIDTH];
		for(short s=0;s<FIELD_WIDTH;s++) {
			res[s] = get(s, row);
		}
		return res;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public short getHeight(short column) throws FieldException {
		short height = 0;
		for(short row=0;row<FIELD_HEIGHT && get(column, row)>0;row++) {
			height++;
		}
		return height;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isColumnFull(short column) throws FieldException {
		if(getHeight(column)>=FIELD_HEIGHT) {
			return true;
		}
		return false;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDraw() throws FieldException {
		for(short x=0;x<FIELD_WIDTH;x++) {
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
		// TODO isWin()
		return false;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reset() {
		for(short x=0;x<FIELD_WIDTH;x++) {
			for(short y=0;y<FIELD_HEIGHT;y++) {
				field[x][y] = 0;
			}
		}
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doExport() throws IOException {
		// TODO Auto-generated method stub
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doImport() throws IOException {
		// TODO Auto-generated method stub
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field clone() {
		Field f = new Field();
		for(short row=0;row<FIELD_HEIGHT;row++) {
			for(short column=0;column<FIELD_WIDTH;column++) {
				try {
					f.set(column, row, get(column, row));
				} catch (FieldException e) {
					f.set(column, row, (short) -1);
				}
			}
		}
		return null;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(short row=FIELD_HEIGHT-1;row>=0;row--) {
			for(short column=0;column<FIELD_WIDTH;column++) {
				try {
					sb.append("("+column+"|"+row+")"+get(column, row)+" ");
				} catch (FieldException e) {
					sb.append("E");
				}
			}
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}
}
