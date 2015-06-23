package io.kimo.faker.mvp.view.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import io.kimo.faker.R;
import io.kimo.lib.faker.Faker;
import io.kimo.lib.faker.FakerProvider;

public class ProfileFragment extends Fragment {

    private ImageView image;
    private TextView name, title, website, email, phone;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        image = (ImageView) view.findViewById(R.id.image);
        name = (TextView) view.findViewById(R.id.name);
        title = (TextView) view.findViewById(R.id.title);
        website = (TextView) view.findViewById(R.id.website);
        email = (TextView) view.findViewById(R.id.email);
        phone = (TextView) view.findViewById(R.id.phone);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FakerProvider fakerProvider = Faker.with(getActivity());

        Picasso.with(getActivity())
                .load(fakerProvider.Url.avatar())
                .placeholder(R.drawable.drawer_background)
                .error(R.drawable.drawer_background)
                .into(image);
        name.setText(fakerProvider.Name.fullName());
        title.setText(fakerProvider.Name.title());
        website.setText(fakerProvider.Internet.url());
        email.setText(fakerProvider.Internet.email());
        phone.setText(fakerProvider.Phone.phoneWithAreaCode());

        getActivity().setTitle("\"Specific\" Random Data");

    }
}
