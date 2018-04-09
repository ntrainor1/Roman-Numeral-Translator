package com.skilldistillery.translator.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.translator.app.RomanNumeralTranslatorImpl;

public class TranslatorRomanNumeralImplTests {

    private RomanNumeralTranslatorImpl tr;
    
    @Before
    public void setUp() throws Exception {
        tr = new RomanNumeralTranslatorImpl();
    }

    @After
    public void tearDown() throws Exception {
        tr = null;
    }

    @Test
    public void test_non_integer_returns_original_string() {
        assertEquals("Frog", tr.translateWord("Frog"));
        assertEquals("3.1415", tr.translateWord("3.1415"));
    }

    @Test
    public void test_first_ten_numerals_print_correctly() {
        assertEquals("I", tr.translateWord("1"));
        assertEquals("II", tr.translateWord("2"));
        assertEquals("III", tr.translateWord("3"));
        assertEquals("IV", tr.translateWord("4"));
        assertEquals("V", tr.translateWord("5"));
        assertEquals("VI", tr.translateWord("6"));
        assertEquals("VII", tr.translateWord("7"));
        assertEquals("VIII", tr.translateWord("8"));
        assertEquals("IX", tr.translateWord("9"));
        assertEquals("X", tr.translateWord("10"));
    }
    
    @Test
    public void test_eleven_to_twenty() {
        assertEquals("XI", tr.translateWord("11"));
        assertEquals("XII", tr.translateWord("12"));
        assertEquals("XIII", tr.translateWord("13"));
        assertEquals("XIV", tr.translateWord("14"));
        assertEquals("XV", tr.translateWord("15"));
        assertEquals("XVI", tr.translateWord("16"));
        assertEquals("XVII", tr.translateWord("17"));
        assertEquals("XVIII", tr.translateWord("18"));
        assertEquals("XIX", tr.translateWord("19"));
        assertEquals("XX", tr.translateWord("20"));
    }
    
    @Test
    public void test_40_to_50(){
        assertEquals("XL", tr.translateWord("40"));
        assertEquals("XLI", tr.translateWord("41"));
        assertEquals("XLII", tr.translateWord("42"));
        assertEquals("XLIII", tr.translateWord("43"));
        assertEquals("XLIV", tr.translateWord("44"));
        assertEquals("XLV", tr.translateWord("45"));
        assertEquals("XLVI", tr.translateWord("46"));
        assertEquals("XLVII", tr.translateWord("47"));
        assertEquals("XLVIII", tr.translateWord("48"));
        assertEquals("XLIX", tr.translateWord("49"));
        assertEquals("L", tr.translateWord("50"));
    }

}