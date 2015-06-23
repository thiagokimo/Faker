package io.kimo.faker.mvp.presenter;

import android.content.Context;

import io.kimo.faker.mvp.BasePresenter;
import io.kimo.faker.mvp.view.ColorView;
import io.kimo.lib.faker.Faker;

public class ColorPresenter extends BasePresenter{

    public ColorPresenter(ColorView view, Context context) {
        super(view, context);
    }

    @Override
    public void configureMainView() {
        ColorView colorView = (ColorView) view;

        colorView.updateRandomColorExample(Faker.with(context).Color.randomColor());
        colorView.updateRedColorExample(Faker.with(context).Color.redColor());
        colorView.updateGreenColorExample(Faker.with(context).Color.greenColor());
        colorView.updateBlueColorExample(Faker.with(context).Color.blueColor());
        colorView.updateMonochromeColorExample(Faker.with(context).Color.monochromeColor());
        colorView.updateBrightColorExample(Faker.with(context).Color.brightColor());
        colorView.updateDarkColorExample(Faker.with(context).Color.darkColor());
        colorView.updateLightColorExample(Faker.with(context).Color.lightColor());
    }

    @Override
    public void destroyView() {

    }
}
