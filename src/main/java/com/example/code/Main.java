package com.example.code;

import com.java.components.lang.StringBuilders;
import com.java.components.lang.StringBuildersUtils;

import java.util.Arrays;
import java.util.Locale;

import static com.java.components.Prints.println;

public class Main {
	public static void main() {
		StringBuilders sb = new StringBuilders("Hella--Helle--Helli--Hello--Hellu!");
		println(sb.toLowerCase(Locale.ENGLISH));
		println(sb);
		String s = "Hella--Helle--Helli--Hello--Hellu!";
		println(s.toLowerCase());
		println(s);
	}
}