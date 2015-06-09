package io.kimo.faker.mvp.presenter;

import android.content.Context;

import io.kimo.faker.mvp.BasePresenter;
import io.kimo.faker.mvp.view.NumberView;
import io.kimo.lib.faker.Faker;

public class NumberPresenter extends BasePresenter {

    public NumberPresenter(NumberView view, Context context) {
        super(view, context);
    }

    @Override
    public void configureMainView() {
        NumberView numberView = (NumberView) view;

        numberView.updateDigit(Faker.with(context).Number.digit());
        numberView.updatePositiveDigit(Faker.with(context).Number.positiveDigit());
        numberView.updateNegativeDigit(Faker.with(context).Number.negativeDigit());
        numberView.updateNumbers(Faker.with(context).Number.number());
        numberView.updatePositiveNumbers(Faker.with(context).Number.positiveNumber());
        numberView.updateNegativeNumbers(Faker.with(context).Number.negativeNumber());
    }

    @Override
    public void destroyView() {}
}
