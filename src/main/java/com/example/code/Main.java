package com.example.code;

import com.java.components.lang.StringBuilders;
import static com.java.components.Prints.println;

public class Main {
	public static void main() {
		StringBuilders sbs = new StringBuilders("Hello, Hello, Hello");
		println(sbs.replaceLast('H', 1, 'h'));
		println(sbs);
	}
}