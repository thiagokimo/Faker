package io.kimo.faker.mvp;

public interface View {

    void showFeedback(String msg);

    void showView();
    void hideView();

    void showLoading();
    void hideLoading();
}
