package io.kimo.faker.ui.fragment;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import io.kimo.faker.R;
import io.kimo.faker.mvp.BaseView;
import io.kimo.faker.mvp.presenter.NumberPresenter;
import io.kimo.faker.mvp.view.NumberView;

public class NumberFragment extends BaseView implements NumberView {

    private View mainView, loadingView;
    private TextView digit, positiveDigit, negativeDigit, numbers, positiveNumbers, negativeNumbers;

    private NumberPresenter presenter;

    public static NumberFragment newInstance() {
        return new NumberFragment();
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_number;
    }

    @Override
    public void mapGUI(View view) {
        mainView = view.findViewById(R.id.main_container);
        loadingView = view.findViewById(R.id.view_loading);
        digit = (TextView) view.findViewById(R.id.digit);
        positiveDigit = (TextView) view.findViewById(R.id.positive_digit);
        negativeDigit = (TextView) view.findViewById(R.id.negative_digit);
        numbers = (TextView) view.findViewById(R.id.number);
        positiveNumbers = (TextView) view.findViewById(R.id.positive_number);
        negativeNumbers = (TextView) view.findViewById(R.id.negative_number);
    }

    @Override
    public void configureGUI() {
        getActivity().setTitle("Numbers");
    }

    @Override
    public void startPresenter() {
        presenter = new NumberPresenter(this, getActivity());
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
    public void updateDigit(int value) {
        digit.setText(String.valueOf(value));
    }

    @Override
    public void updatePositiveDigit(int value) {
        positiveDigit.setText(String.valueOf(value));
    }

    @Override
    public void updateNegativeDigit(int value) {
        negativeDigit.setText(String.valueOf(value));
    }

    @Override
    public void updateNumbers(int value) {
        numbers.setText(String.valueOf(value));
    }

    @Override
    public void updatePositiveNumbers(int value) {
        positiveNumbers.setText(String.valueOf(value));
    }

    @Override
    public void updateNegativeNumbers(int value) {
        negativeNumbers.setText(String.valueOf(value));
    }
}
