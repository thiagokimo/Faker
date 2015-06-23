package io.kimo.faker.mvp.view;

import io.kimo.faker.mvp.View;

public interface ColorView extends View {

    void updateRandomColorExample(int color);

    void updateRedColorExample(int color);
    void updateGreenColorExample(int color);
    void updateBlueColorExample(int color);

    void updateMonochromeColorExample(int color);
    void updateBrightColorExample(int color);

    void updateLightColorExample(int color);
    void updateDarkColorExample(int color);
}
