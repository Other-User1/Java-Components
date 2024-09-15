package com.example.code;

import com.java.components.lang.StringBuilders;
import org.jetbrains.annotations.Contract;

import static com.java.components.Prints.println;

public class Main {

	@Contract(pure = true)
	public static void main(String[] args) {
		StringBuilders STR = new StringBuilders();
		println(STR.append("Hello").append("World").toString());
	}
}