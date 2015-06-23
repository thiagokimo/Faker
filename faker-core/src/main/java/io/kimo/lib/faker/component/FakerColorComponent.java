package io.kimo.lib.faker.component;

import android.content.Context;

public abstract class FakerColorComponent extends FakerNumericComponent {

    public FakerColorComponent(Context context) {
        super(context);
    }

    public abstract int randomColor();
}
