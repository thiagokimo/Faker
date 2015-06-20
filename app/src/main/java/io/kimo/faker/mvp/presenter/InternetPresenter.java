package io.kimo.faker.mvp.presenter;

import android.content.Context;

import io.kimo.faker.mvp.BasePresenter;
import io.kimo.faker.mvp.view.InternetView;
import io.kimo.lib.faker.Faker;

public class InternetPresenter extends BasePresenter{

    public InternetPresenter(InternetView view, Context context) {
        super(view, context);
    }

    @Override
    public void configureMainView() {
        InternetView internetView = (InternetView) view;

        internetView.updateEmailExample(Faker.with(context).Internet.email());
        internetView.updateURLExample(Faker.with(context).Internet.url());
        internetView.updateDomainExample(Faker.with(context).Internet.domain());
        internetView.updateDomainSuffixExample(Faker.with(context).Internet.domainSuffix());
    }

    @Override
    public void destroyView() {}
}
