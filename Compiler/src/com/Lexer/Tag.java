package com.Lexer;

public class Tag {
	public final static int 
		AND   = 256, BASIC = 257, BREAK = 258, DO   = 259, ELSE  = 260,
		EQ    = 261, FALSE = 262, GE    = 263, ID   = 264, IF    = 265,
		INDEX = 266, LE    = 267, MINUS = 268, NE   = 269, NUM   = 270,
		OR    = 271, REAL  = 272, TEMP  = 273, TRUE = 274, WHILE = 275;
	public static String getTagName(int tag) {
		switch (tag) {
		case AND:
			return "AND";
		case BASIC:
			return "BASIC";
		case BREAK:
			return "BREAK";
		case DO:
			return "DO";
		case ELSE:
			return "ELSE";
		case EQ:
			return "EQ";
		case FALSE:
			return "FALSE";
		case GE:
			return "GE";
		case ID:
			return "ID";
		case IF:
			return "IF";
		case INDEX:
			return "INDEX";
		case LE:
			return "LE";
		case MINUS:
			return "MINUS";
		case NE:
			return "NE";
		case NUM:
			return "NUM";
		case OR:
			return "OR";
		case REAL:
			return "REAL";
		case TEMP:
			return "TEMP";
		case TRUE:
			return "TRUE";
		case WHILE:
			return "WHILE";	
		default:
			return ""+(char)tag;
		}
		
	}
}
