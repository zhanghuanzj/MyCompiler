package com.Lexer;

public class Word extends Token {
	public final String lexeme;
	public static final Word
		and = new Word(Tag.AND, "&&"), or = new Word(Tag.OR, "||"),
		eq = new Word(Tag.EQ, "=="),  ne = new Word(Tag.NE, "!="),
		le = new Word(Tag.LE, "<="),  ge = new Word(Tag.GE, ">="),
		minus = new Word(Tag.MINUS, "minus"),
		True = new Word(Tag.TRUE, "true"),
		False = new Word(Tag.FALSE,"false"),
		temp = new Word(Tag.TEMP, "t");
	
	public Word(int tag,String s) {
		// TODO Auto-generated constructor stub
		super(tag);
		lexeme = s;
	}
	public String toString() {
		return "<"+Tag.getTagName(tag)+","+lexeme+">";
	}
}
