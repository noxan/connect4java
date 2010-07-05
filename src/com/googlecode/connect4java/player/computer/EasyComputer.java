package com.googlecode.connect4java.player.computer;

import java.awt.Color;
import java.util.Random;

import com.googlecode.connect4java.field.Field;
import com.googlecode.connect4java.field.FieldValue;

/**
 * 
 * @author richard.stromer
 * @version 1.1b5
 * @since 1.1
 */
public class EasyComputer extends AbstractComputer {
	public EasyComputer(Color color) {
		super("Computer (Easy)", color);
	}

	@Override
	public int getTurn(Field<FieldValue> field) { // range: 0 -> integer.max
		int[] rate = new int[field.getWidth()];
		int result = 0;
		for(int col=0;col<field.getWidth();col++) {
			if(!field.isColumnFull(col)) {
				rate[col] = rateColumn(field, col);
			}
		}
		int rate_cur = rate[0];
		for(int index=0;index<rate.length;index++) {
			if(rate[index]>rate_cur) {
				rate_cur = rate[index];
				result = index;
			}
		}
		if(rate_cur==-1) {
			result = randomColumn(field.getWidth());
		}
		return result;
	}
	
	private int randomColumn(int max) {
		return new Random().nextInt(max-1);
	}
	
	private int rateColumn(Field<FieldValue> field, int col) {
		int height = field.getHeight(col);
		FieldValue value = field.get(col, height);
		System.out.println(col+", "+height+" -> "+value);
		return -1;
	}
	
	
}
