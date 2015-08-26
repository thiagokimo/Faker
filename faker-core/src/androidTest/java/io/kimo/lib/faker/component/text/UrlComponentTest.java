package io.kimo.lib.faker.component.text;

import android.test.AndroidTestCase;

import org.junit.Before;
import org.junit.Test;

import io.kimo.lib.faker.component.number.NumberComponent;

public class UrlComponentTest extends AndroidTestCase {

    private URLComponent url;
    private NumberComponent numberComponent;
    private String imageRegex = "http:\\/\\/lorempixel.com\\/\\d+\\/\\d+";
    private String avatarRegex = "https:\\/\\/robohash.org\\/.+";

    @Before
    public void setUp() throws Exception {
        url = new URLComponent(getContext());
        numberComponent = new NumberComponent(getContext());
    }

    @Test
    public void testImage() throws Exception {
        String randomURL = url.image();

        assertTrue(randomURL.matches(imageRegex));
    }

    @Test
    public void testImageWithArguments() throws Exception {
        int randomWidth = numberComponent.number(3);
        int randomHeight = numberComponent.number(3);

        String randomURL = url.image(randomWidth, randomHeight);

        assertTrue(randomURL.contains(String.valueOf(randomHeight)));
        assertTrue(randomURL.contains(String.valueOf(randomWidth)));
    }

    @Test
    public void testAvatar() throws Exception {
        String randomAvatarURL = url.avatar();

        assertTrue(randomAvatarURL.matches(avatarRegex));
    }

    @Test
    public void testAvatarWithArguments() throws Exception {
        int randomWidth = numberComponent.number(3);
        int randomHeight = numberComponent.number(3);

        String randomURL = url.avatar(randomWidth, randomHeight);

        assertTrue(randomURL.contains(String.valueOf(randomHeight)));
        assertTrue(randomURL.contains(String.valueOf(randomWidth)));
    }
}