package com.java.components.util.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pattern {
	private final String input;

	public Pattern(String s) {
		input = s;
	}

	public static void main(String[] args) {
		Pattern p = new Pattern("(ab)(cd)");
		System.out.println(Arrays.toString(p.groups().toArray()));
	}

	private ArrayList<String> groups() {
		return new ParenthesisGroup(input).groups();
	}

	public static Pattern compile(String regex) {
		return new Pattern(regex);
	}

	protected interface Groups {
		ArrayList<String> groups();
	}

	protected static class ParenthesisGroup implements Groups {
		private final String group;
		private int position;

		public ParenthesisGroup(String group) {
			this.group = group;
			position = 0;
		}

		@Override
		public ArrayList<String> groups() {
			ArrayList<String> list = new ArrayList<>();
			for (int i = 0; i < group.length(); i++) {
				if (group.charAt(i) == '(') position++;
				if (group.charAt(i) == ')') position--;
				if (position == 0) {
					list.add(group.substring(i - 2, i));
				};
			}
			return list;
		}
	}
}
