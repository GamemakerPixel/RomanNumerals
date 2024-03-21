package edu.bsu.cs.numerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpandedFormTest {
    @Test
    public void testSecondDigitIs7(){
        int number = 4765;
        ExpandedForm expandedForm = new ExpandedForm(number);
        Assertions.assertEquals(7, expandedForm.getDigit(1));
    }

    @Test
    public void testThirdSummandIs300(){
        int number = 10368;
        ExpandedForm expandedForm = new ExpandedForm(number);
        Assertions.assertEquals(300, expandedForm.getSummand(2));
    }

    @Test
    public void testDigitCountOf6(){
        int number = 204952;
        ExpandedForm expandedForm = new ExpandedForm(number);
        Assertions.assertEquals(6, expandedForm.getDigitCount());
    }
}
