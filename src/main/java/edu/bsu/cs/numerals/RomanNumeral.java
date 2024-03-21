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
        StringBuilder result = new StringBuilder();
        ExpandedForm expandedForm = new ExpandedForm(value);
        for (int digitIndex = 0; digitIndex < expandedForm.getDigitCount(); digitIndex++){
            if (expandedForm.getDigit(digitIndex) == 4 || expandedForm.getDigit(digitIndex) == 9){
                result.append(getSubtractiveNotation(expandedForm.getSummand(digitIndex)));
            }
            else{
                result.append(getAdditiveNotation(expandedForm.getSummand(digitIndex)));
            }
        }

        return result.toString();
    }

    private String getAdditiveNotation(int remainder){
        StringBuilder representation = new StringBuilder();

        for (int arabicKey: arabicKeys){
            int quotient = remainder / arabicKey;
            remainder -= quotient * arabicKey;

            representation.append(arabicRomanDigitMap.get(arabicKey).repeat(quotient));
        }

        return representation.toString();
    }

    private String getSubtractiveNotation(int remainder){
        StringBuilder representation = new StringBuilder();

        int reversalIndex = findSubtractiveReversalIndex(remainder);
        int reversalKey = arabicKeys[reversalIndex];
        remainder = reversalKey - remainder;
        representation.append(arabicRomanDigitMap.get(reversalKey));

        for (int keyIndex = reversalIndex + 1; keyIndex < arabicKeys.length; keyIndex++) {
            if (arabicKeys[keyIndex] == remainder){
                representation.insert(0, arabicRomanDigitMap.get(arabicKeys[keyIndex]));
            }
        }

        return representation.toString();
    }

    private int findSubtractiveReversalIndex(int remainder){
        for (int keyIndex = arabicKeys.length - 2; keyIndex >= 1; keyIndex--){
            int arabicKey = arabicKeys[keyIndex];
            if (arabicKey > remainder){
                return keyIndex;
            }
        }
        return 0;
    }
}
