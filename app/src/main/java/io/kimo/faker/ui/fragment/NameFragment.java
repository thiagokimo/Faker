package io.kimo.faker.ui.fragment;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import io.kimo.faker.R;
import io.kimo.faker.mvp.BaseView;
import io.kimo.faker.mvp.presenter.NamePresenter;
import io.kimo.faker.mvp.view.NameView;

public class NameFragment extends BaseView implements NameView {

    private View mainView, loadingView;
    private TextView completeName, fullName, firstName, lastName, prefix, suffix, title;

    private NamePresenter presenter;

    public static NameFragment newInstance() {
        return new NameFragment();
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_name;
    }

    @Override
    public void mapGUI(View view) {
        mainView = view.findViewById(R.id.main_container);
        loadingView = view.findViewById(R.id.view_loading);
        completeName = (TextView) view.findViewById(R.id.complete_name);
        fullName = (TextView) view.findViewById(R.id.full_name);
        firstName = (TextView) view.findViewById(R.id.first_name);
        lastName = (TextView) view.findViewById(R.id.last_name);
        prefix = (TextView) view.findViewById(R.id.prefix);
        suffix = (TextView) view.findViewById(R.id.suffix);
        title = (TextView) view.findViewById(R.id.title);
    }

    @Override
    public void configureGUI() {
        getActivity().setTitle("Name");
    }

    @Override
    public void startPresenter() {
        presenter = new NamePresenter(this, getActivity());
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

    @Override
    public void updateCompleteNameExample(String value) {
        completeName.setText(value);
    }

    @Override
    public void updateFullNameExample(String value) {
        fullName.setText(value);
    }

    @Override
    public void updateFirstNameExample(String value) {
        firstName.setText(value);
    }

    @Override
    public void updateLastNameExample(String value) {
        lastName.setText(value);
    }

    @Override
    public void updatePrefixExample(String value) {
        prefix.setText(value);
    }

    @Override
    public void updateSuffixExample(String value) {
        suffix.setText(value);
    }

    @Override
    public void updateTitleExample(String value) {
        title.setText(value);
    }
}
