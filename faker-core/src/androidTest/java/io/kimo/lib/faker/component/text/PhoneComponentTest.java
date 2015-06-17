package io.kimo.lib.faker.component.text;

import android.test.AndroidTestCase;
import android.text.TextUtils;

import org.junit.Before;
import org.junit.Test;

public class PhoneComponentTest extends AndroidTestCase {

    private PhoneComponent phoneComponent;

    @Before
    public void setUp() throws Exception {
        phoneComponent = new PhoneComponent(getContext());
    }

    @Test
    public void testPhoneWithAreaCode() throws Exception {
        String randomPhoneNumber = phoneComponent.phoneWithAreaCode();

        assertTrue(randomPhoneNumber.contains("("));
        assertTrue(randomPhoneNumber.contains(")"));
    }

    @Test
    public void testPhoneWithCountryCode() throws Exception {
        String randomPhoneNumber = phoneComponent.phoneWithCountryCode();

        assertTrue(randomPhoneNumber.contains("-"));
    }

    @Test
    public void testRandomText() throws Exception {
        assertTrue(!TextUtils.isEmpty(phoneComponent.randomText()));
    }
}