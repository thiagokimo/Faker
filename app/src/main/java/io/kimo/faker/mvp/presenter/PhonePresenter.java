package io.kimo.faker.mvp.presenter;

import android.content.Context;

import io.kimo.faker.mvp.BasePresenter;
import io.kimo.faker.mvp.View;
import io.kimo.faker.mvp.view.PhoneView;
import io.kimo.lib.faker.Faker;

public class PhonePresenter extends BasePresenter {

    public PhonePresenter(View view, Context context) {
        super(view, context);
    }

    @Override
    public void configureMainView() {
        PhoneView phoneView = (PhoneView) view;

        phoneView.updatePhoneWithAreaCodeExample(Faker.with(context).Phone.phoneWithAreaCode());
        phoneView.updatePhoneWithCountryCodeExample(Faker.with(context).Phone.phoneWithCountryCode());
    }

    @Override
    public void destroyView() {}
}
