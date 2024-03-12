package edu.bsu.cs.numerals;

import java.util.HashMap;

public class RomanNumeral {
    public static final HashMap<Integer, String> arabicRomanDigitMap = new HashMap<>(){{
        put(1, "I");
        put(5, "V");
        put(10, "X");
        put(50, "L");
        put(100, "C");
        put(500, "D");
        put(1000, "M");
    }};

    private final int value;

    public RomanNumeral(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return convertToRomanNumeralRepresentation();
    }

    private String convertToRomanNumeralRepresentation(){
        return arabicRomanDigitMap.get(value);
    }
}
