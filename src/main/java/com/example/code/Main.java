package com.example.code;

import com.java.components.lang.StringBuilders;

import java.util.Arrays;

import static com.java.components.Prints.println;

public class Main {
	public static void main() {
		StringBuilders sb = new StringBuilders("Hello,-World!");
		println(Arrays.toString(sb.split(2)));
	}
}