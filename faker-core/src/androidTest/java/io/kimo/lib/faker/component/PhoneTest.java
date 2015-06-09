package io.kimo.lib.faker.component;

import android.test.AndroidTestCase;

import org.junit.Before;
import org.junit.Test;

public class PhoneTest extends AndroidTestCase {

    private Phone phone;

    @Before
    public void setUp() throws Exception {
        phone = new Phone(getContext());
    }

    @Test
    public void testPhoneWithAreaCode() throws Exception {
        String randomPhoneNumber = phone.phoneWithAreaCode();

        assertTrue(randomPhoneNumber.contains("("));
        assertTrue(randomPhoneNumber.contains(")"));
    }

    @Test
    public void testPhoneWithCountryCode() throws Exception {
        String randomPhoneNumber = phone.phoneWithCountryCode();

        assertTrue(randomPhoneNumber.contains("-"));
    }
}