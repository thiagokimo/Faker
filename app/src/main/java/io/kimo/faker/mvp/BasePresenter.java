package io.kimo.faker.mvp;

import android.content.Context;

public abstract class BasePresenter implements Presenter {

    protected View view;
    protected Context context;

    public BasePresenter(View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void createView() {
        hideAllViews();

        view.showLoading();
        configureMainView();
        view.hideLoading();

        view.showView();
    }

    public void hideAllViews() {
        view.hideView();
        view.hideLoading();
    }

    public abstract void configureMainView();
}
