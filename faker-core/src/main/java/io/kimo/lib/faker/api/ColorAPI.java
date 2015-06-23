package io.kimo.lib.faker.api;

public interface ColorAPI {

    int redColor();
    int [] redColors(int numberOfRedColors);

    int greenColor();
    int [] greenColors(int numberOfGreenColors);

    int blueColor();
    int [] blueColors(int numberOfBlueColors);

    int monochromeColor();
    int brightColor();

    int lightColor();
    int darkColor();
}
