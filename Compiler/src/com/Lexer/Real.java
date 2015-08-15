package com.Lexer;

public class Real extends Token {
	public final float value;
	public Real(float f) {
		// TODO Auto-generated constructor stub
		super(Tag.REAL);
		value = f;
	}
	public String toStirng() {
		return "< "+Tag.getTagName(tag)+" , "+value+" >";		
	}
}
