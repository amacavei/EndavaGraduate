package com.endava.graduates.trainings.utils;

public class StringUtils {
	
	public static String toUpperCase (String input){

		return input.toUpperCase();
	}
	
	public static String concatStrings (String firstString, String secondString){
		return firstString + secondString;
	}
	
	public static String substringValue (String input, int beginIndex){
		String output = "";
		if(beginIndex < input.length()){
			output = input.substring(beginIndex);
		}
		return output;
	}

}
