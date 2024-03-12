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

    public static final int[] arabicKeys = {1000, 500, 100, 50, 10, 5, 1};

    private final int value;

    public RomanNumeral(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return convertToRomanNumeralRepresentation();
    }

    private String convertToRomanNumeralRepresentation(){
        StringBuilder representation = new StringBuilder();
        int remainder = value;

        for (int arabicKey: arabicKeys){
            int quotient = remainder / arabicKey;
            remainder -= quotient * arabicKey;
            representation.append(arabicRomanDigitMap.get(arabicKey).repeat(quotient));
        }

        return representation.toString();
    }
}
