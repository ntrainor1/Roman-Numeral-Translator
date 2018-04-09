package com.skilldistillery.translator.app;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumeralTranslatorImpl implements Translator {
	HashMap<Integer, String> ones = new HashMap<>();
	HashMap<Integer, String> tens = new HashMap<>();
	HashMap<Integer, String> hundreds = new HashMap<>();
	HashMap<Integer, String> thousands = new HashMap<>();
	HashMap<Integer, String> tenthousands = new HashMap<>();
	HashMap<Integer, String> hunthousands = new HashMap<>();
	HashMap<Integer, String> millions = new HashMap<>();
	HashMap<String, Integer> toArabicOnes = new HashMap<>();
	HashMap<String, Integer> toArabicTens = new HashMap<>();
	HashMap<String, Integer> toArabicHuns = new HashMap<>();

	@Override
	public String translateWord(String untranslatedWord) {
		ArrayList<String> reversedNumber = new ArrayList<String>();
		StringBuilder newRomanNumeral = new StringBuilder();
		
		try {
			int newNumeral = Integer.parseInt(untranslatedWord);
		} catch (NumberFormatException e) {
			return untranslatedWord;
		}
		
		populateHashMaps();
		
		char[] brokenWord = new char[untranslatedWord.length()];
		
		for (int i = 0; i < untranslatedWord.length(); i++) {
			brokenWord[i] = untranslatedWord.charAt(i);
		}
		
		char onesPlace = brokenWord[untranslatedWord.length() - 1];
		reversedNumber.add(ones.get(Character.getNumericValue(onesPlace)));
		
		try {
			char tensPlace = brokenWord[untranslatedWord.length() - 2];
			reversedNumber.add(tens.get(Character.getNumericValue(tensPlace)));
		} catch (ArrayIndexOutOfBoundsException e) {
			reversedNumber.add("");
		}
		
		try {
			char hundredsPlace = brokenWord[untranslatedWord.length() - 3];
			reversedNumber.add(hundreds.get(Character.getNumericValue(hundredsPlace)));
		} catch (ArrayIndexOutOfBoundsException e) {
			reversedNumber.add("");
		}
		
		for (int i = (reversedNumber.size() - 1); i >= 0; i--) {
			newRomanNumeral.append(reversedNumber.get(i));
		}
		
		return newRomanNumeral.toString().trim();
	}

	@Override
	public String translateText(String untranslatedText) {
		StringBuilder sb = new StringBuilder();

		populateHashMaps2();

//		StringReader sr = new StringReader(untranslatedText);
		String rNumeral = "(C*?D?C*M?)(X*?L?X*C?)(I*?V?I*X?)";
		Pattern p = Pattern.compile(rNumeral);
		Matcher m = p.matcher(untranslatedText);
		
		String onesPlace = m.group(3);
		String tensPlace = m.group(2);
		String hunsPlace = m.group(1);
		
		sb.append(toArabicHuns.get(hunsPlace));
		sb.append(toArabicTens.get(tensPlace));
		sb.append(toArabicOnes.get(onesPlace));
		
		return sb.toString().trim();
	}

	public void populateHashMaps2() {
		populateHashMaps();

		Set<Integer> keySetOnes = ones.keySet();
		Set<Integer> keySetTens = tens.keySet();
		Set<Integer> keySetHuns = hundreds.keySet();

		Iterator<Integer> iterOne = keySetOnes.iterator();
		Iterator<Integer> iterTens = keySetTens.iterator();
		Iterator<Integer> iterHuns = keySetHuns.iterator();

		while (iterOne.hasNext()) {
			Integer variable = iterOne.next();
			toArabicOnes.put(ones.get(variable), variable);
		}

		while (iterTens.hasNext()) {
			Integer variable = iterTens.next();
			toArabicTens.put(ones.get(variable), variable);
		}

		while (iterHuns.hasNext()) {
			Integer variable = iterHuns.next();
			toArabicHuns.put(ones.get(variable), variable);
		}
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

		tenthousands.put(1, "\u2182");
		tenthousands.put(2, "XX");
		tenthousands.put(3, "XXX");
		tenthousands.put(4, "XL");
		tenthousands.put(5, "L");
		tenthousands.put(6, "LX");
		tenthousands.put(7, "LXX");
		tenthousands.put(8, "LXXX");
		tenthousands.put(9, "XC");
		tenthousands.put(0, "");

		hunthousands.put(1, "X");
		hunthousands.put(2, "XX");
		hunthousands.put(3, "XXX");
		hunthousands.put(4, "XL");
		hunthousands.put(5, "L");
		hunthousands.put(6, "LX");
		hunthousands.put(7, "LXX");
		hunthousands.put(8, "LXXX");
		hunthousands.put(9, "XC");
		hunthousands.put(0, "");
	}
}
