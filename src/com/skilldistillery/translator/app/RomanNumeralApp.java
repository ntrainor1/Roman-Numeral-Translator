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
		int userInput;

		System.out.println("Choose between Arabic-Roman conversion and Roman-Arabic conversion: (1/2)");
		userInput = kb.nextInt();
		
		switch (userInput) {
		case 1:
			System.out.println("Input an Arabic numeral:");
			String arabicNum = kb.next();
			System.out.println(plt.translateWord(arabicNum));
			break;
		case 2:
			System.out.println("Input an Roman numeral:");
			String romanNum = kb.next();
			System.out.println(plt.translateText(romanNum));
			break;
		default:
			break;
		}
		

		kb.close();
	}
}
