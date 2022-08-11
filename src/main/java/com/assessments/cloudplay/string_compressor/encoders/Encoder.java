package com.assessments.cloudplay.string_compressor.encoders;

public class Encoder {

	private Encoder() {};
	
	public static String encode(String str) throws IllegalArgumentException {
		
		if (str == null || str.isEmpty())
			throw new IllegalArgumentException("String is null or empty");
		
		
		StringBuilder sb = new StringBuilder();
		
		int timesRepeated = 1;
				
		char current = str.charAt(0);	
		
		for (int i = 1; i < str.length() ; i++) {
			
			if (str.toCharArray()[i] == current && timesRepeated !=9  ) {
				timesRepeated++;
			}else {
				sb.append(timesRepeated).append(current);
				current = str.charAt(i);
				timesRepeated = 1;
			}
			
		}
		if (timesRepeated >= 1) {
			sb.append(timesRepeated).append(current);
		}
		
		
		return sb.toString();
	}

	
	
}
