package com.java.components.lang.exception;

import com.java.components.lang.CompilerTaskException;

public class UnsupportedException extends CompilerTaskException {
	public UnsupportedException() {
		super();
	}

	public UnsupportedException(Throwable cause) {
		super(cause);
		this.suppressed = new Throwable[] { cause };
	}

	public UnsupportedException(String msg) {
		super(msg);
		this.message = msg;
	}

	public UnsupportedException(String msg, Throwable cause) {
		super(msg, cause);
		this.suppressed = new Throwable[] { cause };
		this.message = msg;
	}

	public UnsupportedException(String msg, Throwable[] cause) {
		super(msg, cause[0]);
		this.suppressed = cause;
		this.message = msg;
	}

	public UnsupportedException(int msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedException(int msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedException(byte msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedException(byte msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedException(short msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedException(short msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedException(long msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedException(long msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedException(float msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedException(float msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedException(double msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedException(double msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedException(char msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedException(char msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedException(boolean msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedException(boolean msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedException(CharSequence msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedException(CharSequence msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}
}
