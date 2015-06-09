package io.kimo.lib.faker.component;

import android.content.Context;

import io.kimo.lib.faker.CoreComponent;
import io.kimo.lib.faker.R;

public class Phone extends CoreComponent {

    private String areaCodeMask, countryCodeMask;
    private Number number;

    public Phone(Context context) {
        super(context);
        number = new Number(context);
        areaCodeMask = context.getResources().getString(R.string.area_code_phone_mask);
        countryCodeMask = context.getResources().getString(R.string.country_code_phone_mask);
    }

    private String numbersInMask(String mask, char maskPlaceholder) {

        StringBuilder phoneInMask = new StringBuilder();
        for(int i = 0; i < mask.length(); i++) {

            char currentChar = mask.charAt(i);

            if(currentChar == maskPlaceholder) {
                phoneInMask.append(number.positiveDigit());
            } else {
                phoneInMask.append(currentChar);
            }
        }

        return phoneInMask.toString();
    }

    public String phoneWithAreaCode() {
        return numbersInMask(areaCodeMask, '#');
    }

    public String phoneWithCountryCode() {
        return numbersInMask(countryCodeMask, '#');
    }
}
