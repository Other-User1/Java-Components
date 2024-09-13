package com.java.components.util;

import static com.java.components.Prints.print;
import static com.java.components.Prints.println;

public class Formatter {
	private String input;

	public Formatter(String text) {
		this.input = text;
	}

	public String format(Object... args) {
		println(args.length);
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < args.length; j++) {
				char ch = input.charAt(i);
				if (ch == '$') {
					ch = input.charAt(i + 1);
					if (ch == '{') {
						ch = input.charAt(i + 2);
						print(ch);
						if (j > 8) {
							ch = input.charAt(i + 3);
							if ((String.valueOf(ch) + input.charAt(i + 4)).equals(String.valueOf(j))) {
								input = input.substring(0, i) + args[j] + input.substring(i + 7);
							}
						}/* else if (ch == String.valueOf(j).charAt(0)) {
							input = input.substring(0, i) + args[j] + input.substring(i + 4);
						}*/
					}
				}
			}
		}
		return input;
	}
}
