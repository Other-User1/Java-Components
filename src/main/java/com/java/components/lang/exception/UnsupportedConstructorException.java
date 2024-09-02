package com.java.components.lang.exception;

import com.java.components.lang.CompilerTaskException;

public class UnsupportedConstructorException extends CompilerTaskException {
	public UnsupportedConstructorException() {
		super();
	}

	public UnsupportedConstructorException(Throwable cause) {
		super(cause);
		this.suppressed = new Throwable[] { cause };
	}

	public UnsupportedConstructorException(String msg) {
		super(msg);
		this.message = msg;
	}

	public UnsupportedConstructorException(String msg, Throwable cause) {
		super(msg, cause);
		this.suppressed = new Throwable[] { cause };
		this.message = msg;
	}

	public UnsupportedConstructorException(String msg, Throwable[] cause) {
		super(msg, cause[0]);
		this.suppressed = cause;
		this.message = msg;
	}

	public UnsupportedConstructorException(int msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedConstructorException(int msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedConstructorException(byte msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedConstructorException(byte msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedConstructorException(short msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedConstructorException(short msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedConstructorException(long msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedConstructorException(long msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedConstructorException(float msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedConstructorException(float msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedConstructorException(double msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedConstructorException(double msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedConstructorException(char msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedConstructorException(char msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedConstructorException(boolean msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedConstructorException(boolean msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnsupportedConstructorException(CharSequence msg) {
		this(String.valueOf(msg));
	}

	public UnsupportedConstructorException(CharSequence msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}
}
