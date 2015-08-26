package io.kimo.lib.faker.component.number;

import android.test.AndroidTestCase;

import org.junit.Before;
import org.junit.Test;

public class NumberComponentTest extends AndroidTestCase {

    private NumberComponent numberComponent;

    @Before
    public void setUp() throws Exception {
        numberComponent = new NumberComponent(getContext());
    }

    @Test
    public void testDigit() throws Exception {

        int randomDigit = numberComponent.digit();
        assertTrue(randomDigit > -10 && randomDigit < 10);

    }

    @Test
    public void testPositiveDigit() throws Exception {

        int positiveDigit = numberComponent.positiveDigit();
        assertTrue(positiveDigit >= 0 && positiveDigit < 10);

    }

    @Test
    public void testNegativeDigit() throws Exception {

        int negativeDigit = numberComponent.negativeDigit();
        assertTrue(negativeDigit < 0 && negativeDigit > -10);

    }

    @Test
    public void testNumbers() throws Exception {

        try {
            Integer.parseInt(numberComponent.number() + "");
            assertTrue(true);
        } catch (NumberFormatException e) {
            assertTrue(false);
        }

    }

    @Test
    public void testNumbersWithArguments() throws Exception {
        for(int i = 0; i < 10000; i++) {
            String randomNumber = numberComponent.number(3) + "";
            assertTrue(randomNumber.length() == 3);
        }
    }

    @Test
    public void testNumbersWithInvalidArguments() throws Exception {
        try {
            numberComponent.number(0);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testPositiveNumbers() throws Exception {
        int randomPositiveNumber = numberComponent.positiveNumber();
        assertTrue(randomPositiveNumber > -1);
    }

    @Test
    public void testNegativeNumbers() throws Exception {
        int randomPositiveNumber = numberComponent.negativeNumber();
        assertTrue(randomPositiveNumber < 0);
    }

    @Test
    public void testRandomNumber() throws Exception {
        assertTrue(numberComponent.randomNumber() instanceof Number);
    }
}