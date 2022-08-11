package com.assessments.cloudplay.string_compressor.decoders;

public class Decoder {

	private Decoder() {
	}

	public static String decode(String str) {

		if (str == null || str.isEmpty())
			throw new IllegalArgumentException("String is null or empty");

		StringBuilder sb = new StringBuilder();

		char current = str.charAt(0);

		int timesToRepeat = 0;

		for (int i = 1; i < str.length(); i++) {

			if (Character.isDigit(current) && (timesToRepeat == 0)) {
				timesToRepeat = Integer.valueOf(String.valueOf(current));
				current = str.charAt(i);
			} else {

				sb.append(String.valueOf(current).repeat(timesToRepeat));
				timesToRepeat = 0;
				current = str.charAt(i);

			}
		}

		if (timesToRepeat > 0) {
			sb.append(String.valueOf(current).repeat(timesToRepeat));
		}

		return sb.toString();

	}

}
