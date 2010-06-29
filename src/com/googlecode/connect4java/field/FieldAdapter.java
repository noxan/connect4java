package com.googlecode.connect4java.field;

/**
 * 
 * @author richard.stromer
 * @version 1.1b4(r34)
 * @since 1.1b4(r34)
 */
public class FieldAdapter<E> implements FieldListener<E> {
	@Override
	public void handleTokenSet(int col, int row, E e) {
	}
	@Override
	public void handleStatusChange(FieldStatus status) {
	}
}
