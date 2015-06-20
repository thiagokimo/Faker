package io.kimo.faker.mvp.view.ui.fragment;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import io.kimo.faker.R;
import io.kimo.faker.mvp.BaseView;
import io.kimo.faker.mvp.presenter.InternetPresenter;
import io.kimo.faker.mvp.view.InternetView;

public class InternetFragment extends BaseView implements InternetView {

    private View mainView, loadingView;
    private TextView email, url, domain, domainSuffix;

    private InternetPresenter presenter;

    public static InternetFragment newInstance() {
        return new InternetFragment();
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_internet;
    }

    @Override
    public void mapGUI(View view) {
        mainView = view.findViewById(R.id.main_container);
        loadingView = view.findViewById(R.id.view_loading);
        email = (TextView) view.findViewById(R.id.email);
        url = (TextView) view.findViewById(R.id.url);
        domain = (TextView) view.findViewById(R.id.domain);
        domainSuffix = (TextView) view.findViewById(R.id.domain_suffix);
    }

    @Override
    public void configureGUI() {
        getActivity().setTitle("Internet");
    }

    @Override
    public void startPresenter() {
        presenter = new InternetPresenter(this, getActivity());
        presenter.createView();
    }

    @Override
    public void stopPresenter() {
        presenter.destroyView();
    }

    @Override
    public void updateEmailExample(String value) {
        email.setText(value);
    }

    @Override
    public void updateURLExample(String value) {
        url.setText(value);
    }

    @Override
    public void updateDomainExample(String value) {
        domain.setText(value);
    }

    @Override
    public void updateDomainSuffixExample(String value) {
        domainSuffix.setText(value);
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
