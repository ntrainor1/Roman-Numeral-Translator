package com.skilldistillery.translator.app;

import java.util.ArrayList;
import java.util.HashMap;

public class RomanNumeralTranslatorImpl implements Translator {
	HashMap<Integer, String> ones = new HashMap<>();
	HashMap<Integer, String> tens = new HashMap<>();
	HashMap<Integer, String> hundreds = new HashMap<>();
	HashMap<Integer, String> thousands = new HashMap<>();

	@Override
	public String translateNumeral(String untranslatedNumeral) {
		ArrayList<String> reversedNumber = new ArrayList<String>();
		StringBuilder newRomanNumeral = new StringBuilder();

		try {
			int newNumeral = Integer.parseInt(untranslatedNumeral);
		} catch (NumberFormatException e) {
			return untranslatedNumeral;
		}

		populateHashMaps();

		char[] brokenWord = new char[untranslatedNumeral.length()];

		for (int i = 0; i < untranslatedNumeral.length(); i++) {
			brokenWord[i] = untranslatedNumeral.charAt(i);
		}

		char onesPlace = brokenWord[untranslatedNumeral.length() - 1];
		reversedNumber.add(ones.get(Character.getNumericValue(onesPlace)));

		try {
			char tensPlace = brokenWord[untranslatedNumeral.length() - 2];
			reversedNumber.add(tens.get(Character.getNumericValue(tensPlace)));
		} catch (ArrayIndexOutOfBoundsException e) {
			reversedNumber.add("");
		}

		try {
			char hundredsPlace = brokenWord[untranslatedNumeral.length() - 3];
			reversedNumber.add(hundreds.get(Character.getNumericValue(hundredsPlace)));
		} catch (ArrayIndexOutOfBoundsException e) {
			reversedNumber.add("");
		}

		for (int i = (reversedNumber.size() - 1); i >= 0; i--) {
			newRomanNumeral.append(reversedNumber.get(i));
		}

		return newRomanNumeral.toString().trim();
	}

	public void populateHashMaps() {
		ones.put(1, "I");
		ones.put(2, "II");
		ones.put(3, "III");
		ones.put(4, "IV");
		ones.put(5, "V");
		ones.put(6, "VI");
		ones.put(7, "VII");
		ones.put(8, "VIII");
		ones.put(9, "IX");
		ones.put(0, "");

		tens.put(1, "X");
		tens.put(2, "XX");
		tens.put(3, "XXX");
		tens.put(4, "XL");
		tens.put(5, "L");
		tens.put(6, "LX");
		tens.put(7, "LXX");
		tens.put(8, "LXXX");
		tens.put(9, "XC");
		tens.put(0, "");

		hundreds.put(1, "C");
		hundreds.put(2, "CC");
		hundreds.put(3, "CCC");
		hundreds.put(4, "CD");
		hundreds.put(5, "D");
		hundreds.put(6, "DC");
		hundreds.put(7, "DCC");
		hundreds.put(8, "DCCC");
		hundreds.put(9, "CM");
		hundreds.put(0, "");

		thousands.put(1, "M");
		thousands.put(2, "MM");
		thousands.put(3, "MMM");
		thousands.put(4, "XL");
		thousands.put(5, "L");
		thousands.put(6, "LX");
		thousands.put(7, "LXX");
		thousands.put(8, "LXXX");
		thousands.put(9, "XC");
		thousands.put(0, "");
	}
}
