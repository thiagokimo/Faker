package io.kimo.lib.faker;

import android.content.Context;

public abstract class FakerCoreComponent {

    protected Context context;

    public FakerCoreComponent(Context context) {
        if(context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        this.context = context;
    }
}
