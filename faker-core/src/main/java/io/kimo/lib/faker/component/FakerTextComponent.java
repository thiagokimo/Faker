package io.kimo.lib.faker.component;

import android.content.Context;

import io.kimo.lib.faker.FakerCoreComponent;

public abstract class FakerTextComponent extends FakerCoreComponent {

    public FakerTextComponent(Context context) {
        super(context);
    }

    public abstract String randomText();
}
