package com.java.components.lang;

public non-sealed class StringBuilders extends AbstractStringBuilder {

	public StringBuilders() {
		super();
	}

	public StringBuilders(String str) {
		super(str);
	}

	public StringBuilders(char[] chars) {
		this(chars, 0);
	}

	public StringBuilders(char[] chars, int offset) {
		this(chars, offset, chars.length - offset);
	}

	public StringBuilders(char[] chars, int offset, int length) {
		super(chars, offset, length);
	}

	public StringBuilders(String[] strings) {
		super(strings);
	}

	public StringBuilders(String[] strings, int offset) {
		super(strings, offset);
	}

	public StringBuilders(String[] strings, int offset, int length) {
		super(strings, offset, length);
	}
}
