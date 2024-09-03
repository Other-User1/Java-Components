package com.java.components.lang;

import com.java.components.lang.exception.NumberNegativeException;
import com.java.components.lang.exception.UnsupportedMethodException;

import java.util.*;

import static com.java.components.Prints.println;

public sealed abstract class AbstractStringBuilder implements InterfaceStringBuilder permits StringBuilders {
	protected char[] values;
	protected int capacity;
	protected int offset;
	protected int count;

	public AbstractStringBuilder() {
		this.values = new char[this.capacity = 1];
		this.offset = 0;
		this.count = 0;
	}

	public AbstractStringBuilder(String str) {
		this.capacity = 0;
		this.values = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			this.values[i] = str.charAt(i);
		}
		this.offset = 0;
		this.count = str.length();
	}

	public AbstractStringBuilder(String[] values) {
		String str = String.join("", values);
		char[] chars = str.toCharArray();
		int length = chars.length;
		if (values == null) throw new NullPointerException();
		this.values = new char[length];
		this.count = length;
		this.offset = 0;
		java.lang.System.arraycopy(chars, 0, this.values, 0, length);
	}

	public AbstractStringBuilder(String[] values, int offset) {
		String str = String.join("", values);
		char[] chars = str.toCharArray();
		int length = chars.length - offset;
		if (values == null) throw new NullPointerException();
		if (offset < 0 || offset > values.length) throw new IndexOutOfBoundsException();
		this.values = new char[length];
		this.count = length;
		this.offset = offset;
		java.lang.System.arraycopy(chars, offset, this.values, 0, length);
	}

	public AbstractStringBuilder(String[] values, int offset, int length) {
		if (values == null) throw new NullPointerException();
		if (offset < 0 || offset > values.length) throw new IndexOutOfBoundsException();
		if (length < 0) throw new IndexOutOfBoundsException();
		if (offset + length > values.length) throw new IndexOutOfBoundsException(length + " > " + values.length);
		this.values = new char[length];
		this.count = length;
		this.offset = offset;
		String str = String.join("", Arrays.copyOfRange(values, offset, length + offset));
		char[] chars = str.toCharArray();
		java.lang.System.arraycopy(chars, 0, this.values, 0, length);
	}

	public AbstractStringBuilder(char[] values, int offset, int length) {
		if (values == null) throw new NullPointerException();
		if (offset < 0 || offset > values.length) throw new IndexOutOfBoundsException();
		if (length < 0) throw new IndexOutOfBoundsException();
		if (offset + length > values.length) throw new IndexOutOfBoundsException(length + " > " + values.length);
		this.values = new char[length];
		this.count = length;
		this.offset = offset;
		java.lang.System.arraycopy(values, offset, this.values, 0, length);
	}

	@Override
	public AbstractStringBuilder setCharAt(int index, char ch) {
		if (index < 0) {
			throw new CompilerTaskException("The 'Index' value (" + index + ") is less than 0", new Throwable[] {
					new NumberNegativeException(),
					new IndexOutOfBoundsException()
			});
		}
		if (index > this.count) {
			throw new CompilerTaskException("The 'Index' value (" + index + ") is greater than length/size", new IndexOutOfBoundsException());
		}
		this.values[index] = ch;
		return this;
	}

	@Override
	public AbstractStringBuilder setChatAtCodePoint(int index, int codePoint) {
		if (index < 0) {
			throw new CompilerTaskException("The 'Index' value (" + index + ") is less than 0", new Throwable[] {
					new NumberNegativeException(),
					new IndexOutOfBoundsException()
			});
		}
		if (index > this.count) {
			throw new CompilerTaskException("The 'Index' value (" + index + ") is greater than length/size", new IndexOutOfBoundsException());
		}
		this.values[index] = (char) codePoint;
		return this;
	}

	private void expandCapacity(int minCapacity) {
		this.values = new char[minCapacity];
	}

	@Override
	public AbstractStringBuilder append(String str) {
		if (str == null) {
			str = "null";
		}
		char[] oldCharacters = this.values;
		expandCapacity(this.count + str.length());
		for (int i = 0; i < oldCharacters.length; i++) {
			this.values[i] = oldCharacters[i];
		}
		for (int i = 0; i < str.length(); i++) {
			this.values[this.count + i] = str.charAt(i);
		}
		this.count += str.length();
		return this;
	}

	@Override
	public AbstractStringBuilder append(char ch) {
		char[] oldCharacters = this.values;
		expandCapacity(this.count + 1);
		for (int i = 0; i < oldCharacters.length; i++) {
			this.values[i] = oldCharacters[i];
		}
		this.values[this.count] = ch;
		this.count++;
		return this;
	}

	@Override
	public AbstractStringBuilder append(byte b) {
		return this.append(String.valueOf(b));
	}

	@Override
	public AbstractStringBuilder append(short s) {
		return this.append(String.valueOf(s));
	}

	@Override
	public AbstractStringBuilder append(int i) {
		return this.append(String.valueOf(i));
	}

	@Override
	public AbstractStringBuilder append(long l) {
		return this.append(String.valueOf(l));
	}

	@Override
	public AbstractStringBuilder append(float f) {
		return this.append(String.valueOf(f));
	}

	@Override
	public AbstractStringBuilder append(double d) {
		return this.append(String.valueOf(d));
	}

	@Override
	public AbstractStringBuilder append(boolean b) {
		char[] oldCharacters = this.values;
		if (b) {
			expandCapacity(this.count + 4);
			for (int i = 0; i < oldCharacters.length; i++) {
				this.values[i] = oldCharacters[i];
			}
			this.values[this.count++] = 't';
			this.values[this.count++] = 'r';
			this.values[this.count++] = 'u';
			this.values[this.count++] = 'e';
		} else {
			expandCapacity(this.count + 5);
			for (int i = 0; i < oldCharacters.length; i++) {
				this.values[i] = oldCharacters[i];
			}
			this.values[this.count++] = 'f';
			this.values[this.count++] = 'a';
			this.values[this.count++] = 'l';
			this.values[this.count++] = 's';
		}
		this.values[this.count++] = 'e';
		return this;
	}

	@Override
	public AbstractStringBuilder append(Object obj) {
		return this.append(String.valueOf(obj));
	}

	@Override
	public AbstractStringBuilder appendFirst(String str) {
		if (str == null) {
			str = "null";
		}
		char[] oldCharacters = this.values;
		expandCapacity(this.count + str.length());
		for (int i = 0; i < str.length(); i++) {
			this.values[i] = str.charAt(i);
		}
		if (this.count >= 0) java.lang.System.arraycopy(oldCharacters, 0, this.values, str.length(), this.count);
		this.count += str.length();
		return this;
	}

	@Override
	public AbstractStringBuilder appendFirst(char ch) {
		char[] oldCharacters = this.values;
		expandCapacity(this.count + 1);
		this.values[0] = ch;
		for (int i = 0; i < oldCharacters.length; i++) {
			this.values[1 + i] = oldCharacters[i];
		}
		this.count++;
		return this;
	}

	@Override
	public AbstractStringBuilder appendFirst(byte b) {
		return this.appendFirst(String.valueOf(b));
	}

	@Override
	public AbstractStringBuilder appendFirst(short s) {
		return this.appendFirst(String.valueOf(s));
	}

	@Override
	public AbstractStringBuilder appendFirst(int i) {
		return this.appendFirst(String.valueOf(i));
	}

	@Override
	public AbstractStringBuilder appendFirst(long l) {
		return this.appendFirst(String.valueOf(l));
	}

	@Override
	public AbstractStringBuilder appendFirst(float f) {
		return this.appendFirst(String.valueOf(f));
	}

	@Override
	public AbstractStringBuilder appendFirst(double d) {
		return this.appendFirst(String.valueOf(d));
	}

	@Override
	public AbstractStringBuilder appendFirst(boolean b) {
		return this.appendFirst(String.valueOf(b));
	}

	@Override
	public AbstractStringBuilder appendFirst(Object obj) {
		return this.appendFirst(String.valueOf(obj));
	}

	@Override
	public InterfaceStringBuilder insert(int index, String str) {
		char[] oldCharacters = this.values;
		char[] valuesStr = str.toCharArray();
		expandCapacity(this.values.length + str.length());
		for (int i = 0, j = 0; j < oldCharacters.length; i++, j++) {
			if (i == index) {
				for (int k = 0; k < str.length(); k++) {
					this.values[i++] = valuesStr[k];
				}
			}
			this.values[i] = oldCharacters[j];
		}
		return this;
	}

	@Override
	public InterfaceStringBuilder insert(int index, char ch) {
		char[] oldCharacters = this.values;
		expandCapacity(this.values.length + 1);
		for (int i = 0, j = 0; j < oldCharacters.length; i++, j++) {
			if (i == index) {
				this.values[i] = ch;
				i++;
			}
			this.values[i] = oldCharacters[j];
		}
		return this;
	}

	@Override
	public InterfaceStringBuilder insert(int index, byte b) {
		return insert(index, String.valueOf(b));
	}

	@Override
	public InterfaceStringBuilder insert(int index, short s) {
		return insert(index, String.valueOf(s));
	}

	@Override
	public InterfaceStringBuilder insert(int index, int i) {
		return insert(index, String.valueOf(i));
	}

	@Override
	public InterfaceStringBuilder insert(int index, long l) {
		return insert(index, String.valueOf(l));
	}

	@Override
	public InterfaceStringBuilder insert(int index, float f) {
		return insert(index, String.valueOf(f));
	}

	@Override
	public InterfaceStringBuilder insert(int index, double d) {
		return insert(index, String.valueOf(d));
	}

	@Override
	public InterfaceStringBuilder insert(int index, boolean b) {
		if (b) {
			insert(index, 't');
			insert(index + 1, 'r');
			insert(index + 2, 'u');
			insert(index + 3, 'e');
		} else {
			insert(index, 'f');
			insert(index + 1, 'a');
			insert(index + 2, 'l');
			insert(index + 3, 's');
			insert(index + 4, 'e');
		}
		return this;
	}

	@Override
	public InterfaceStringBuilder insert(int index, Object obj) {
		return insert(index, String.valueOf(obj));
	}

	@Override
	public AbstractStringBuilder replace(int start, int end, String replacement) {
		return substring(0, start).append(replacement).append(substring(end));
	}

	@Override
	public AbstractStringBuilder replace(String target, String replacement) {
		StringBuilders sb = new StringBuilders();
		int start = 0;
		int end;
		while ((end = indexOf(target, start)) != -1) {
			sb.append(substring(start, end));
			sb.append(replacement);
			start = end + target.length();
		}
		sb.append(substring(start));
		return sb;
	}

	@Override
	public InterfaceStringBuilder replace(String target, String replacement, int start, int end) {
		return replace(target, 0, replacement, length(), start, end);
	}

	@Override
	public AbstractStringBuilder replace(String target, int position, String replacement) {
		return replace(target, position, replacement, length(), 0, length());
	}

	@Override
	public AbstractStringBuilder replace(String target, String replacement, int replacementCount) {
		return replace(target, 0, replacement, replacementCount, 0, length());
	}

	@Override
	public AbstractStringBuilder replace(String target, int position, String replacement, int replacementCount) {
		return replace(target, position, replacement, replacementCount, 0, length());
	}

	@Override
	public AbstractStringBuilder replace(String target, int position, String replacement, int replacementCount, int start, int end) {
		StringBuilders sb = new StringBuilders();
		int begin = start;
		int finals;
		while ((finals = indexOf(target, begin)) != -1 && finals < end) {
			if (replacementCount > 0) {
				if (position == 0) {
					sb.append(substring(begin, finals));
					sb.append(replacement);
					replacementCount--;
				} else {
					sb.append(substring(begin, finals));
					sb.append(target);
					position--;
				}
				begin = finals + target.length();
			} else {
				break;
			}
		}
		sb.append(substring(begin));
		return sb;
	}

	@Override
	public AbstractStringBuilder replace(int start, int end, char replacement) {
		StringBuilders sb = (StringBuilders) substring(0, start);
		sb.append(replacement);
		sb.append(substring(end));
		return sb;
	}

	@Override
	public AbstractStringBuilder replace(char target, char replacement) {
		return replace(target, 0, replacement);
	}

	@Override
	public AbstractStringBuilder replace(char target, int position, char replacement) {
		return replace(target, position, replacement, Integer.MAX_VALUE);
	}

	@Override
	public AbstractStringBuilder replace(char target, char replacement, int replacementCount) {
		return  replace(target, 0, replacement, replacementCount);
	}

	@Override
	public AbstractStringBuilder replace(char target, char replacement, int start, int end) {
		return replace(target, 0, replacement, Integer.MAX_VALUE, start, end);
	}

	@Override
	public AbstractStringBuilder replace(char target, int position, char replacement, int replacementCount) {
		return replace(target, position, replacement, replacementCount, 0, this.count);
	}

	@Override
	public AbstractStringBuilder replace(char target, int position, char replacement, int replacementCount, int start, int end) {
		char[] oldCharacters = Arrays.copyOfRange(values, offset, count);
		for (int i = start; i < end; i++) {
			if (oldCharacters[i] == target) {
				if (position == 0 && replacementCount != 0) {
					oldCharacters[i] = replacement;
					replacementCount--;
				} else {
					position--;
				}
			}
		}
		return new StringBuilders(oldCharacters, offset, count);
	}

	@Override
	public InterfaceStringBuilder replaceFirst(char target, char replacement) {
		return replaceFirst(target, 0, replacement);
	}

	@Override
	public InterfaceStringBuilder replaceFirst(char target,  int position, char replacement) {
		return replace(target, position, replacement, 1);
	}

	@Override
	public InterfaceStringBuilder replaceLast(char target, char replacement) {
		return replaceLast(target, 0, replacement);
	}

	@Override
	public InterfaceStringBuilder replaceLast(char target, int position, char replacement) {
		int index = reverseIndexOf(position, target);
		return (index != -1) ? replace(index, index + 1, replacement) : this;
	}

	@Override
	public AbstractStringBuilder substring(int start, int end) {
		return ((start == 0) && (end == count)) ? this :
				new StringBuilders(values, offset + start, end - start);
	}

	@Override
	public AbstractStringBuilder substring(int start) {
		return substring(start, this.count);
	}

	@Override
	public AbstractStringBuilder substr(int index, int length) {
		return new StringBuilders(values, index, index + length);
	}

	@Override
	public AbstractStringBuilder slide(int start, int end) {
		return ((start == 0) && (end == count)) ? this :
				new StringBuilders(values, offset + start, end - start);
	}

	@Override
	public AbstractStringBuilder slide(int start) {
		return slide(start, this.count);
	}

	@Override
	public AbstractStringBuilder trimStart() {
		int tmpOffset = offset;
		for (; tmpOffset < count; tmpOffset++) {
			if (values[tmpOffset] != ' ') {
				return new StringBuilders(values, tmpOffset, count - tmpOffset);
			}
		}
		return this;
	}

	@Override
	public AbstractStringBuilder trim() {
		return new StringBuilders(values, offset, count).trimEnd().trimStart();
	}

	@Override
	public AbstractStringBuilder trimEnd() {
		int tmpOffset = count - 1;
		for (; tmpOffset >= offset; tmpOffset--) {
			if (values[tmpOffset] != ' ') {
				return new StringBuilders(values, offset, tmpOffset - offset + 1);
			}
		}
		return this;
	}

	@Override
	public AbstractStringBuilder toLowerCase() {
		return this.toLowerCase(0, this.count);
	}

	@Override
	public AbstractStringBuilder toLowerCase(Locale locale) {
		return toLowerCase(locale, 0, this.count);
	}

	@Override
	public AbstractStringBuilder toLowerCase(int start, int end) {
		StringBuilders sb = new StringBuilders(values);
		int position = start;
		while ((position) < end) {
			if (sb.values[offset + position] >= 'A' && sb.values[offset + position] <= 'Z') {
				sb.values[this.offset + position] = (char) (sb.values[this.offset + position] + 32);
			}
			position++;
		}
		return sb;
	}

	@Override
	public AbstractStringBuilder toLowerCase(Locale locale, int start, int end) {
		if (locale == Locale.ENGLISH) {
			return toLowerCase(start, end);
		}
		throw new UnsupportedMethodException("toLowerCase(Locale locale, int start, int end) is not supported. Currently only English is supported.");
	}

	@Override
	public AbstractStringBuilder toUpperCase() {
		return null;
	}

	@Override
	public AbstractStringBuilder toUpperCase(Locale locale) {throw new UnsupportedMethodException("toUpperCase(Locale locale) is not supported, missing implementation for all languages");
	}

	@Override
	public AbstractStringBuilder toUpperCase(int start, int end) {
		char[] oldValues = this.values;
		int position = start;
		while (position < end) {
			if (getCharAt(offset + position) >= 'a' && getCharAt(offset + position) <= 'z') {
				oldValues[offset + position] = (char) (oldValues[offset + position] - 32);
			}
			position++;
		}
		return new StringBuilders(oldValues);
	}

	@Override
	public InterfaceStringBuilder toUpperCase(Locale locale, int start, int end) {
		throw new UnsupportedMethodException("toUpperCase(Locale locale, int start, int end) is not supported, missing implementation for all languages");
	}

	@Override
	public InterfaceStringBuilder[] split(char ch) {
		return split(ch, 99999999, 0, false);
	}

	@Override
	public InterfaceStringBuilder[] split(char ch, boolean retainDelimiters) {
		return split(ch, 99999999, 0, retainDelimiters);
	}

	@Override
	public InterfaceStringBuilder[] split(char ch, int limit) {
		return split(ch, limit, 0, false);
	}

	@Override
	public InterfaceStringBuilder[] split(char ch, int limit, boolean retainDelimiters) {
		return split(ch, limit, 0, retainDelimiters);
	}

	@Override
	public InterfaceStringBuilder[] split(char ch, int limit, int offset) {
		return split(ch, limit, offset, false);
	}

	@Override
	public AbstractStringBuilder[] split(char ch, int limit, int offset, boolean retainDelimiters) {
		if (values == null || count == 0) {
			throw new IllegalArgumentException("Invalid input");
		}
		StringBuilders sb = new StringBuilders(values);

		limit++;

		StringBuilders[] result = new StringBuilders[limit];
		int count = 0;
		int start = 0;
		int end;

		while ((end = sb.indexOf(ch, offset + start)) != -1) {
			if (count == limit - 1) {
				break;
			}
			if (!retainDelimiters) {
				result[count++] = (StringBuilders) sb.substring(start, end);
			} else {
				result[count++] = (StringBuilders) sb.substring(start, end + 1);
			}
			start = end + 1;
		}

		result[count] = (StringBuilders) sb.substring(start);

		if (count < limit - 1) {
			StringBuilders[] trimmedResult = new StringBuilders[count + 1];
			java.lang.System.arraycopy(result, 0, trimmedResult, 0, count + 1);
			return trimmedResult;
		}
		return result;
	}

	@Override
	public AbstractStringBuilder[] split(String str) {
		return split(str, str.length());
	}

	@Override
	public AbstractStringBuilder[] split(String str, boolean retainDelimiters) {
		return split(str, str.length(), retainDelimiters);
	}

	@Override
	public AbstractStringBuilder[] split(String str, int limit) {
		return split(str, limit, false);
	}

	@Override
	public AbstractStringBuilder[] split(String str, int limit, boolean retainDelimiters) {
		return new AbstractStringBuilder[0];
	}

	@Override
	public AbstractStringBuilder[] split(String str, int limit, int offset) {
		return split(str, limit, offset, false);
	}

	@Override
	public AbstractStringBuilder[] split(String str, int limit, int offset, boolean retainDelimiters) {
		if (values == null || count == 0) {
			throw new IllegalArgumentException("Invalid input");
		}
		StringBuilders sb = new StringBuilders(values);

		limit++;

		StringBuilders[] result = new StringBuilders[limit];
		int count = 0;
		int start = 0;
		int end;

		while ((end = sb.indexOf(str, offset + start)) != -1) {
			if (count == limit - 1) {
				break;
			}
			if (!retainDelimiters) {
				result[count++] = (StringBuilders) sb.substring(start, end);
			} else {
				result[count++] = (StringBuilders) sb.substring(start, end + str.length());
			}
			start = end + str.length();
		}

		result[count] = (StringBuilders) sb.substring(start);

		if (count < limit - 1) {
			StringBuilders[] trimmedResult = new StringBuilders[count + 1];
			java.lang.System.arraycopy(result, 0, trimmedResult, 0, count + 1);
			return trimmedResult;
		}
		return result;
	}

	@Override
	public AbstractStringBuilder join(String delimiter, CharSequence... args) {
		return join(delimiter, "", "", "[", "]", -1, args);
	}

	@Override
	public AbstractStringBuilder join(String delimiter, int limit, CharSequence... args) {
		return join(delimiter, "", "", "[", "]", limit, args);
	}

	public AbstractStringBuilder join(String delimiter, String prefixDelimiter, String suffixDelimiter, String prefix, String suffix, int limit, CharSequence... args) {
		StringBuilders sb = new StringBuilders();
		sb.append(prefix);
		limit = limit < 0 ? args.length : limit;
		for (int i = 0; i < limit; i++) {
			if (i != 0) {
				sb.append(delimiter);
			}
			sb.append(prefixDelimiter);
			sb.append(args[i]);
			sb.append(suffixDelimiter);
		}
		sb.append(suffix);
		return sb;
	}

	@Override
	public AbstractStringBuilder repeat(int count) {
		count++;
		char[] oldValues = this.values;
		expandCapacity(count * oldValues.length);
		for (int i = 0, j = 0; i < values.length; i++, j++) {
			if (j == oldValues.length) {
				j = 0;
			}
			this.values[i] = oldValues[j];
		}
		return this;
	}

	@Override
	public AbstractStringBuilder reverse() {
		return reverse(0, this.count);
	}

	@Override
	public AbstractStringBuilder reverse(int start, int end) {
		for (int i = start, j = end - 1; i < j; i++, j--) {
			char temp = this.values[i];
			this.values[i] = this.values[j];
			this.values[j] = temp;
		}
		return this;
	}

	@Override
	public int indexOf(char ch) {
		for (int i = 0; i < count; i++) {
			if (values[i] == ch) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int indexOf(char ch, int offset) {
		for (int i = offset; i < count; i++) {
			if (values[i] == ch) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int indexOf(char ch, int start, int end) {
		for (int i = start; i < end; i++) {
			if (values[i] == ch) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int indexOf(char ch, int offset, int start, int end) {
		for (int i = start + offset; i < end; i++) {
			if (values[i] == ch) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int indexOf(int position, char ch) {
		for (int i = 0; i < count; i++) {
			if (values[i] == ch) {
				if (position == 0) {
					return i;
				} else {
					position--;
				}
			}
		}
		return -1;
	}

	@Override
	public int indexOf(int position, char ch, int offset) {
		for (int i = offset; i < count; i++) {
			if (values[i] == ch) {
				if (position == 0) {
					return i;
				} else {
					position--;
				}
			}
		}
		return -1;
	}

	@Override
	public int indexOf(int position, char ch, int start, int end) {
		for (int i = start; i < end; i++) {
			if (values[i] == ch) {
				if (position == 0) {
					return i;
				} else {
					position--;
				}
			}
		}
		return -1;
	}

	@Override
	public int indexOf(int position, char ch, int offset, int start, int end) {
		for (int i = start + offset; i < end; i++) {
			if (values[i] == ch) {
				if (position == 0) {
					return i;
				} else {
					position--;
				}
			}
		}
		return -1;
	}

	@Override
	public int indexOf(String str) {
		return indexOf(0, str);
	}

	@Override
	public int indexOf(String str, int offset) {
		return indexOf(0, str, offset);
	}

	@Override
	public int indexOf(String str, int start, int end) {
		return indexOf(0, str, start, end);
	}

	@Override
	public int indexOf(String str, int offset, int start, int end) {
		return indexOf(0, str, offset, start, end);
	}

	@Override
	public int indexOf(int position, String str) {
		return indexOf(position, str, 0);
	}

	@Override
	public int indexOf(int position, String str, int offset) {
		return indexOf(0, str, offset, 0, this.count);
	}

	@Override
	public int indexOf(int position, String str, int start, int end) {
		return indexOf(position, str, 0, start, end);
	}

	@Override
	public int indexOf(int position, String str, int offset, int start, int end) {
		char[] chars = str.toCharArray();
		for (int i = start + offset; i < end; i++) {
			if (values[i] != chars[0]) {
				continue;
			}
			for (int j = 0; j < chars.length; j++) {
				if (values[i + j] != chars[j]) {
					break;
				} else if (j == chars.length - 1) {
					if (position == 0) {
						return i;
					} else {
						position--;
					}
				}
			}
		}
		return -1;
	}

	@Override
	public int reverseIndexOf(char ch) {
		return reverseIndexOf(ch, 0);
	}

	@Override
	public int reverseIndexOf(char ch, int offset) {
		return reverseIndexOf(ch, offset, 0, this.count);
	}

	@Override
	public int reverseIndexOf(char ch, int start, int end) {
		return reverseIndexOf(ch, 0, start, end);
	}

	@Override
	public int reverseIndexOf(char ch, int offset, int start, int end) {
		return reverseIndexOf(0, ch, offset, start, end);
	}

	@Override
	public int reverseIndexOf(int position, char ch) {
		return reverseIndexOf(position, ch, 0);
	}

	@Override
	public int reverseIndexOf(int position, char ch, int offset) {
		return reverseIndexOf(position, ch, offset, 0, this.count);
	}

	@Override
	public int reverseIndexOf(int position, char ch, int start, int end) {
		return reverseIndexOf(position, ch, 0, start, end);
	}

	@Override
	public int reverseIndexOf(int position, char ch, int offset, int start, int end) {
		for (int i = end == this.count ? end - 1 : end; i >= start + offset; i--) {
			if (values[i] == ch) {
				if (position == 0) {
					return i;
				} else {
					position--;
				}
			}
		}
		return -1;
	}

	@Override
	public int reverseIndexOf(String str) {
		return reverseIndexOf(str, 0);
	}

	@Override
	public int reverseIndexOf(String str, int offset) {
		return reverseIndexOf(str, offset, 0, this.count);
	}

	@Override
	public int reverseIndexOf(String str, int start, int end) {
		return reverseIndexOf(str, 0, start, end);
	}

	@Override
	public int reverseIndexOf(String str, int offset, int start, int end) {
		return reverseIndexOf(0, str, offset, start, end);
	}

	@Override
	public int reverseIndexOf(int position, String str) {
		return reverseIndexOf(position, str, 0);
	}

	@Override
	public int reverseIndexOf(int position, String str, int offset) {
		return reverseIndexOf(position, str, 0, 0, this.count);
	}

	@Override
	public int reverseIndexOf(int position, String str, int start, int end) {
		return reverseIndexOf(position, str, 0, start, end);
	}

	@Override
	public int reverseIndexOf(int position, String str, int offset, int start, int end) {
		char[] chars = str.toCharArray();
		for (int i = end == this.count ? this.count - 1 : end; i >= start; i--) {
			if (values[i] != chars[0]) {
				continue;
			}
			for (int j = 0; j < chars.length; j++) {
				if (values[i + j] != chars[j]) {
					break;
				} else if (j == chars.length - 1) {
					if (position == 0) {
						return i;
					} else {
						position--;
					}
				}
			}
		}
		return -1;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public int length() {
		return count;
	}

	@Override
	public int getCharAtCodePoint(int index) {
		if (index < 0) {
			throw new CompilerTaskException("The 'Index' value (" + index + ") is less than 0", new Throwable[] {
					new NumberNegativeException(),
					new IndexOutOfBoundsException()
			});
		}
		if (index > this.count) {
			throw new CompilerTaskException("The 'Index' value (" + index + ") is greater than length/size", new IndexOutOfBoundsException());
		}
		return this.values[index];
	}

	@Override
	public boolean isEmpty() {
		return this.count == 0;
	}

	@Override
	public boolean isBlank() {
		for (int i = 0; i < count; i++) {
			if (values[i] != ' ') {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean equal(AbstractStringBuilder asb) {
		for (int i = 0; i < count; i++) {
			if (values[i] != asb.values[i]) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean equalIgnoreCase(AbstractStringBuilder asb) {
		return toLowerCase().equal(asb.toLowerCase());
	}

	@Override
	public boolean equals(AbstractStringBuilder... asbs) {
		for (AbstractStringBuilder asb : asbs) {
			if (!equal(asb)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean equalsIgnoreCase(AbstractStringBuilder... asbs) {
		for (AbstractStringBuilder asb : asbs) {
			if (!equalIgnoreCase(asb)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean contains(String str) {
		return indexOf(str) >= 0;
	}

	@Override
	public boolean contains(char ch) {
		return indexOf(ch) >= 0;
	}

	@Override
	public boolean containsIgnoreCase(String str) {
		return toLowerCase().contains(str.toLowerCase());
	}

	@Override
	public boolean containsIgnoreCase(char ch) {
		return indexOf(Character.toLowerCase(ch)) >= 0;
	}

	@Override
	public boolean startsWith(String str) {
		return startsWith(str, 0);
	}

	@Override
	public boolean startsWith(String str, int position) {
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != values[position + i]) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean startsWith(char ch) {
		return startsWith(ch, 0);
	}

	@Override
	public boolean startsWith(char ch, int position) {
		return this.values[position] == ch;
	}

	@Override
	public boolean startsWithIgnoreCase(String str) {
		return startsWithIgnoreCase(str, 0);
	}

	@Override
	public boolean startsWithIgnoreCase(String str, int position) {
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (Character.toLowerCase(chars[i]) != Character.toLowerCase(values[position + i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean startsWithIgnoreCase(char ch) {
		return startsWithIgnoreCase(ch, 0);
	}

	@Override
	public boolean startsWithIgnoreCase(char ch, int position) {
		return Character.toLowerCase(ch) == Character.toLowerCase(this.values[position]);
	}

	@Override
	public boolean endsWith(String str) {
		return endsWith(str, 0);
	}

	@Override
	public boolean endsWith(String str, int position) {
		return startsWith(str, values.length - position - str.length());
	}

	@Override
	public boolean endsWith(char ch) {
		return endsWith(ch, 0);
	}

	@Override
	public boolean endsWith(char ch, int position) {
		return this.values[count - position - 1] == ch;
	}

	@Override
	public boolean endsWithIgnoreCase(String str) {
		return endsWithIgnoreCase(str, 0);
	}

	@Override
	public boolean endsWithIgnoreCase(String str, int position) {
		return startsWithIgnoreCase(str, values.length - position - str.length());
	}

	@Override
	public boolean endsWithIgnoreCase(char ch) {
		return endsWithIgnoreCase(ch, 0);
	}

	@Override
	public boolean endsWithIgnoreCase(char ch, int position) {
		return Character.toLowerCase(ch) == Character.toLowerCase(this.values[count - position - 1]);
	}

	@Override
	public boolean matches(String regex) {
		return false;
	}

	@Override
	public char getCharAt(int index) {
		if (index < 0) {
			throw new CompilerTaskException("The 'Index' value (" + index + ") is less than 0", new Throwable[] {
					new NumberNegativeException(),
					new IndexOutOfBoundsException()
			});
		}
		if (index > this.count) {
			throw new CompilerTaskException("The 'Index' value (" + index + ") is greater than length/size", new IndexOutOfBoundsException());
		}
		return this.values[index];
	}

	@Override
	public byte[] toByteArray() {
		byte[] bytes = new byte[this.count];
		for (int i = 0; i < this.count; i++) {
			bytes[i] = (byte) this.values[i];
		}
		return bytes;
	}

	@Override
	public char[] toCharArray() {
		return this.values;
	}

	@Override
	@Deprecated(since = "Use toCharArray()")
	public Map<Integer, Character> toCharMap() {
		Map<Integer, Character> map = new HashMap<>();
		for (int i = 0; i < this.count; i++) {
			map.put(i, this.values[i]);
		}
		return map;
	}

	@Override
	@Deprecated(since = "Use toByteArray()")
	public Map<Integer, Byte> toByteMap() {
		Map<Integer, Byte> map = new HashMap<>();
		for (int i = 0; i < this.count; i++) {
			map.put(i, (byte) this.values[i]);
		}
		return map;
	}

	@Override
	@Deprecated(since = "Use toCharArray()")
	public List<Character> toCharList() {
		List<Character> list = new ArrayList<>();
		for (char ch : this.values) {
			list.add(ch);
		}
		return list;
	}

	@Override
	@Deprecated(since = "Use toByteArray()")
	public List<Byte> toByteList() {
		List<Byte> list = new ArrayList<>();
		for (char ch : this.values) {
			list.add((byte) ch);
		}
		return list;
	}

	@Override
	public String toString() {
		return new String(this.values);
	}
}
