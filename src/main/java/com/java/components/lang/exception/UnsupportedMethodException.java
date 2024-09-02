package com.java.components.lang.exception;

import com.java.components.lang.CompilerTaskException;

public class UnsupportedMethodException extends CompilerTaskException {
	public UnsupportedMethodException() {
		super();
	}

	public UnsupportedMethodException(Throwable cause) {
		super(cause);
		this.suppressed = new Throwable[] { cause };
	}

	public UnsupportedMethodException(String msg) {
		super(msg);
		this.message = msg;
	}

	public UnsupportedMethodException(String msg, Throwable cause) {
		super(msg, cause);
		this.suppressed = new Throwable[] { cause };
		this.message = msg;
	}

	public UnsupportedMethodException(String msg, Throwable[] cause) {
		super(msg, cause[0]);
		this.suppressed = cause;
		this.message = msg;
	}

	public UnsupportedMethodException(int msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedMethodException(int msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedMethodException(byte msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedMethodException(byte msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedMethodException(short msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedMethodException(short msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedMethodException(long msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedMethodException(long msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedMethodException(float msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedMethodException(float msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedMethodException(double msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedMethodException(double msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedMethodException(char msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedMethodException(char msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedMethodException(boolean msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedMethodException(boolean msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedMethodException(CharSequence msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedMethodException(CharSequence msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}
}
