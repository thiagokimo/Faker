package io.kimo.lib.faker.component;

import android.content.Context;

import java.util.Random;

import io.kimo.lib.faker.CoreComponent;

public class Number extends CoreComponent {

    public Number(Context context) {
        super(context);
    }

    private int randomNumberInRangePositiveOrNegative(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public int digit() {
        return randomNumberInRangePositiveOrNegative(-9, 9);
    }

    public int positiveDigit() {
        return randomNumberInRangePositiveOrNegative(0, 9);
    }

    public int negativeDigit() {
        return randomNumberInRangePositiveOrNegative(-9,-1);
    }

    public int number() {

        int randomSignal = (int) Math.random() * 10;

        if(randomSignal % 2 == 0) {
            return number(randomNumberInRangePositiveOrNegative(1, 9));
        } else {
            return -number(randomNumberInRangePositiveOrNegative(1, 9));
        }
    }

    public int number(int amountOfNumbers) {

        if(amountOfNumbers < 1) {
            throw new IllegalArgumentException("Argument must be bigger than 0");
        }

        StringBuilder randomNumbers = new StringBuilder();

        for(int i = 0; i < amountOfNumbers; i++) {
            randomNumbers.append(positiveDigit());
        }

        return Integer.parseInt(randomNumbers.toString());
    }

    public int positiveNumber() {
        return Math.abs(number());
    }

    public int negativeNumber() {
        return -positiveNumber();
    }
}
