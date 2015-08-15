package com.Lexer;

public class Num extends Token {
	public final int value;
	public Num(int v) {
		// TODO Auto-generated constructor stub
		super(Tag.NUM);
		value = v;
	}
	public String toString() {
		return "< "+Tag.getTagName(tag)+" , "+value+" >";
	}
}
