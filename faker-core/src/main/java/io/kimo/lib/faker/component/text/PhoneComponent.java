package io.kimo.lib.faker.component.text;

import android.content.Context;

import java.lang.*;

import io.kimo.lib.faker.R;
import io.kimo.lib.faker.component.FakerTextComponent;
import io.kimo.lib.faker.component.number.NumberComponent;

public class PhoneComponent extends FakerTextComponent {

    private String areaCodeMask, countryCodeMask;
    private NumberComponent numberComponent;

    public PhoneComponent(Context context) {
        super(context);
        numberComponent = new NumberComponent(context);
        areaCodeMask = context.getResources().getString(R.string.area_code_phone_mask);
        countryCodeMask = context.getResources().getString(R.string.country_code_phone_mask);
    }

    @Override
    public String randomText() {
        int method = (int)(Math.random() * 10);

        switch (method % 2) {
            case 0:
                return phoneWithAreaCode();
            case 1:
                return phoneWithCountryCode();
            default:
                return "";
        }
    }

    private String numbersInMask(String mask, char maskPlaceholder) {

        StringBuilder phoneInMask = new StringBuilder();
        for(int i = 0; i < mask.length(); i++) {

            char currentChar = mask.charAt(i);

            if(currentChar == maskPlaceholder) {
                phoneInMask.append(numberComponent.positiveDigit());
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
