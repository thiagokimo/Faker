package io.kimo.faker.ui.fragment;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import io.kimo.faker.R;
import io.kimo.faker.mvp.BaseView;
import io.kimo.faker.mvp.presenter.AddressPresenter;
import io.kimo.faker.mvp.view.AddressView;

public class AddressFragment extends BaseView implements AddressView {

    private AddressPresenter presenter;

    private View mainView, loadingView;
    private TextView city, street, secondaryAddress, zipcode, timezone, cityPrefix, citySuffix, state, stateAbbrv, country, countryAbbrv, latitude, longitude;

    public static AddressFragment newInstance() {
        return new AddressFragment();
    }

    @Override
    public void updateCityExample(String value) {
        city.setText(value);
    }

    @Override
    public void updateStreetExample(String value) {
        street.setText(value);
    }

    @Override
    public void updateSecondaryAddressExample(String value) {
        secondaryAddress.setText(value);
    }

    @Override
    public void updateZipcodeExample(String value) {
        zipcode.setText(value);
    }

    @Override
    public void updateTimezoneExample(String value) {
        timezone.setText(value);
    }

    @Override
    public void updateCityPrefixExample(String value) {
        cityPrefix.setText(value);
    }

    @Override
    public void updateCitySuffixExample(String value) {
        citySuffix.setText(value);
    }

    @Override
    public void updateStateExample(String value) {
        state.setText(value);
    }

    @Override
    public void updateStateAbbrvExample(String value) {
        stateAbbrv.setText(value);
    }

    @Override
    public void updateCountryExample(String value) {
        country.setText(value);
    }

    @Override
    public void updateCountryAbbrvExample(String value) {
        countryAbbrv.setText(value);
    }

    @Override
    public void updateLatitudeExample(String value) {
        latitude.setText(value);
    }

    @Override
    public void updateLongitudeExample(String value) {
        longitude.setText(value);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_address;
    }

    @Override
    public void mapGUI(View view) {
        mainView = view.findViewById(R.id.main_container);
        loadingView = view.findViewById(R.id.view_loading);

        city = (TextView) mainView.findViewById(R.id.city);
        street = (TextView) mainView.findViewById(R.id.street);
        secondaryAddress = (TextView) mainView.findViewById(R.id.secondary_address);
        zipcode = (TextView) mainView.findViewById(R.id.zipcode);
        timezone = (TextView) mainView.findViewById(R.id.timezone);
        cityPrefix = (TextView) mainView.findViewById(R.id.city_prefix);
        citySuffix = (TextView) mainView.findViewById(R.id.city_suffix);
        state = (TextView) mainView.findViewById(R.id.state);
        stateAbbrv = (TextView) mainView.findViewById(R.id.state_abbrv);
        country = (TextView) mainView.findViewById(R.id.country);
        countryAbbrv = (TextView) mainView.findViewById(R.id.country_abbrv);
        latitude = (TextView) mainView.findViewById(R.id.latitude);
        longitude = (TextView) mainView.findViewById(R.id.longitude);
    }

    @Override
    public void configureGUI() {
        getActivity().setTitle("Address");
    }

    @Override
    public void startPresenter() {
        presenter = new AddressPresenter(this, getActivity());
        presenter.createView();
    }

    @Override
    public void stopPresenter() {
        presenter.destroyView();
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
