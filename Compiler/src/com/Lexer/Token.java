package com.Lexer;

import java.util.jar.Attributes.Name;

public class Token {
	public final int tag;
	public Token(int t) {
		// TODO Auto-generated constructor stub
		tag = t;
	}
	public String toString() {
		return "< "+Tag.getTagName(tag)+" >";
	}
}

