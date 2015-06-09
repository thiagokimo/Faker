package io.kimo.faker.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseView extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(), container, false);
        mapGUI(view);
        configureGUI();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        startPresenter();
    }

    @Override
    public void onStop() {
        super.onStop();
        stopPresenter();
    }

    public abstract int getLayoutResource();
    public abstract void mapGUI(View view);
    public abstract void configureGUI();

    public abstract void startPresenter();
    public abstract void stopPresenter();
}
