package com.java.components.lang;

public class StringBuildersUtils {
	private final StringBuilders stringBuilders;

	public StringBuildersUtils(StringBuilders stringBuilders) {
		this.stringBuilders = stringBuilders;
	}

	public StringBuildersUtils(String str) {
		this.stringBuilders = new StringBuilders(str);
	}

	public AbstractStringBuilder[] split(String str, int limit, int offset, int begin, int ending, boolean retainDelimiters) {
		if (stringBuilders.values == null || stringBuilders.count == 0) {
			throw new IllegalArgumentException("Invalid input");
		}
		StringBuilders sb = new StringBuilders(stringBuilders.values);

		limit++;

		StringBuilders[] result = new StringBuilders[limit];
		int count = 0;
		int start = begin;
		int end;

		while ((end = sb.indexOf(str, offset + start)) != -1) {
			if (end >= ending) {
				break;
			}
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
}
