package com.Lexer;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class Lexer {
	public static int line = 1;  //record the line number
	char peek = ' ';             //current character read
	Hashtable<String, Word> reservedIdentifiers = new Hashtable<>();   //reserved keywords
	
	public Lexer() {
		// add the reserved identifiers to the hashtable
		reserve(new Word(Tag.IF,"if"));
		reserve(new Word(Tag.ELSE,"else"));
		reserve(new Word(Tag.WHILE, "while"));
		reserve(new Word(Tag.DO, "do"));
		reserve(new Word(Tag.BREAK, "break"));
		
		//boolean
		reserve(new Word(Tag.TRUE, "true"));
		reserve(new Word(Tag.FALSE, "false"));
		
		//relationship operation
		reserve(new Word(Tag.AND,"&&"));
		reserve(new Word(Tag.OR, "||"));
		reserve(new Word(Tag.EQ, "=="));
		reserve(new Word(Tag.NE, "!="));
		reserve(new Word(Tag.LE, "<="));
		reserve(new Word(Tag.GE, ">="));
	}
	private void reserve(Word w) {
		reservedIdentifiers.put(w.lexeme,w);
	}
	
	//read the next char 
	private void readChar() throws IOException {
		peek = (char)System.in.read();
	}
	
	//read the next char to see if it eauals to c
	private boolean checkChar (char c) throws IOException{
		readChar();
		if(peek!=c) return false;
		peek = ' ';
		return true;
	}
	
	//check the char whether as an number
	private boolean isNumber(char c) {
		if (c>='0'&&c<='9') {
			return true;
		}
		return false;
	}
	
	//check the char whether as letter
	private boolean isLetter(char c) {
		if ((c>='a'&&c<='z')||(c>='A'&&c<='Z')||c=='_') {
			return true;
		}
		return false;
	}
	
	//get the next token
	public Token scan() throws IOException {
		//reduce the white space ,if it's a new line then add the line number
		for( ; ;readChar()){
			if (peek == ' '||peek == '\t') {
				continue;
			}else if (peek == '\n') {
				line++;
			}else {
				break;
			}
		}
		//get the operation 
		switch (peek) {
		case '&':
			if (checkChar('&')) {
				return Word.and;
			}else {
				return new Token('&');
			}
		case '|':
			if (checkChar('|')) {
				return Word.or;
			}else {
				return new Token('|');
			}
		case '=':
			if (checkChar('=')) {
				return Word.eq;
			}else {
				return new Token('=');
			}
		case '!':
			if (checkChar('=')) {
				return Word.ne;
			}else {
				return new Token('!');
			}
		case '>':
			if (checkChar('=')) {
				return Word.ge;
			}else {
				return new Token('>');
			}
		case '<':
			if (checkChar('=')) {
				return Word.le;
			}else {
				return new Token('<');
			}
		case '~': return new Token('~');
		case '^': return new Token('^');
		case '+': return new Token('+');
		case '-': return new Token('-');
		case '*': return new Token('*');
		case '/': return new Token('/');
		case '%': return new Token('%');
		}
		//get the number
		if (isNumber(peek)) {
			int v = 0;
			do {
				v = 10*v + Character.digit(peek, 10);
				readChar();
			} while (isNumber(peek));
			if (peek!='.') {
				return new Num(v);
			}
			//the number is a real
			float x = v;
			float d = 10;
			for(;;){
				readChar();
				if (!isNumber(peek)) {
					break;
				}
				x = x+Character.digit(peek, 10)/d;
				d *= 10;
			}
			return new Real(x);
		}
		//get the identifier
		if (isLetter(peek)) {
			StringBuilder sb = new StringBuilder();
			do {
				sb.append(peek);
				readChar();
			} while (isLetter(peek));
			String s = sb.toString();
			Word word = (Word)reservedIdentifiers.get(s);
			if (word!=null) {
				return word;               //it's in the reservedIdentitiers
			}
			word = new Word(Tag.ID, s);
			reservedIdentifiers.put(s, word); //add to the hashtable
			return word;
		}
		// other characters 
		Token token = new Token(peek);
		peek = ' ';      //indicates the character has been visited
		return token;	
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Lexer lex = new Lexer();
		Token tok = lex.scan();
		while(tok!=null){
			System.out.println(tok.toString());
			tok = lex.scan();
		}
		
	}

}
