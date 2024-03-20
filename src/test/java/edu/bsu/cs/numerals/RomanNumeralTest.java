package edu.bsu.cs.numerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RomanNumeralTest {

    @ParameterizedTest
    @MethodSource("testSingleDigitsArgs")
    public void testSingleDigits(int digit, String expectedNumeral){
        RomanNumeral numeral = new RomanNumeral(digit);
        Assertions.assertEquals(expectedNumeral, numeral.toString());
    }

    public static Stream<Arguments> testSingleDigitsArgs(){
        return Stream.of(
                Arguments.of(1, "I"),
                Arguments.of(5, "V"),
                Arguments.of(10, "X"),
                Arguments.of(50, "L"),
                Arguments.of(100, "C"),
                Arguments.of(500, "D"),
                Arguments.of(1000, "M")
        );
    }

    @ParameterizedTest
    @MethodSource("testAdditiveNotationArgs")
    public void testAdditiveNotation(int digit, String expectedNumeral){
        RomanNumeral numeral = new RomanNumeral(digit);
        Assertions.assertEquals(expectedNumeral, numeral.toString());
    }

    public static Stream<Arguments> testAdditiveNotationArgs(){
        return Stream.of(
                Arguments.of(2, "II"),
                Arguments.of(3, "III"),
                Arguments.of(6, "VI"),
                Arguments.of(7, "VII"),
                Arguments.of(8, "VIII"),
                Arguments.of(20, "XX"),
                Arguments.of(30, "XXX"),
                Arguments.of(60, "LX"),
                Arguments.of(70, "LXX"),
                Arguments.of(80, "LXXX"),
                Arguments.of(200, "CC"),
                Arguments.of(300, "CCC"),
                Arguments.of(600, "DC"),
                Arguments.of(700, "DCC"),
                Arguments.of(800, "DCCC"),
                Arguments.of(2000, "MM"),
                Arguments.of(3000, "MMM")
        );
    }

    @ParameterizedTest
    @MethodSource("testSubtractiveNotationArgs")
    public void testSubtractiveNotation(int digit, String expectedNumeral){
        RomanNumeral numeral = new RomanNumeral(digit);
        Assertions.assertEquals(expectedNumeral, numeral.toString());
    }

    public static Stream<Arguments> testSubtractiveNotationArgs(){
        return Stream.of(
                Arguments.of(4, "IV"),
                Arguments.of(9, "IX"),
                Arguments.of(40, "XL"),
                Arguments.of(90, "XC"),
                Arguments.of(400, "CD"),
                Arguments.of(900, "CM")
        );
    }
}
