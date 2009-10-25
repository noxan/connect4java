package com.googlecode.connect4java.game;

import java.awt.Point;
import java.io.IOException;

/**
 * Field Interface
 * @author noxan
 * @version 0.0.1
 * @since 0.0.1
 * @see Field
 */
public interface FieldInterface {
	/**
	 * Field width (the number of columns)
	 */
	public static final short FIELD_WIDTH = 7;
	/**
	 * Field height (the number of rows)
	 */
	public static final short FIELD_HEIGHT = 6;
	
	/**
	 * Returns a row.
	 * @param row
	 * @return
	 * @throws FieldException
	 */
	public short[] getRow(short row) throws FieldException;
	/**
	 * Returns a column.
	 * @param column
	 * @return
	 * @throws FieldException
	 */
	public short[] getColumn(short column) throws FieldException;
	/**
	 * Returns the value at the given position.
	 * @param column
	 * @param row
	 * @return the value of this field
	 * @throws FieldException
	 */
	public short get(short column, short row) throws FieldException;
	/**
	 * Returns the value at the given point.
	 * @param p
	 * @return the value of this field
	 * @throws FieldException
	 */
	public short get(Point p)  throws FieldException;
	/**
	 * Returns the height of the given column (counts the pieces in this column).
	 * @param column
	 * @return the number of pieces in this column
	 * @throws FieldException
	 */
	public short getHeight(short column) throws FieldException;
	
	/**
	 * Adds a piece to the given column.
	 * @param column
	 * @return
	 * @throws FieldException
	 */
	public boolean add(short column, short value) throws FieldException;
	
	/**
	 * Resets this field.
	 * @since 0.0.1
	 */
	public void reset();
	
	/**
	 * Returns true if a player has won in this field.
	 * @return
	 * @since 0.0.1
	 */
	public boolean isWin();
	/**
	 * Returns true if every column is full and no player has won in this field, else returns false.
	 * @return 
	 * @since 0.0.1
	 * @throws FieldException
	 */
	public boolean isDraw() throws FieldException;
	/**
	 * Returns true if the hight of the given column is as great as <code>FIELD_HEIGHT</code>, else returns false.
	 * @param column 
	 * @return 
	 * @throws FieldException if column is greater than FIELD_WIDTH.
	 * @since 0.0.1
	 */
	public boolean isColumnFull(short column) throws FieldException;
	/**
	 * Exports this object to a given location.
	 * @throws IOException
	 */
	public void doExport() throws IOException;
	/**
	 * Imports this object from a given xml-file.
	 * @throws IOException
	 */
	public void doImport() throws IOException;
	/**
	 * Returns a string representation of the object.
	 * @since 0.0.1
	 * @return a string representating this object.
	 */
	public String toString();
	/**
	 * Creates and returns a copy of this object.
	 * @return a copy of this object
	 * @since 0.0.1
	 */
	public Field clone();
}
