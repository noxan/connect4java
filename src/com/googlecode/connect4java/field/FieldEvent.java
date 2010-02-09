package com.googlecode.connect4java.field;

import java.util.EventObject;

/**
 * 
 * @author richard.stromer
 * @version 1.0.25
 * @since 1.0.23
 */
public class FieldEvent extends EventObject {
	private static final long serialVersionUID = 1L;
	
	public FieldEvent(Field source) {
		super(source);
	}
}
