package io.kimo.faker.mvp.view;

import io.kimo.faker.mvp.View;

public interface NumberView extends View {
    void updateDigit(int value);
    void updatePositiveDigit(int value);
    void updateNegativeDigit(int value);
    void updateNumbers(int value);
    void updatePositiveNumbers(int value);
    void updateNegativeNumbers(int value);
}
