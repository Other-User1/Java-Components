package com.example.code;

import com.java.components.lang.StringBuilders;

import java.util.Arrays;

import static com.java.components.Prints.print;
import static com.java.components.Prints.println;

public class Main {
	public static void main() {
		StringBuilders sbs = new StringBuilders("Hello--Hello--Hello--Hello--H");
		println(Arrays.toString(sbs.indexOfAll("Hello")));
		println(Arrays.toString(sbs.relativeIndexOfAll("Hello")));
		println(Arrays.toString(sbs.indexOfAll('H')));
		println(Arrays.toString(sbs.relativeIndexOfAll('H')));
		println(sbs.length());
		println(sbs);
	}
}