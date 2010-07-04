package com.googlecode.connect4java.field;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractField<E> implements Field<E> {
	private List<FieldListener<E>> listeners;
	private E[][] array;
	private int width;
	private int height;
	
	@SuppressWarnings("unchecked")
	public AbstractField(int width, int height) {
		setWidth(width);
		setHeight(height);
		listeners = new LinkedList<FieldListener<E>>();
		array = (E[][])new Object[getWidth()][getHeight()];
	}
	
	@Override
	public boolean addFieldListener(FieldListener<E> l) {
		return listeners.add(l);
	}
	
	public boolean removeFieldListener(FieldListener<E> l) {
		return listeners.remove(l);
	}
	
	@Override
	public E get(int col, int row) {
		return array[col][row];
	}
	
	@Override
	public E get(Point p) {
		return get(p.x, p.y);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public E[] getRow(int row) {
		E[] result = (E[])new Object[getWidth()];
		for(int col = 0; col<getWidth(); col++) {
			result[col] = get(col, row);
		}
		return result;
	}
	
	@Override
	public E[] getColumn(int col) {
		return array[col];
	}
	
	private void setWidth(int width) {
		this.width = width;
	}
	
	@Override
	public int getWidth() {
		return width;
	}
	
	private void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	public int getHeight(int col) {
		int res = 0;
		while(res<getHeight()&&!FieldValue.EMPTY.equals(get(col, res))) {
			res++;
		}
		return res;
	}
	
	protected void set(int col, int row, E e) {
		array[col][row] = e;
		fireTokenSetEvent(col, row, e);
	}
	
	protected void fireTokenSetEvent(int col, int row, E e) {
		for(int index = 0; index<listeners.size(); index++) {
			listeners.get(index).handleTokenSet(col, row, e);
		}
	}
	
	protected void fireStatusChangeEvent(FieldStatus status) {
		for(int index = 0; index<listeners.size(); index++) {
			listeners.get(index).handleStatusChange(status);
		}
	}
	
	@Override
	public boolean add(int col, E e) {
		if(!isColumnFull(col)) {
			set(col, getHeight(col), e);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isColumnFull(int col) {
		return getHeight(col)>=getHeight();
	}
	
	@Override
	public abstract Field<E> clone();
	
	@Override
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
	
	@Override
	public String toString() {
		return getClass().getName()+"@"+hashCode();
	}
}
