package io.kimo.lib.faker;

import android.content.Context;

public abstract class CoreComponent {

    protected Context context;

    public CoreComponent(Context context) {
        if(context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        this.context = context;
    }
}
