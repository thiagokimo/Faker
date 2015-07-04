package io.kimo.faker.ui.fragment;

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

        Picasso.with(getActivity())
                .load(Faker.with(getActivity()).Url.avatar())
                .placeholder(R.drawable.drawer_background)
                .error(R.drawable.drawer_background)
                .into(image);
        name.setText(Faker.with(getActivity()).Name.fullName());
        title.setText(Faker.with(getActivity()).Name.title());
        website.setText(Faker.with(getActivity()).Internet.url());
        email.setText(Faker.with(getActivity()).Internet.email());
        phone.setText(Faker.with(getActivity()).Phone.phoneWithAreaCode());

        getActivity().setTitle("\"Specific\" Random Data");

    }
}
