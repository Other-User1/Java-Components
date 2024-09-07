package com.java.components.lang;

public non-sealed class StringBuilders extends AbstractStringBuilder {

	public StringBuilders() {
		super();
	}

	public StringBuilders(char c, Capacity capacity) {
		super(c, capacity);
	}

	public StringBuilders(String str, Capacity capacity) {
		super(str, capacity);
	}

	public StringBuilders(char[] chars, Capacity capacity) {
		this(chars, 0, capacity);
	}

	public StringBuilders(char[] chars, int offset, Capacity capacity) {
		this(chars, offset, chars.length - offset, capacity);
	}

	public StringBuilders(char[] chars, int offset, int length, Capacity capacity) {
		super(chars, offset, length, capacity);
	}

	public StringBuilders(String[] strings, Capacity capacity) {
		super(strings, capacity);
	}

	public StringBuilders(String[] strings, int offset, Capacity capacity) {
		super(strings, offset, capacity);
	}

	public StringBuilders(String[] strings, int offset, int length, Capacity capacity) {
		super(strings, offset, length, capacity);
	}

	public StringBuilders(char c) {
		super(c, new Capacity(0));
	}

	public StringBuilders(String str) {
		super(str, new Capacity(0));
	}

	public StringBuilders(char[] chars) {
		this(chars, 0, new Capacity(0));
	}

	public StringBuilders(char[] chars, int offset) {
		this(chars, offset, chars.length - offset, new Capacity(0));
	}

	public StringBuilders(char[] chars, int offset, int length) {
		super(chars, offset, length, new Capacity(0));
	}

	public StringBuilders(String[] strings) {
		super(strings, new Capacity(0));
	}

	public StringBuilders(String[] strings, int offset) {
		super(strings, offset, new Capacity(0));
	}

	public StringBuilders(String[] strings, int offset, int length) {
		super(strings, offset, length, new Capacity(0));
	}

	public interface Replacement {
		String replacement(String target);
	}
}
