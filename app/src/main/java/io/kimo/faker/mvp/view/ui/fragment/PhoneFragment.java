package io.kimo.faker.mvp.view.ui.fragment;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import io.kimo.faker.R;
import io.kimo.faker.mvp.BaseView;
import io.kimo.faker.mvp.presenter.PhonePresenter;
import io.kimo.faker.mvp.view.PhoneView;

public class PhoneFragment extends BaseView implements PhoneView {

    private View mainView, loadingView;
    private TextView areaCode, countryCode;

    private PhonePresenter presenter;

    public static PhoneFragment newInstance() {
        return new PhoneFragment();
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_phone;
    }

    @Override
    public void mapGUI(View view) {
        mainView = view.findViewById(R.id.main_container);
        loadingView = view.findViewById(R.id.view_loading);
        areaCode = (TextView) view.findViewById(R.id.area_code_phone);
        countryCode = (TextView) view.findViewById(R.id.country_code_phone);
    }

    @Override
    public void configureGUI() {
        getActivity().setTitle("Phone");
    }

    @Override
    public void startPresenter() {
        presenter = new PhonePresenter(this, getActivity());
        presenter.createView();
    }

    @Override
    public void stopPresenter() {
        presenter.destroyView();
    }

    @Override
    public void updatePhoneWithAreaCodeExample(String value) {
        areaCode.setText(value);
    }

    @Override
    public void updatePhoneWithCountryCodeExample(String value) {
        countryCode.setText(value);
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
