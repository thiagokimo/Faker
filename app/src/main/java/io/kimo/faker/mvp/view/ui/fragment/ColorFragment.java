package io.kimo.faker.mvp.view.ui.fragment;

import android.view.View;
import android.widget.Toast;

import io.kimo.faker.R;
import io.kimo.faker.mvp.BaseView;
import io.kimo.faker.mvp.presenter.ColorPresenter;
import io.kimo.faker.mvp.view.ColorView;

public class ColorFragment extends BaseView implements ColorView {

    private View mainView, loadingView, random, red, green, blue, monochrome, bright, dark, light;

    private ColorPresenter presenter;

    public static ColorFragment newInstance() {
        return new ColorFragment();
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_color;
    }

    @Override
    public void mapGUI(View view) {
        mainView = view.findViewById(R.id.main_container);
        loadingView = view.findViewById(R.id.view_loading);
        random = view.findViewById(R.id.random_color);
        red = view.findViewById(R.id.red_color);
        green = view.findViewById(R.id.green_color);
        blue = view.findViewById(R.id.blue_color);
        monochrome = view.findViewById(R.id.monochrome_color);
        bright = view.findViewById(R.id.bright_color);
        dark = view.findViewById(R.id.dark_color);
        light = view.findViewById(R.id.light_color);
    }

    @Override
    public void configureGUI() {
        getActivity().setTitle("Color");
    }

    @Override
    public void startPresenter() {
        presenter = new ColorPresenter(this, getActivity());
        presenter.createView();
    }

    @Override
    public void stopPresenter() {
        presenter.destroyView();
    }

    @Override
    public void updateRandomColorExample(int color) {
        random.setBackgroundColor(color);
    }

    @Override
    public void updateRedColorExample(int color) {
        red.setBackgroundColor(color);
    }

    @Override
    public void updateGreenColorExample(int color) {
        green.setBackgroundColor(color);
    }

    @Override
    public void updateBlueColorExample(int color) {
        blue.setBackgroundColor(color);
    }

    @Override
    public void updateMonochromeColorExample(int color) {
        monochrome.setBackgroundColor(color);
    }

    @Override
    public void updateBrightColorExample(int color) {
        bright.setBackgroundColor(color);
    }

    @Override
    public void updateLightColorExample(int color) {
        light.setBackgroundColor(color);
    }

    @Override
    public void updateDarkColorExample(int color) {
        dark.setBackgroundColor(color);
    }

    @Override
    public void showFeedback(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showView() {
        mainView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideView() {
        mainView.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingView.setVisibility(View.GONE);
    }
}
