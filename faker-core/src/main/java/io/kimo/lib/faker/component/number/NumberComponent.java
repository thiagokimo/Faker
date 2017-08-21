package io.kimo.lib.faker.component.number;

import android.content.Context;

import java.util.Random;

import io.kimo.lib.faker.api.NumberAPI;
import io.kimo.lib.faker.component.FakerNumericComponent;

public class NumberComponent extends FakerNumericComponent implements NumberAPI {

    private Random mRandom = new Random();

    public NumberComponent(Context context) {
        super(context);
    }

    @Override
    public Number randomNumber() {
        int method = (int)(Math.random() * 10);

        switch (method % 6) {
            case 0:
                return digit();
            case 1:
                return positiveDigit();
            case 2:
                return negativeDigit();
            case 3:
                return number();
            case 4:
                return positiveNumber();
            case 5:
                return negativeNumber();
            default:
                return 0;
        }
    }

    private int randomNumberInRangePositiveOrNegative(int min, int max) {
        return mRandom.nextInt((max - min) + 1) + min;
    }

    @Override
    public void setSeed(Random random) {
        mRandom = random;
    }

    public Random getSeed() {
        return mRandom;
    }

    @Override
    public int digit() {
        return randomNumberInRangePositiveOrNegative(-9, 9);
    }

    @Override
    public int positiveDigit() {
        return randomNumberInRangePositiveOrNegative(0, 9);
    }

    @Override
    public int negativeDigit() {
        return randomNumberInRangePositiveOrNegative(-9,-1);
    }

    @Override
    public int number() {

        int randomSignal = (int) (Math.random() * 10);

        if(randomSignal % 2 == 0) {
            return number(randomNumberInRangePositiveOrNegative(1, 9));
        } else {
            return -number(randomNumberInRangePositiveOrNegative(1, 9));
        }
    }

    @Override
    public int number(int amountOfDigits) {

        if(amountOfDigits < 1) {
            throw new IllegalArgumentException("Argument must be bigger than 0");
        }

        StringBuilder randomNumbers = new StringBuilder();

        for(int i = 0; i < amountOfDigits; i++) {
            randomNumbers.append(randomNumberInRangePositiveOrNegative(1,9));
        }

        return Math.abs(Integer.parseInt(randomNumbers.toString()));
    }

    @Override
    public int positiveNumber() {
        return Math.abs(number());
    }

    @Override
    public int negativeNumber() {
        return -positiveNumber();
    }
}
