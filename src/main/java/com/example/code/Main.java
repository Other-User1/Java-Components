package com.example.code;

import com.java.components.lang.StringBuilders;

import static com.java.components.Prints.println;


public class Main {

	public static void main() {
		StringBuilders stringBuilders = new StringBuilders("Hello from World, for World; in the World!");
		println(stringBuilders.replace(new StringBuilders.OnTargetListener() {
			@Override
			public String onTarget(String text) {
				if (text.contains("World")) {
					return "World";
				}
				if (text.contains("in")) {
					return "in";
				}
				return "";
			}
		}, "Test"));
	}
}