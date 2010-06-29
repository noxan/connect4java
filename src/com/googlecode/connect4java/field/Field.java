package com.googlecode.connect4java.field;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author richard.stromer
 * @version 1.1b4(r34)
 * @since 1.1b4(r34)
 */
public interface Field<E> extends Cloneable {
	public E get(int col, int row);
	public E get(Point p);
	
	public E[] getRow(int row);
	public E[] getColumn(int col);
	
	public int getWidth();
	public int getWidth(int row);
	public int getHeight();
	public int getHeight(int col);
	
	public boolean add(int col, E e);
	
	public boolean isColumnFull(int col);
	
	public boolean isDrawn();
	public boolean isWin();
	public ArrayList<Point> getWinTokens();
	
	public void reset();
	
	public void load(String location) throws IOException;
	public void save(String location) throws IOException;
	
	public boolean addFieldListener(FieldListener<E> l);
	public boolean removeFieldListener(FieldListener<E> l);
	
	public Field<E> clone();
	public boolean equals(Object obj);
	public String toString();
}
