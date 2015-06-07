package io.kimo.lib.faker;

import android.content.Context;

public abstract class FakerComponent {

    protected Context context;

    public FakerComponent(Context context) {
        if(context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        this.context = context;
    }
}
