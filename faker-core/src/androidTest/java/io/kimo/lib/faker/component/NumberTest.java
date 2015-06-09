package io.kimo.lib.faker.component;

import android.test.AndroidTestCase;

import org.junit.Before;
import org.junit.Test;

public class NumberTest extends AndroidTestCase {

    private Number number;

    @Before
    public void setUp() throws Exception {
        number = new Number(getContext());
    }

    @Test
    public void testDigit() throws Exception {

        int randomDigit = number.digit();
        assertTrue(randomDigit > -10 && randomDigit < 10);

    }

    @Test
    public void testPositiveDigit() throws Exception {

        int positiveDigit = number.positiveDigit();
        assertTrue(positiveDigit >= 0 && positiveDigit < 10);

    }

    @Test
    public void testNegativeDigit() throws Exception {

        int negativeDigit = number.negativeDigit();
        assertTrue(negativeDigit < 0 && negativeDigit > -10);

    }

    @Test
    public void testNumbers() throws Exception {

        try {
            Integer.parseInt(number.number() + "");
            assertTrue(true);
        } catch (NumberFormatException e) {
            assertTrue(false);
        }

    }

    @Test
    public void testNumbersWithArguments() throws Exception {
        String randomNumber = number.number(3) + "";
        assertTrue(randomNumber.length() == 3);
    }

    @Test
    public void testNumbersWithInvalidArguments() throws Exception {
        try {
            number.number(0);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testPositiveNumbers() throws Exception {
        int randomPositiveNumber = number.positiveNumber();
        assertTrue(randomPositiveNumber > -1);
    }

    @Test
    public void testNegativeNumbers() throws Exception {
        int randomPositiveNumber = number.negativeNumber();
        assertTrue(randomPositiveNumber < 0);
    }
}