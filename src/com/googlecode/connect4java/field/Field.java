package com.googlecode.connect4java.field;

import java.awt.Point;
import java.io.IOException;

/**
 * Field
 * 
 * @author richard.stromer
 * @version 0.8.20
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
			field[column][getHeight(column)] = value;
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
