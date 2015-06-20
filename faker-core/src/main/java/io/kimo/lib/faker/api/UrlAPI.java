package io.kimo.lib.faker.api;

public interface UrlAPI {
    String image();
    String image(int width, int height);

    String avatar();
    String avatar(int width, int height);
}
