package com.example.code;

import com.java.components.lang.StringBuilders;
import com.java.components.util.Formatter;

import static com.java.components.Prints.println;

public class Main {
	public static void main(String[] args) {
		StringBuilders stringBuilders = new StringBuilders("Hello World, for World!"); // custom class
		println(stringBuilders.replace("World", new StringBuilders.OnReplacementListener() {
			@Override
			public String onReplacement(String target, int position) {
				if (position == 1) {
					return "Planet";
				}
				return "Java";
			}
		})); // output: Hello Java, for Planet!
	}
}