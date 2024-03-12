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
}
