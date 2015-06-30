package io.kimo.faker.mvp.view;

import io.kimo.faker.mvp.View;

public interface AddressView extends View {
    void updateCityExample(String value);
    void updateStreetExample(String value);
    void updateSecondaryAddressExample(String value);
    void updateZipcodeExample(String value);
    void updateTimezoneExample(String value);
    void updateCityPrefixExample(String value);
    void updateCitySuffixExample(String value);
    void updateStateExample(String value);
    void updateStateAbbrvExample(String value);
    void updateCountryExample(String value);
    void updateCountryAbbrvExample(String value);
    void updateLatitudeExample(String value);
    void updateLongitudeExample(String value);
}
