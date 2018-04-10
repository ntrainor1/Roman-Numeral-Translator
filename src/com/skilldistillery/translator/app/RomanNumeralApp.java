package com.skilldistillery.translator.app;

import java.util.Scanner;

public class RomanNumeralApp {
	public static void main(String[] args) {
		RomanNumeralApp rna = new RomanNumeralApp();
		rna.translatorApp();
	}

	private void translatorApp() {
		RomanNumeralTranslatorImpl plt = new RomanNumeralTranslatorImpl();
		Scanner kb = new Scanner(System.in);

		System.out.println("WELCOME TO ROMAN NUMERAL TRANSLATOR!");
		System.out.println("Input an Arabic numeral:");
		String arabicNum = kb.next();
		System.out.println(plt.translateNumeral(arabicNum));

		kb.close();
	}
}
