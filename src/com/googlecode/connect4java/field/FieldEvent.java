package com.googlecode.connect4java.field;

import java.util.EventObject;

/**
 * FieldEvent
 * @author richard.stromer
 * @version 0.1.29b1
 * @since 1.0.23
 */
public class FieldEvent extends EventObject {
	private static final long serialVersionUID = 1L;
	private FieldStatus status;
	
	public FieldEvent(Field source, FieldStatus status) {
		super(source);
		this.status = status;
	}
	/**
	 * @since 1.0.27
	 * @return
	 */
	public boolean isWin() {
		return FieldStatus.WIN.equals(status);
	}
	/**
	 * @since 1.0.29
	 * @return
	 */
	public boolean isDrawn() {
		return FieldStatus.DRAWN.equals(status);
	}
	
	@Override
	public String toString() {
		return getClass().getName()+"["+source.hashCode()+" | "+status+"]";
	}
}
