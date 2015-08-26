package io.kimo.lib.faker.component.text;

import android.content.Context;

import io.kimo.lib.faker.api.UrlAPI;
import io.kimo.lib.faker.component.FakerTextComponent;

public class URLComponent extends FakerTextComponent implements UrlAPI {

    private static final String BASE_IMAGE_URL = "http://lorempixel.com/";
    private static final String BASE_AVATAR_URL = "https://robohash.org/";
    private static final int DEFAULT_DIMENSION = 300;

    private NameComponent nameComponent;

    public URLComponent(Context context) {
        super(context);
        nameComponent = new NameComponent(context);
    }

    @Override
    public String randomText() {
        int method = (int)(Math.random() * 10);

        switch (method % 2) {
            case 0:
                return image();
            case 1:
                return avatar();
            default:
                return "";
        }
    }

    @Override
    public String image() {
        return image(DEFAULT_DIMENSION,DEFAULT_DIMENSION);
    }

    @Override
    public String image(int width, int height) {
        return BASE_IMAGE_URL + width + "/" + height;
    }

    @Override
    public String avatar() {
        return avatar(DEFAULT_DIMENSION,DEFAULT_DIMENSION);
    }

    @Override
    public String avatar(int width, int height) {
        return BASE_AVATAR_URL + nameComponent.firstName() + "?size=" + width + "x" + height;
    }
}
