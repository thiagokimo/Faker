package io.kimo.faker.fragment;

import android.view.View;
import android.widget.TextView;

import io.kimo.faker.BaseFragment;
import io.kimo.faker.R;
import io.kimo.lib.faker.Faker;

public class NameFragment extends BaseFragment {

    private TextView name, firstName, lastName, prefix, suffix, title;

    public static NameFragment newInstance() {
        return new NameFragment();
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_name;
    }

    @Override
    public void mapGUI(View view) {
        name = (TextView) view.findViewById(R.id.name);
        firstName = (TextView) view.findViewById(R.id.first_name);
        lastName = (TextView) view.findViewById(R.id.last_name);
        prefix = (TextView) view.findViewById(R.id.prefix);
        suffix = (TextView) view.findViewById(R.id.suffix);
        title = (TextView) view.findViewById(R.id.title);
    }

    @Override
    public void configureGUI() {

        getActivity().setTitle("Name");

        name.setText(Faker.with(getActivity()).Name.fullName());
        firstName.setText(Faker.with(getActivity()).Name.firstName());
        lastName.setText(Faker.with(getActivity()).Name.lastName());
        prefix.setText(Faker.with(getActivity()).Name.prefix());
        suffix.setText(Faker.with(getActivity()).Name.suffix());
        title.setText(Faker.with(getActivity()).Name.title());
    }
}
