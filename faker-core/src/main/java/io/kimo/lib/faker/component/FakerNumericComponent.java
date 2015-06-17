package io.kimo.lib.faker.component;

import android.content.Context;

import io.kimo.lib.faker.FakerCoreComponent;

public abstract class FakerNumericComponent extends FakerCoreComponent {

    public FakerNumericComponent(Context context) {
        super(context);
    }

    public abstract Number randomNumber();
}
