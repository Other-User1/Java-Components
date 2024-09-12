package com.java.components.lang;

import static com.java.components.Prints.println;

/**
 * <H1>AbstractStringBuilder</H1>
 * el "<strong>AbstractStringBuilder</strong>" es una clase que se utiliza
 * para dar una "construccion" de cadenas de manera eficiente, que es <strong>ES MUTABLE</strong>
 * por lo cual, se puede modificar de forma eficiente, sin necesidad de crear una nueva instancia
 * de la clase, por ejemplo:
 * <pre><code>
 *         StringBuilders stringBuilders = new StringBuilders("Hello World");
 *         stringBuilders.append("!");
 *         System.out.println(stringBuilders);
 * </code></pre>
 * que es equivalente a el siguiente:
 * <pre><code>
 *         String Greeting = "Hello World!";
 *         System.out.println(Greeting + "!");
 * </code></pre>
 * o ha:
 * <pre><code>
 *         char[] chars = new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!'};
 *         String Greeting = new String(chars);
 * </code></pre>
 * que <strong>NO ES/SON MUTABLE</strong>, excepto por la array chars.
 * <p>
 * ademas la clase "<strong>StringBuilders</strong>" contiene metodo de busqueda,
 * como los:
 * <pre><code>
 *         StringBuilders stringBuilders = new StringBuilders("Hello World");
 *         int index = stringBuilders.indexOf("World"); // Output: 6;
 * </code></pre>
 * como obtener la <strong>longitud</strong>
 * <pre><code>
 *         StringBuilders stringBuilders = new StringBuilders("Hello World", new Capacity(10));
 *         int length = stringBuilders.length(); // Output: 11
 * </code></pre>
 * de la cadena y <strong>el tamaño</strong>:
 * <pre><code>
 *         StringBuilders stringBuilders = new StringBuilders("Hello World", new Capacity(10));
 *         int length = stringBuilders.size(); // Output: 21
 * </code></pre>
 * como obtener la <strong>sub-cadena</strong> por media de <code>StringBuilders.substring(int)</code> o <code>StringBuilders.substring(int, int)</code>
 * y replazar cadenas por medio de un "<strong>target</strong>" usando el metodo <code>StringBuilders.replace(String, String)</code>
 *
 *
 * @see com.java.components.lang.AbstractStringBuilder
 * @see com.java.components.lang.AbstractStringBuilder
 * @see java.lang.String
 * @see java.lang.StringBuilder
 * @see java.lang.StringBuffer
 *
 * @sincejava 1.8
 *
 * @version 1.0
 *
 * @author noobhack
 *
 * @package com.java.components.lang
 */
@SuppressWarnings("all")
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

	public StringBuilders(int number) {
		super(String.valueOf(number), new Capacity(0));
	}

	public StringBuilders(int number, Capacity capacity) {
		super(String.valueOf(number), capacity);
	}

	public interface OnReplacementListener {
		default String onReplacement(String target, final int position) { return "\0"; };
		default char onReplacement(char target, final int position) { return '\0'; }
	}

	public abstract static class OnTargetListener {
		public String onTarget(String text) { return "\0"; }
	}

	public abstract static class OnTargetListener2 {
		public char onTarget(String text) { return '\0'; }
	}
}
