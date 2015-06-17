package io.kimo.lib.faker.component.text;

import android.test.AndroidTestCase;
import android.text.TextUtils;
import android.webkit.URLUtil;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import io.kimo.lib.faker.R;

public class InternetComponentTest extends AndroidTestCase {

    private InternetComponent internetComponent;
    private NameComponent nameComponent;
    private LoremComponent loremComponent;
    private List<String> domainSuffixes;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Before
    public void setUp() throws Exception {
        internetComponent = new InternetComponent(getContext());
        nameComponent = new NameComponent(getContext());
        loremComponent = new LoremComponent(getContext());
        domainSuffixes = Arrays.asList(getContext().getResources().getStringArray(R.array.domain_suffixes));
    }

    @Test
    public void testEmail() throws Exception {
        for(int i = 0; i < 1000; i++) {
            String randomEmail = internetComponent.email();

            assertTrue(randomEmail.matches(EMAIL_PATTERN));
            assertTrue(randomEmail.toLowerCase().equals(randomEmail));
        }
    }

    @Test
    public void testEmailWithArguments() throws Exception {
        for(int i = 0; i < 1000; i++) {
            String randomName = nameComponent.firstName().toLowerCase();
            String randomDomain = nameComponent.lastName().toLowerCase();
            String randomDomainSuffix = internetComponent.domainSuffix();

            String randomEmail = internetComponent.email(randomName, randomDomain, randomDomainSuffix);

            assertTrue(randomEmail.contains(randomName));
            assertTrue(randomEmail.contains(randomDomain));
            assertTrue(randomEmail.contains(randomDomainSuffix));
            assertTrue(randomEmail.matches(EMAIL_PATTERN));
        }
    }

    @Test
    public void testDomainSuffix() throws Exception {
        for(int i = 0; i < 1000; i++) {
            assertTrue(domainSuffixes.contains(internetComponent.domainSuffix().replace(".", "")));
        }
    }

    @Test
    public void testDomainSuffixWithArguments() throws Exception {
        for(int i = 0; i < 1000; i++) {
            String randomSuffix = loremComponent.characters(3);
            assertTrue(internetComponent.domainSuffix(randomSuffix).contains(randomSuffix));
        }
    }

    @Test
    public void testDomain() throws Exception {
        for(int i = 0; i < 1000; i++) {
            String randomDomain = internetComponent.domain();
            assertFalse(TextUtils.isEmpty(randomDomain));
            assertTrue(randomDomain.toLowerCase().equals(randomDomain));
        }
    }

    @Test
    public void testUrl() throws Exception {
        for(int i = 0; i < 1000; i++) {
            String randomURL = internetComponent.url();
            assertTrue(URLUtil.isValidUrl(randomURL));
            assertTrue(randomURL.toLowerCase().equals(randomURL));
        }
    }

    @Test
    public void testUrlWithArguments() throws Exception {
        for(int i = 0; i < 1000; i++) {

            String randomDomain = internetComponent.domain();
            String randomSuffix = internetComponent.domainSuffix();

            String randomURL = internetComponent.url(randomDomain, randomSuffix);
            assertTrue(randomURL.contains(randomDomain));
            assertTrue(randomURL.contains(randomSuffix));
        }
    }

    @Test
    public void testRandomText() throws Exception {
        assertTrue(!TextUtils.isEmpty(internetComponent.randomText()));
    }
}