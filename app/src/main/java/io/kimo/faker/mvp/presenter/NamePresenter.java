package io.kimo.faker.mvp.presenter;

import android.content.Context;

import io.kimo.faker.mvp.BasePresenter;
import io.kimo.faker.mvp.view.NameView;
import io.kimo.lib.faker.Faker;

public class NamePresenter extends BasePresenter {

    public NamePresenter(NameView view, Context context) {
        super(view, context);
    }

    @Override
    public void configureMainView() {
        NameView nameView = (NameView) view;

        nameView.updateCompleteNameExample(Faker.with(context).Name
                .completeName());
        nameView.updateFullNameExample(Faker.with(context).Name
                .fullName());
        nameView.updateFirstNameExample(Faker.with(context).Name
                .firstName());
        nameView.updateLastNameExample(Faker.with(context).Name
                .lastName());
        nameView.updatePrefixExample(Faker.with(context).Name
                .prefix());
        nameView.updateSuffixExample(Faker.with(context).Name
                .suffix());
        nameView.updateTitleExample(Faker.with(context).Name
                .title());
    }

    @Override
    public void destroyView() {}
}
