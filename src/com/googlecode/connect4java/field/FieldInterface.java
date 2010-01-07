package com.googlecode.connect4java.field;

import java.awt.Point;
import java.io.IOException;

/**
 * Field Interface
 * @author noxan
 * @version 0.4.10
 * @since 0.1
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
	 * @since 0.1
	 * @param row
	 * @return
	 */
	public FieldValue[] getRow(short row);
	/**
	 * Returns a column.
	 * @since 0.1
	 * @param column
	 * @return
	 */
	public FieldValue[] getColumn(short column);
	/**
	 * Returns the value at the given position.
	 * @since 0.1
	 * @param column
	 * @param row
	 * @return the value of this field
	 */
	public FieldValue get(short column, short row) ;
	/**
	 * Returns the value at the given point.
	 * @since 0.1
	 * @param p
	 * @return the value of this field
	 */
	public FieldValue get(Point p)  ;
	/**
	 * Returns the height of the given column (counts the pieces in this column).
	 * @since 0.1
	 * @param column
	 * @return the number of pieces in this column
	 */
	public short getHeight(short column) ;
	
	/**
	 * Adds a piece to the given column.
	 * @since 0.1
	 * @param column
	 * @return 
	 */
	public boolean add(short column, FieldValue value) ;
	
	/**
	 * Resets this field.
	 * @since 0.1
	 */
	public void reset();
	
	/**
	 * Returns true if a player has won in this field.
	 * @since 0.1
	 * @return 
	 */
	public boolean isWin();
	/**
	 * Returns true if every column is full and no player has won in this field, else returns false.
	 * @since 0.1
	 * @return 
	 */
	public boolean isDraw() ;
	/**
	 * Returns true if the hight of the given column is as great as <code>FIELD_HEIGHT</code>, else returns false.
	 * @since 0.1
	 * @param column 
	 * @return 
	 */
	public boolean isColumnFull(short column) ;
	/**
	 * Exports this object to a given location.
	 * @since 0.1
	 * @throws IOException
	 */
	public void doExport(String location) throws IOException;
	/**
	 * Imports this object from a given xml-file.
	 * @since 0.1
	 * @throws IOException
	 */
	public void doImport(String location) throws IOException;
	/**
	 * Returns a string representation of the object.
	 * @since 0.1
	 * @return a string representating this object.
	 */
	public String toString();
	/**
	 * Creates and returns a copy of this object.
	 * @since 0.1
	 * @return a copy of this object
	 */
	public Field clone();
}
