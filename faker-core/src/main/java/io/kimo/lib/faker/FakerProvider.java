package io.kimo.lib.faker;

import android.content.Context;

import io.kimo.lib.faker.component.Lorem;
import io.kimo.lib.faker.component.Name;

public class FakerProvider {

    public static Lorem Lorem;
    public static io.kimo.lib.faker.component.Name Name;

    public FakerProvider(Context context) {
        Lorem = new Lorem(context);
        Name = new Name(context);
    }


}
