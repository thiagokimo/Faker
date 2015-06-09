package io.kimo.lib.faker;

import android.content.Context;

import io.kimo.lib.faker.component.Lorem;
import io.kimo.lib.faker.component.Name;
import io.kimo.lib.faker.component.Number;
import io.kimo.lib.faker.component.Phone;

public class FakerProvider {

    public static Lorem Lorem;
    public static Name Name;
    public static Number Number;
    public static Phone Phone;

    public FakerProvider(Context context) {
        Lorem = new Lorem(context);
        Name = new Name(context);
        Number = new Number(context);
        Phone = new Phone(context);
    }
}
