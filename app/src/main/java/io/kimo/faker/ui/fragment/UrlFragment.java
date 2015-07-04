package io.kimo.faker.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import io.kimo.faker.R;
import io.kimo.faker.mvp.BaseView;
import io.kimo.faker.mvp.presenter.UrlPresenter;
import io.kimo.faker.mvp.view.UrlView;

public class UrlFragment extends BaseView implements UrlView {

    private View mainView, loadingView;
    private TextView imageUrl, avatarUrl;
    private ImageView image, avatar;

    private UrlPresenter presenter;

    public static UrlFragment newInstance() {
        return new UrlFragment();
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_url;
    }

    @Override
    public void mapGUI(View view) {
        mainView = view.findViewById(R.id.main_container);
        loadingView = view.findViewById(R.id.view_loading);

        imageUrl = (TextView) view.findViewById(R.id.image_url);
        image = (ImageView) view.findViewById(R.id.image);

        avatarUrl = (TextView) view.findViewById(R.id.avatar_url);
        avatar = (ImageView) view.findViewById(R.id.avatar);
    }

    @Override
    public void configureGUI() {
        getActivity().setTitle("Url");
    }

    @Override
    public void startPresenter() {
        presenter = new UrlPresenter(this, getActivity());
        presenter.createView();
    }

    @Override
    public void stopPresenter() {
        presenter.destroyView();
    }

    @Override
    public void updateImageUrlExample(String value) {
        Picasso.with(getActivity())
                .load(value)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .placeholder(R.drawable.drawer_background)
                .error(R.drawable.drawer_background)
                .into(image);
        imageUrl.setText(value);
    }

    @Override
    public void updateAvatarUrlExample(String value) {
        Picasso.with(getActivity())
                .load(value)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .placeholder(R.drawable.drawer_background)
                .error(R.drawable.drawer_background)
                .into(avatar);
        avatarUrl.setText(value);
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
