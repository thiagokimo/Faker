package io.kimo.lib.faker;

import android.content.Context;

public class Faker {

    private static FakerProvider instance = null;

    public static FakerProvider with(Context context) {
        if(instance == null) {
            synchronized (Faker.class) {
                if (instance == null) {
                    instance = new FakerProvider(context);
                }
            }
        }

        return instance;
    }
}
