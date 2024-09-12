package com.example.code;

import com.java.components.lang.StringBuilders;

import static com.java.components.Prints.println;


public class Main {
	static String text = "Hello from World, for World; in the World!";

	public static void main() {
		StringBuilders stringBuilders = new StringBuilders(text);
		println(stringBuilders.replace(new StringBuilders.OnTargetListener() {
			@Override
			public String onTarget(String text) {
				if (text.contains("from")) {
					return "from";
				} else if (text.contains("in")) {
					return "in";
				} else {
					return "";
				}
			}
		}, "Test"));
	}
}