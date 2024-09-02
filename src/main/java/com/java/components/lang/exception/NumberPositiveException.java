package com.java.components.lang.exception;

import com.java.components.lang.CompilerTaskException;

public class NumberPositiveException extends CompilerTaskException {
	public NumberPositiveException() {
		super();
	}

	public NumberPositiveException(Throwable cause) {
		super(cause);
		this.suppressed = new Throwable[] { cause };
	}

	public NumberPositiveException(String msg) {
		super(msg);
		this.message = msg;
	}

	public NumberPositiveException(String msg, Throwable cause) {
		super(msg, cause);
		this.suppressed = new Throwable[] { cause };
		this.message = msg;
	}

	public NumberPositiveException(String msg, Throwable[] cause) {
		super(msg, cause[0]);
		this.suppressed = cause;
		this.message = msg;
	}

	public NumberPositiveException(int msg) {
		this(String.valueOf(msg));
	}

	public NumberPositiveException(int msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NumberPositiveException(byte msg) {
		this(String.valueOf(msg));
	}

	public NumberPositiveException(byte msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NumberPositiveException(short msg) {
		this(String.valueOf(msg));
	}

	public NumberPositiveException(short msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NumberPositiveException(long msg) {
		this(String.valueOf(msg));
	}

	public NumberPositiveException(long msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NumberPositiveException(float msg) {
		this(String.valueOf(msg));
	}

	public NumberPositiveException(float msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NumberPositiveException(double msg) {
		this(String.valueOf(msg));
	}

	public NumberPositiveException(double msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NumberPositiveException(char msg) {
		this(String.valueOf(msg));
	}

	public NumberPositiveException(char msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NumberPositiveException(boolean msg) {
		this(String.valueOf(msg));
	}

	public NumberPositiveException(boolean msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NumberPositiveException(CharSequence msg) {
		this(String.valueOf(msg));
	}

	public NumberPositiveException(CharSequence msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}
}
