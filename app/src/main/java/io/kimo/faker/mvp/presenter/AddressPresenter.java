package io.kimo.faker.mvp.presenter;

import android.content.Context;

import io.kimo.faker.mvp.BasePresenter;
import io.kimo.faker.mvp.view.AddressView;
import io.kimo.lib.faker.Faker;

public class AddressPresenter extends BasePresenter{

    public AddressPresenter(AddressView view, Context context) {
        super(view, context);
    }

    @Override
    public void configureMainView() {
        AddressView addressView = (AddressView) view;

        addressView.updateCityExample(Faker.with(context).Address.city());
        addressView.updateStreetExample(Faker.with(context).Address.street());
        addressView.updateSecondaryAddressExample(Faker.with(context).Address.secondaryAddress());
        addressView.updateZipcodeExample(Faker.with(context).Address.zipCode());
        addressView.updateTimezoneExample(Faker.with(context).Address.timeZone());
        addressView.updateCityPrefixExample(Faker.with(context).Address.cityPrefix());
        addressView.updateCitySuffixExample(Faker.with(context).Address.citySuffix());
        addressView.updateStateExample(Faker.with(context).Address.state());
        addressView.updateStateAbbrvExample(Faker.with(context).Address.stateAbbreviation());
        addressView.updateCountryExample(Faker.with(context).Address.country());
        addressView.updateCountryAbbrvExample(Faker.with(context).Address.countryAbbreviation());
        addressView.updateLatitudeExample(Faker.with(context).Address.latitude());
        addressView.updateLongitudeExample(Faker.with(context).Address.longitude());
    }

    @Override
    public void destroyView() {

    }
}
