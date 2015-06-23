package io.kimo.lib.faker.component.number;

import android.content.Context;

import com.github.lzyzsd.randomcolor.RandomColor;

import io.kimo.lib.faker.api.ColorAPI;
import io.kimo.lib.faker.component.FakerColorComponent;

/**
 * Provides random colors based on AndroidRandomColor by lzyzsd (https://github.com/lzyzsd/AndroidRandomColor)
 */
public class ColorComponent extends FakerColorComponent implements ColorAPI {

    public ColorComponent(Context context) {
        super(context);
    }

    @Override
    public Number randomNumber() {
        return randomColor();
    }

    @Override
    public int randomColor() {
        return new RandomColor().randomColor();
    }


    @Override
    public int redColor() {
        return new RandomColor().randomColor(RandomColor.Color.RED);
    }

    @Override
    public int[] redColors(int numberOfRedColors) {
        return new RandomColor().random(RandomColor.Color.RED, numberOfRedColors);
    }

    @Override
    public int greenColor() {
        return new RandomColor().randomColor(RandomColor.Color.GREEN);
    }

    @Override
    public int[] greenColors(int numberOfGreenColors) {
        return new RandomColor().random(RandomColor.Color.GREEN, numberOfGreenColors);
    }

    @Override
    public int blueColor() {
        return new RandomColor().randomColor(RandomColor.Color.BLUE);
    }

    @Override
    public int[] blueColors(int numberOfBlueColors) {
        return new RandomColor().random(RandomColor.Color.BLUE, numberOfBlueColors);
    }

    @Override
    public int monochromeColor() {
        return new RandomColor().randomColor(randomColor(), RandomColor.SaturationType.MONOCHROME, RandomColor.Luminosity.RANDOM);
    }

    @Override
    public int brightColor() {
        return new RandomColor().randomColor(randomColor(), RandomColor.SaturationType.RANDOM, RandomColor.Luminosity.BRIGHT);
    }

    @Override
    public int lightColor() {
        return new RandomColor().randomColor(randomColor(), RandomColor.SaturationType.RANDOM, RandomColor.Luminosity.LIGHT);
    }

    @Override
    public int darkColor() {
        return new RandomColor().randomColor(randomColor(), RandomColor.SaturationType.RANDOM, RandomColor.Luminosity.DARK);
    }
}
