package io.kimo.faker.mvp.presenter;

import android.content.Context;

import io.kimo.faker.mvp.BasePresenter;
import io.kimo.faker.mvp.view.UrlView;
import io.kimo.lib.faker.Faker;

public class UrlPresenter extends BasePresenter{

    public UrlPresenter(UrlView view, Context context) {
        super(view, context);
    }

    @Override
    public void configureMainView() {
        UrlView urlView = (UrlView) view;

        urlView.updateImageUrlExample(Faker.with(context).Url.image());
        urlView.updateAvatarUrlExample(Faker.with(context).Url.avatar());
    }

    @Override
    public void destroyView() {

    }
}
