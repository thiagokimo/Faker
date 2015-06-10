package io.kimo.lib.faker.component;

import android.test.AndroidTestCase;
import android.text.TextUtils;
import android.webkit.URLUtil;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import io.kimo.lib.faker.R;

public class InternetTest extends AndroidTestCase {

    private Internet internet;
    private Name name;
    private Lorem lorem;
    private List<String> domainSuffixes;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Before
    public void setUp() throws Exception {
        internet = new Internet(getContext());
        name = new Name(getContext());
        lorem = new Lorem(getContext());
        domainSuffixes = Arrays.asList(getContext().getResources().getStringArray(R.array.domain_suffixes));
    }

    @Test
    public void testEmail() throws Exception {
        for(int i = 0; i < 1000; i++) {
            String randomEmail = internet.email();

            assertTrue(randomEmail.matches(EMAIL_PATTERN));
            assertTrue(randomEmail.toLowerCase().equals(randomEmail));
        }
    }

    @Test
    public void testEmailWithArguments() throws Exception {
        for(int i = 0; i < 1000; i++) {
            String randomName = name.firstName().toLowerCase();
            String randomDomain = name.lastName().toLowerCase();
            String randomDomainSuffix = internet.domainSuffix();

            String randomEmail = internet.email(randomName, randomDomain, randomDomainSuffix);

            assertTrue(randomEmail.contains(randomName));
            assertTrue(randomEmail.contains(randomDomain));
            assertTrue(randomEmail.contains(randomDomainSuffix));
            assertTrue(randomEmail.matches(EMAIL_PATTERN));
        }
    }

    @Test
    public void testDomainSuffix() throws Exception {
        for(int i = 0; i < 1000; i++) {
            assertTrue(domainSuffixes.contains(internet.domainSuffix().replace(".", "")));
        }
    }

    @Test
    public void testDomainSuffixWithArguments() throws Exception {
        for(int i = 0; i < 1000; i++) {
            String randomSuffix = lorem.characters(3);
            assertTrue(internet.domainSuffix(randomSuffix).contains(randomSuffix));
        }
    }

    @Test
    public void testDomain() throws Exception {
        for(int i = 0; i < 1000; i++) {
            String randomDomain = internet.domain();
            assertFalse(TextUtils.isEmpty(randomDomain));
            assertTrue(randomDomain.toLowerCase().equals(randomDomain));
        }
    }

    @Test
    public void testUrl() throws Exception {
        for(int i = 0; i < 1000; i++) {
            String randomURL = internet.url();
            assertTrue(URLUtil.isValidUrl(randomURL));
            assertTrue(randomURL.toLowerCase().equals(randomURL));
        }
    }

    @Test
    public void testUrlWithArguments() throws Exception {
        for(int i = 0; i < 1000; i++) {

            String randomDomain = internet.domain();
            String randomSuffix = internet.domainSuffix();

            String randomURL = internet.url(randomDomain, randomSuffix);
            assertTrue(randomURL.contains(randomDomain));
            assertTrue(randomURL.contains(randomSuffix));
        }
    }
}