package com.skilldistillery.translator.app;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractTranslator implements Translator {

	public AbstractTranslator() {
	}

	@Override
	public String translateText(String untranslatedText) {
		RomanNumeralTranslatorImpl rnt = new RomanNumeralTranslatorImpl();
		if (untranslatedText == null) {
			return null;
		}
		else {
			String textRegex = "\\b\\w+\\b";
			Pattern textPattern = Pattern.compile(textRegex);
			Matcher textMatcher = textPattern.matcher(untranslatedText);
			List<String> unTransWords = new ArrayList<>();
			String untranslatedWord = null;

			String[] words = untranslatedText.split("\\s");
			String translatedText = "";
			for (int i = 0; i < words.length; i++) {
				if (translatedText == "") {
					translatedText = rnt.translateWord(words[i]);
				}
				else {
					translatedText = translatedText + " " + rnt.translateWord(words[i]);
				}
			}
			return translatedText;
		}

	}

}
