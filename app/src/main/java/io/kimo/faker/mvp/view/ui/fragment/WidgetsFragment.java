package io.kimo.faker.mvp.view.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.kimo.faker.R;
import io.kimo.lib.faker.Faker;

public class WidgetsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_widgets, container, false);
        getActivity().setTitle("Full Random Data");
        Faker.with(getActivity()).fill(view);
        return view;
    }
}
