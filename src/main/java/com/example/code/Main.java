package com.example.code;

import com.java.components.lang.StringBuilders;

import java.util.Arrays;

import static com.java.components.Prints.println;

public class Main {
	public static void main() {
		StringBuilders sbs = new StringBuilders("Hello--Hello--Hello--Hello");
		sbs.appendCodePoint(33);
		println(Arrays.toString(sbs.indexOfAll("He")));
		println(STR."\{sbs.lastIndexOf('H', 6)}: lastIndexOf(ch, int)");
		println(STR."\{sbs.reverseIndexOf(0, 'H', 7, 0, sbs.length())}: reverseIndexOf(ch, int)");
		println(sbs);
	}
}