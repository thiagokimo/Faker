package io.kimo.lib.faker.api;

import java.util.Random;

public interface NumberAPI {

    void setSeed(Random random);

    int digit();
    int positiveDigit();
    int negativeDigit();
    int number();
    int number(int amountOfDigits);
    int positiveNumber();
    int negativeNumber();
}
