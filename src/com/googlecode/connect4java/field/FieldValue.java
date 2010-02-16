package com.googlecode.connect4java.field;

/**
 * @author   richard.stromer
 * @version   1.0.25
 * @since   0.4.10
 */
public enum FieldValue {
	/**
	 * @uml.property  name="eMPTY"
	 * @uml.associationEnd  
	 */
	EMPTY(0), /**
	 * @uml.property  name="pLAYER1"
	 * @uml.associationEnd  
	 */
	PLAYER1(1), /**
	 * @uml.property  name="pLAYER2"
	 * @uml.associationEnd  
	 */
	PLAYER2(2);
	
	private FieldValue(int i) {
		
	}
}
