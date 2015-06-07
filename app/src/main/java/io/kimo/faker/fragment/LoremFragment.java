package io.kimo.faker.fragment;

import android.view.View;
import android.widget.TextView;

import io.kimo.faker.BaseFragment;
import io.kimo.faker.R;
import io.kimo.lib.faker.Faker;

public class LoremFragment extends BaseFragment {

    private TextView word, words, sentence;

    public static LoremFragment newInstance() {
        return new LoremFragment();
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_lorem;
    }

    @Override
    public void mapGUI(View view) {
        word = (TextView) view.findViewById(R.id.lorem_word);
        words = (TextView) view.findViewById(R.id.lorem_words);
        sentence = (TextView) view.findViewById(R.id.lorem_sentence);
    }

    @Override
    public void configureGUI() {

        getActivity().setTitle("Lorem");

        word.setText(Faker.with(getActivity()).Lorem.word());
        words.setText(Faker.with(getActivity()).Lorem.words());
        sentence.setText(Faker.with(getActivity()).Lorem.sentence());
    }
}
