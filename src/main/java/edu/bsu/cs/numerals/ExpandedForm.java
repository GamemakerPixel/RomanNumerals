package edu.bsu.cs.numerals;

public class ExpandedForm {
    private final int[] expanded;
    private final int[] digits;

    public ExpandedForm(int number){
        int digitCount = (int) Math.log10(number) + 1;
        expanded = new int[digitCount];
        digits = new int[digitCount];

        int remainder = number;
        for (int digitIndex = 0; digitIndex < digitCount; digitIndex++){
            int powerOfTen = digitCount - digitIndex - 1;
            int baseTenMultiplier = (int) Math.pow(10, powerOfTen);

            expanded[digitIndex] = remainder - remainder % baseTenMultiplier;
            digits[digitIndex] = remainder / baseTenMultiplier;

            remainder -= expanded[digitIndex];
        }
    }

    public int getSummand(int index){
        return expanded[index];
    }

    public int getDigit(int index){
        return digits[index];
    }

    public int getDigitCount(){
        return digits.length;
    }
}
