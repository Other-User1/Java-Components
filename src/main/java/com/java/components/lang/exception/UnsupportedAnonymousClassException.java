package com.java.components.lang.exception;

import com.java.components.lang.CompilerTaskException;

public class UnsupportedAnonymousClassException extends CompilerTaskException {
	public UnsupportedAnonymousClassException() {
		super();
	}

	public UnsupportedAnonymousClassException(Throwable cause) {
		super(cause);
		this.suppressed = new Throwable[] { cause };
	}

	public UnsupportedAnonymousClassException(String msg) {
		super(msg);
		this.message = msg;
	}

	public UnsupportedAnonymousClassException(String msg, Throwable cause) {
		super(msg, cause);
		this.suppressed = new Throwable[] { cause };
		this.message = msg;
	}

	public UnsupportedAnonymousClassException(String msg, Throwable[] cause) {
		super(msg, cause[0]);
		this.suppressed = cause;
		this.message = msg;
	}

	public UnsupportedAnonymousClassException(int msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedAnonymousClassException(int msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedAnonymousClassException(byte msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedAnonymousClassException(byte msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedAnonymousClassException(short msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedAnonymousClassException(short msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedAnonymousClassException(long msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedAnonymousClassException(long msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedAnonymousClassException(float msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedAnonymousClassException(float msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedAnonymousClassException(double msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedAnonymousClassException(double msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedAnonymousClassException(char msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedAnonymousClassException(char msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedAnonymousClassException(boolean msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedAnonymousClassException(boolean msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedAnonymousClassException(CharSequence msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedAnonymousClassException(CharSequence msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}
}
