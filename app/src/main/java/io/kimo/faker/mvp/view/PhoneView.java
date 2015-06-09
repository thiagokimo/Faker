package io.kimo.faker.mvp.view;

import io.kimo.faker.mvp.View;

public interface PhoneView extends View {
    void updatePhoneWithAreaCodeExample(String value);
    void updatePhoneWithCountryCodeExample(String value);
}
