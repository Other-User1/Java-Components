package com.java.components.lang;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@SuppressWarnings("unused")
public interface InterfaceStringBuilder {
	InterfaceStringBuilder setCharAt(int index, char ch);
	InterfaceStringBuilder setChatAtCodePoint(int index, int codePoint);

	InterfaceStringBuilder append(String str);
	InterfaceStringBuilder append(char ch);
	InterfaceStringBuilder append(byte b);
	InterfaceStringBuilder append(short s);
	InterfaceStringBuilder append(int i);
	InterfaceStringBuilder append(long l);
	InterfaceStringBuilder append(float f);
	InterfaceStringBuilder append(double d);
	InterfaceStringBuilder append(boolean b);
	InterfaceStringBuilder append(Object obj);

	InterfaceStringBuilder appendFirst(String str);
	InterfaceStringBuilder appendFirst(char ch);
	InterfaceStringBuilder appendFirst(byte b);
	InterfaceStringBuilder appendFirst(short s);
	InterfaceStringBuilder appendFirst(int i);
	InterfaceStringBuilder appendFirst(long l);
	InterfaceStringBuilder appendFirst(float f);
	InterfaceStringBuilder appendFirst(double d);
	InterfaceStringBuilder appendFirst(boolean b);
	InterfaceStringBuilder appendFirst(Object obj);

	InterfaceStringBuilder insert(int index, String str);
	InterfaceStringBuilder insert(int index, char ch);
	InterfaceStringBuilder insert(int index, byte b);
	InterfaceStringBuilder insert(int index, short s);
	InterfaceStringBuilder insert(int index, int i);
	InterfaceStringBuilder insert(int index, long l);
	InterfaceStringBuilder insert(int index, float f);
	InterfaceStringBuilder insert(int index, double d);
	InterfaceStringBuilder insert(int index, boolean b);
	InterfaceStringBuilder insert(int index, Object obj);

	InterfaceStringBuilder replace(int start, int end, String replacement);
	InterfaceStringBuilder replace(String target, String replacement);
	InterfaceStringBuilder replace(String target, int position, String replacement);
	InterfaceStringBuilder replace(String target, String replacement, int replacementCount);
	InterfaceStringBuilder replace(String target, String replacement, int start, int end);
	InterfaceStringBuilder replace(String target, int position, String replacement, int replacementCount);
	InterfaceStringBuilder replace(String target, int position, String replacement, int replacementCount, int start, int end);

	InterfaceStringBuilder replace(int start, int end, char replacement);
	InterfaceStringBuilder replace(char target, char replacement);
	InterfaceStringBuilder replace(char target, int position, char replacement);
	InterfaceStringBuilder replace(char target, char replacement, int replacementCount);
	InterfaceStringBuilder replace(char target, char replacement, int start, int end);
	InterfaceStringBuilder replace(char target, int position, char replacement, int replacementCount);
	InterfaceStringBuilder replace(char target, int position, char replacement, int replacementCount, int start, int end);

	InterfaceStringBuilder substring(int start, int end);
	InterfaceStringBuilder substring(int start);
	InterfaceStringBuilder substr(int index, int length);
	InterfaceStringBuilder slide(int start, int end);
	InterfaceStringBuilder slide(int start);

	InterfaceStringBuilder trimStart();
	InterfaceStringBuilder trim();
	InterfaceStringBuilder trimEnd();

	InterfaceStringBuilder toLowerCase();
	InterfaceStringBuilder toLowerCase(Locale locale);
	InterfaceStringBuilder toLowerCase(int start, int end);
	InterfaceStringBuilder toLowerCase(Locale locale, int start, int end);

	InterfaceStringBuilder toUpperCase();
	InterfaceStringBuilder toUpperCase(Locale locale);
	InterfaceStringBuilder toUpperCase(int start, int end);
	InterfaceStringBuilder toUpperCase(Locale locale, int start, int end);

	InterfaceStringBuilder[] split(char ch);
	InterfaceStringBuilder[] split(char ch, boolean retainDelimiters);
	InterfaceStringBuilder[] split(char ch, int limit);
	InterfaceStringBuilder[] split(char ch, int limit, boolean retainDelimiters);
	InterfaceStringBuilder[] split(char ch, int limit, int offset);
	InterfaceStringBuilder[] split(char ch, int limit, int offset, boolean retainDelimiters);

	InterfaceStringBuilder[] split(String str);
	InterfaceStringBuilder[] split(String str, int limit);
	InterfaceStringBuilder[] split(String str, boolean retainDelimiters);
	InterfaceStringBuilder[] split(String str, int limit, boolean retainDelimiters);
	InterfaceStringBuilder[] split(String str, int limit, int offset);
	InterfaceStringBuilder[] split(String str, int limit, int offset, boolean retainDelimiters);

	InterfaceStringBuilder join(String delimiter, CharSequence... args);
	InterfaceStringBuilder join(String delimiter, int limit, CharSequence... args);
	InterfaceStringBuilder join(String delimiter, String prefixDelimiter, String suffixDelimiter, String prefix, String suffix, int limit, CharSequence... args);

	int indexOf(char ch);
	int indexOf(char ch, int offset);
	int indexOf(char ch, int start, int end);
	int indexOf(char ch, int offset, int start, int end);
	int indexOf(int position, char ch);
	int indexOf(int position, char ch, int offset);
	int indexOf(int position, char ch, int start, int end);
	int indexOf(int position, char ch, int offset, int start, int end);

	int indexOf(String str);
	int indexOf(String str, int offset);
	int indexOf(String str, int start, int end);
	int indexOf(String str, int offset, int start, int end);
	int indexOf(int position,String str);
	int indexOf(int position, String str, int offset);
	int indexOf(int position, String str, int start, int end);
	int indexOf(int position, String str, int offset, int start, int end);

	int length();
	int size();

	int getCharAtCodePoint(int index);

	boolean isEmpty();
	boolean isBlank();

	boolean equal(AbstractStringBuilder abs);
	boolean equalIgnoreCase(AbstractStringBuilder abs);

	boolean equals(AbstractStringBuilder... asbs);
	boolean equalsIgnoreCase(AbstractStringBuilder... asbs);

	boolean contains(String str);
	boolean contains(char ch);
	boolean containsIgnoreCase(String str);
	boolean containsIgnoreCase(char ch);

	boolean startsWith(String str);
	boolean startsWith(String str, int start);
	boolean startsWith(char ch);
	boolean startsWith(char ch, int position);
	boolean startsWithIgnoreCase(String str);
	boolean startsWithIgnoreCase(String str, int position);
	boolean startsWithIgnoreCase(char ch);
	boolean startsWithIgnoreCase(char ch, int position);

	boolean endsWith(String str);
	boolean endsWith(String str, int position);
	boolean endsWith(char ch);
	boolean endsWith(char ch, int position);
	boolean endsWithIgnoreCase(String str);
	boolean endsWithIgnoreCase(String str, int position);
	boolean endsWithIgnoreCase(char ch);
	boolean endsWithIgnoreCase(char ch, int position);

	boolean matches(String regex);

	char getCharAt(int index);

	String toString();

	char[] toCharArray();
	byte[] toByteArray();

	@Deprecated(since = "Use toCharArray()")
	List<Character> toCharList();
	@Deprecated(since = "Use toByteArray()")
	List<Byte> toByteList();

	@Deprecated(since = "Use toCharArray()")
	Map<Integer, Character> toCharMap();
	@Deprecated(since = "Use toByteArray()")
	Map<Integer, Byte> toByteMap();
}
