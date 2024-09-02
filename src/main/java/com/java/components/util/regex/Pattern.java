package com.java.components.util.regex;

public class Pattern {
	public static void compile(String text) {
		for (int i = 0; i < text.length(); i++) {
			switch (text.charAt(i)) {
				case 'a':
				case '\\': return;
			}
		}
	}
}
